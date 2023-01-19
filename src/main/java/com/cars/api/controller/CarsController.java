package com.cars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarsDTO;
import com.cars.api.model.Cars;
import com.cars.api.repository.CarsRepository;

import jakarta.validation.Valid;
import lombok.Delegate;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

  @Autowired
  private CarsRepository repository;

  @GetMapping
  public List<Cars> listAll() {
    return repository.findAll();
  }

  @PostMapping
  public void createCars(@RequestBody @Valid CarsDTO req) {
    repository.save(new Cars(req));
  }

  @DeleteMapping("/{id}")
  public void deleteCars(@PathVariable Long id) {
    repository.deleteById(id);
  }

  @PutMapping("/{id}")
  public void updateCars(@PathVariable Long id, @RequestBody @Valid CarsDTO req) {
    repository.findById(id).map(car -> {
      car.setModelo(req.modelo());
      car.setFabricante(req.fabricante());
      car.setDataFabricacao(req.dataFabricacao());
      car.setAnoModelo(req.anoModelo());
      car.setValor(req.valor());

      return repository.save(car);
    });
  }
}
