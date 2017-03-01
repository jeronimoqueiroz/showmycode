package com.sentinels.kwd.engine.cmd.handler;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.sentinels.kwd.engine.cmd.invoker.KernelATMCommand;

public abstract class ClickHandler extends KernelATMCommand {

	public void click(String targetElement){
		WebElement element =  this.getElement(targetElement);
		try{
			boolean clicked = false;
			for (int i = 0; i < 3; i++) {
				if(element.isDisplayed() && element.isEnabled()){
					element.click();
					clicked = true;
				}
				Thread.sleep(2000);
			}
			if(!clicked){
				WebElement button = getAvailableElement(targetElement);
				button.click();
			}
			
		}catch(Exception e){
			List<WebElement> elements = element.findElements(buildCriteria(targetElement));
			if(elements.size() > 0){
				elements.get(0).click();
			}
		}
		
		
	}
	


}
