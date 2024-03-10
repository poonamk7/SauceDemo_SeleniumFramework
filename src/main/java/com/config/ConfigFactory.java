package com.config;

public final class ConfigFactory {
	
	private ConfigFactory(){
		
	}
	
	public static FrameworkConfig getConfig() {
		
		return org.aeonbits.owner.ConfigFactory.create(FrameworkConfig.class);
	}

}
