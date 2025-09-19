package edu.galileo.agenda.model.dto;

import java.util.List;

public class ContactoDTO {

    private Integer id;
    private String nombre;
    private List<DireccionDTO> direccionesList;
    private List<TelefonoDTO> telefonosList;

    public ContactoDTO() {
    }

    public ContactoDTO(Integer id, String nombre, List<DireccionDTO> direccionesList,
            List<TelefonoDTO> telefonosList) {
        this.id = id;
        this.nombre = nombre;
        this.direccionesList = direccionesList;
        this.telefonosList = telefonosList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DireccionDTO> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<DireccionDTO> direccionesList) {
        this.direccionesList = direccionesList;
    }

    public List<TelefonoDTO> getTelefonosList() {
        return telefonosList;
    }

    public void setTelefonosList(List<TelefonoDTO> telefonosList) {
        this.telefonosList = telefonosList;
    }
}
