package edu.galileo.agenda.model.service;

import edu.galileo.agenda.model.dto.ContactoDTO;
import edu.galileo.agenda.model.entity.Contacto;
import edu.galileo.agenda.model.mapper.ContactoMapper;
import edu.galileo.agenda.model.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository contactoRepository;

    @Autowired
    public ContactoServiceImpl(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @Override
    public ContactoDTO save(ContactoDTO contactoDTO) {
        Contacto contacto = ContactoMapper.toEntity(contactoDTO);
        Contacto saved = contactoRepository.save(contacto);
        return ContactoMapper.toDTO(saved);
    }

    @Override
    public List<ContactoDTO> findAll() {
        return ((List<Contacto>) contactoRepository.findAll())
                .stream()
                .map(ContactoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactoDTO findById(Integer id) {
        return contactoRepository.findById(id)
                .map(ContactoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado"));
    }

    @Override
    public ContactoDTO update(Integer id, ContactoDTO contactoDTO) {
        return contactoRepository.findById(id)
                .map(existente -> {
                    Contacto contacto = ContactoMapper.toEntity(contactoDTO);
                    contacto.setId(existente.getId());
                    return ContactoMapper.toDTO(contactoRepository.save(contacto));
                })
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado"));
    }

    @Override
    public void deleteById(Integer id) {
        if(!contactoRepository.existsById(id)) {
            throw new RuntimeException("Contacto no encontrado");
        }
        contactoRepository.deleteById(id);
    }


}
