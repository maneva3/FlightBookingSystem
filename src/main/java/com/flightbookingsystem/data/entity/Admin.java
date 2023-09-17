package com.flightbookingsystem.data.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Admin {
    @EmbeddedId
    private UserIdentification  userIdentification;

}
