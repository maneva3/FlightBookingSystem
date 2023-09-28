package com.flightbookingsystem.dto;

<<<<<<< HEAD
public class UpdatePersonalInfoDTO {
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UpdatePersonalInfoDTO {
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "[0-9]{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;
>>>>>>> ec270f741e24252b45f1cd1c66ea0e49cb7792d1
}
