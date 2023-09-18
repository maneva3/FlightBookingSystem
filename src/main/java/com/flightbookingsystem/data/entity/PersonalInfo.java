package com.flightbookingsystem.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "personal_info")
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identification_number", referencedColumnName = "identification_number")
    private Identification identification;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Column(name = "phone_number")
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "[0-9]{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Column(name = "credit_card")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_number", referencedColumnName = "card_number")
    private CreditCard creditCard;

    @OneToOne(mappedBy = "personalInfo")
    private Client client;
}
