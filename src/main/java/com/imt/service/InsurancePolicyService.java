package com.imt.service;

import java.util.List;

import com.imt.exception.InsurancePolicyException;
import com.imt.model.InsurancePolicy;

public interface InsurancePolicyService {
	
	public List<InsurancePolicy> fetchAll()throws InsurancePolicyException;
	public InsurancePolicy fetchById(Long id)throws InsurancePolicyException;
	public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy)throws InsurancePolicyException;
	public InsurancePolicy deleteInsurancePolicy(Long id)throws InsurancePolicyException;
	public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurancePolicy, Long id)throws InsurancePolicyException;

}
