package com.sentinels.kwd.engine.cmd.invoker;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.sentinels.kwd.engine.cmd.context.SessionContext;

@Service("declararCommand")
@Scope("prototype")
public class DeclararCommand extends KernelATMCommand{

	private static final Logger LOG = LoggerFactory.getLogger(DeclararCommand.class);
	
	@Override
	public void execute() {
		
		WebElement element = getElement(this.getDataAction().getValor());
		
		LOG.info("DECLARANDO VARIAVEL "+this.getDataAction().getNomeCampo()+" VALOR : " +element.getText());
		SessionContext.INSTANCE.add(this.getDataAction().getNomeCampo(), element.getText());
		
	}

}
