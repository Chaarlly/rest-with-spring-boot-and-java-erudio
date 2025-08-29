package br.com.erudio.service;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all persons");
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 10; i++) {
            Person person = mockPerson(i);
            persons.add(person);

        }
        return persons;
    }

    public Person findById(Long id) {
        logger.info("Finding person with id: " + id);

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Charly");
        person.setLastName("Dev");
        person.setAddress("São Paulo/SP");
        person.setGender("M");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating person");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating person");
        return person;
    }

    public void delete(Long id) {
        logger.info("Deleting person with id: " + id);

    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Address " + i);
        person.setGender("Gender " + i);
        return person;
    }

}
