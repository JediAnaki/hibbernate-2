package ru.kulikov.javarush.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class FilmCategoryId implements Serializable {
    private short filmId;
    private byte categoryId;
}
