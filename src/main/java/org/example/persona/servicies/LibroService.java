package org.example.persona.servicies;

import java.util.List;
import java.util.Optional;

import org.example.persona.entities.Libro;
import org.example.persona.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LibroService implements BaseService<Libro> {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    @Transactional
    public List<Libro> findAll() throws Exception {
        try {
            List<Libro> libros = libroRepository.findAll();
            return libros;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro findById(Long id) throws Exception {
        try {
            Optional<Libro> libros = libroRepository.findById(id);
            return libros.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro save(Libro entity) throws Exception {
        try {
            entity = libroRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro update(Long id, Libro entity) throws Exception {
        try {
            Optional<Libro> entityOptional = libroRepository.findById(id);
            Libro lib1 = entityOptional.get();
            lib1 = libroRepository.save(entity);
            return lib1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (libroRepository.existsById(id)) {
                libroRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No existe esa persona");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
