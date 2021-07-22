package com.prueba.crud.servicesimpl;

import com.prueba.crud.CrudApplication;
import com.prueba.crud.requests.numerosRequest;
import com.prueba.crud.services.calculadoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Lazy
@Service
public class calculadoraServiceImpl implements calculadoraService {

    private static final Logger logger = LoggerFactory.getLogger(CrudApplication.class);

    @Override
    public List<Double> calculadora(List<numerosRequest> datos) {
        List<Double> sal= new ArrayList<Double>();
        for (numerosRequest dat : datos)
        {
            if (dat.getOperacion() == null) {
                throw new RuntimeException("Operación imposible de procesar: " + dat.getOperacion());
            }
            switch (dat.getOperacion().charAt(0)) {
                case '+':
                    sal.add(dat.getNumero1() + dat.getNumero2());
                    //return dat.getNumero1() + dat.getNumero2();
                    break;
                case '-':
                    sal.add(dat.getNumero1() - dat.getNumero2());
                    break;
                //return dat.getNumero1() - dat.getNumero2();
                case '*':
                    sal.add(dat.getNumero1() * dat.getNumero2());
                    break;
                //return dat.getNumero1() * dat.getNumero2();
                case '/':
                    sal.add(dat.getNumero1() / dat.getNumero2());
                    break;
                //return dat.getNumero1() / dat.getNumero2();
                default:
                    throw new RuntimeException("Operación no soportada para ser calculada: " + dat.getOperacion());

            }

        }
        return sal;
    }
}
