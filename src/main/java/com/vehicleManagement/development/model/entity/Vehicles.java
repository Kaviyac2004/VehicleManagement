package com.vehicleManagement.development.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicles")
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private int year;
    private String licensePlateNumber;
    private String vin;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String status; // Available, Rented, Under Maintenance, In Repair
    private double dailyRate;
    private double weeklyRate;
    private double monthlyRate;

    private LocalDate dateAdded;
    private LocalDate lastMaintenanceDate;
    private LocalDate nextMaintenanceDue;

}