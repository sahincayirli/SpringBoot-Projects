package com.sahin.postgresqldatajparest.service;


import com.sahin.postgresqldatajparest.dto.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface EntityService {

    PersonDTO save(PersonDTO dto);
    void delete(Long id);
    Collection<PersonDTO> getAll();
    Page<PersonDTO> getAll(Pageable pageable);

}
