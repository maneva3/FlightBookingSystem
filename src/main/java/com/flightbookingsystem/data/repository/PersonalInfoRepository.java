package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
    List<PersonalInfo> findAllByFirstName(String firstName);
    List<PersonalInfo> findByLastName(String lastName);
    List<PersonalInfo> findByFirstNameAndLastName(String firstName, String lastName);
    PersonalInfo findByPhoneNumber(String phoneNumber);
    PersonalInfo findByUserUsername(String username);
}
