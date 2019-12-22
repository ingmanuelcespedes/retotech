package com.intercorp.retotech.dto.expose;

import com.intercorp.retotech.dto.ClientDetailDto;
import lombok.Data;

import java.util.List;
@Data
public class ListClientsRs {
    List<ClientDetailDto> listClients;
}
