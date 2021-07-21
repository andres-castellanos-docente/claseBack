package com.prueba.crud.responses;

public class calculadoraResponse {
    private Double resultado;
    private String messError;
    private Integer codError;

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public String getMessError() {
        return messError;
    }

    public void setMessError(String messError) {
        this.messError = messError;
    }

    public Integer getCodError() {
        return codError;
    }

    public void setCodError(Integer codError) {
        this.codError = codError;
    }

    public calculadoraResponse(Integer codError, String messError, Double resultado){
        setResultado(resultado);
        setMessError(messError);
        setCodError(codError);


    }
}
