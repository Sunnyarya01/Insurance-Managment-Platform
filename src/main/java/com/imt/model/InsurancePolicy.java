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
public class InsurancePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long policyId;
	private String policyNumber;
	private String type;
	private double coverageAmmount;
	private double premium;
	private Date startDate;
	private Date endDate;
	
	@ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
	
}
