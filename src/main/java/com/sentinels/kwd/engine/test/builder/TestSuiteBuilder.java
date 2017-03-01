/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.test.builder;

import com.sentinels.kwd.engine.cmd.config.KwdCommandFactory;
import com.sentinels.kwd.engine.cmd.invoker.AbstractCommand;
import com.sentinels.kwd.engine.cmd.parser.KwdVOParser;
import com.sentinels.kwd.engine.cmd.vo.KwdVO;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeronimoqueiroz
 */
@Service("testSuiteBuilder")
@Scope("singleton")
@PropertySource("classpath:kwd.properties")
public class TestSuiteBuilder {
    
    @Value("${diretorio.planilhas.testcase}")
    private String testCaseContentPath;
    
    public List<List<KwdVO>> context;
    
    public List<TestSuite> cenariosDeTeste;
    
    @Autowired
    public KwdCommandFactory kwdCommandFactory;
    
   
    public void buildCenarios(){
        
        File folder = new File(testCaseContentPath);
        context = KwdVOParser.buildKwdParser(folder);
        
        kwdCommandFactory.buildCommandTemplates();
        
        
    }
    
    public List<TestSuite> buildTestSuite(){
        
        List<TestSuite> suitesList = new LinkedList<>();
        for (List<KwdVO> list : context) {
            TestSuite suite = new TestSuite();
            
            for (KwdVO kwdVO : list) {
            	Logger.getLogger(KwdCommandFactory.class.getName()).log(Level.INFO,"Comando "+kwdVO.getAcao()+" declarado ");
                AbstractCommand command = kwdCommandFactory.buildCommand(kwdVO);
                suite.addTest(command);
                suite.setName(kwdVO.getTestSuiteName());
            }
            suitesList.add(suite);
            
        }
        
        return suitesList;
    }
    
}
