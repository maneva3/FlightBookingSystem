package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.LuggageType;
import com.flightbookingsystem.data.enums.TravelClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "booking_reference")
    private String bookingReference;

    @ManyToOne(targetEntity = Flight.class)
    @JoinColumn(name = "flight_id")
    @NotNull(message = "Flight must be set!")
    private Flight flight;

    @Column(name = "seat")
    @Pattern(regexp = "([1-9]|[1-3][0-9])[A-F]", message = "Seat must be in format: XX[A-F] or X[A-F]")
    private String seat;

    @Column(name = "travel_class")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Choose travel class!")
    private TravelClass travelClass;

    @Column(name = "luggage_type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Choose luggage type!")
    private LuggageType luggageType;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    @NotNull(message = "User must be set!")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(bookingReference, ticket.bookingReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingReference);
    }
}
