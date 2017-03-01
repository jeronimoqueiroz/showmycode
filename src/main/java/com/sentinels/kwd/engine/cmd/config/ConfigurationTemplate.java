/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.config;

import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.sentinels.kwd.engine.cmd.invoker.AbstractCommand;

/**
 *
 * @author jeronimoqueiroz
 */
@Service
public class ConfigurationTemplate {

    @Autowired
    private Environment environment;
    @Value("${properties.location:}")
    private String propertiesLocation;
    
    @Autowired
    private ApplicationContext context;
    
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationTemplate.class);

    
    public AbstractCommand getCommandInstance(String name){
        
        return (AbstractCommand)context.getBean(name);
        
    }
  

    public CommandTemplate buildTemplate(String command) {

        String name         = environment.getProperty(command + ".kwd.name", String.class);
        String className    = environment.getProperty(command + ".kwd.class", String.class);
        Boolean inicial     = environment.getProperty(command + ".kwd.inicial", Boolean.class);
        Boolean fim         = environment.getProperty(command + ".kwd.final", Boolean.class);
        String loadfield    = environment.getProperty(command + ".kwd.loadfield", String.class);
        
        CommandTemplate template = new CommandTemplate();
        template.setFim(fim);
        template.setInicial(inicial);
        template.setKwdToken(name);
        template.setKwdClass(className);
        template.setLoadfield(loadfield);
        
        return template;
    }

    
    public Properties loadProperties(final String filename) {
        
        final Resource propertiesResource = 
                new ClassPathResource(filename+".properties");
       
        final Properties properties = new Properties();

        try {
            properties.load(propertiesResource.getInputStream());
        } catch(final IOException exception) {
            throw new RuntimeException(exception);
        }

        LOG.info("Using {} as resource", propertiesResource);

        return properties;
    }
    
    
    @SuppressWarnings("unused")
	private String getCustomPath(final String filename) {
        return propertiesLocation.endsWith(".properties") ? propertiesLocation : propertiesLocation + filename;
    }

   

}
