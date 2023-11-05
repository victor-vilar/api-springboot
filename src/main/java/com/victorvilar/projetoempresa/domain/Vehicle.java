package com.victorvilar.projetoempresa.domain;


import com.victorvilar.projetoempresa.enums.VechicleType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

/**
 * REPRESENTAR UM VEICULO -- todo
 */
public class Vehicle {

    private String id;
    //tipo de Veiculo
    @Enumerated(EnumType.STRING)
    private VechicleType type;

    //placa XXX-XXXX
    @Column(nullable = false)
    private String plate;

    //renavam
    private String renavam;

    //url do ultimo crlv emitido
    private String validCrlvUrl;


    /**
     * ABASTECIMENTOS REALIZADOS
     */
    @OneToMany
    List<Refueling> fills = new ArrayList<>();

    /**
    *DESCARTES REALIZADOS
    */
    // @OneToMany
    //List<Tratament> tratamentList = ArrayList<>();
}
