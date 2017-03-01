
package com.sentinels.kwd.engine.cmd.invoker;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sentinels.kwd.engine.util.WebBrowserSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeronimoqueiroz
 */
@Service("abrirBrowserCommand")
@Scope("prototype")
public class AbrirBrowserCommand extends KernelATMCommand {
    

    @Override
    public void execute() {
    		
           WebBrowserSession.getDefaultSession(this.getDataAction());
 
    }
    
}
