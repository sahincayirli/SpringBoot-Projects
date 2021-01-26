package com.sahin.postgresqldatajparest.entity;

import com.sahin.postgresqldatajparest.entity.signature.EntitySign;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person implements EntitySign {

    @Id
    @SequenceGenerator(name = "seq_person",allocationSize = 1)
    @GeneratedValue(generator = "seq_person",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 50)
    private String fisrtName;
    @Column(length = 50)
    private String lastName;
    @OneToMany
    @JoinColumn(name = "person_address_id")
    private Set<Address> addresses;

}
