package com.example.distributioncentre.model;


import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Item {
    public enum Brands {
        DIOR("Dior"), STONE_ISLAND("Stone Island"), PALMANGELS("Palm Angels"), BALENCIAGA ("Balenciaga"), CHANEL("Chanel");
        
        @JsonValue
        @NotBlank
        private String title;
        Brands(String title){
            this.title = title;
        }
        public String getTitle(){
            return title;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private Brands brand;
    @Min(2021)
    private int created;
    @Min(1000)
    private int price;
    private int quantity;
    
    @Builder.Default
    private LocalDate createdAt = LocalDate.now();
}
