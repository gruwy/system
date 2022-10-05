package com.suprapartimport.system.item;

import org.springframework.context.annotation.Configuration;


@Configuration
public class ItemConfig {
    // Commented out data that is inserted via create-drop config during learning. Changed app.prop to validate
    /*@Bean
    CommandLineRunner commandLineRunner (ItemRepository repository) {
        return args -> {
            Item panel = new Item(
                    "Panel"
            );

            Item panel2 = new Item(
                    "Panel2"
            );

        repository.saveAll(
                List.of(panel, panel2)
        );
        };*/
    }
