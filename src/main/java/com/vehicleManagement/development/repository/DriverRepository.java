package com.vehicleManagement.development.repository;

import com.vehicleManagement.development.model.entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Drivers,Long> {
}