package com.microservices.Abono.Infrastructure.Services;


import org.springframework.stereotype.Component;


import java.text.NumberFormat;
import java.util.Locale;

/**
 * Utility class for formatting monetary values based on the US currency format.
 */
@Component
public class Currency {
    private final NumberFormat numberFormat;

    public Currency(){
        this.numberFormat= NumberFormat.getCurrencyInstance(Locale.US);
    }
    /**
     * Formats a given double value into a currency string using the US currency format.
     *
     * @param value The monetary value to format.
     * @return A string representing the formatted currency value.
     */
    public String moneyFormat(Double value){
       return numberFormat.format(value);
    }

}
