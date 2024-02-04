package io.nwdaf.eventsubscription.utilities;

import java.security.SecureRandom;
import java.time.OffsetDateTime;
import java.util.List;

import io.nwdaf.eventsubscription.model.*;
import io.nwdaf.eventsubscription.model.SupportedGADShapes.SupportedGADShapesEnum;
import io.nwdaf.eventsubscription.model.AnalyticsSubset.AnalyticsSubsetEnum;

import static io.nwdaf.eventsubscription.utilities.Constants.METRICS_PERIOD_SECONDS;
import static io.nwdaf.eventsubscription.utilities.Constants.MIN_PERIOD_SECONDS;

public class OtherUtil {
    // set the shape attribute for each geographicArea
    // because of polymoprhic inheritance bug when jackson is deserialising the json
    public static EventSubscription setShapes(EventSubscription e) {
        if (e.getExptUeBehav() != null) {
            if (e.getExptUeBehav().getExpectedUmts() != null) {
                for (int j = 0; j < e.getExptUeBehav().getExpectedUmts().size(); j++) {
                    LocationArea area = e.getExptUeBehav().getExpectedUmts().get(j);
                    if (area.getGeographicAreas() != null) {
                        for (int k = 0; k < area.getGeographicAreas().size(); k++) {
                            String shapeType = area.getGeographicAreas().get(k).getType();
                            switch (shapeType) {
                                case "Point" ->
                                        ((GADShape) area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.Point));
                                case "PointAltitude" ->
                                        ((GADShape) area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.PointAltitude));
                                case "PointAltitudeUncertainty" ->
                                        ((GADShape) area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.PointAltitudeUncertainty));
                                case "PointUncertaintyCircle" ->
                                        ((GADShape) area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.PointUncertaintyCircle));
                                case "PointUncertaintyEllipse" ->
                                        ((GADShape) area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.PointUncertaintyEllipse));
                                case "Polygon" ->
                                        ((GADShape) area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.Polygon));
                                case "EllipsoidArc" ->
                                        ((GADShape) area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.EllipsoidArc));
                            }
                        }
                    }
                }
            }
        }
        return e;
    }

    public static NnwdafEventsSubscription setupShapes(NnwdafEventsSubscription s) {
        if (s != null) {
            if (s.getEventSubscriptions() != null) {
                s.getEventSubscriptions().replaceAll(OtherUtil::setShapes);
            }
        }
        return s;
    }

    public static String setNfloadPostgresColumns(String columns, List<AnalyticsSubset> listOfAnaSubsets) {
        String columnFormat = Constants.nfloadPostgresColumnFormat;
        if (ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_RESOURCE_USAGE))) {
            columns += String.format(columnFormat, "nfCpuUsage");
            columns += String.format(columnFormat, "nfMemoryUsage");
            columns += String.format(columnFormat, "nfStorageUsage");
            columns += "NULL as nfLoadLevelAverage,";
            columns += "NULL as nfLoadAvgInAoi,";
            columns += "NULL as nfLoadLevelpeak,";
        }
        if (ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_LOAD))) {
            columns += "NULL as nfCpuUsage,";
            columns += "NULL as nfMemoryUsage,";
            columns += "NULL as nfStorageUsage,";
            columns += String.format(columnFormat, "nfLoadLevelAverage");
            columns += "NULL as nfLoadAvgInAoi,";
            columns += "NULL as nfLoadLevelpeak,";
        }
        if (ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_LOAD_AVG_IN_AOI))) {
            columns += "NULL as nfCpuUsage,";
            columns += "NULL as nfMemoryUsage,";
            columns += "NULL as nfStorageUsage,";
            columns += "NULL as nfLoadLevelAverage,";
            columns += String.format(columnFormat, "nfLoadAvgInAoi");
            columns += "NULL as nfLoadLevelpeak,";
        }
        if (ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_PEAK_LOAD))) {
            columns += "NULL as nfCpuUsage,";
            columns += "NULL as nfMemoryUsage,";
            columns += "NULL as nfStorageUsage,";
            columns += "NULL as nfLoadLevelAverage,";
            columns += "NULL as nfLoadAvgInAoi,";
            columns += String.format(columnFormat, "nfLoadLevelpeak");
        }
        return columns;
    }

    public static List<NfLoadLevelInformation> setNfloadNonIncludedInfoNull(List<NfLoadLevelInformation> nfLoadLevels, List<AnalyticsSubset> listOfAnaSubsets) {
        if (listOfAnaSubsets == null || listOfAnaSubsets.isEmpty()) {
            return nfLoadLevels;
        }
        boolean cont = false;
        for (AnalyticsSubset listOfAnaSubset : listOfAnaSubsets) {
            if (listOfAnaSubset.getAnaSubset() != null) {
                cont = true;
                break;
            }
        }
        if (!cont) {
            return nfLoadLevels;
        }
        if (!ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_RESOURCE_USAGE))) {
            for (NfLoadLevelInformation nfLoadLevel : nfLoadLevels) {
                nfLoadLevel.nfCpuUsage(null).nfMemoryUsage(null).nfStorageUsage(null);
            }
        }
        if (!ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_LOAD))) {
            for (NfLoadLevelInformation nfLoadLevel : nfLoadLevels) {
                nfLoadLevel.nfLoadLevelAverage(null);
            }
        }
        if (!ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_LOAD_AVG_IN_AOI))) {
            for (NfLoadLevelInformation nfLoadLevel : nfLoadLevels) {
                nfLoadLevel.nfLoadAvgInAoi(null);
            }
        }
        if (!ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_PEAK_LOAD))) {
            for (NfLoadLevelInformation nfLoadLevel : nfLoadLevels) {
                nfLoadLevel.nfLoadLevelpeak(null);
            }
        }
        if (!ParserUtil.safeParseContains(listOfAnaSubsets, new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_STATUS))) {
            for (NfLoadLevelInformation nfLoadLevel : nfLoadLevels) {
                nfLoadLevel.nfStatus(null);
            }
        }
        return nfLoadLevels;
    }

    public static String generateRandomNumericString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public static String generateRandomHexString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomInt = random.nextInt(16);
            sb.append(Integer.toHexString(randomInt));
        }

        return sb.toString().toUpperCase();
    }

    public static void fillNotificationWithGeographicalInfo(NnwdafEventsSubscriptionNotification notification) {
        for (EventNotification eventNotification : notification.getEventNotifications()) {
            for (UeMobility ueMobility : eventNotification.getUeMobs()) {
                fillUeMobilityWithGeographicalInfo(ueMobility);
            }
        }
    }

    public static void fillUeMobilityWithGeographicalInfo(UeMobility ueMobility) {
        if (ueMobility.getLocInfos() == null) {
            return;
        }
        for (LocationInfo locationInfo : ueMobility.getLocInfos()) {
            if (locationInfo.getLoc() == null || locationInfo.getLoc().getNrLocation() == null) {
                continue;
            }
            String geographicalInfo = locationInfo.getLoc().getNrLocation().getGeographicalInformation();
            if (geographicalInfo == null) {
                continue;
            }
            locationInfo.getLoc().getNrLocation().setPointUncertaintyCircle(ConvertUtil.decodeEllipsoidPointWithUncertaintyCircle(geographicalInfo.substring(8)));
        }
    }

    public static boolean checkOffsetInsideAvailableData(Long start, Long end, Integer period, List<OffsetDateTime> availableTimeStamps, Boolean isCompressed) {
        OffsetDateTime now = OffsetDateTime.now().withNano(0);
        start = start == null ? MIN_PERIOD_SECONDS : start;
        OffsetDateTime startOffset = now.minusSeconds(start);
        OffsetDateTime endOffset = null;
        OffsetDateTime mostRecent = now.minusSeconds(period);
        if (isCompressed) {
            startOffset = startOffset.withSecond(0);
            mostRecent = mostRecent.withSecond(0);
        }
        if (end != null && end > 0) {
            if (end > start) {
                return false;
            }
            endOffset = now.minusSeconds(end);
            if (isCompressed) {
                endOffset = endOffset.withSecond(0);
            }
        }
        if ((!isCompressed && start > 3600 * 24) ||
                period < METRICS_PERIOD_SECONDS ||
                availableTimeStamps == null ||
                availableTimeStamps.size() < 2 ||
                availableTimeStamps.getFirst() == null ||
                availableTimeStamps.getLast() == null) {
            return false;
        }
        OffsetDateTime last = availableTimeStamps.getFirst();
        OffsetDateTime first = availableTimeStamps.getLast();
        boolean withinRange = (startOffset.isAfter(first) || startOffset.isEqual(first)) &&
                ((endOffset == null && (last.isAfter(mostRecent) || last.isEqual(mostRecent))) ||
                        (endOffset != null && (endOffset.isBefore(last) || endOffset.isEqual(last))));

        int startIndex = availableTimeStamps.indexOf(startOffset);
        if (!withinRange || startIndex < 0) {
            return false;
        }
        if (endOffset == null) {
            for (int i = startIndex + 1; i < availableTimeStamps.size(); i++) {
                if (availableTimeStamps.get(i).toEpochSecond() - availableTimeStamps.get(i - 1).toEpochSecond() > period) {
                    return false;
                }
            }
        } else {
            int endIndex = availableTimeStamps.indexOf(endOffset);
            if (endIndex < 0) {
                return false;
            }
            for (int i = startIndex; i < endIndex; i++) {
                if (availableTimeStamps.get(i).toEpochSecond() - availableTimeStamps.get(i - 1).toEpochSecond() > period) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void setPastOffsetCutoff(EventSubscription eventSubscription, Integer repPeriod) {
        EventReportingRequirement eventRepReq = eventSubscription.getExtraReportReq();
        if (eventRepReq == null) {
            return;
        }
        OffsetDateTime now = OffsetDateTime.now();
        if (eventRepReq.getEndTs() != null && eventRepReq.getStartTs() != null) {
            long start = eventRepReq.getStartTs().toEpochSecond();
            long end = eventRepReq.getEndTs().toEpochSecond();
            if (end < start) {
                return;
            }
            if (end > now.toEpochSecond() &&
                    start < now.toEpochSecond()) {
                return;
            }
            if (end - start > repPeriod) {
                eventRepReq.setStartTs(now.minusSeconds(repPeriod));
            }
            return;
        }
        if (eventRepReq.getStartTs() != null) {
            long start = eventRepReq.getStartTs().toEpochSecond();
            if (now.toEpochSecond() - start > repPeriod) {
                eventRepReq.setStartTs(now.minusSeconds(repPeriod));
            }
            return;
        }
        if (eventRepReq.getOffsetPeriod() != null &&
                eventRepReq.getOffsetPeriod() < 0) {
            eventRepReq.setOffsetPeriod((-1) * Math.min((-1) * eventRepReq.getOffsetPeriod(), repPeriod));
        }
    }

    public static void muteSubscription(NnwdafEventsSubscription subscription) {
        if(subscription == null) {
            return;
        }
        NotificationFlag mutedFlag = new NotificationFlag().notifFlag(NotificationFlag.NotificationFlagEnum.DEACTIVATE);
        if (subscription.getEvtReq() == null) {
            subscription.setEvtReq(new ReportingInformation().notifFlag(mutedFlag));
        } else {
            subscription.getEvtReq().setNotifFlag(mutedFlag);
        }
    }
}
