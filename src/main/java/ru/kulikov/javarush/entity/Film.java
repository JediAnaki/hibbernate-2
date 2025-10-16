package ru.kulikov.javarush.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.Year;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film",  schema = "movie")
public class Film {

    @Id
    @Column(name = "film_id", nullable = false)
    private short filmId;

    @Column(name = "title", length = 128, nullable = false)
    private String title;

    @Type(type = "text")
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "release_year", columnDefinition = "year")
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @Column(name = "rental_duration", nullable = false)
    private byte rentalDuration;

    @Column(name = "rental_rate", precision = 4, scale = 2, nullable = false)
    private BigDecimal rentalRate;

    @Column(name = "length")
    private short length;

    @Column(name = "replacement_cost", precision = 5, scale = 2, nullable = false)
    private BigDecimal replacementCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating", columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    private Rating rating;

    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;
}
