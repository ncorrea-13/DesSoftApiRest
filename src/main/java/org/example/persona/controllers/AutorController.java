package org.example.persona.controllers;

import lombok.AllArgsConstructor;
import org.example.persona.entities.Autor;
import org.example.persona.servicies.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
@AllArgsConstructor
public class AutorController {
    private AutorService autorService;

    @GetMapping("")
    public ResponseEntity<?> getAll() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(autorService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, porfavor intente más tarde\" \"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(autorService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, porfavor intente más tarde\" \"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Autor entity) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(autorService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, porfavor intente más tarde\" \"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Autor entity) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(autorService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, porfavor intente más tarde\" \"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autorService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, porfavor intente más tarde\" \"}");
        }
    }
}
