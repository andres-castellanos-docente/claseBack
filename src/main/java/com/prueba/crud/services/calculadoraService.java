package com.prueba.crud.services;

import com.prueba.crud.requests.numerosRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface calculadoraService {

    List<Double> calculadora(@RequestBody List<numerosRequest> datos);
}
