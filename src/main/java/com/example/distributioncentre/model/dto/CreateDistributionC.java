package com.example.distributioncentre.model.dto;

import com.example.distributioncentre.model.DistributionCentre;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDistributionC {
    @NotBlank
    private String name;
    @NotBlank
    private String latitude;
    @NotBlank
    private String longitude;
    private int available;

    public DistributionCentre toCreateDistributionC() {
        return DistributionCentre.builder()
                .name(this.getName())
                .latitude(this.getLatitude())
                .longitude(this.getLongitude())
                .available(this.getAvailable())
                .build();
    }
}
