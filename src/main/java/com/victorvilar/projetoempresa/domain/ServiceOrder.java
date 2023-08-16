package com.victorvilar.projetoempresa.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * CRIAR OBJETO ORDEM DE SERVIÇO -- todo
 */

public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate emissionDate = LocalDate.now();
    private LocalDate serviceDate;
    private String manifestINEA;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    @Column(nullable = false)
    private ItemContract itemContract;

    private String observation;
    private String osFileUrl;






}
