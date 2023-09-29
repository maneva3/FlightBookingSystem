package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.IdentificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, String> {

}
