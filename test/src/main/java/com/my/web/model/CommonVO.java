package com.my.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "common")
public class CommonVO implements Serializable {

    private static final long serialVersionUID = 7419229779731522702L;
    
    private String module;

    private String orgName;
    
    private String orgId;
    
    private String orgStatus;
    
    private String billName;
    
    private String billCode;
    
    private String billNum;
    
    private String execStatus;
    
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgStatus() {
		return orgStatus;
	}

	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getBillNum() {
		return billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public String getExecStatus() {
		return execStatus;
	}

	public void setExecStatus(String execStatus) {
		this.execStatus = execStatus;
	}

	

}