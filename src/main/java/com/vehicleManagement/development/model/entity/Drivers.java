package com.vehicleManagement.development.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drivers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_license_id")
    private DriverLicense driverLicense;

    // Login credentials (optional, if applicable)
    private String username;
    private String password; // Hashed and secured

    private LocalDate dateOfBirth; // Optional

    // Loyalty program details (optional)
    private int loyaltyPoints;
    private String membershipTier;

    // Getters and Setters omitted for brevity
}