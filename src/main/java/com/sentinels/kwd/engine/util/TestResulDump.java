/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.util;

import java.text.MessageFormat;
import java.util.Enumeration;
import junit.framework.TestFailure;
import junit.framework.TestResult;

/**
 *
 * @author jeronimoqueiroz
 */
public class TestResulDump {
    
    
    public static void dumpResults(TestResult result) {
	System.out.println();
	dumpList("Failures: ", result.failures());

	System.out.println();
	dumpList("Errors: ", result.errors());

	int failedCount = result.errorCount() + result.failureCount();
	System.out.println();
        if(failedCount > 0){
            System.out.println(MessageFormat.format("{0} dos {1} Testes falharam", failedCount, result.runCount()));
        }
        System.out.println(MessageFormat.format("{0} out of {1} Testes executaram com sucesso",  result.runCount() - failedCount, result.runCount()));
   
    }
    
    public static void dumpList(String header, Enumeration<TestFailure> failures) { 
        System.out.println(header); 
        while (failures.hasMoreElements()) { 
            TestFailure failure = failures.nextElement(); 
            System.out.print("  "); 
            System.out.println(failure.toString()); 
        } 
    }
}
