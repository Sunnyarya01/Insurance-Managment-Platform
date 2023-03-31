package com.imt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imt.model.InsurancePolicy;

@Repository
public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy, Long>{

}
