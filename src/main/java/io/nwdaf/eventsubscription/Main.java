package io.nwdaf.eventsubscription;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.IntStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.nwdaf.eventsubscription.customModel.NefUeState;
import io.nwdaf.eventsubscription.model.*;
import io.nwdaf.eventsubscription.utilities.Constants;
import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import org.springframework.util.Assert;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

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

        NefEventNotification notification = NefEventNotification.builder()
                .event(NefEvent.UE_MOBILITY)
                .timeStamp(OffsetDateTime.now().withNano(0))
                .ueMobilityInfos(Collections.nCopies(5, UeMobilityInfo.builder()
                        .supi("202010000000003")
                        .appId("appID")
                        .ueTrajs(Collections.nCopies(5, UeTrajectoryInfo.builder()
                                .ts(OffsetDateTime.now().withNano(0))
                                .location(new UserLocation()
                                        .nrLocation(new NrLocation()
                                                .ueLocationTimestamp(OffsetDateTime.now().withNano(0))
                                                .geographicalInformation("01010110101010110")
                                                .ncgi(new Ncgi().plmnId(new PlmnId().mcc("123").mnc("123")).nrCellId("001"))))
                                .build()))
                        .build()))
                .build();
        String originalNotif = objectMapper.writeValueAsString(notification);
//        System.out.println(originalNotif);
        NefEventNotification readNotification = objectMapper.reader().readValue(
                "{\"event\": \"UE_MOBILITY\", \"timeStamp\": \"2024-02-12T23:02:24+02:00\", \"ueMobilityInfos\": [{\"supi\": \"202010000000003\", \"appId\": \"appID\", \"ueTrajs\": [{\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}]}, {\"supi\": \"202010000000003\", \"appId\": \"appID\", \"ueTrajs\": [{\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}]}, {\"supi\": \"202010000000003\", \"appId\": \"appID\", \"ueTrajs\": [{\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}]}, {\"supi\": \"202010000000003\", \"appId\": \"appID\", \"ueTrajs\": [{\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}]}, {\"supi\": \"202010000000003\", \"appId\": \"appID\", \"ueTrajs\": [{\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}, {\"ts\": \"2024-02-12T23:02:24+02:00\", \"location\": {\"eutraLocation\": null, \"nrLocation\": {\"tai\": null, \"ncgi\": {\"plmnId\": {\"mcc\": \"123\", \"mnc\": \"123\"}, \"nrCellId\": \"001\", \"nid\": null}, \"ignoreNcgi\": false, \"ageOfLocationInformation\": null, \"ueLocationTimestamp\": \"2024-02-12T23:02:24+02:00\", \"geographicalInformation\": \"01010110101010110\",  \"geodeticInformation\": null, \"globalGnbId\": null}}}]}]}\n",
                NefEventNotification.class
        );
        String givenNotif = objectMapper.writeValueAsString(readNotification);
//        System.out.println(givenNotif);
//        Assert.isTrue(Objects.equals(originalNotif, givenNotif), "message");

        NefEventExposureSubsc subsc = NefEventExposureSubsc.builder()
                .dataAccProfId("srrgw")
                .eventsRepInfo(new ReportingInformation()
                        .immRep(true)
                        .repPeriod(1)
                        .notifMethod(new NotificationMethod().notifMethod(NotificationMethod.NotificationMethodEnum.PERIODIC)))
                .eventsSubs(Collections.nCopies(2, NefEventSubs.builder()
                                .event(NefEvent.UE_MOBILITY)
                                .appId("241455")
                                .eventFilter(NefEventFilter.builder()
                                        .locArea(new NetworkAreaInfo().id(UUID.randomUUID())
                                                .ecgis(List.of(new Ecgi().nid("3423566").plmnId(Constants.plmnId))))
                                        .build())
                        .build()))
                .build();

        System.out.println(objectMapper.reader().readValue(
                "{\"dataAccProfId\": \"\", \"eventsSubs\": [{\"event\": \"UE_MOBILITY\", \"eventFilter\": null, \"supi\": null, \"interGroupId\": null, \"appId\": null, \"comms\": null}], \"eventsRepInfo\": {\"immRep\": true, \"notifMethod\": {\"notifMethod\": null}, \"maxReportNbr\": null, \"monDur\": null, \"repPeriod\": 1, \"sampRatio\": null, \"partitionCriteria\": null, \"grpRepTime\": null, \"notifFlag\": null}, \"notifUri\": \"http://localhost:\", \"eventNotifs\": [{\"event\": null, \"timeStamp\": null, \"ueMobilityInfos\": null}], \"notifId\": \"11122233\", \"suppFeat\": \"10101010\"}\n"
                , NefEventExposureSubsc.class));
    }
}
