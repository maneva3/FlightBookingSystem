package com.flightbookingsystem.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "authority")
    private String authority;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
