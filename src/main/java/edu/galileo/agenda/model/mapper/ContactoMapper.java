package edu.galileo.agenda.model.mapper;

import edu.galileo.agenda.model.dto.ContactoDTO;
import edu.galileo.agenda.model.dto.DireccionDTO;
import edu.galileo.agenda.model.dto.TelefonoDTO;
import edu.galileo.agenda.model.entity.Contacto;
import edu.galileo.agenda.model.entity.Direccion;
import edu.galileo.agenda.model.entity.Telefono;

import java.util.List;
import java.util.stream.Collectors;

public class ContactoMapper {

    public static ContactoDTO toDTO(Contacto entity) {
        if (entity == null) { return null; }

        List<DireccionDTO> direcciones = entity.getDireccionList()
                .stream()
                .map(direccion -> new DireccionDTO(direccion.getId(), direccion.getValor(), direccion.getTipoDireccion().name()))
                .collect(Collectors.toList());

        List<TelefonoDTO> telefonos = entity.getTelefonoList()
                .stream()
                .map(telefono -> new TelefonoDTO(telefono.getId(), telefono.getValor(), telefono.getTipo().name()))
                .collect(Collectors.toList());

        return new ContactoDTO(entity.getId(), entity.getNombre(), direcciones, telefonos);
    }

    public static Contacto toEntity(ContactoDTO dto) {
        if (dto == null) { return null; }

        Contacto contacto = new Contacto(dto.getNombre());
        contacto.setId(dto.getId());

        List<Direccion> direcciones = dto.getDireccionesList()
                .stream()
                .map(direccion -> new Direccion(direccion.getId(), direccion.getValor(), Direccion.TipoDireccion.valueOf(direccion.getTipo()), contacto))
                .collect(Collectors.toList());

        List<Telefono> telefonos = dto.getTelefonosList()
                .stream()
                .map(telefono -> new Telefono(telefono.getId(), telefono.getValor(), Telefono.TipoTelefono.valueOf(telefono.getTipo()), contacto))
                .collect(Collectors.toList());

        contacto.setDireccionList(direcciones);
        contacto.setTelefonoList(telefonos);


        return contacto;
    }

}
