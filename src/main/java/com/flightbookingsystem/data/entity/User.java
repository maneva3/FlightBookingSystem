package com.flightbookingsystem.data.entity;

<<<<<<< HEAD:src/main/java/com/flightbookingsystem/data/entity/UserIdentification.java
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
=======
import jakarta.persistence.*;
>>>>>>> main:src/main/java/com/flightbookingsystem/data/entity/User.java
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
<<<<<<< HEAD:src/main/java/com/flightbookingsystem/data/entity/UserIdentification.java
@Embeddable
public class UserIdentification implements java.io.Serializable {
=======
@Entity
@Table(name = "user")
public class User {
    @Id
>>>>>>> ec270f741e24252b45f1cd1c66ea0e49cb7792d1:src/main/java/com/flightbookingsystem/data/entity/User.java
    @Column(name = "username")
    @Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
    private String username;

    @Column(name = "password")
    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit!")
    @Size(min = 8, max = 64, message = "The password must contain at least 8 characters!")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id")
    private PersonalInfo personalInfo;

    @Column(name = "tickets")
    @OneToMany(targetEntity = Ticket.class, mappedBy = "user")
    private Set<Ticket> tickets;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles;
}
