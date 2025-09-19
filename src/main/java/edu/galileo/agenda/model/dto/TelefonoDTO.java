package edu.galileo.agenda.model.dto;

public class TelefonoDTO {

    private Integer id;
    private String valor;
    private String tipo;

    public TelefonoDTO() {}

    public TelefonoDTO(Integer id, String valor, String tipo) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
