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

import com.imt.exception.ClaimException;
import com.imt.model.Claim;
import com.imt.service.ClaimService;

@RestController
@RequestMapping("/api")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	@PostMapping("/claims")
	public ResponseEntity<Claim> create(@RequestBody Claim claim){
		try {
			return new ResponseEntity<Claim>(claimService.createClaim(claim), HttpStatus.ACCEPTED);
		} catch (ClaimException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/claims/{id}")
	public ResponseEntity<Claim> update(@RequestBody Claim claim, @PathVariable("id") Long id){
		try {
			return new ResponseEntity<Claim>(claimService.updateClaim(claim, id), HttpStatus.OK);
		} catch (ClaimException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@DeleteMapping("claims/{id}")
	public ResponseEntity<Claim> delete(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<Claim>(claimService.deleteClaim(id), HttpStatus.OK);
		} catch (ClaimException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@GetMapping("claims")
	public ResponseEntity<List<Claim>> getAll(){
		try {
			return new ResponseEntity<List<Claim>>(claimService.fetchAll(), HttpStatus.OK);
		} catch (ClaimException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("claims/{id}")
	public ResponseEntity<Claim> get(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<Claim>(claimService.fetchById(id), HttpStatus.OK);
		} catch (ClaimException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
