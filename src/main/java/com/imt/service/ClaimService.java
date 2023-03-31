package com.imt.service;

import java.util.List;

import com.imt.exception.ClaimException;
import com.imt.model.Claim;

public interface ClaimService {
	
	public List<Claim> fetchAll()throws ClaimException;
	public Claim fetchById(Long id)throws ClaimException;
	public Claim createClaim(Claim claim)throws ClaimException;
	public Claim deleteClaim(Long id)throws ClaimException;
	public Claim updateClaim(Claim Claim, Long id)throws ClaimException;

}
