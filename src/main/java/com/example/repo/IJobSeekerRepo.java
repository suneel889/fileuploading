package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.JobSeekerInfo;

@Repository
public interface IJobSeekerRepo extends JpaRepository<JobSeekerInfo,Integer>{
	@Query(value="select RESUME_PATH from job_seeker_info where JS_ID=:Id" ,nativeQuery = true)
	public String resumePathByID(Integer Id);
	@Query(value="select PHOTO_PATH from job_seeker_info  where JS_ID=:Id",nativeQuery = true)
	public String photoPathByID(Integer Id);

}
