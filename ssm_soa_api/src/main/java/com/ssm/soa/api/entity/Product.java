package com.ssm.soa.api.entity;

import java.io.Serializable;

public class Product implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7082543050875164819L;

	private String skuId;
	
	private String skuName;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	
	
}
