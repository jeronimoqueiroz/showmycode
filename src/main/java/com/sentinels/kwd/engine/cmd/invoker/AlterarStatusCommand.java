package com.sentinels.kwd.engine.cmd.invoker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sentinels.kwd.engine.cmd.handler.HttpPostIntegrationHandler;

@Service("alterarStatusCommand")
@Scope("prototype")
public class AlterarStatusCommand extends HttpPostIntegrationHandler {

	public static String URL_ALTERA_STATUS = "http://10.10.30.30/AlteraProposta/";
	public static String SUCESSO = "http://10.10.30.30/AlteraProposta/";
	
	@Override
	public void execute() {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("proposta", this.getDataAction().getNomeCampo());
		params.put("situacao", this.getDataAction().getValor());
		
		String result = this.post(URL_ALTERA_STATUS, params);
		//if(result.contains(::))
		System.out.println(result);
		
		
	}

}
