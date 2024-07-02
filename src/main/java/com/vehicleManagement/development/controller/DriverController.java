package com.vehicleManagement.development.controller;

import com.vehicleManagement.development.model.entity.Drivers;
import com.vehicleManagement.development.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverRepository repository;

    // Create (POST) - Add a new Drivers
    @PostMapping
    public ResponseEntity<Drivers> createDriver(@RequestBody Drivers driver) {
        Drivers savedDriver = repository.save(driver);
        return ResponseEntity.ok(savedDriver);
    }

    // Read (GET) - Retrieve all Drivers
    @GetMapping
    public ResponseEntity<List<Drivers>> getAllDrivers() {
        List<Drivers> Drivers = repository.findAll();
        return ResponseEntity.ok(Drivers);
    }

    // Read (GET) - Get a Drivers by ID
    @GetMapping("/{id}")
    public ResponseEntity<Drivers> getDriverById(@PathVariable Long id) {
        Optional<Drivers> Driver = repository.findById(id);
        if (Driver.isPresent()) {
            return ResponseEntity.ok(Driver.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update (PUT) - Update an existing Drivers
    @PutMapping("/{id}")
    public ResponseEntity<Drivers> updateDriver(@PathVariable Long id, @RequestBody Drivers vehicle) {
        Optional<Drivers> existingDriver = repository.findById(id);
        if (existingDriver.isPresent()) {
            vehicle.setId(existingDriver.get().getId()); // Set ID to avoid creating new record
            Drivers updatedDriver= repository.save(vehicle);
            return ResponseEntity.ok(updatedDriver);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete (DELETE) - Remove a Drivers by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
