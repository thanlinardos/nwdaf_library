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

import static io.nwdaf.eventsubscription.utilities.ConvertUtil.toOptional;

public class DummyDataGenerator {
    public static List<NfLoadLevelInformation> generateDummyNfLoadLevelInfo(int c) {
        List<NfLoadLevelInformation> result = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            result.add(new NfLoadLevelInformation());
        }
        Random r = new Random();
        Instant now = Instant.now();
        r.setSeed(now.toEpochMilli());
        for (NfLoadLevelInformation nfLoadLevelInfo : result) {
            int[] nums = {r.nextInt(101), r.nextInt(101), r.nextInt(101)};
            int[] peaks = {r.nextInt(nums[0], 101), r.nextInt(nums[1], 101), r.nextInt(nums[2], 101)};
            nfLoadLevelInfo.nfCpuUsage(nums[0])
                    .nfMemoryUsage(nums[1]).nfStorageUsage(nums[2]).nfLoadLevelAverage((nums[0] + nums[1] + nums[2]) / 3)
                    .nfLoadLevelpeak((peaks[0] + peaks[1] + peaks[2]) / 3).nfLoadAvgInAoi(r.nextInt(101))
                    .time(now).nfInstanceId(UUID.randomUUID());
            int aoiIndex = r.nextInt(4);
            NFTypeEnum nfType = NFTypeEnum.values()[r.nextInt(NFTypeEnum.values().length)];
            List<UUID> keys = new ArrayList<>(Constants.ExampleAOIsMap.keySet());
            keys.remove(Constants.InitialServingAreaOfInterest.getId());
            switch (aoiIndex) {
                case 0:
                    nfLoadLevelInfo.areaOfInterestId(keys.get(r.nextInt(keys.size())));
                    break;
                case 1:
                    nfLoadLevelInfo.nfSetId("set" + (char) (r.nextInt(26) + 'a') + (char) (r.nextInt(26) + 'a') + (char) (r.nextInt(26) + 'a') + "." +
                            nfType.toString() + "set.5gc.mnc" + r.nextInt(10) + r.nextInt(10) + r.nextInt(10) + ".mcc" + r.nextInt(10) + r.nextInt(10) + r.nextInt(10)
                    );
                    break;
                case 2:
                    nfLoadLevelInfo.snssai(randomSnssai(r));
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

    public static void changeNfLoadTimeDependentProperties(List<NfLoadLevelInformation> nfloadinfos) {
        Instant now = Instant.now();
        Random r = new Random();
        r.setSeed(now.toEpochMilli());
        for (NfLoadLevelInformation nfloadinfo : nfloadinfos) {
            int[] nums = {r.nextInt(101), r.nextInt(101), r.nextInt(101)};
            int[] maxes = {r.nextInt(nums[0], 101), r.nextInt(nums[1], 101), r.nextInt(nums[2], 101)};
            nfloadinfo.nfCpuUsage(nums[0])
                    .nfMemoryUsage(nums[1]).nfStorageUsage(nums[2]).nfLoadLevelAverage((nums[0] + nums[1] + nums[2]) / 3)
                    .nfLoadLevelpeak((maxes[0] + maxes[1] + maxes[2]) / 3).nfLoadAvgInAoi(r.nextInt(101)).time(now);
        }
    }

    public static List<UeMobility> generateDummyUeMobilities(int c, UeMobility locationInfosInput) {
        List<UeMobility> ueMobilities = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            ueMobilities.add(new UeMobility());
        }
        Random r = new Random();
        OffsetDateTime now = OffsetDateTime.now();
        r.setSeed(now.toEpochSecond());
        for (UeMobility ueMobility : ueMobilities) {
            int locNum = r.nextInt(6);
            EutraLocation eutraLocation = new EutraLocation()
                    .ecgi(Constants.AreaOfInterestExample3.getEcgis().getFirst())
                    .tai(Constants.AreaOfInterestExample3.getTais().getFirst())
                    .globalNgenbId(Constants.AreaOfInterestExample3.getGRanNodeIds().get(0))
                    .globalENbId(Constants.AreaOfInterestExample3.getGRanNodeIds().get(1))
                    .ageOfLocationInformation(0).ueLocationTimestamp(now)
                    .geodeticInformation(null).geographicalInformation(null);
            NrLocation nrLocation = new NrLocation()
                    .ncgi(Constants.AreaOfInterestExample1.getNcgis().getFirst())
                    .tai(Constants.AreaOfInterestExample1.getTais().getFirst())
                    .ageOfLocationInformation(0).ueLocationTimestamp(now)
                    .geodeticInformation(null).geographicalInformation(null);
            N3gaLocation n3gaLocation = new N3gaLocation()
                    .gci("00-00-5E-00-53-00@5gc.mnc123.mcc123.example.com")
                    .gli(new Gli().data("gli-YXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZmFzZGZhc2RmYXNkZg=="))
                    .hfcNodeId(new HfcNodeId().hfcNId("YXNkZm"))
                    .n3IwfId(Constants.AreaOfInterestExample3.getGRanNodeIds().get(2).getN3IwfId())
                    .n3gppTai(Constants.AreaOfInterestExample3.getTais().getFirst())
                    .portNumber(8080).protocol(new TransportProtocol().transportProtocol(TransportProtocolEnum.TCP))
                    .tnapId(new TnapId().bssId(UUID.randomUUID().toString()).civicAddress("agioukonst12"))
                    .twapId(new TwapId().bssId(UUID.randomUUID().toString()).ssId(UUID.randomUUID().toString()).civicAddress("agioukonst12"))
                    .ueIpv4Addr("61.166.76.219").ueIpv6Addr("1702:b2fc:b695:2e32:8541:4020:5abe:bc46")
                    .w5gbanLineType(new LineType().lType(LineTypeEnum.DSL));
            GeraLocation geraLocation = new GeraLocation()
                    .cgi(new CellGlobalId().plmnId(Constants.plmnId).cellId("FFFF").lac("FFFF"))
                    .lai(new LocationAreaId().plmnId(Constants.plmnId).lac("FFFF"))
                    .rai(new RoutingAreaId().plmnId(Constants.plmnId).lac("FFFF").rac("00"))
                    .sai(new ServiceAreaId().plmnId(Constants.plmnId).lac("FFFF").sac("FFFF"))
                    .vlrNumber(Constants.plmnId.toFormattedString() + ".vlrYXNkZmFzZGZh")
                    .ageOfLocationInformation(0).ueLocationTimestamp(now)
                    .geodeticInformation(null).geographicalInformation(null);
            UtraLocation utraLocation = new UtraLocation()
                    .cgi(new CellGlobalId().plmnId(Constants.plmnId).cellId("0000").lac("FFFF"))
                    .lai(new LocationAreaId().plmnId(Constants.plmnId).lac("FFFF"))
                    .rai(new RoutingAreaId().plmnId(Constants.plmnId).lac("FFFF").rac("FF"))
                    .sai(new ServiceAreaId().plmnId(Constants.plmnId).lac("FFFF").sac("0000"))
                    .ageOfLocationInformation(0).ueLocationTimestamp(now)
                    .geodeticInformation(null).geographicalInformation(null);

            UserLocation userLocation = new UserLocation();
            switch (locNum) {
                case (0):
                    userLocation.eutraLocation(eutraLocation);
                    break;
                case (1):
                    userLocation.nrLocation(nrLocation);
                    break;
                case (2):
                    userLocation.n3gaLocation(n3gaLocation);
                    break;
                case (3):
                    userLocation.geraLocation(geraLocation);
                    break;
                case (4):
                    userLocation.utraLocation(utraLocation);
                    break;
                case (5):
                    ueMobility.ladnDnn(Constants.exampleDnn);
                    break;
                default:
                    break;
            }
            ueMobility.time(now.toInstant()).duration(1).durationVariance(0.0).supi(randomSupi(false)).intGroupId(randomInternalGroupId(false));
            ueMobility.addLocInfosItem(new LocationInfo().ratio(r.nextInt(1, 101)).confidence(r.nextInt(101))
                    .loc(userLocation));
            if (r.nextInt(3) == 0) {
                ueMobility.setLocInfos(toOptional(locationInfosInput).map(UeMobility::getLocInfos).orElse(null));
                ueMobility.setAreaOfInterestIds(toOptional(locationInfosInput).map(UeMobility::getAreaOfInterestIds).orElse(null));
            }
        }
        return ueMobilities;
    }

    public static List<UeCommunication> generateDummyUeCommunications(int c) {
        List<UeCommunication> ueCommunications = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            ueCommunications.add(new UeCommunication());
        }
        Random r = new Random();
        OffsetDateTime now = OffsetDateTime.now();
        r.setSeed(now.toEpochSecond());
        for (UeCommunication ueCommunication : ueCommunications) {
            NetworkAreaInfo spacialValidity;
            int locNum = r.nextInt(4);
            spacialValidity = switch (locNum) {
                case 0 -> Constants.AreaOfInterestExample1;
                case 1 -> Constants.AreaOfInterestExample2;
                case 2 -> Constants.AreaOfInterestExample3;
                default -> Constants.InitialServingAreaOfInterest;
            };
            List<UUID> keys = new ArrayList<>(Constants.ExampleAOIsMap.keySet());
            keys.remove(Constants.InitialServingAreaOfInterest.getId());
            int aoiIndex = r.nextInt(2);
            if (aoiIndex == 0) {
                ueCommunication.areaOfInterestId(keys.get(r.nextInt(keys.size())));
            } else {
                ueCommunication.intGroupId(randomInternalGroupId(false));
            }
            ueCommunication.supi(randomSupi(false))
                    .time(now.toInstant()).commDur(r.nextInt(100))
                    .commDurVariance(r.nextDouble(1))
                    .confidence(r.nextInt(100))
                    .recurringTime(new ScheduledCommunicationTime()
                            .daysOfWeek(List.of(1, 2, 5, 7))
                            .timeOfDayStart("12:00")
                            .timeOfDayEnd("18:00"))
                    .anaOfAppList(new AppListForUeComm()
                            .appId("nwdafSubCollector")
                            .appDur(r.nextInt(1000))
                            .occurRatio(r.nextInt(100))
                            .spatialValidity(spacialValidity)
                            .startTime(randomOffsetDateTime(now, r)))
                    .perioTime(Constants.MIN_PERIOD_SECONDS)
                    .perioTimeVariance(r.nextDouble(1))
                    .perioCommInd(true)
                    .sessInactTimer(new SessInactTimerForUeComm()
                            .sessInactiveTimer(r.nextInt(10))
                            .n4SessId(r.nextInt(256)))
                    .trafChar(new TrafficCharacterization()
                            .addFDescsItem(new IpEthFlowDescription()
                                    .ethTrafficFilter(new EthFlowDescription()
                                            .ethType(Constants.ethernetTypes.get(r.nextInt(32)))
                                            .addVlanTagsItem(OtherUtil.generateRandomHexString(4))  // customer-vlan tag
                                            .addVlanTagsItem(OtherUtil.generateRandomHexString(4))  // service-vlan tag
                                            .destMacAddr(randomMacAddress())
                                            .fDir(new FlowDirection()
                                                    .fDir(FlowDirection.FlowDirectionEnum.UPLINK))
                                            .fDesc(Constants.exampleIpv4FilterRule.toAvp())
                                            .sourceMacAddr(randomMacAddress())
                                            .destMacAddrEnd(randomMacAddress()))
                                    .ipTrafficFilter(Constants.exampleIpv4FilterRule.toAvp()))
                            .dnn(Constants.exampleDnn)
                            .dlVol(r.nextInt(1_000_000))
                            .appId("nwdafSubCollector")
                            .dlVolVariance(r.nextDouble(1))
                            .snssai(randomSnssai(r))
                            .ulVol(r.nextInt(1_000_000))
                            .ulVolVariance(r.nextDouble(1)))
                    .tsVariance(r.nextDouble(1))
                    .ratio(r.nextInt(100));
        }
        return ueCommunications;
    }

