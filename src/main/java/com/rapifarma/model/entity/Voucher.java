package com.rapifarma.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "vouchers")
public class Voucher {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Ingrese el numero de orden")
	@Column(name = "name", nullable = false, length = 20)
	private String name;
		
	@Column(name = "date_emission", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateEmission;			
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@Min(0)
	@Column(name = "sale_value", nullable = false)
	private double sale_value;
	
	@Min(0)
	@Column(name = "igv", nullable = false)
	private double igv;
	
	@Min(0)	
	@Column(name = "total_import", nullable = false)
	private double total_import;
	
	@OneToMany(mappedBy = "voucher", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private List<voucherDetail> voucherDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public double getSale_value() {
		return sale_value;
	}

	public void setSale_value(double sale_value) {
		this.sale_value = sale_value;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotal_import() {
		return total_import;
	}

	public void setTotal_import(double total_import) {
		this.total_import = total_import;
	}

	public List<voucherDetail> getVoucherDetails() {
		return voucherDetails;
	}

	public void setVoucherDetails(List<voucherDetail> voucherDetails) {
		this.voucherDetails = voucherDetails;
	}	
}
