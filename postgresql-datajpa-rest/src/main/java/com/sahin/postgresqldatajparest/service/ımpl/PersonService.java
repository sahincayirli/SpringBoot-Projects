package com.sahin.postgresqldatajparest.service.ımpl;

import com.sahin.postgresqldatajparest.dto.PersonDTO;

import com.sahin.postgresqldatajparest.entity.Address;
import com.sahin.postgresqldatajparest.entity.AddressType;
import com.sahin.postgresqldatajparest.entity.Person;
import com.sahin.postgresqldatajparest.entity.signature.EntitySign;
import com.sahin.postgresqldatajparest.repository.AddressRepository;
import com.sahin.postgresqldatajparest.repository.PersonRepository;
import com.sahin.postgresqldatajparest.service.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService implements EntityService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    public PersonDTO save(PersonDTO dto) {

        Person person = new Person();
        person.setId(dto.getId());
        person.setFisrtName(dto.getFirstName());
        person.setLastName(dto.getLastName());

        Person dbPerson = personRepository.save(person);

        Set<Address> addresses = new HashSet<>();
        dto.getAdresses().forEach( item -> {
                    Address address = new Address();
                    address.setAddress(item);
                    address.setActive(true);
                    address.setAddressType(AddressType.HOME);
                    address.setPerson(dbPerson);
                    addresses.add(address);
                }
        );
        addressRepository.saveAll(addresses);
        dto.setId(dbPerson.getId());
        return dto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Collection<PersonDTO> getAll() {

        List<Person> personList = personRepository.findAll();
        List<PersonDTO> personDTOList = new ArrayList<>();

        personList.forEach(item -> {
            PersonDTO dto = new PersonDTO();
            dto.setId(item.getId());
            dto.setFirstName(item.getFisrtName());
            dto.setLastName(item.getLastName());
            dto.setAdresses(item.getAddresses().stream().map(Address::getAddress).collect(Collectors.toSet()));
            personDTOList.add(dto);
        });

        return personDTOList;

    }

    @Override
    public Page<PersonDTO> getAll(Pageable pageable) {
        return null;
    }
}
