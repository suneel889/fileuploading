package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.JobSeekerInfo;
import com.example.repo.IJobSeekerRepo;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {

	@Autowired
	IJobSeekerRepo jsRepo;
	
	
	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		// TODO Auto-generated method stub
		return "Job seeker registered with :"+jsRepo.save(info).getJsId()+ ": id value";
	}


	@Override
	public List<JobSeekerInfo> fetchingAllEmloyee() {
		return jsRepo.findAll();
		
	}


	@Override
	public String fetchResumePath(Integer id) {
		// TODO Auto-generated method stub
		return jsRepo.resumePathByID(id);
	}


	@Override
	public String fetchPhotoPath(Integer id) {
		
		return jsRepo.photoPathByID(id);
	}
	

}
