package com.nahuel.clinic_api.repository;

import com.nahuel.clinic_api.entity.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
}
