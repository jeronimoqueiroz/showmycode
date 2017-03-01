/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.sentinels.kwd.engine.cmd.vo.KwdVO;
import com.sentinels.kwd.engine.cmd.vo.WebBrowserType;

/**
 *
 * @author jeronimoqueiroz
 */
public class WebBrowserSession {
    
    public static WebDriver driver;
    
    public static void closeSession(){
        driver.close();
        driver = null;
    }
    
    
    public static WebDriver getATMSession(){
        if(driver == null){
            String currentDir = "D:\\saquepague-projetos";
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		String marionetteDriverLocation = currentDir + "\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);

		driver = new FirefoxDriver(capabilities);
		driver.get("http://localhost:40000/index.html?sep_peer_name=gui&with_cursor=yes&force_print_on_screen=no&without_timeout=yes&enable_internal_tests=true&dump_tlvs=no%22");
                
        }
        return driver;
    }
    
    public static WebDriver getDefaultSession(KwdVO dataAction){
        if(driver == null){
            try{
	        	WebBrowserType type = WebBrowserType.buildType(dataAction.getControle());
	        	
	        	switch (type) {
				case FIREFOX:
					String currentDir = "D:\\saquepague-projetos";
					System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
					String marionetteDriverLocation = currentDir + "\\geckodriver.exe";
					System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
			
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
			
					driver = new FirefoxDriver(capabilities);
					
					
					break;
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "C:\\TEST_CASES\\DRIVERS\\SETUP\\chromedriver.exe");
					DesiredCapabilities capabilities1 = DesiredCapabilities.chrome();
					driver = new ChromeDriver(capabilities1);
				default:
					break;
				}
	        	
	           
	        	driver.get(dataAction.getValor());
            }catch(Throwable e){
            	e.printStackTrace();
            }
                
        }
        return driver;
    }
    
    
}
