package com.cars.api.dto;

import java.sql.Date;
import java.time.Year;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarsDTO(
    @NotBlank String modelo,

    @NotBlank String fabricante,

    @Past @NotNull Date dataFabricacao,

    @NumberFormat @NotNull double valor,

    @NotNull Year anoModelo) {

}
