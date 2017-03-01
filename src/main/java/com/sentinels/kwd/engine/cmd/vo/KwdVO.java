/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.vo;

/**
 *
 * @author jeronimoqueiroz
 */
public class KwdVO {
    
    private String controle;
    private String acao;
    private String nomeCampo;
    private String valor;
    private String testSuiteName;
    

    /**
     * @return the controle
     */
    public String getControle() {
        return controle;
    }

    /**
     * @param controle the controle to set
     */
    public void setControle(String controle) {
        this.controle = controle;
    }

    /**
     * @return the acao
     */
    public String getAcao() {
        return acao;
    }

    /**
     * @param acao the acao to set
     */
    public void setAcao(String acao) {
        this.acao = acao;
    }

    /**
     * @return the nomeCampo
     */
    public String getNomeCampo() {
        return nomeCampo;
    }

    /**
     * @param nomeCampo the nomeCampo to set
     */
    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the testSuiteName
     */
    public String getTestSuiteName() {
        return testSuiteName;
    }

    /**
     * @param testSuiteName the testSuiteName to set
     */
    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }
    
    
}
