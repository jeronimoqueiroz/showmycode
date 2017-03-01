package com.sentinels.kwd.engine.cmd.handler;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sentinels.kwd.engine.cmd.invoker.KernelATMCommand;

public abstract class SelectOptionHandler  extends KernelATMCommand{
	
	public void select(String targetElement, String value){
		  WebElement element  =this.getElement(targetElement);
	      Select dropdown = new Select(element);
	      dropdown.selectByVisibleText(value);
	        
	}
	
}
