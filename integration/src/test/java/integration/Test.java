package integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.json.JsonPathUtils;

public class Test{

	final private ClassPathXmlApplicationContext ctx;
	
	public Test() {
		ctx = new ClassPathXmlApplicationContext("integration.xml");
		
		ctx.start();
		
		
	}
	
	public static void main(String[] args) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "cuong");
		map.put("lastName", "truong");
		map.put("id", "100");
		
		System.err.println(map);
		
		new Test();

	}

	

}
