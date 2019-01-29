package com.bonc.utils;

import java.util.Arrays;
import java.util.List;

public class Util01 {

	/**
	 * 构建Hibernate entity类
	 */
	public static void getEntity() {
		List<String> attrs = Arrays.asList("id","name");
		List<String> cols  = Arrays.asList("id","name");
		if(cols==null || cols.isEmpty() || cols.size()<attrs.size()) {
			cols = null;
		}
		System.out.println("import javax.persistence.Column;\n" + 
				"import javax.persistence.Entity;\n" + 
				"import javax.persistence.GeneratedValue;\n" + 
				"import javax.persistence.Id;\n" + 
				"import javax.persistence.Table;\n" + 
				"import org.hibernate.annotations.GenericGenerator;");
		System.out.println("@Entity\n" + 
				"@Table(name=\"tableName\")\n" + 
				"public class ClassName {");
		for (int i = 0; i < attrs.size(); i++) {
			if(i==0) {
				System.out.println("@Id\n@GeneratedValue(generator = \"idsSynLogGenerator\")"
						+ "\n@GenericGenerator(name = \"idsSynLogGenerator\", strategy = \"identity\")");
			}
			if(cols!=null) {
				System.out.println("@Column(name=\""+cols.get(i)+"\")");
			}else {
				System.out.println("@Column(name=\"\")");
			}
			System.out.println("String "+attrs.get(i)+";");
		}
		System.out.println("}");
	}
	
	
}
