package com.flightbookingsystem.data.entity;

import com.flightbookingsystem.data.enums.LuggageType;
import com.flightbookingsystem.data.enums.TravelClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bookingReference;

    @ManyToOne(targetEntity = Flight.class)
    @JoinColumn(name = "ticket_id")
    @NotNull
    private Flight flight;

    @Column(name = "seat")
    @Pattern(regexp = "([1-9]|[1-3][0-9])[A-F]", message = "Seat must be in format: XX[A-F] or X[A-F]")
    private String seat;

    @Column(name = "starting_price")
    @Positive(message = "Price must be positive!")
    private BigDecimal startingPrice;

    @Column(name = "travel_class")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Choose travel class!")
    private TravelClass travelClass;

    @Column(name = "luggage_type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Choose luggage type!")
    private LuggageType luggageType;

    BigDecimal getPrice(TravelClass travelClass, LuggageType luggageType){
        double travelClassMultiplier;
        if (travelClass == TravelClass.ECONOMY){
            travelClassMultiplier = 1;
        }
        else if(travelClass == TravelClass.BUSINESS){
            travelClassMultiplier = 1.3;
        }
        else {
            travelClassMultiplier = 2;
        }

        double luggageTypeMultiplier;
        if (luggageType == LuggageType.FREE){
            luggageTypeMultiplier = 1;
        }
        else if(luggageType == LuggageType.CABIN){
            luggageTypeMultiplier = 1.2;
        }
        else {
            luggageTypeMultiplier = 1.5;
        }
        return BigDecimal.valueOf(startingPrice.doubleValue()*travelClassMultiplier*luggageTypeMultiplier);
    }
}
