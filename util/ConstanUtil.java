package com.intercorp.retotech.util;

import com.intercorp.retotech.dto.ClientDetailDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConstanUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstanUtil.class);

    public final static String LOGGER_FORMAT_DATE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String FORMAT_DATE_BT		= "ddMMyyyy";
    public static final int YEAR_PERSON = 70;
    public static final String DATE_00000000		= "00000000";
    private static List<ClientDetailDto> listClients = new ArrayList<>();
    public final static String SUCCESFULL = "create ok";
    static {
        inizialice();
    }
    public static void addClient (ClientDetailDto clientDetailDto){
        listClients.add(clientDetailDto);
    }

    public static List<ClientDetailDto> getClients () {
        return listClients;
    }

    public static Date parseToDate(String date, String dateFormat) {
        if (StringUtils.isNotBlank(date) && !date.equals(DATE_00000000)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                return sdf.parse(date);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return null;
    }

    public static String parseDateToString(Date date) {
        try {
            Format formatter = new SimpleDateFormat(FORMAT_DATE_BT);
            return formatter.format(date);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public static void inizialice () {
        ClientDetailDto clientDetailDto = new ClientDetailDto();
        clientDetailDto.setName("Alexander Manuel");
        clientDetailDto.setLastName("Cespedes Leonardo");
        clientDetailDto.setAge(30);
        clientDetailDto.setDate("25121988");
        addClient(clientDetailDto);

        ClientDetailDto clientDetailDto2 = new ClientDetailDto();
        clientDetailDto2.setName("Deborah Esther");
        clientDetailDto2.setLastName("Cespedes Leonardo");
        clientDetailDto2.setAge(28);
        clientDetailDto2.setDate("20021990");
        addClient(clientDetailDto2);

        ClientDetailDto clientDetailDto3 = new ClientDetailDto();
        clientDetailDto3.setName("Juan Pablo Daniel");
        clientDetailDto3.setLastName("Cespedes Leonardo");
        clientDetailDto3.setAge(26);
        clientDetailDto3.setDate("08071992");
        addClient(clientDetailDto3);

        ClientDetailDto clientDetailDto4 = new ClientDetailDto();
        clientDetailDto4.setName("Jeremy Jesus");
        clientDetailDto4.setLastName("Cespedes Leonardo");
        clientDetailDto4.setAge(23);
        clientDetailDto4.setDate("19021996");
        addClient(clientDetailDto4);

        ClientDetailDto clientDetailDto5 = new ClientDetailDto();
        clientDetailDto5.setName("Rocio del Pilar");
        clientDetailDto5.setLastName("Cespedes Leonardo");
        clientDetailDto5.setAge(21);
        clientDetailDto5.setDate("31051998");
        addClient(clientDetailDto5);

        ClientDetailDto clientDetailDto6 = new ClientDetailDto();
        clientDetailDto6.setName("Kassandra Abigail");
        clientDetailDto6.setLastName("Cespedes Leonardo");
        clientDetailDto6.setAge(8);
        clientDetailDto6.setDate("26082010");
        addClient(clientDetailDto6);
    }
}
