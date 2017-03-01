/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.invoker;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeronimoqueiroz
 */
@Service("esperarCommand")
@Scope("prototype")
public class EsperarCommand extends KernelATMCommand{

    @Override
    public void execute() {
        
        this.delayXSeconds(new Integer(this.getDataAction().getValor()));
        
    }
    
}
