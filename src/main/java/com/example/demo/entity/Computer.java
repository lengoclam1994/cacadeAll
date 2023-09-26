package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "warranty_duration")
    private Integer warrantyDuration;

    private Long price;

    @OneToOne(mappedBy="computer")
    private Inventory inventory;

    public Computer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
