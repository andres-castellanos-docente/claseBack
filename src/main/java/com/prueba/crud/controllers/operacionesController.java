package com.prueba.crud.controllers;

import com.prueba.crud.CrudApplication;
import com.prueba.crud.requests.numerosRequest;
import com.prueba.crud.responses.calculadoraResponse;
import com.prueba.crud.services.calculadoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class operacionesController {

    @Autowired
    private HttpServletRequest request;

    private static final Logger logger = LoggerFactory.getLogger(operacionesController.class);

    @Lazy
    @Autowired
    calculadoraService calcService;

    @GetMapping("/oper/{num1}/{num2}")
    public Double getSumar(@PathVariable(value = "num1") Double numero1,
                           @PathVariable(value = "num2") Double numero2) {

        return numero1 + numero2;

    }

    @PostMapping("/oper")
    public Double postSumar(@RequestBody numerosRequest datos) {
        return datos.getNumero1() + datos.getNumero2();
    }

    @PutMapping("/oper")
    public Double putSumar(@RequestBody numerosRequest datos) {
        return datos.getNumero1() + datos.getNumero2();
    }

    @DeleteMapping("/oper/{num1}/{num2}")
    public Double deleteSumar(@PathVariable(value = "num1") Double numero1,
                              @PathVariable(value = "num2") Double numero2) {
        return numero1 + numero2;

    }


    @PostMapping("/operaciones")
    public Double postOper(@RequestBody numerosRequest datos) {

        if (datos.getOperacion() == null) {
            throw new RuntimeException("Operación imposible de procesar: " + datos.getOperacion());
        }

        switch (datos.getOperacion().charAt(0)) {
            case '+':
                return datos.getNumero1() + datos.getNumero2();
            case '-':
                return datos.getNumero1() - datos.getNumero2();
            case '*':
                return datos.getNumero1() * datos.getNumero2();
            case '/':
                return datos.getNumero1() / datos.getNumero2();
            default:
                throw new RuntimeException("Operación no soportada para ser calculada: " + datos.getOperacion());

        }
    }


    @PostMapping("/dowhile")
    public List<String> postDoWhile() {
        List<String> sal= new ArrayList<>();

        Integer i=20;
        do{
            System.out.println(i);
            sal.add(i.toString());
            i++;
        }while(i<=10);

        return sal;
    }



    @PostMapping("/while")
    public List<String> postOperwhile() {
        List<String> sal= new ArrayList<>();
        Integer i = 0;
        while (i < 5) {
            sal.add(i.toString());
            System.out.println(i);
            i++;
        }

        return sal;
    }



    @PostMapping("/operacionesmuchos")
    public List<Double> postOpermuchos(@RequestBody List<numerosRequest> datos) {
        return calcService.calculadora(datos);
    }





    @PostMapping("/operacionesif")
    public Double postOperif(@RequestBody numerosRequest datos) {

        logger.info("Usuario inicia operacion " + datos.getNumero1() + datos.getOperacion().charAt(0)+ datos.getNumero2() + "ip :"+ request.getRemoteAddr()); //Print a Info Logger Msg

        //System.out.println(new Date());
        if (datos.getOperacion() == null) {
            logger.error("INFO - Level Log Message"); //Print a Info Logger Msg
            throw new RuntimeException("Operación imposible de procesar: " + datos.getOperacion());
        }
        else if (datos.getOperacion().charAt(0) == '+') {
            return datos.getNumero1() + datos.getNumero2();

        } else if (datos.getOperacion().charAt(0) == '-') {
            return datos.getNumero1() - datos.getNumero2();

        } else if (datos.getOperacion().charAt(0) == '*') {
            return datos.getNumero1() * datos.getNumero2();

        } else if (datos.getOperacion().charAt(0) == '/') {
            return datos.getNumero1() / datos.getNumero2();

        }
        else {
            throw new RuntimeException("Operación no soportada para ser calculada: " + datos.getOperacion());
        }

    }

    @PostMapping("/operacionesifjson")
    public calculadoraResponse postOperifjson(@RequestBody numerosRequest datos) {
        //System.out.println(new Date());

        if (datos.getOperacion() == null) {
            return new calculadoraResponse(-1, "Operación no soportada para ser calculada: " + datos.getOperacion(), new Double(0));
            //throw new RuntimeException("Operación imposible de procesar: " + datos.getOperacion());
        }
        else if (datos.getOperacion().charAt(0) == '+') {
            return  new calculadoraResponse(1, "Se hizo ok", datos.getNumero1() + datos.getNumero2());
            /* ret.setCodError(1);
            ret.setResultado(datos.getNumero1() + datos.getNumero2());
            ret.setMessError("Se hizo ok"); */
            //return datos.getNumero1() + datos.getNumero2();

        } else if (datos.getOperacion().charAt(0) == '-') {
            return  new calculadoraResponse(1, "Se hizo ok", datos.getNumero1() - datos.getNumero2());
            //return datos.getNumero1() - datos.getNumero2();

        } else if (datos.getOperacion().charAt(0) == '*') {
            return   new calculadoraResponse(1, "Se hizo ok", datos.getNumero1() + datos.getNumero2());
            //return datos.getNumero1() * datos.getNumero2();

        } else if (datos.getOperacion().charAt(0) == '/') {
            //return datos.getNumero1() / datos.getNumero2();
            return new calculadoraResponse(1, "Se hizo ok", datos.getNumero1() + datos.getNumero2());

        }
        else {
            return new calculadoraResponse(-1, "Operación no soportada para ser calculada: " + datos.getOperacion(), new Double(0));
            //throw new RuntimeException("Operación no soportada para ser calculada: " + datos.getOperacion());
        }
        //return ret;

    }




}
