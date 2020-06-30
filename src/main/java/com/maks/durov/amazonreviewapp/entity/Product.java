package com.maks.durov.amazonreviewapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "review_products")
public class Product {
    @Id
    private String id;
}
