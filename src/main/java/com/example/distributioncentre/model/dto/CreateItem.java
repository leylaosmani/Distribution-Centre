package com.example.distributioncentre.model.dto;

import com.example.distributioncentre.model.Item;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateItem {
    @NotBlank
    private String name;
    @NotNull
    private Item.Brands brand;
    @Min(2021)
    private int created;
    @Min(1000)
    private int price;
    @NotNull
    private int quantity;
    @NotNull
    private Long distributionId;

    public Item toItem() {
        return Item.builder()
                .name(this.getName())
                .created(this.getCreated())
                .price(this.getPrice())
                .quantity(this.getQuantity())
                .brand(this.getBrand())
                .distributionId(this.getDistributionId())
                .build();
    }
}
