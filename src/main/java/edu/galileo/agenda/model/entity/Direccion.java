package edu.galileo.agenda.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {

    public enum TipoDireccion {
        CASA,
        TRABAJO,
        OTRO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDireccion tipo;

    @ManyToOne
    @JoinColumn(name = "contacto_id", nullable = false)
    private Contacto contacto;

    protected Direccion() { }

    public Direccion(String valor, TipoDireccion tipo, Contacto contacto) {
        this.valor = valor;
        this.tipo = tipo;
        this.contacto = contacto;
    }

    public Direccion(Integer id, String valor, TipoDireccion tipo, Contacto contacto) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.contacto = contacto;
    }

    public Integer getId() {
        return id;
    }

    public String getValor() {
        return valor;
    }

    public TipoDireccion getTipoDireccion() {
        return tipo;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
