package com.sentinels.kwd.engine.cmd.handler;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.sentinels.kwd.engine.cmd.invoker.KernelATMCommand;

public abstract class FieldHandler extends KernelATMCommand{
	
    public void type(String target, String value) {
    	
    	this.limpar(target);
    	WebElement element  =this.getElement(target);
    	
    	if(element.getAttribute("class").equals("decimal")){
    		element.sendKeys(Keys.END);
    		 
    	}else{
    		element.sendKeys(Keys.HOME);
    	}
    	
    	element.sendKeys(value);
		//element.sendKeys(Keys.RETURN);

    }
    
    public void limpar(String target) {
    	WebElement element  =this.getElement(target);
    	element.sendKeys(Keys.CONTROL + "a");
    	element.sendKeys(Keys.DELETE);

    }
	


}
