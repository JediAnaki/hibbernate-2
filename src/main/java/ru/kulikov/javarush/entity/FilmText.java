package ru.kulikov.javarush.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film_text", schema = "movie")
public class FilmText {

    @Id
    @Column(name = "film_id", nullable = false)
    private short filmId;

    @Column(name = "title", length = 254, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;
}
