package com.microservices.Abono.Infrastructure.Entities.Query;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@SuppressWarnings("all")
/**
 * Entity class representing a queryable payment record in the database.
 * This class is mapped to the "queryAbonos" table and contains fields for retrieving payment details.
 */
@Entity
@Table(name = "queryAbonos")
@Setter
@Getter
public class QueryPaymentEntity {
    @Id
    @Column(name = "factura_id")
    private long paymentId;
    @Column(name = "paciente_nombre")
    private String patientName;
    @Column(name = "fecha_pago")
    private LocalDate paymentDate;
    @Column(name = "abono_currency")
    private String paymentCurrency;
}
