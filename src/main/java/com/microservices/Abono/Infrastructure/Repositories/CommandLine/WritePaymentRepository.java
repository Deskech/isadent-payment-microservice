package com.microservices.Abono.Infrastructure.Repositories.CommandLine;

import com.microservices.Abono.Infrastructure.Entities.CommandLine.WritePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Stores a new payment
 */
@Repository
public interface WritePaymentRepository extends JpaRepository<WritePaymentEntity,Long> {

    @Modifying
    @Query("update WritePaymentEntity f set f.paymentValue= :paymentValue, f.paymentCurrency= :paymentCurrency,f.paymentDate= :paymentDate where f.patientName= :patientName")
    void registerLastPayment(@Param("paymentValue")Double paymentValue, @Param("paymentCurrency")String paymentCurrency,
                             @Param("patientName")String patientName, @Param("paymentDate")LocalDate paymentDate);

    boolean existsByPatientName(String patientName);
}
