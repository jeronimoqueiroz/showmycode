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
@Service("limparCommand")
@Scope("prototype")
public class LimparCommand extends FieldHandler{

    @Override
    public void execute() {
        
        this.limpar(this.getDataAction().getNomeCampo());
    }
    
}
