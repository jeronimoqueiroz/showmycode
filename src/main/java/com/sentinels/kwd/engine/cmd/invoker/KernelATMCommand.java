/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.invoker;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sentinels.kwd.engine.util.WebBrowserSession;

/**
 *
 * @author jeronimoqueiroz
 */
public abstract class KernelATMCommand extends AbstractCommand {

   
    public void delay1Second() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    public void delay3Seconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
    }

    public void delayXSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
        }
    }

    public WebElement getAvailableElement(String uidToBeClickable){
    	WebElement element = (new WebDriverWait(WebBrowserSession.driver, 5)).until(ExpectedConditions.elementToBeClickable(buildCriteria(uidToBeClickable)));
    	if(element.isDisplayed() && element.isEnabled()){
    		return element;
    	}else{
    		throw new RuntimeException();
    	}
    }


    public static void waitForPageLoad(String uidToBeClickable) {
        (new WebDriverWait(WebBrowserSession.driver, 30)).until(ExpectedConditions.elementToBeClickable(By.id(uidToBeClickable)));
    }
    



    public static void waitForPageLoadAndClick(String uidToBeClickable) {
        (new WebDriverWait(WebBrowserSession.driver, 30)).until(ExpectedConditions.elementToBeClickable(By.id(uidToBeClickable))).click();
    }

    public By buildCriteria(String labelToBeClickable){
    	By element = null;
    	if(labelToBeClickable.indexOf("//") >= 0){
    		element = By.xpath(labelToBeClickable);
        }else if(labelToBeClickable.indexOf("id=") >= 0 || labelToBeClickable.indexOf("ID=") >= 0){
            labelToBeClickable = labelToBeClickable.replace("id=", "");
     		element = By.id(labelToBeClickable);
        }else if(labelToBeClickable.indexOf("name=") >= 0 || labelToBeClickable.indexOf("NAME=") >= 0){
            labelToBeClickable = labelToBeClickable.replace("name=", "");
            element = By.name(labelToBeClickable);
        }else if(labelToBeClickable.indexOf("css=") >= 0 || labelToBeClickable.indexOf("CSS=") >= 0){
            labelToBeClickable = labelToBeClickable.replace("css=", "");
            element = By.cssSelector(labelToBeClickable);
        }else if(labelToBeClickable.indexOf("link=") >= 0  || labelToBeClickable.indexOf("LINK=") >= 0){
            labelToBeClickable = labelToBeClickable.replace("link=", "");
            element = By.linkText(labelToBeClickable);
        }else {
        	element = By.xpath("//*[text()='"+labelToBeClickable+"']");
        }
    	return element;
    }
    
    public WebElement getElement(String labelToBeClickable){
    	By criteria = buildCriteria(labelToBeClickable);
    	WebElement ui = null;
    	try{
    		ui = (new WebDriverWait(WebBrowserSession.driver, 30)).until(ExpectedConditions.presenceOfElementLocated(criteria));
    	}catch(Exception e){
    		e.printStackTrace();
    		ui = (new WebDriverWait(WebBrowserSession.driver, 15)).until(ExpectedConditions.presenceOfElementLocated(criteria));
    	}
    	return ui;
    }
    

    public void doFecharNavegador() {
        WebBrowserSession.closeSession();
    }

}
