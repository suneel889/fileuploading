package com.example.service;

import java.util.List;

import com.example.entity.JobSeekerInfo;

public interface IJobSeekerMgmtService {
	
	String registerJobSeeker(JobSeekerInfo info);
	public List<JobSeekerInfo> fetchingAllEmloyee();
	public String fetchResumePath(Integer id);
	public String fetchPhotoPath(Integer id);

}
