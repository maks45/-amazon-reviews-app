package com.maks.durov.amazonreviewapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "review_users")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReviewUser {
    @Id
    @Column(name = "user_id")
    private String id;
    @Column(name = "user_name")
    private String name;
}
