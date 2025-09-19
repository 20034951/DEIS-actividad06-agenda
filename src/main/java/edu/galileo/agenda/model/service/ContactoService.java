package edu.galileo.agenda.model.service;

import edu.galileo.agenda.model.dto.ContactoDTO;

import java.util.List;

public interface ContactoService {
    ContactoDTO save(ContactoDTO contactoDTO);
    ContactoDTO findById(Integer id);
    List<ContactoDTO> findAll();
    ContactoDTO update(Integer id, ContactoDTO contactoDTO);
    void deleteById(Integer id);
}
