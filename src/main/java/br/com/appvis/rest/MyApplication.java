package br.com.appvis.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MyApplication extends Application {
	
	
	@Override
	public Map<String, Object> getProperties(){
		Map<String, Object> properties = new HashMap<>();
		
		properties.put("jersey.config.server.provider.packages", "br.com.appvis");
		return properties;
	}
	
	

}
