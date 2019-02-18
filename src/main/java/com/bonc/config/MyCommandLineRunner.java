package com.bonc.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bonc.constant.Constant;
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class MyCommandLineRunner implements CommandLineRunner {

	@Value("${server.port}")
	String port;
	@Value("${server.context-path}")
	String contextPath;
	@Override
	public void run(String... arg0) throws Exception {
		mkUploadDir();
		contextPath = contextPath.startsWith("/")?contextPath.substring(1):contextPath;
		System.out.println(String.format("http://localhost:%s/%s",port, contextPath));
	}

	private void mkUploadDir() {
		File file = new File(Constant.UPLOAD_DIR_PATH);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
}
