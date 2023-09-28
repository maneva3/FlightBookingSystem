package com.flightbookingsystem.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "client")
public class Client {
    @Id
    private Long id;
    //private UserIdentification userIdentification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id")
    private PersonalInfo personalInfo;

    //TODO: add tickets
}
