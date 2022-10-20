package com.spring.generator.CSV.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;
}
