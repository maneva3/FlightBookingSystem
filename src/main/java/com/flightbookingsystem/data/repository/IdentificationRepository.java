package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.Identification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificationRepository extends JpaRepository<Identification, String> {

}
