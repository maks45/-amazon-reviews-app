package com.maks.durov.amazonreviewapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "review_users")
@EqualsAndHashCode
public class ReviewUser {
    @Id
    @Column(name = "user_id")
    private String id;
    @Column(name = "user_name")
    private String name;
}
