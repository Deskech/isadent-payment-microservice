package com.microservices.Abono.Domain.Factories;

import com.microservices.Abono.Domain.Model.Query.PaymentView;
/**
 * Factory interface for creating PaymentView objects from a given type.
 *
 *
 */
public interface PaymentViewFactory<T>{
    /**
     * Creates a PaymentView from the given object.
     *
     * @param paymentView The object used to create the PaymentView.
     * @return A PaymentView instance.
     */
    PaymentView create(T paymentView);
}
