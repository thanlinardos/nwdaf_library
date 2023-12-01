package io.nwdaf.eventsubscription.utilities;

import java.security.SecureRandom;
import java.util.List;

import io.nwdaf.eventsubscription.model.AnalyticsSubset;
import io.nwdaf.eventsubscription.model.NfLoadLevelInformation;
import io.nwdaf.eventsubscription.model.NnwdafEventsSubscription;
import io.nwdaf.eventsubscription.model.SupportedGADShapes;
import io.nwdaf.eventsubscription.model.SupportedGADShapes.SupportedGADShapesEnum;
import io.nwdaf.eventsubscription.model.AnalyticsSubset.AnalyticsSubsetEnum;
import io.nwdaf.eventsubscription.model.EventSubscription;
import io.nwdaf.eventsubscription.model.GADShape;
import io.nwdaf.eventsubscription.model.LocationArea;

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
}
