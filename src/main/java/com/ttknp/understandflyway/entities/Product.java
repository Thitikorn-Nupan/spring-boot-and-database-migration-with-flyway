package com.ttknp.understandflyway.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
// I got bug @Data it's not generated getter setter *** Error From IDE ?? *** ToString() still work
// fix by run on cmd or add version on pom file
@Data
// @Getter
// @Setter
@NoArgsConstructor
public class Product {
   /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Double price;
    @Getter
    @Setter
    private Integer quantity;
    @Getter
    @Setter
    private String sku;
    @Getter
    @Setter
    private Boolean active;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String sku;
    private Boolean active;

}
