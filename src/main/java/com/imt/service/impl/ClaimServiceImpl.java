package com.imt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imt.exception.ClaimException;
import com.imt.model.Claim;
import com.imt.repository.ClaimRepo;
import com.imt.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	private ClaimRepo claimRepo;
	
	@Override
	public List<Claim> fetchAll()throws ClaimException {
		// TODO Auto-generated method stub
		List<Claim> claims = claimRepo.findAll();
		if(claims==null) {
			throw new ClaimException("Not found.........");
		}
		return claims;
	}

	@Override
	public Claim fetchById(Long id)throws ClaimException {
		// TODO Auto-generated method stub
		Claim claim = claimRepo.findById(id).get();
		if(claim==null) {
			throw new ClaimException("not found........");
		}
		return claim;
	}

	@Override
	public Claim createClaim(Claim claim)throws ClaimException {
		// TODO Auto-generated method stub
		if(claim==null) {
			throw new ClaimException("Enter a valid data..........");
		}
		return claimRepo.save(claim);
	}

	@Override
	public Claim deleteClaim(Long id)throws ClaimException {
		// TODO Auto-generated method stub
		Claim claim = claimRepo.findById(id).get();
		if(claim==null) {
			throw new ClaimException("not found........");
		}
		claimRepo.delete(claim);
		return claim;
	}

	@Override
	public Claim updateClaim(Claim Claim, Long id)throws ClaimException {
		// TODO Auto-generated method stub
		Claim claim = claimRepo.findById(id).get();
		if(claim==null) {
			throw new ClaimException("not found........");
		}
		claim.setClaimDate(Claim.getClaimDate());
		claim.setClaimNumber(Claim.getClaimNumber());
		claim.setClaimStatus(Claim.getClaimStatus());
		claim.setDescription(Claim.getDescription());
		claim.setInsurancePolicy(Claim.getInsurancePolicy());
		claimRepo.save(claim);
		return claim;
	}

}
