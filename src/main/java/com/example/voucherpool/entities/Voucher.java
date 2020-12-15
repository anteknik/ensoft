package com.example.voucherpool.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Voucher{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String voucherId = RunnerNumber.getNumber();
	
	private Boolean valid=Boolean.TRUE;
	
	private Date expiredRedeem;
	
	@OneToOne(mappedBy = "voucher")
	private Offer offer;
	
	public Voucher() {}

	public Voucher(String expiredRedeem) throws Exception {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = simpleDateFormat.parse(expiredRedeem);
		this.expiredRedeem = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVoucherId() {
		return this.voucherId;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Date getExpiredRedeem() {
		return expiredRedeem;
	}

	public void setExpiredRedeem(Date expiredRedeem) {
		this.expiredRedeem = expiredRedeem;
	}

}