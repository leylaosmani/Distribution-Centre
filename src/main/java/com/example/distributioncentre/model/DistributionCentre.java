package com.example.distributioncentre.model;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class DistributionCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String item;
    private int available;
    private int longitude;
    private int latitude;
  
    public static class DistributionCentreBuilder {
        private String name;
        private String item;
        private int available;
        private int longitude;
        private int latitude;

        public DistributionCentreBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DistributionCentreBuilder item(String item) {
            this.item = item;
            return this;
        }

        public DistributionCentreBuilder available(int available) {
            this.available = available;
            return this;
        }

        public DistributionCentreBuilder longitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        public DistributionCentreBuilder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

      public DistributionCentre build() {
    return new DistributionCentre(null, name, item, available, longitude, latitude);
}
    }

    public static DistributionCentreBuilder builder() {
        return new DistributionCentreBuilder();
    }
}
