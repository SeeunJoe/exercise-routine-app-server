package com.metacoding.exerciseappserver.fitness;

import com.metacoding.exerciseappserver.category.Category;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "fitness_tb")
public class Fitness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, unique = true)
    private String fitnessName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String content;

    @Builder
    public Fitness(Integer id, String fitnessName, Category category, String imageUrl, String content) {
        this.id = id;
        this.fitnessName = fitnessName;
        this.category = category;
        this.imageUrl = imageUrl;
        this.content = content;
    }
}
