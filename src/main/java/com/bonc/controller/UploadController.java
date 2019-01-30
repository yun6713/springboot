package com.bonc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bonc.constant.Constant;


@Controller
@RequestMapping("/upload")
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	@RequestMapping("/uploadFiles")
	@ResponseBody
	public void upload(HttpServletRequest request,MultipartFile[] files,
			MultipartFile[] file1) throws IllegalStateException, IOException {
		for (int i = 0; i < files.length; i++) {
			MultipartFile mFile = files[i];
			String name = mFile.getOriginalFilename();
			if("".equals(name) || name==null) {
				continue;
			}
			File file = new File(Constant.UPLOAD_DIR_PATH+name);
			if(!file.exists()) {
				file.createNewFile();
			}
			mFile.transferTo(file);
		}		
	}
	@RequestMapping("/uploadPage")
	public String uploadPage() throws IllegalStateException, IOException {
		logger.info("uploadPage123456");
		return "uploadPage";
	}
}
