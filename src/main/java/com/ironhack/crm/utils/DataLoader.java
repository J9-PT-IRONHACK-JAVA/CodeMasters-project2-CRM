package com.ironhack.crm.utils;

import com.ironhack.crm.model.Lead;
import com.ironhack.crm.model.SalesRep;
import com.ironhack.crm.repository.LeadRepository;
import com.ironhack.crm.repository.SalesRepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final SalesRepRepository salesRepRepository;
    private final LeadRepository leadRepository;

    @Bean
    void loadSalesRepData(){
        var salesRep1 = new SalesRep("Juana Gomez", "juana.gomez@email.com", "123456");
        salesRepRepository.save(salesRep1);

        var salesRep2 = new SalesRep("Lucho Padrique", "lucho@amunique.com", "MarruecosVive");
        salesRepRepository.save(salesRep2);

    }

    @Bean
    void loadLeadsData() {
        var lead1 = new Lead("Pepe Perez", "+34 666123987", "pepe@desatranques.com", "Desatranques Jaén");
        leadRepository.save(lead1);

        var lead2 = new Lead("Tomás Torquemada", "+34 666666666", "tomas@santainquisicion.gov", "La Santa Inquisición");
        leadRepository.save(lead2);

        var lead3 = new Lead("Eliseo Reclus", "+33 666987312", "eliseo@paris.com", "Geografía en Globo");
        leadRepository.save(lead3);
    }

}
