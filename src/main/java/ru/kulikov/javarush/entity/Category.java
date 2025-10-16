package ru.kulikov.javarush.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category", schema = "movie")
public class Category {

    @Id
    @Column(name = "category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte categoryId;

    @Column(name = "name", length = 25, nullable = false)
    private String name;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;
}
