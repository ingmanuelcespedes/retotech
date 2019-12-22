package com.intercorp.retotech.service.Impl;

import com.intercorp.retotech.dto.expose.KpiClientRs;
import com.intercorp.retotech.dto.expose.ListClientsRs;
import com.intercorp.retotech.util.ConstanUtil;
import org.apache.commons.lang3.StringUtils;
import com.intercorp.retotech.dto.ClientDetailDto;
import com.intercorp.retotech.dto.expose.ClientDetailRq;
import com.intercorp.retotech.dto.expose.ClientDetailRs;
import com.intercorp.retotech.service.ClientService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public ClientDetailRs createClient(ClientDetailRq clientDetailRq) {
        ClientDetailDto clientDetailDto = new ClientDetailDto();
        clientDetailDto.setName(StringUtils.trimToEmpty(clientDetailRq.getName()));
        clientDetailDto.setLastName(StringUtils.trimToEmpty(clientDetailRq.getLastName()));
        clientDetailDto.setAge(clientDetailRq.getAge());
        clientDetailDto.setDate(StringUtils.trimToEmpty(clientDetailRq.getDate()));
        ConstanUtil.addClient(clientDetailDto);
        ClientDetailRs clientDetailRs = new ClientDetailRs();
        clientDetailRs.setMessage(ConstanUtil.SUCCESFULL);
        return clientDetailRs;
    }

    @Override
    public KpiClientRs kpiClient() {
        KpiClientRs kpiClientRs = new KpiClientRs();
        kpiClientRs.setAverage(average(ConstanUtil.getClients()));
        kpiClientRs.setStandarDesviation(standarDesviation(ConstanUtil.getClients(), kpiClientRs.getAverage()));
        return kpiClientRs;
    }

    @Override
    public ListClientsRs listClient() {
        ListClientsRs listClientsRs = new ListClientsRs();
        listClientsRs.setListClients(ConstanUtil.getClients().stream().map( x -> parseListClientRs(x)).collect(Collectors.toList()));
        return listClientsRs;
    }

    public ClientDetailDto parseListClientRs(ClientDetailDto clientDetailDto){
        ClientDetailDto clientDetailDtoRs = new ClientDetailDto();
        clientDetailDtoRs.setName(clientDetailDto.getName());
        clientDetailDtoRs.setLastName(clientDetailDto.getLastName());
        clientDetailDtoRs.setAge(clientDetailDto.getAge());
        clientDetailDtoRs.setDate(clientDetailDto.getDate());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ConstanUtil.parseToDate(clientDetailDto.getDate(),ConstanUtil.FORMAT_DATE_BT));
        calendar.add(Calendar.YEAR, ConstanUtil.YEAR_PERSON);
        clientDetailDtoRs.setProbableDateOfDeath(ConstanUtil.parseDateToString(calendar.getTime()));
        return clientDetailDtoRs;
    }

    private Double average(List<ClientDetailDto> listClients) {
        long value = NumberUtils.LONG_ZERO;
        for (ClientDetailDto clientDetailDto: listClients
             ) {
            value += clientDetailDto.getAge();
        }
        return Double.valueOf(value / listClients.size());
    }

    private Double standarDesviation(List<ClientDetailDto> listClients, Double average) {
        Double values = Double.valueOf(NumberUtils.LONG_ZERO);
        for (ClientDetailDto clientDetailDto: listClients
        ) {
            values += Math.pow(clientDetailDto.getAge() - average, 2);
        }
        return values / listClients.size();
    }
}