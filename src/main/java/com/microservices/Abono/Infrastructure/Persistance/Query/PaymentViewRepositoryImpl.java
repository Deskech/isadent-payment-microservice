package com.microservices.Abono.Infrastructure.Persistance.Query;

import com.microservices.Abono.Domain.Factories.PaymentViewFactory;
import com.microservices.Abono.Domain.Model.Query.PaymentView;
import com.microservices.Abono.Domain.Repositories.Query.PaymentViewRepository;
import com.microservices.Abono.Infrastructure.Entities.Query.QueryPaymentEntity;
import com.microservices.Abono.Infrastructure.Repositories.Query.QueryAbonoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Implementation of the PaymentViewRepository interface for retrieving and displaying payment history.
 * This class queries the database to show the payment history of a patient.
 */
@Component
public class PaymentViewRepositoryImpl implements PaymentViewRepository {
    private final QueryAbonoRepository queryAbonoRepository;
    private final PaymentViewFactory<QueryPaymentEntity> paymentViewFactory;
    public PaymentViewRepositoryImpl(QueryAbonoRepository queryAbonoRepository, PaymentViewFactory<QueryPaymentEntity> paymentViewFactory){
        this.queryAbonoRepository= queryAbonoRepository;
        this.paymentViewFactory = paymentViewFactory;
    }
    /**
     * Retrieves and displays the payment history for a given patient.
     *
     * @param patientName The name of the patient whose payment history is being requested.
     * @return A list of PaymentView objects representing the patient's payment history.
     */
    @Override
    public List<PaymentView> seePaymentHistory(String patientName) {

            List<QueryPaymentEntity> queryPaymentEntity = queryAbonoRepository.showPayment(patientName);

        return queryPaymentEntity.stream()
                    .map(paymentViewFactory::create)
                    .collect(Collectors.toList());

    }
}
