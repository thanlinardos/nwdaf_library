package io.nwdaf.eventsubscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.nwdaf.eventsubscription.customModel.DiscoverMessage;
import io.nwdaf.eventsubscription.customModel.NefUeState;
import io.nwdaf.eventsubscription.model.*;
import io.nwdaf.eventsubscription.utilities.ConvertUtil;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String json = """
                     {
                               "202010000000002": {
                                 "mnc": 1,
                                 "name": "UE2",
                                 "external_identifier": "10002@domain.com",
                                 "description": "This is a UE",
                                 "speed": "LOW",
                                 "ip_address_v4": "10.0.0.2",
                                 "latitude": 37.998709,
                                 "ip_address_v6": "::2",
                                 "longitude": 23.819015,
                                 "mac_address": "22-00-00-00-00-02",
                                 "path_id": 2,
                                 "dnn": "province1.mnc01.mcc202.gprs",
                                 "owner_id": 1,
                                 "Cell_id": 1,
                                 "supi": "202010000000002",
                                 "mcc": 202,
                                 "cell_id_hex": "AAAAA1001",
                                 "gnb_id_hex": "AAAAA1"
                               },
                               "202010000000001": {
                                 "mnc": 1,
                                 "name": "UE1",
                                 "external_identifier": "10001@domain.com",
                                 "description": "This is a UE",
                                 "speed": "LOW",
                                 "ip_address_v4": "10.0.0.1",
                                 "latitude": 37.998528,
                                 "ip_address_v6": "::1",
                                 "longitude": 23.819448,
                                 "mac_address": "22-00-00-00-00-01",
                                 "path_id": 2,
                                 "dnn": "province1.mnc01.mcc202.gprs",
                                 "owner_id": 1,
                                 "Cell_id": 1,
                                 "supi": "202010000000001",
                                 "mcc": 202,
                                 "cell_id_hex": "AAAAA1001",
                                 "gnb_id_hex": "AAAAA1"
                               },
                               "202010000000003": {
                                 "mnc": 1,
                                 "name": "UE3",
                                 "external_identifier": "10003@domain.com",
                                 "description": "This is a UE",
                                 "speed": "HIGH",
                                 "ip_address_v4": "10.0.0.3",
                                 "latitude": 37.998048,
                                 "ip_address_v6": "::3",
                                 "longitude": 23.819472,
                                 "mac_address": "22-00-00-00-00-03",
                                 "path_id": 2,
                                 "dnn": "province1.mnc01.mcc202.gprs",
                                 "owner_id": 1,
                                 "Cell_id": 2,
                                 "supi": "202010000000003",
                                 "mcc": 202,
                                 "cell_id_hex": "AAAAA1002",
                                 "gnb_id_hex": "AAAAA1"
                               }
                             }
                """;
        Map<String, Object> map = objectMapper.readValue(json, new TypeReference<>() {
        });
        List<String> supiList = map.keySet().stream().toList();
        List<UeMobility> ueMobilityList = new ArrayList<>();
        List<UeCommunication> ueCommunicationList = new ArrayList<>();
        for (String supi : supiList) {
            NefUeState nefUeState = objectMapper.convertValue(map.get(supi), NefUeState.class);

            UeMobility ueMobility = ConvertUtil.mapNefUeStateToUeMobility(nefUeState);
            PointUncertaintyCircle pointUncertaintyCircle = ConvertUtil
                    .decodeEllipsoidPointWithUncertaintyCircle(ueMobility
                            .getLocInfos().getFirst().getLoc().getNrLocation().getGeographicalInformation().substring(8));
            System.out.println(pointUncertaintyCircle);

            UeCommunication ueCommunication = ConvertUtil.mapNefUeStateToUeCommunication(nefUeState);

            ueMobilityList.add(ueMobility);
            ueCommunicationList.add(ueCommunication);
        }

        System.out.println(ueMobilityList);
        System.out.println(ueCommunicationList);

        PointUncertaintyCircle point = new PointUncertaintyCircle().point(new GeographicalCoordinates()
                .lon(23.819015).lat(37.998709))
                .uncertainty(10.0)
                .type("PointUncertaintyCircle");
        point.setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapes.SupportedGADShapesEnum.PointUncertaintyCircle));
        System.out.println(point);
        PointUncertaintyCircle pp = PointUncertaintyCircle.fromMap(point.toMap());
        System.out.println(pp);
        PointUncertaintyCircle ppp = objectMapper.convertValue(point.toMap(), PointUncertaintyCircle.class);
        System.out.println(ppp);

        DiscoverMessage msg = DiscoverMessage.builder()
                .availableOffset(12).requestedOffset(12).collectorInstanceId(UUID.randomUUID()).expectedWaitTime(1).requestedEvent(NwdafEvent.NwdafEventEnum.NF_LOAD).build();
        String str = msg.toString();
        System.out.println(DiscoverMessage.fromString(str));
    }
}
