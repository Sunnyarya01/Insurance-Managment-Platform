package com.imt.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long claimId;
    private String claimNumber;
    private String description;
    private Date claimDate;
    private String claimStatus;

    @ManyToOne
    @JoinColumn(name = "insurance_policy_id")
    private InsurancePolicy insurancePolicy;
	
}
