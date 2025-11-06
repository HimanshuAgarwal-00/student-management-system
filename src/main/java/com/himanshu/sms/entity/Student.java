package com.himanshu.sms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int rollNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double marks;
}