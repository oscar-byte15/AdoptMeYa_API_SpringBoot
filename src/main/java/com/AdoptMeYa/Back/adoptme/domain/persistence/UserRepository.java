package com.AdoptMeYa.Back.adoptme.domain.persistence;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
