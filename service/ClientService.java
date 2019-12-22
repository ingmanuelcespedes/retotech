package com.intercorp.retotech.service;

import com.intercorp.retotech.dto.expose.ClientDetailRq;
import com.intercorp.retotech.dto.expose.ClientDetailRs;
import com.intercorp.retotech.dto.expose.KpiClientRs;
import com.intercorp.retotech.dto.expose.ListClientsRs;

public interface ClientService {
    ClientDetailRs createClient(ClientDetailRq clientDetailRq);
    KpiClientRs kpiClient();
    ListClientsRs listClient();
}
