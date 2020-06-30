package com.maks.durov.amazonreviewapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity(name = "reviews")
public class Review {
    @Id
    private Long id;
    private String summary;
    private String text;
    private LocalDateTime reviewTime;
    @ManyToOne
    private Product product;
    @ManyToOne
    private ReviewUser reviewUser;
}
