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
@Table(name = "language", schema = "movie")
public class Language {

    @Id
    @Column(name = "language_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte languageId;

    @Column(name = "name", length = 20, nullable = false)
    private char name;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;
}
