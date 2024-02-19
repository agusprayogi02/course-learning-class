package io.github.agusprayogi02.learningclass.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserModel extends BaseModel {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(length = 150)
    private String name;
    @Column(length = 150, unique = true)
    private String email;
    private String password;
    @Column(length = 20)
    private String role;
}
