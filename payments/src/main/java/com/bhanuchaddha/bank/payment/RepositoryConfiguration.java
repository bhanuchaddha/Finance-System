package com.bhanuchaddha.bank.payment;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * By default Spring Data Rest does not spit out IDs. However you can selectively enable it through exposeIdsFor(..) method. You could do this in configuration, something like this
 */
@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Payment.class);
    }
}
