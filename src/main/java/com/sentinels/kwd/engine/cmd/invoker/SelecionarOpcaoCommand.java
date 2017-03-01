package com.sentinels.kwd.engine.cmd.invoker;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sentinels.kwd.engine.cmd.handler.SelectOptionHandler;

@Service("selecionarOpcaoCommand")
@Scope("prototype")
public class SelecionarOpcaoCommand extends SelectOptionHandler{

	@Override
	public void execute() {
		
		select(this.getDataAction().getNomeCampo(), this.getDataAction().getValor());
		
	}

}
