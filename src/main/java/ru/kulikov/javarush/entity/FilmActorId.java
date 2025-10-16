package ru.kulikov.javarush.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class FilmActorId implements Serializable {
    private short actorId;
    private short filmId;
}
