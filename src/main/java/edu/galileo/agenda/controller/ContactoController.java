package edu.galileo.agenda.controller;

import edu.galileo.agenda.model.dto.ContactoDTO;
import edu.galileo.agenda.model.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    private final ContactoService contactoService;

    @Autowired
    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @PostMapping
    public ContactoDTO save(@RequestBody ContactoDTO contactoDTO) {
        return contactoService.save(contactoDTO);
    }

    @GetMapping("/{id}")
    public ContactoDTO getById(@PathVariable("id") Integer id) {
        return contactoService.findById(id);
    }

    @GetMapping
    public List<ContactoDTO> getAll() {
        return contactoService.findAll();
    }

    @PutMapping("/{id}")
    public ContactoDTO update(@PathVariable("id") Integer id, @RequestBody ContactoDTO contactoDTO) {
        return contactoService.update(id, contactoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        contactoService.deleteById(id);
    }
}
