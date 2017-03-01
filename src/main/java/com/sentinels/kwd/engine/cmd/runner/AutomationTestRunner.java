/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sentinels.kwd.engine.cmd.context.SessionContext;
import com.sentinels.kwd.engine.test.api.AuditTestRunner;
import com.sentinels.kwd.engine.test.builder.TestSuiteBuilder;
import junit.framework.TestSuite;
/**
 *
 * @author jeronimoqueiroz
 */
@ComponentScan(basePackages = {"com.sentinels.kwd.engine"}) 
@SpringBootApplication
public class AutomationTestRunner extends AbstractRunner{
    
	private static final Logger LOG = LoggerFactory.getLogger(AutomationTestRunner.class);
    
    public static void main(String[] args){
        
        ApplicationContext ctx = SpringApplication.run(AutomationTestRunner.class, args);
        
        TestSuiteBuilder builder = (TestSuiteBuilder)ctx.getBean("testSuiteBuilder");
        AuditTestRunner runner = (AuditTestRunner)ctx.getBean("auditTestRunner");
        builder.buildCenarios();
        List<TestSuite> lista = builder.buildTestSuite();
        
        SessionContext.reBuildInstance();
        
        for (TestSuite testSuite : lista) {
            try{
            	LOG.info("Colocando na fila de execucao : {} ", testSuite.getName());
                runner.doRun(testSuite, false);
                
                         

            }catch(Exception e){
                e.printStackTrace();
            }
        }
                
    }
    
    
}
