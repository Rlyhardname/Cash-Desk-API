package com.task.cashdesk.configurations;

import com.task.cashdesk.models.entity.Cashier;
import com.task.cashdesk.businesslogic.CashDesk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InternalObjectsConfiguration {

    @Bean
    public CashDesk initObjects() {
        return new CashDesk(new Cashier("MARTINA"));
    }
}
