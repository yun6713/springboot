package com.bonc;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.bonc.constant.Constant;

public class Test01 {

	@Test
	public void test01() {
		System.out.println(String.format("http://localhost:%s/%s", "web","8080"));
	}
	@Test
	public void test02() throws IOException {
		File f = new File(Constant.UPLOAD_DIR_PATH);
		if(!f.exists()) {
			f.mkdirs();
			//f.createNewFile();
		}
	}
}
