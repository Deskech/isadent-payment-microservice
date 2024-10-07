package com.microservices.Abono.Infrastructure.Entities.CommandLine;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
/**
 * Entity class representing a payment record in the database.
 * This class is mapped to the "writeAbonos" table and contains fields for payment details.
 */
@Entity
@Table(name = "writeAbonos")
@Getter
@Setter
public class WritePaymentEntity {
    @Id
    @Column(name = "factura_id")
    private long paymentId;
    @Column(name = "paciente_nombre")
    private String patientName;
    @Column(name = "abono_valor")
    private Double paymentValue;
    @Column(name = "abono_currency")
    private String paymentCurrency;
    @Column(name = "fecha_pago")
    private LocalDate paymentDate;
}
