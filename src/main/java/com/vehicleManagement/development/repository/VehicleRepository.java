package com.vehicleManagement.development.repository;

import com.vehicleManagement.development.model.entity.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles, Long> {
}
