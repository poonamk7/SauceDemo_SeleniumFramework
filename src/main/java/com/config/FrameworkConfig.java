package com.config;

import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/test/resources/config/config.properties") // This is an alternative to read data from .properties file using Properties class
public interface FrameworkConfig extends Config {
	
	long timeout();
	String url();
	String browser();

}
