/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.invoker;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sentinels.kwd.engine.cmd.handler.FieldHandler;


/**
 *
 * @author jeronimoqueiroz
 */
@Service("digitarCommand")
@Scope("prototype")
public class DigitarCommand extends FieldHandler{

    @Override
    public void execute() {
        
        this.type(this.getDataAction().getNomeCampo(), this.getDataAction().getValor());
      
    }
    
}
