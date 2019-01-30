package com.bonc.config;

import java.io.File;

import org.springframework.boot.CommandLineRunner;

import com.bonc.constant.Constant;

public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		mkUploadDir();
	}

	private void mkUploadDir() {
		File file = new File(Constant.UPLOAD_DIR_PATH);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
}
