package br.com.erudio.controller;

import br.com.erudio.model.Person;
import br.com.erudio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    // GET para buscar por id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> findById(@PathVariable("id") Long id) {
        Person person = service.findById(id);
        return ResponseEntity.ok(person);
    }

    // GET para buscar todos
    @GetMapping(value = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = service.findAll();
        return ResponseEntity.ok(persons);
    }

    // POST para criar
    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person created = service.create(person);
        return ResponseEntity.ok(created);
    }

    // PUT para atualizar
    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> update(@PathVariable("id") Long id, @RequestBody Person person) {
        Person updated = service.update(id, person);
        return ResponseEntity.ok(updated);
    }

    // DELETE para remover
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
