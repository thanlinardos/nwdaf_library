package io.nwdaf.eventsubscription.utilities;

import io.nwdaf.eventsubscription.customModel.PointUncertaintyCircleResult;
import io.nwdaf.eventsubscription.model.LocationInfo;
import io.nwdaf.eventsubscription.model.UeMobility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelUtil {

    public static void addPointsUncertainty(List<PointUncertaintyCircleResult> points, double bound) {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < points.size(); i++) {
            if (i % 10 != 0) continue;
            points.get(i).setLatitude(points.get(i).getLatitude() + random.nextDouble(bound));
            points.get(i).setLongitude(points.get(i).getLongitude() + random.nextDouble(bound));
        }
    }

    public static List<PointUncertaintyCircleResult> getPointsFromUeMobilities(List<UeMobility> ueMobilities) {
        List<PointUncertaintyCircleResult> points = new ArrayList<>();
        for (UeMobility ueMobility : ueMobilities) {
            for (LocationInfo locationInfo : ueMobility.getLocInfos()) {
                String geographicalInfo = locationInfo.getLoc().getNrLocation().getGeographicalInformation();

            }
        }
        return points;
    }

    public static void addUeMobilityPointsUncertainty(List<UeMobility> ueMobilities, double bound) {
        List<PointUncertaintyCircleResult> points = getPointsFromUeMobilities(ueMobilities);
        addPointsUncertainty(points, bound);
    }
}
