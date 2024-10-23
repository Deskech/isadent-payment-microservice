package com.microservices.Abono.Infrastructure.Repositories.Query;

import com.microservices.Abono.Infrastructure.Entities.Query.QueryPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Saves the events comming from the command line database.
 */
@Repository
public interface QueryPaymentActualization extends JpaRepository<QueryPaymentEntity, Long> {


}
