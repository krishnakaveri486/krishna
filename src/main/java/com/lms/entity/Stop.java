package com.lms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "stop")
public class Stop {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "stop_name")
    private String stopName;



}