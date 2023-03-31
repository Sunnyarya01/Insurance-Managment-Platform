package com.imt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imt.exception.InsurancePolicyException;
import com.imt.model.InsurancePolicy;
import com.imt.repository.InsurancePolicyRepo;
import com.imt.service.InsurancePolicyService;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService{
	
	@Autowired
	private InsurancePolicyRepo policyRepo;

	@Override
	public List<InsurancePolicy> fetchAll()throws InsurancePolicyException {
		// TODO Auto-generated method stub
		List<InsurancePolicy> policies = policyRepo.findAll();
		if(policies==null) {
			throw new InsurancePolicyException("Not found any policies......");
		}
		return policies;
	}

	@Override
	public InsurancePolicy fetchById(Long id)throws InsurancePolicyException {
		// TODO Auto-generated method stub
		InsurancePolicy insurancePolicy = policyRepo.findById(id).get();
		if(insurancePolicy==null) {
			throw new InsurancePolicyException("Policy not found with this id "+id);
		}
		return insurancePolicy;
	}

	@Override
	public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy)throws InsurancePolicyException {
		// TODO Auto-generated method stub
		if(insurancePolicy==null) {
			throw new InsurancePolicyException("Enter a valid data.......");
		}
		return policyRepo.save(insurancePolicy);
	}

	@Override
	public InsurancePolicy deleteInsurancePolicy(Long id)throws InsurancePolicyException {
		// TODO Auto-generated method stub
		InsurancePolicy insurancePolicy = policyRepo.findById(id).get();
		if(insurancePolicy==null) {
			throw new InsurancePolicyException("Policy not found with this id "+id);
		}
		policyRepo.delete(insurancePolicy);
		return insurancePolicy;
	}

	@Override
	public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurancePolicy, Long id)throws InsurancePolicyException {
		// TODO Auto-generated method stub
		InsurancePolicy insurancePolicy2 = policyRepo.findById(id).get();
		if(insurancePolicy2==null) {
			throw new InsurancePolicyException("Policy not found with this id "+id);
		}
		insurancePolicy2.setClient(insurancePolicy.getClient());
		insurancePolicy2.setCoverageAmmount(insurancePolicy.getCoverageAmmount());
		insurancePolicy2.setEndDate(insurancePolicy.getEndDate());
		insurancePolicy2.setPolicyNumber(insurancePolicy.getPolicyNumber());
		insurancePolicy2.setPremium(insurancePolicy.getPremium());
		insurancePolicy2.setStartDate(insurancePolicy.getStartDate());
		insurancePolicy2.setType(insurancePolicy.getType());
		return policyRepo.save(insurancePolicy2);
	}

}
