package com.vehicleManagement.development.controller;

import com.vehicleManagement.development.model.entity.Vehicles;
import com.vehicleManagement.development.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    // Create (POST) - Add a new vehicle
    @PostMapping
    public ResponseEntity<Vehicles> createVehicle(@RequestBody Vehicles vehicle) {
        Vehicles savedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    // Read (GET) - Retrieve all vehicles
    @GetMapping
    public ResponseEntity<List<Vehicles>> getAllVehicles() {
        List<Vehicles> vehicles = vehicleRepository.findAll();
        return ResponseEntity.ok(vehicles);
    }

    // Read (GET) - Get a vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicles> getVehicleById(@PathVariable Long id) {
        Optional<Vehicles> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            return ResponseEntity.ok(vehicle.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update (PUT) - Update an existing vehicle
    @PutMapping("/{id}")
    public ResponseEntity<Vehicles> updateVehicle(@PathVariable Long id, @RequestBody Vehicles vehicle) {
        Optional<Vehicles> existingVehicle = vehicleRepository.findById(id);
        if (existingVehicle.isPresent()) {
            vehicle.setId(existingVehicle.get().getId()); // Set ID to avoid creating new record
            Vehicles updatedVehicle = vehicleRepository.save(vehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete (DELETE) - Remove a vehicle by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}