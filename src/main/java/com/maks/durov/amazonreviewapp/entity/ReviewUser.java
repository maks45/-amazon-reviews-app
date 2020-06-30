package com.maks.durov.amazonreviewapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "review_users")
public class ReviewUser {
    @Id
    private String id;
    private String name;
}
