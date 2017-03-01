/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.config;

/**
 *
 * @author jeronimoqueiroz
 */
public class CommandTemplate {
    
    private String kwdToken;
    private String kwdClass;
    private Boolean inicial;
    private Boolean fim;
    private String loadfield;

    /**
     * @return the kwdToken
     */
    public String getKwdToken() {
        return kwdToken;
    }

    /**
     * @param kwdToken the kwdToken to set
     */
    public void setKwdToken(String kwdToken) {
        this.kwdToken = kwdToken;
    }

    /**
     * @return the kwdClass
     */
    public String getKwdClass() {
        return kwdClass;
    }

    /**
     * @param kwdClass the kwdClass to set
     */
    public void setKwdClass(String kwdClass) {
        this.kwdClass = kwdClass;
    }

    /**
     * @return the inicial
     */
    public Boolean getInicial() {
        return inicial;
    }

    /**
     * @param inicial the inicial to set
     */
    public void setInicial(Boolean inicial) {
        this.inicial = inicial;
    }

    /**
     * @return the fim
     */
    public Boolean getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(Boolean fim) {
        this.fim = fim;
    }

    /**
     * @return the loadfield
     */
    public String getLoadfield() {
        return loadfield;
    }

    /**
     * @param loadfield the loadfield to set
     */
    public void setLoadfield(String loadfield) {
        this.loadfield = loadfield;
    }
    
    
}
