/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.invoker;

import com.sentinels.kwd.engine.cmd.vo.KwdVO;

import junit.framework.TestCase;

/**
 *
 * @author jeronimoqueiroz
 */
public abstract class AbstractCommand extends TestCase {
    
    private KwdVO dataAction;
    
    
    @Override
    protected void runTest(){
        
        this.execute();
        
    }
    
    public abstract void execute();

    /**
     * @return the dataAction
     */
    public KwdVO getDataAction() {
        return dataAction;
    }

    /**
     * @param dataAction the dataAction to set
     */
    public void setDataAction(KwdVO dataAction) {
        this.dataAction = dataAction;
    }
}
