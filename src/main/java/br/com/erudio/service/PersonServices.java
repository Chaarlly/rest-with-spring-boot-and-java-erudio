package br.com.erudio.service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all persons");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding person with id: " + id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
    }

    public Person create(Person person) {
        logger.info("Creating person");
        return repository.save(person);
    }

    public Person update(Long id, Person person) {
        logger.info("Updating person with id: " + id);
        Person existing = findById(id);
        existing.setFirstName(person.getFirstName());
        existing.setLastName(person.getLastName());
        existing.setAddress(person.getAddress());
        existing.setGender(person.getGender());
        return repository.save(existing);
    }

    public void delete(Long id) {
        logger.info("Deleting person with id: " + id);
        Person existing = findById(id);
        repository.delete(existing);
    }
}
