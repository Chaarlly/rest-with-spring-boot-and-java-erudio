package br.com.erudio.controller;

import br.com.erudio.model.Person;
import br.com.erudio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    // POST para buscar por id (modo legado)
    @RequestMapping(value = "/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Person>> findById(@PathVariable("id") Long id) {
        Optional<Person> person = Optional.ofNullable(service.findById(id));
        return ResponseEntity.ok(person);
    }

    // POST para buscar todos (modo legado)
    @RequestMapping(value = "/findall",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = service.findAll();
        return ResponseEntity.ok(persons);
    }

    // POST para criar
    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person created = service.create(person);
        return ResponseEntity.ok(created);
    }

    // PUT para atualizar
    @RequestMapping(value = "/update/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> update(@PathVariable("id") Long id, @RequestBody Person person) {
        Person updated = service.update(id, person);
        return ResponseEntity.ok(updated);
    }

    // DELETE para remover
    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
