package com.flightbookingsystem.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
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

    @ManyToMany(fetch = FetchType.EAGER)
    protected Set<Role> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public String getPassword(){
        return password;
    }
}
