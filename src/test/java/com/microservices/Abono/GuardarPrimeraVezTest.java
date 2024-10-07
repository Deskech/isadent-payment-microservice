package com.microservices.Abono;

import com.microservices.Abono.Application.Dto.NewPayment;
import com.microservices.Abono.Application.Services.SavePayments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class GuardarPrimeraVezTest {
    @Autowired
    private SavePayments savePayments;

    @Test
    void guardarAbonos(){
        NewPayment newPayment = new NewPayment("pruebaParaAlgo",300.00);

        savePayments.setNewPayment(newPayment);
    }
    @Test
    void firstPayment(){
        NewPayment newPayment= new NewPayment("pruebaParaAlgo",3000.00);

        savePayments.firstPayment(newPayment);
    }
}
