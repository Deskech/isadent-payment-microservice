package com.microservices.Abono.Infrastructure.Repositories.Query;

import com.microservices.Abono.Infrastructure.Entities.Query.QueryPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Retrieves a payment history
 */
@Repository
public interface QueryAbonoRepository extends JpaRepository<QueryPaymentEntity, Long> {

    @Query("select f from QueryPaymentEntity f where f.patientName= :patientName")
    List<QueryPaymentEntity> showPayment(@Param("patientName") String patientName);
}
