package com.example.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class jobSeekarData {
	

	

		private Integer jsId;
		private String jsName;
		private String jsAddrs;
		private MultipartFile resumePath;
	    private MultipartFile photoPath;
	    
	    @Override
		public String toString() {
			return "jobSeekarData [jsId=" + jsId + ", jsName=" + jsName + ", jsAddrs=" + jsAddrs + ", resumePath="
					+ resumePath + ", photoPath=" + photoPath + "]";
		}
		public String getJsAddrs() {
			return jsAddrs;
		}
		public void setJsAddrs(String jsAddrs) {
			this.jsAddrs = jsAddrs;
		}
		public Integer getJsId() {
			return jsId;
		}
		public void setJsId(Integer jsId) {
			this.jsId = jsId;
		}
		public MultipartFile getResumePath() {
			return resumePath;
		}
		public void setResumePath(MultipartFile resumePath) {
			this.resumePath = resumePath;
		}
		public MultipartFile getPhotoPath() {
			return photoPath;
		}
		public void setPhotoPath(MultipartFile photoPath) {
			this.photoPath = photoPath;
		}
		public String getJsName() {
			return jsName;
		}

		public void setJsName(String jsName) {
			this.jsName = jsName;
		}

}