    public static String randomSupi(boolean randomPlmnId) {
        String mcc, mnc, msin;
        if (randomPlmnId) {
            mcc = OtherUtil.generateRandomNumericString(3);
            mnc = OtherUtil.generateRandomNumericString(2);
        } else {
            mcc = Constants.plmnId.getMcc();
            mnc = Constants.plmnId.getMnc();
        }
        msin = OtherUtil.generateRandomNumericString(10);
        return "imsi-" + mcc + mnc + msin;
    }

    public static String randomInternalGroupId(boolean randomPlmnId) {
        String mcc, mnc, serviceId, localGroupId;
        if (randomPlmnId) {
            mcc = OtherUtil.generateRandomNumericString(3);
            mnc = OtherUtil.generateRandomNumericString(2);
        } else {
            mcc = Constants.plmnId.getMcc();
            mnc = Constants.plmnId.getMnc();
        }
        serviceId = OtherUtil.generateRandomHexString(8);
        localGroupId = OtherUtil.generateRandomHexString(10);
        return serviceId + "-" + mcc + "-" + mnc + "-" + localGroupId;
    }

    public static OffsetDateTime randomOffsetDateTime(OffsetDateTime now, Random r) {
        return OffsetDateTime
                .of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                        r.nextInt(24), r.nextInt(60), r.nextInt(60),
                        r.nextInt(1_000_000_000), now.getOffset());
    }

    public static Snssai randomSnssai(Random r) {
        return new Snssai().sd(Integer.toHexString(r.nextInt(0, 16777216))).sst(r.nextInt(0, 256));
    }

    public static String randomMacAddress() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(OtherUtil.generateRandomHexString(2));
            if (i != 5) sb.append("-");
        }
        return sb.toString();
    }

    public static void changeUeMobilitiesTimeDependentProperties(List<UeMobility> ueMobilities, long offsetSeconds) {
        Instant now = Instant.now();
        OffsetDateTime date = OffsetDateTime.ofInstant(now, TimeZone.getDefault().toZoneId());
        for (UeMobility ueMobility : ueMobilities) {
            ueMobility.time(now);
            for (int j = 0; j < ueMobility.getLocInfos().size(); j++) {
                UserLocation userLocation = ueMobility.getLocInfos().get(j).getLoc();
                OffsetDateTime ueLocationTimestamp = date.minusSeconds(j * offsetSeconds);
                toOptional(userLocation.getNrLocation()).ifPresent(loc -> loc.ueLocationTimestamp(ueLocationTimestamp));
                toOptional(userLocation.getEutraLocation()).ifPresent(loc -> loc.ueLocationTimestamp(ueLocationTimestamp));
                toOptional(userLocation.getUtraLocation()).ifPresent(loc -> loc.ueLocationTimestamp(ueLocationTimestamp));
                toOptional(userLocation.getGeraLocation()).ifPresent(loc -> loc.ueLocationTimestamp(ueLocationTimestamp));
            }
        }
    }

    public static void changeUeCommunicationsTimeDependentProperties(List<UeCommunication> ueCommunications) {
        Instant now = Instant.now();
        for (UeCommunication ueCommunication : ueCommunications) {
            ueCommunication.time(now);
        }
    }
}
