package com.example.distributioncentre.model;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class DistributionCentre {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
    
        @NotBlank
        private String name;
    
        @NotBlank
        private String latitude;
    
        @NotBlank
        private String longitude;

        private int available;
    
    
        public DistributionCentre(String name, String latitude, String longitude, int available) {
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
            this.available = available;
        }
    }