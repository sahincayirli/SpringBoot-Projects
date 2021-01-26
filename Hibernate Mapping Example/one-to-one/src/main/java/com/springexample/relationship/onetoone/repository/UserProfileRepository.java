package com.springexample.relationship.onetoone.repository;

import com.springexample.relationship.onetoone.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
}
