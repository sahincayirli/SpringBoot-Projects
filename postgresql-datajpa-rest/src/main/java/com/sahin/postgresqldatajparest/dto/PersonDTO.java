package com.sahin.postgresqldatajparest.dto;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO{

    private Long id;
    private String firstName;
    private String lastName;
    private Set<String> adresses;

}
