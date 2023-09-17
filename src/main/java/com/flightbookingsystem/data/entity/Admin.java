package com.flightbookingsystem.data.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Admin {
    @EmbeddedId
    private UserIdentification  userIdentification;

}
