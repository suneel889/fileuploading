package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.JobSeekerInfo;
import com.example.model.jobSeekarData;
import com.example.service.JobSeekerMgmtServiceImpl;

@Controller
public class JobSeekerOperationController {
@Autowired
Environment Env;

@Autowired
ServletContext sc;

@Autowired
JobSeekerMgmtServiceImpl service;
	
@GetMapping("/")
   public String welcome() {
	   
	   
	   return "welcome";
   }
	
@GetMapping("/register")	
public String showJSRegistrationForn(@ModelAttribute("js") jobSeekarData jsData) {

 return "register";
}
@PostMapping("/register")
public String uploadingFileDAta(@ModelAttribute("js") jobSeekarData jabs,Map<String,Object> map) throws IOException {
	
	String store=Env.getRequiredProperty("upload.store");
	File file=new File(store);
	if(!file.exists())
		file.mkdir();
	MultipartFile photo=jabs.getPhotoPath();
	MultipartFile resume=jabs.getResumePath();
	InputStream isphoto=photo.getInputStream();
	InputStream isresume=resume.getInputStream();
	
	String photopath=photo.getOriginalFilename();
	String resumepath=resume.getOriginalFilename();
	 
	OutputStream photo1=new FileOutputStream(file.getAbsolutePath()+"\\"+photopath);
	OutputStream resume1=new FileOutputStream(file.getAbsolutePath()+"\\"+resumepath);
	
	IOUtils.copy(isresume, resume1);
	IOUtils.copy(isphoto, photo1);
	isresume.close();
	isphoto.close();
	photo1.close();
	resume1.close();
	JobSeekerInfo js1=new JobSeekerInfo();
	js1.setJsName(jabs.getJsName());
	js1.setJsAddrs(jabs.getJsAddrs());
	js1.setPhotoPath(file.getAbsolutePath()+"\\"+photopath);
	js1.setResumePath(file.getAbsolutePath()+"\\"+resumepath);
	String msg=service.registerJobSeeker(js1);
	
	map.put("file1",photopath);
	map.put("file2", resumepath);
	map.put("message", msg);
	return "show_result";
}
@GetMapping("List_is")
public String showReport(Map<String,Object> map) {
	
	List<JobSeekerInfo> list=service.fetchingAllEmloyee();
	map.put("jsList", list);
	return "ShowReport"; 
}
@RequestMapping("download")
public String DownloadImages(HttpServletResponse re,@RequestParam("jsId") Integer jsId,@RequestParam("type") String type) throws IOException {
	
	String filePath=null;
	if(type=="photo")
		filePath=service.fetchPhotoPath(jsId);
	else
		filePath=service.fetchResumePath(jsId);
	
	File file=new File(filePath);
	re.setContentLengthLong(file.length());
	String mimeType=sc.getMimeType(filePath);
	mimeType=mimeType!=null?mimeType:"application/octet-stream";
	re.setContentType(mimeType);
	InputStream is=new FileInputStream(file);
	OutputStream os=re.getOutputStream();
	 re.setHeader("Content-Disposition", "attachment;fileName:"+file.getName());
	 IOUtils.copy(is, os);
	
	return null;
}


}
