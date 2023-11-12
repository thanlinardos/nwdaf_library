package io.nwdaf.eventsubscription.utilities;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

import io.nwdaf.eventsubscription.model.*;
import io.nwdaf.eventsubscription.model.NFType.NFTypeEnum;
import io.nwdaf.eventsubscription.model.TransportProtocol.TransportProtocolEnum;
import io.nwdaf.eventsubscription.model.LineType.LineTypeEnum;

public class DummyDataGenerator {
    public static List<NfLoadLevelInformation> generateDummyNfLoadLevelInfo(int c){
        List<NfLoadLevelInformation> result = new ArrayList<>();
        for(int i=0;i<c;i++){
            result.add(new NfLoadLevelInformation());
        }
        Random r = new Random();
        Instant now = Instant.now();
        for (NfLoadLevelInformation nfLoadLevelInfo : result) {
            int[] nums = {r.nextInt(101), r.nextInt(101), r.nextInt(101)};
            int[] peaks = {r.nextInt(nums[0], 101), r.nextInt(nums[1], 101), r.nextInt(nums[2], 101)};
            nfLoadLevelInfo.nfCpuUsage(nums[0])
                    .nfMemoryUsage(nums[1]).nfStorageUsage(nums[2]).nfLoadLevelAverage((nums[0] + nums[1] + nums[2]) / 3)
                    .nfLoadLevelpeak((peaks[0] + peaks[1] + peaks[2]) / 3).nfLoadAvgInAoi(r.nextInt(101))
                    .time(now).nfInstanceId(UUID.randomUUID());
            int aoiIndex = r.nextInt(4);
            NFTypeEnum nfType = NFTypeEnum.values()[r.nextInt(NFTypeEnum.values().length)];
            switch (aoiIndex) {
                case 0:
                    List<UUID> keys = new ArrayList<>(Constants.ExampleAOIsMap.keySet());
                    keys.remove(Constants.ServingAreaOfInterest.getId());
                    int t = r.nextInt(keys.size());
                    nfLoadLevelInfo.areaOfInterestId(keys.get(t));
                    break;
                case 1:
                    nfLoadLevelInfo.nfSetId("set" + (char) (r.nextInt(26) + 'a') + (char) (r.nextInt(26) + 'a') + (char) (r.nextInt(26) + 'a') + "." +
                            nfType.toString() + "set.5gc.mnc" + r.nextInt(10) + r.nextInt(10) + r.nextInt(10) + ".mcc" + r.nextInt(10) + r.nextInt(10) + r.nextInt(10)
                    );
                    break;
                case 2:
                    nfLoadLevelInfo.snssai(new Snssai().sd(Integer.toHexString(r.nextInt(0, 16777216))).sst(r.nextInt(0, 256)));
                    break;
                case 3:
                    for (int j = 0; j < 3; j++) {
                        nfLoadLevelInfo.addSupi("imsi-123123" + r.nextInt(100000000, 999999999));
                    }
                    nfLoadLevelInfo.addSupi("nai-user@example.com").addSupi("gci-00-00-5E-00-53-00@5gc.mnc123.mcc123.example.com")
                            .addSupi("gli-YXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZg==");
                    break;
            }
            int reg = r.nextInt(1, 51);
            int undisc = r.nextInt(1, 50);
            nfLoadLevelInfo.nfType(new NFType().nfType(nfType))
                    .nfStatus(new NfStatus().statusRegistered(reg).statusUndiscoverable(undisc).statusUnregistered(100 - reg - undisc))
                    .confidence(r.nextInt(101));
        }
        
        return result;
    }
    public static List<NfLoadLevelInformation> changeNfLoadTimeDependentProperties(List<NfLoadLevelInformation> nfloadinfos){
        Instant now = Instant.now();
        Random r = new Random();
        for (NfLoadLevelInformation nfloadinfo : nfloadinfos) {
            int[] nums = {r.nextInt(101), r.nextInt(101), r.nextInt(101)};
            int[] maxes = {r.nextInt(nums[0], 101), r.nextInt(nums[1], 101), r.nextInt(nums[2], 101)};
            nfloadinfo.nfCpuUsage(nums[0])
                    .nfMemoryUsage(nums[1]).nfStorageUsage(nums[2]).nfLoadLevelAverage((nums[0] + nums[1] + nums[2]) / 3)
                    .nfLoadLevelpeak((maxes[0] + maxes[1] + maxes[2]) / 3).nfLoadAvgInAoi(r.nextInt(101)).time(now);
        }
        return nfloadinfos;
    }

