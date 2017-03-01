package com.sentinels.kwd.engine.test.api;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.sentinels.kwd.engine.cmd.invoker.AbstractCommand;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

@Service("auditTestListener")
@PropertySource("classpath:kwd.properties")
public class AuditTestListener implements TestListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuditTestListener.class);
	
	@Override
	public void addError(Test test, Throwable erro) {
		AbstractCommand cmd = ((AbstractCommand) test);
		if(erro instanceof org.openqa.selenium.TimeoutException || erro instanceof NoSuchElementException){
			LOG.info("** Error:  ACAO:{}, {} ",cmd.getDataAction().getAcao(), "O campo "+cmd.getDataAction().getNomeCampo()+" nao foi localizado na pagina");
		}
		
	}

	@Override
	public void addFailure(Test test, AssertionFailedError arg1) {
		LOG.info("** Failure:  {}", test);
		if (arg1 != null) {
			if (arg1.getMessage() != null){
				LOG.info(arg1.getMessage());
			}
			StackTraceElement st = arg1.getStackTrace()[0];
			LOG.info(st.toString());
		}
	}

	@Override
	public void endTest(Test test) {
		AbstractCommand cmd = ((AbstractCommand) test);
		LOG.info("Finalizando Passo: {} {} {}", cmd.getDataAction().getAcao(), cmd.getDataAction().getNomeCampo(), cmd.getDataAction().getValor());
	}

	@Override
	public void startTest(Test test) {
		AbstractCommand cmd = ((AbstractCommand) test);
		LOG.info("Executando Passo: {} {} {}", cmd.getDataAction().getAcao(), cmd.getDataAction().getNomeCampo(), cmd.getDataAction().getValor());
	}
}
