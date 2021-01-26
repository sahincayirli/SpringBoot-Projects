package com.sahin.postgresqldatajparest.repository;

import com.sahin.postgresqldatajparest.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
