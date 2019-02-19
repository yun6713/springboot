package com.bonc.utils;

import java.util.Arrays;
import java.util.List;

public class Util01 {
	public static void main(String... args) {
		List<String> attrs = Arrays.asList("username","authority");
		List<String> cols  = Arrays.asList("username","authority");
		String className = "OauthUserAuthority";
		System.out.println(getEntity(attrs, cols,className));
	}

	/**
	 * 构建Hibernate entity类
	 */
	public static String getEntity(List<String> attrs,List<String> cols,String className) {
		StringBuilder sb = new StringBuilder();
		if(attrs==null || attrs.isEmpty()) {
			return null;
		}
		if(cols==null || cols.isEmpty() || cols.size()<attrs.size()) {
			cols = null;
		}
		className = className==null||"".equals(className.trim())?"className":className;
		sb.append("import javax.persistence.Column;\n" + 
				"import javax.persistence.Entity;\n" + 
				"import javax.persistence.GeneratedValue;\n" + 
				"import javax.persistence.Id;\n" + 
				"import javax.persistence.Table;\n" + 
				"import org.hibernate.annotations.GenericGenerator;\n"+
				"import java.io.Serializable;\n");
		sb.append("@Entity\n" + 
				"@Table(name=\"tableName\")\n" + 
				"public class "+className+" implements Serializable{\n"+
				"private static final long serialVersionUID = 1L;\n");
		for (int i = 0; i < attrs.size(); i++) {
			if(i==0) {
				sb.append("@Id\n@GeneratedValue(generator = \""+className+"_Generator\")"
						+ "\n@GenericGenerator(name = \""+className+"_Generator\", strategy = \"identity\")\n");
			}
			if(cols!=null) {
				sb.append("@Column(name=\""+cols.get(i)+"\")\n");
			}else {
				sb.append("@Column(name=\"\")\n");
			}
			sb.append("private String "+attrs.get(i)+";\n");
		}
		sb.append("}\n");
		return sb.toString();
	}
	
}
