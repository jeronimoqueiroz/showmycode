/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.invoker;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sentinels.kwd.engine.cmd.handler.ClickHandler;

/**
 *
 * @author jeronimoqueiroz
 */
@Service("clickBotaoCommand")
@Scope("prototype")
public class ClickBotaoCommand extends ClickHandler{

    @Override
    public void execute() {
        
        click(this.getDataAction().getNomeCampo());
        
    }
    
}
