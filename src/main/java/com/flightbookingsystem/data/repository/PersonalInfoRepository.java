package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
}
