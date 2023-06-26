package com.spring.generator.CSV.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    private Long id;

    @Column(name = "user_name")
    @NotBlank(message = "username is mandatory")
    private String userName;

    @Column(name = "address")
    @NotBlank(message = "address is mandatory")
    private String address;

    @Column(name = "city")
    @NotBlank(message = "city is mandatory")
    private String city;
}
