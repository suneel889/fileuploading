package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Table()
public class JobSeekerInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer jsId;
	public JobSeekerInfo() {
		super();
	}
	private String jsName;
	private String jsAddrs;
	private String resumePath;
	private String photoPath;
	public Integer getJsId() {
		return jsId;
	}
	public void setJsId(Integer jsId) {
		this.jsId = jsId;
	}
	public String getJsName() {
		return jsName;
	}
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	public String getJsAddrs() {
		return jsAddrs;
	}
	public void setJsAddrs(String jsAddrs) {
		this.jsAddrs = jsAddrs;
	}
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	@Override
	public String toString() {
		return "JobSeekerInfo [jsId=" + jsId + ", jsName=" + jsName + ", jsAddrs=" + jsAddrs + ", resumePath="
				+ resumePath + ", photoPath=" + photoPath + "]";
	}
	
	

}
