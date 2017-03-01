package com.sentinels.kwd.engine.cmd.handler;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sentinels.kwd.engine.cmd.invoker.KernelATMCommand;

public abstract class HttpPostIntegrationHandler extends KernelATMCommand {
	
	
	public String post(String url, Map<String, String> params){
	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity( url, params, String.class );
		
		return response.getBody();
	}

}
