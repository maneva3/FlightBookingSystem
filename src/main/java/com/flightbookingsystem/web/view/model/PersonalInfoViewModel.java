package com.flightbookingsystem.web.view.model;

import com.flightbookingsystem.data.entity.CreditCard;
import com.flightbookingsystem.data.entity.Identification;
<<<<<<< HEAD
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
=======
import com.flightbookingsystem.data.entity.User;
import jakarta.persistence.*;
>>>>>>> main
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonalInfoViewModel {
    @NotNull(message = "Identification must be set!")
    private Identification identification;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "[0-9]{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Column(name = "credit_card")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_number", referencedColumnName = "card_number")
    private CreditCard creditCard;

    @NotNull(message = "User must be set!")
    private User user;
}
