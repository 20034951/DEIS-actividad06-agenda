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
@Table(name = "telefono")
public class Telefono {

    public enum TipoTelefono {
        MOVIL,
        FIJO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTelefono tipo;

    @ManyToOne
    @JoinColumn(name = "contacto_id", nullable = false)
    private Contacto contacto;

    protected Telefono() {}

    public Telefono(String valor, TipoTelefono tipo, Contacto contacto) {
        this.valor = valor;
        this.tipo = tipo;
        this.contacto = contacto;
    }

    public Telefono(Integer id, String valor, TipoTelefono tipo, Contacto contacto) {
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

    public TipoTelefono getTipo() {
        return tipo;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
