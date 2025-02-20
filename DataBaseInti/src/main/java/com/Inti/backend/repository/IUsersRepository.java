package com.Inti.backend.repository;


import com.Inti.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findById(Long id);

}
