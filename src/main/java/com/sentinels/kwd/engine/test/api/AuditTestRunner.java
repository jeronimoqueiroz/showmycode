package com.sentinels.kwd.engine.test.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.textui.TestRunner;

@Service("auditTestRunner")
public class AuditTestRunner extends TestRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuditTestRunner.class);
	
	@Autowired
	AuditTestListener auditTestListener;
	
	public TestResult doRun(Test suite, boolean wait) {
		TestResult result= createTestResult();
		result.addListener(auditTestListener);
		long startTime= System.currentTimeMillis();
		suite.run(result);
		long endTime= System.currentTimeMillis();
		long runTime= endTime-startTime;
		LOG.debug("Tempo de execucao testSuite {}ms", runTime);

		pause(wait);
		return result;
	}

}
