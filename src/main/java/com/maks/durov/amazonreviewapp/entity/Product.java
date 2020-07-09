package com.maks.durov.amazonreviewapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "review_products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
}
