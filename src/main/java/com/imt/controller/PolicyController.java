package com.imt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imt.exception.InsurancePolicyException;
import com.imt.model.InsurancePolicy;
import com.imt.service.InsurancePolicyService;

@RestController
@RequestMapping("/api")
public class PolicyController {

	@Autowired
	private InsurancePolicyService policyService;
	
	@PostMapping("/policies")
	public ResponseEntity<InsurancePolicy> create(@RequestBody InsurancePolicy policy){
		try {
			return new ResponseEntity<InsurancePolicy>(policyService.createInsurancePolicy(policy), HttpStatus.ACCEPTED);
		} catch (InsurancePolicyException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return null;
	}
	
	@PutMapping("/policies/{id}")
	public ResponseEntity<InsurancePolicy> update(@RequestBody InsurancePolicy policy, @PathVariable("id") Long id){
		try {
			return new ResponseEntity<InsurancePolicy>(policyService.updateInsurancePolicy(policy, id), HttpStatus.OK);
		} catch (InsurancePolicyException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return null;
	}
	
	@DeleteMapping("/policies/{id}")
	public ResponseEntity<InsurancePolicy> delete(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<InsurancePolicy>(policyService.deleteInsurancePolicy(id), HttpStatus.OK);
		} catch (InsurancePolicyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/policies")
	public ResponseEntity<List<InsurancePolicy>> getAll(){
		try {
			return new ResponseEntity<List<InsurancePolicy>>(policyService.fetchAll(), HttpStatus.OK);
		} catch (InsurancePolicyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("policies/{id}")
	public ResponseEntity<InsurancePolicy> get(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<InsurancePolicy>(policyService.fetchById(id), HttpStatus.OK);
		} catch (InsurancePolicyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
