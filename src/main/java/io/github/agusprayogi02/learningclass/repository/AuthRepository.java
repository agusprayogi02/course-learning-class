package io.github.agusprayogi02.learningclass.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.agusprayogi02.learningclass.model.UserModel;

@Repository
@EnableJpaRepositories
public interface AuthRepository extends CrudRepository<UserModel, UUID> {
    public UserModel findByEmail(String email);
}
