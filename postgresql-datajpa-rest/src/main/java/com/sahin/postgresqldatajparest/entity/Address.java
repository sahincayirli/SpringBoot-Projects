package com.sahin.postgresqldatajparest.entity;

import com.sahin.postgresqldatajparest.entity.signature.EntitySign;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address implements EntitySign, Serializable {

    @Id
    @SequenceGenerator(name = "seq_address",allocationSize = 1)
    @GeneratedValue(generator = "seq_address",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500)
    private String address;
    @Enumerated
    private AddressType addressType;
    @Column
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "person_address_id")
    private Person person;


}
