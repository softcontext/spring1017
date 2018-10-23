package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("server")
public class ServerProperties {
	
	private String email;
	private List<Cluster> cluster = new ArrayList<>();
	
	@Override
	public String toString() {
		return "ServerProperties [\n\temail=" + email + ", \n\tcluster=" + cluster + "\n]";
	}

	@Data
	public static class Cluster {
		private String ip;
		private String path;
	}

}
