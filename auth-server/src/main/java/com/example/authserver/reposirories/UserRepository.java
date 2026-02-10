package com.example.authserver.reposirories;
import com.example.authserver.models.User;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);
}
