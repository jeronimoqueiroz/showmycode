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
@Service("carregarTelaCommand")
@Scope("prototype")
public class CarregarTelaCommand extends KernelATMCommand {

    @Override
    public void execute() {
        
        System.out.println("com.sentinels.kwd.engine.cmd.invoker.CarregarTelaCommand.execute() start :"+this.getDataAction().getNomeCampo());
        
        waitForPageLoad(this.getDataAction().getNomeCampo());
        
        System.out.println("com.sentinels.kwd.engine.cmd.invoker.CarregarTelaCommand.execute() end ");
        
    }
    
}
