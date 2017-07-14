package com.github.davinkevin.poc.jooqdiscovery.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kevin on 14/07/2017.
 */
@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper().registerModules(
                        new VavrModule()
                );
    }

}
