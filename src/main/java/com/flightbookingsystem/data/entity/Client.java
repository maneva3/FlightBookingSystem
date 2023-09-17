package com.flightbookingsystem.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @EmbeddedId
    private UserIdentification userIdentification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id")
    private PersonalInfo personalInfo;

}
