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
@Table(name = "store", schema = "movie")
public class Store {

    @Id
    @Column(name = "store_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte storeId;

    @OneToOne
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private Staff manager;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}
