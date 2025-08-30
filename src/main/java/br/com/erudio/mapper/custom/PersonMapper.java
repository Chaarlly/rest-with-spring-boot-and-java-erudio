package br.com.erudio.mapper.custom;

import br.com.erudio.dto.v2.PersonDTOV2;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    // Entity > DTO

    public PersonDTOV2 entityToDTO(Person person) {
        PersonDTOV2 dto =  new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(person.getBirthDay());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person DtoToEntity(PersonDTOV2 dto) {
        Person entity = new Person();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthDay(dto.getBirthDay());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());
        return entity;
    }

}