    public static List<UeMobility> generateDummyUeMobilities(int c){
        List<UeMobility> ueMobilities = new ArrayList<>();
        for(int i=0;i<c;i++){
            ueMobilities.add(new UeMobility());
        }
        Random r = new Random();
        OffsetDateTime now = OffsetDateTime.now();
        for (UeMobility ueMobility : ueMobilities) {
            int locNum = r.nextInt(5);
            UserLocation userLocation = new UserLocation();
            switch (locNum) {
                case (0):
                    userLocation.eutraLocation(new EutraLocation()
                            .ecgi(Constants.AreaOfInterestExample3.getEcgis().get(0))
                            .tai(Constants.AreaOfInterestExample3.getTais().get(0))
                            .globalNgenbId(Constants.AreaOfInterestExample3.getGRanNodeIds().get(0))
                            .globalENbId(Constants.AreaOfInterestExample3.getGRanNodeIds().get(1))
                            .ageOfLocationInformation(0).ueLocationTimestamp(now)
                            .geodeticInformation(null).geographicalInformation(null));
                    break;
                case (1):
                    userLocation.nrLocation(new NrLocation()
                            .ncgi(Constants.AreaOfInterestExample1.getNcgis().get(0))
                            .tai(Constants.AreaOfInterestExample1.getTais().get(0))
                            .ageOfLocationInformation(0).ueLocationTimestamp(now)
                            .geodeticInformation(null).geographicalInformation(null));
                    break;
                case (2):
                    userLocation.n3gaLocation(new N3gaLocation()
                            .gci("00-00-5E-00-53-00@5gc.mnc123.mcc123.example.com")
                            .gli(new Gli().data("gli-YXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZg=="))
                            .hfcNodeId(new HfcNodeId().hfcNId("YXNkZm"))
                            .n3IwfId(Constants.AreaOfInterestExample3.getGRanNodeIds().get(2).getN3IwfId())
                            .n3gppTai(Constants.AreaOfInterestExample3.getTais().get(0))
                            .portNumber(8080).protocol(new TransportProtocol().transportProtocol(TransportProtocolEnum.TCP))
                            .tnapId(new TnapId().bssId(UUID.randomUUID().toString()).civicAddress("agioukonst12"))
                            .twapId(new TwapId().bssId(UUID.randomUUID().toString()).ssId(UUID.randomUUID().toString()).civicAddress("agioukonst12"))
                            .ueIpv4Addr("61.166.76.219").ueIpv6Addr("1702:b2fc:b695:2e32:8541:4020:5abe:bc46")
                            .w5gbanLineType(new LineType().lType(LineTypeEnum.DSL)));
                    break;
                case (3):
                    userLocation.geraLocation(new GeraLocation()
                            .cgi(new CellGlobalId().plmnId(Constants.plmnId).cellId("FFFF").lac("FFFF"))
                            .lai(new LocationAreaId().plmnId(Constants.plmnId).lac("FFFF"))
                            .rai(new RoutingAreaId().plmnId(Constants.plmnId).lac("FFFF").rac("00"))
                            .sai(new ServiceAreaId().plmnId(Constants.plmnId).lac("FFFF").sac("FFFF"))
                            .vlrNumber(Constants.plmnId.toFormattedString() + ".vlrYXNkZmFzZGZh")
                            .ageOfLocationInformation(0).ueLocationTimestamp(now)
                            .geodeticInformation(null).geographicalInformation(null));
                    break;
                case (4):
                    userLocation.utraLocation(new UtraLocation()
                            .cgi(new CellGlobalId().plmnId(Constants.plmnId).cellId("0000").lac("FFFF"))
                            .lai(new LocationAreaId().plmnId(Constants.plmnId).lac("FFFF"))
                            .rai(new RoutingAreaId().plmnId(Constants.plmnId).lac("FFFF").rac("FF"))
                            .sai(new ServiceAreaId().plmnId(Constants.plmnId).lac("FFFF").sac("0000"))
                            .ageOfLocationInformation(0).ueLocationTimestamp(now)
                            .geodeticInformation(null).geographicalInformation(null));
                    break;
                default:
                    break;
            }
            ueMobility.ts(now).duration(1).durationVariance(0.0).supi(randomSupi(false)).intGroupId(randomInternalGroupId(false));
            ueMobility.addLocInfosItem(new LocationInfo().ratio(r.nextInt(1, 101)).confidence(r.nextInt(101))
                    .loc(userLocation));
        }
        return ueMobilities;
    }

    private static String randomSupi(boolean randomPlmnId) {
        String mcc,mnc,msin;
        if(randomPlmnId) {
            mcc = OtherUtil.generateRandomNumericString(3);
            mnc = OtherUtil.generateRandomNumericString(2);
        } else {
            mcc = Constants.plmnId.getMcc();
            mnc = Constants.plmnId.getMnc();
        }
        msin = OtherUtil.generateRandomNumericString(10);
        return "imsi-"+mcc+mnc+msin;
    }

    private static String randomInternalGroupId(boolean randomPlmnId) {
        String mcc,mnc,serviceId,localGroupId;
        if(randomPlmnId) {
            mcc = OtherUtil.generateRandomNumericString(3);
            mnc = OtherUtil.generateRandomNumericString(2);
        } else {
            mcc = Constants.plmnId.getMcc();
            mnc = Constants.plmnId.getMnc();
        }
        serviceId = OtherUtil.generateRandomHexString(8);
        localGroupId = OtherUtil.generateRandomHexString(10);
        return mcc+"-"+mnc+"-"+serviceId+"-"+localGroupId;
    }

    public static List<UeMobility> changeUeMobilitiesTimeDependentProperties(List<UeMobility> ueMobilities){
        Instant now = Instant.now();
        OffsetDateTime date = OffsetDateTime.ofInstant(now, TimeZone.getDefault().toZoneId());
        for (UeMobility ueMobility : ueMobilities) {
            ueMobility.time(now);
            for (int j = 0; j < ueMobility.getLocInfos().size(); j++) {
                UserLocation userLocation = ueMobility.getLocInfos().get(j).getLoc();
                if (userLocation.getEutraLocation() != null) {
                    userLocation.getEutraLocation().ueLocationTimestamp(date);
                }
                if (userLocation.getNrLocation() != null) {
                    userLocation.getNrLocation().ueLocationTimestamp(date);
                }
                if (userLocation.getGeraLocation() != null) {
                    userLocation.getGeraLocation().ueLocationTimestamp(date);
                }
                if (userLocation.getUtraLocation() != null) {
                    userLocation.getUtraLocation().ueLocationTimestamp(date);
                }
            }
        }
        return ueMobilities;
    }
}
