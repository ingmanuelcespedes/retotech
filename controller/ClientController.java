package com.intercorp.retotech.controller;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;
import com.intercorp.retotech.dto.expose.ClientDetailRq;
import com.intercorp.retotech.dto.expose.ClientDetailRs;
import com.intercorp.retotech.dto.expose.KpiClientRs;
import com.intercorp.retotech.dto.expose.ListClientsRs;
import com.intercorp.retotech.service.ClientService;
import com.intercorp.retotech.util.ConstanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import javax.validation.Valid;

@RestController
@Api(tags = "Clients", description = "Detail Clients")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
    private static final Gson GSON = new GsonBuilder().serializeNulls().setDateFormat(ConstanUtil.LOGGER_FORMAT_DATE).create();

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/creacliente/v1",
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<ClientDetailRs> createClient(@Valid @RequestBody ClientDetailRq request) throws Exception {
        LOGGER.debug("createClient() -> request : {}", GSON.toJson(request));
        return ResponseEntity.ok(clientService.createClient(request));
    }

    @GetMapping(value = "/kpideClientes/v1", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<KpiClientRs> kpiClient() throws Exception {
        LOGGER.debug("kpiClient() -> request : {}");
        return ResponseEntity.ok(clientService.kpiClient());
    }

    @GetMapping(value = "/listclientes/v1", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<ListClientsRs> listClient() throws Exception {
        LOGGER.debug("listClient() -> request : {}");
        return ResponseEntity.ok(clientService.listClient());
    }
}
