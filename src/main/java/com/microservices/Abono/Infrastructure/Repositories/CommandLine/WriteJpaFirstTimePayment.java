package com.microservices.Abono.Infrastructure.Repositories.CommandLine;

import com.microservices.Abono.Infrastructure.Entities.CommandLine.WritePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Stores the first patient's payment in the command line database.
 */
@Repository
public interface WriteJpaFirstTimePayment extends JpaRepository<WritePaymentEntity,Long> {
}
