package com.spring.generator.CSV.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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
