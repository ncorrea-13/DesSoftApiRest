package org.example.persona.servicies;


import jakarta.transaction.Transactional;
import org.example.persona.entities.Autor;
import org.example.persona.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements BaseService<Autor> {
    @Autowired
    private AutorRepository autoresRepository;

    @Override
    @Transactional
    public List<Autor> findAll() throws Exception {
        try {
            List<Autor> autores = autoresRepository.findAll();
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor findById(Long id) throws Exception {
        try {
            Optional<Autor> autores = autoresRepository.findById(id);
            return autores.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor save(Autor entity) throws Exception {
        try {
            entity = autoresRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor update(Long id, Autor entity) throws Exception {
        try {
            Optional<Autor> entityOptional = autoresRepository.findById(id);
            Autor autor1 = entityOptional.get();
            autor1 = autoresRepository.save(entity);
            return autor1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (autoresRepository.existsById(id)) {
                autoresRepository.deleteById(id);
                return true;
            }else {
                throw new Exception("No existe esa persona");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
