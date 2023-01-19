package com.cars.api.model;

import java.sql.Date;
import java.time.Year;

import com.cars.api.dto.CarsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cars {

  public Cars(CarsDTO data) {
    this.modelo = data.modelo();
    this.fabricante = data.fabricante();
    this.dataFabricacao = data.dataFabricacao();
    this.anoModelo = data.anoModelo();
    this.valor = data.valor();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String modelo;

  @Column(length = 50, nullable = false)
  private String fabricante;

  @Column(length = 10, nullable = false)
  private Date dataFabricacao;

  @Column(length = 20, nullable = false)
  private double valor;

  @Column(length = 4, nullable = false)
  private Year anoModelo;
}
