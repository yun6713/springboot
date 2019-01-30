package com.bonc;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.bonc.constant.Constant;
import com.bonc.utils.Util01;

public class Test01 {

	@Test
	public void test01() {
		Util01.getEntity();
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
