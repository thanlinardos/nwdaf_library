package io.nwdaf.eventsubscription;

import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.nwdaf.eventsubscription.model.CellGlobalId;
import io.nwdaf.eventsubscription.model.Ecgi;
import io.nwdaf.eventsubscription.model.EutraLocation;
import io.nwdaf.eventsubscription.model.GNbId;
import io.nwdaf.eventsubscription.model.GeraLocation;
import io.nwdaf.eventsubscription.model.Gli;
import io.nwdaf.eventsubscription.model.GlobalRanNodeId;
import io.nwdaf.eventsubscription.model.HfcNodeId;
import io.nwdaf.eventsubscription.model.LocationAreaId;
import io.nwdaf.eventsubscription.model.LocationInfo;
import io.nwdaf.eventsubscription.model.N3gaLocation;
import io.nwdaf.eventsubscription.model.NFType;
import io.nwdaf.eventsubscription.model.NfLoadLevelInformation;
import io.nwdaf.eventsubscription.model.NfStatus;
import io.nwdaf.eventsubscription.model.NrLocation;
import io.nwdaf.eventsubscription.model.PlmnId;
import io.nwdaf.eventsubscription.model.RoutingAreaId;
import io.nwdaf.eventsubscription.model.ScheduledCommunicationTime;
import io.nwdaf.eventsubscription.model.ServiceAreaId;
import io.nwdaf.eventsubscription.model.Snssai;
import io.nwdaf.eventsubscription.model.TnapId;
import io.nwdaf.eventsubscription.model.TwapId;
import io.nwdaf.eventsubscription.model.UeMobility;
import io.nwdaf.eventsubscription.model.UserLocation;
import io.nwdaf.eventsubscription.model.UtraLocation;
import io.nwdaf.eventsubscription.model.NFType.NFTypeEnum;
import io.nwdaf.eventsubscription.utilities.Regex;

public class Main {
    public static void main(String args[]) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        NfLoadLevelInformation nfLoadLevelInformation = new NfLoadLevelInformation()
                .areaOfInterestId(UUID.randomUUID())
                .nfInstanceId(UUID.randomUUID())
                .nfSetId("setxyz")
                .confidence(100)
                .nfCpuUsage(23)
                .snssai(new Snssai().sd("sd").sst(12))
                .nfType(new NFType().nfType(NFTypeEnum.AMF))
                .nfStatus(new NfStatus().statusRegistered(12).statusUndiscoverable(45).statusUnregistered(234))
                .addSupi("1341356fe").addSupi("wsgwrg")
                .time(Instant.now());
        UeMobility ueMobility = new UeMobility()
                .durationVariance(0.0)
                .recurringTime(new ScheduledCommunicationTime().daysOfWeek(List.of(1,2,3)).timeOfDayEnd("0:0").timeOfDayStart("12:12"))
                .time(Instant.now())
                .addAreaOfInterestIdsItem(UUID.randomUUID()).addAreaOfInterestIdsItem(UUID.randomUUID())
                .addLocInfosItem(new LocationInfo()
                    .confidence(12)
                    .ratio(13)
                    .loc(new UserLocation()
                        .eutraLocation(new EutraLocation()
                            .ueLocationTimestamp(OffsetDateTime.now())
                            .ageOfLocationInformation(1)
                            .ecgi(new Ecgi()
                                .eutraCellId("000000")
                                .nid("000000000000A")
                                .plmnId(new PlmnId().mcc("123").mnc("123")))
                            .globalNgenbId(new GlobalRanNodeId()
                                .eNbId("111")
                                .gNbId(new GNbId()
                                    .bitLength(1000)
                                    .gNBValue("sefwe"))))
                        .nrLocation(new NrLocation()
                            .ueLocationTimestamp(OffsetDateTime.now())
                            .ageOfLocationInformation(0)
                            .globalGnbId(new GlobalRanNodeId()
                                .gNbId(new GNbId().gNBValue("sgsg").bitLength(120000))))
                        .geraLocation(new GeraLocation()
                            .ueLocationTimestamp(OffsetDateTime.now())
                            .ageOfLocationInformation(12)
                            .cgi(new CellGlobalId()
                                .cellId("cell")
                                .lac("lac")
                                .plmnId(new PlmnId().mcc("123").mnc("123")))
                            .geodeticInformation("ewgewg").geographicalInformation("sdgs")
                            .lai(new LocationAreaId().lac("lac").plmnId(new PlmnId().mcc("1243").mnc("123")))
                            .locationNumber("sefegf")
                            .mscNumber("msc")
                            .rai(new RoutingAreaId().lac("sef").rac("fsegfe").plmnId(new PlmnId().mcc("123").mnc("123")))
                            .sai(new ServiceAreaId().sac("sedgfsg"))
                            .ueLocationTimestamp(OffsetDateTime.now())
                            .vlrNumber("sge"))
                        .utraLocation(new UtraLocation().ueLocationTimestamp(OffsetDateTime.now()).cgi(new CellGlobalId().cellId("egf")))
                        .n3gaLocation(new N3gaLocation()
                            .gli(new Gli()
                                .data("wgerg"))
                                .gci("srg")
                                .hfcNodeId(new HfcNodeId()
                                    .hfcNId("fsrg"))
                            .tnapId(new TnapId()
                                .civicAddress("agioukonst12"))
                            .twapId(new TwapId()
                                .civicAddress("trgnikso234")))))
                .addLocInfosItem(new LocationInfo()
                    .confidence(12)
                    .ratio(99)
                    .loc(new UserLocation()
                        .eutraLocation(new EutraLocation()
                            .ageOfLocationInformation(12)
                            .ecgi(new Ecgi()
                                .eutraCellId("srgerg")
                                .plmnId(new PlmnId()
                                    .mcc("123").mnc("123"))))));
        Pattern pattern = Pattern.compile(Regex.group_id);
        if(pattern.matcher("2A3BC9EF-456-78-ABCD1234EF").matches()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
