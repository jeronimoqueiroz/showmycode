/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.config;

import com.sentinels.kwd.engine.cmd.invoker.AbstractCommand;
import com.sentinels.kwd.engine.cmd.vo.KwdVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeronimoqueiroz
 */
@Service
@Scope("singleton")
public class KwdCommandFactory {
    
    @Value("#{'${spring.profiles.active}'.split(',')}")
    public List<String> commands;
    
    public Map<String, CommandTemplate> configTemplateTable = new HashMap<>();
    
    public AbstractCommand initialComand;
    
    public AbstractCommand finalComand;
     
    @Autowired
    public ConfigurationTemplate configurationTemplate;
    
    public void buildCommandTemplates(){

        for (String command : commands) {
            CommandTemplate template = configurationTemplate.buildTemplate(command);
            configTemplateTable.put(command, template);
        }

    }
    
    public AbstractCommand buildCommand(CommandTemplate template){
        
        AbstractCommand command = null;
        try {
            command = configurationTemplate.getCommandInstance(template.getKwdClass());
            
        } catch (Exception ex) {
            Logger.getLogger(KwdCommandFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return command;       
        
    }
    
    
    
    public AbstractCommand buildCommand(KwdVO kwdVO){
        
        CommandTemplate template = configTemplateTable.get(kwdVO.getAcao());
        AbstractCommand command = null;
        try {
            
            command = configurationTemplate.getCommandInstance(template.getKwdClass());
            command.setDataAction(kwdVO);
            
        } catch (Exception ex) {
        	 Logger.getLogger(KwdCommandFactory.class.getName()).log(Level.INFO,"Comando "+kwdVO.getAcao()+" nao declarado ");
        	
            Logger.getLogger(KwdCommandFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return command;       
        
    }
    
    
    
}
