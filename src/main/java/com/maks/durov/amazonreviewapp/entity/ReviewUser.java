package com.maks.durov.amazonreviewapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "review_users")
public class ReviewUser {
    @Id
    private String id;
    private String name;
}
