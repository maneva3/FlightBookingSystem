package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    List<User> findAllByPersonalInfoFirstName(String firstName);
    List<User> findAllByPersonalInfoLastName(String lastName);
    User findByPersonalInfoPhoneNumber(String phoneNumber);

    @Query("SELECT u FROM User u JOIN u.tickets ticket WHERE ticket.bookingReference = ?1")
    User findByTicketBookingReference(String bookingReference);
}
