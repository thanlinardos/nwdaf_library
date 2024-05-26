package io.nwdaf.eventsubscription.utilities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.nwdaf.eventsubscription.customModel.NefCell;
import io.nwdaf.eventsubscription.customModel.NefScenario;
import io.nwdaf.eventsubscription.customModel.NefUeState;
import io.nwdaf.eventsubscription.customModel.NefgNB;
import io.nwdaf.eventsubscription.model.*;

import static io.nwdaf.eventsubscription.utilities.Regex.uuidFromDockerId;

@SuppressWarnings("unused")
public class ConvertUtil {
    // converts empty string to null
    public static String convertEmptyStringToNull(String in) {
        if (in == null) {
            return null;
        }
        if (in.isEmpty()) {
            return null;
        } else {
            return in;
        }
    }

    // converts the hex bits to a list of integers, each representing the presence
    // of a feature, using bit masking
    public static List<Integer> convertFeaturesToList(String features) {
        int in;
        try {
            in = Integer.parseInt(features, 16);
        } catch (NumberFormatException e) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 24; i++) {
            int featureBit = 1 << (i - 1);
            if ((in & featureBit) != 0) {
                res.add(i);
            }
        }

        return res;
    }

    /**
     * Wraps a nullable object with an Optional
     **/
    public static <T> Optional<T> toOptional(T value) {
        return Optional.ofNullable(value);
    }

    public static String convertListToFeatures(List<Integer> list) {
        int res = 0;
        for (int i : list) {
            if (i < 1 || i > 24) {
                throw new IllegalArgumentException("Each integer in the list must be between 1 and 24 (inclusive).");
            }

            res |= 1 << (i - 1);
        }

        return String.format("%06x", res);
    }

    public static List<Boolean> convertListToBooleans(List<Integer> list) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 1; i < 25; i++) {
            if (list.contains(i)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static List<Integer> convertBooleansToList(List<Boolean> b) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            if (b.get(i)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    // converts a list of objects to a list of jsons in string format using
    // objectWriter & jsonObject
    public static <T> List<String> convertObjectWriterList(List<T> list, ObjectWriter ow) {
        List<String> res = new ArrayList<>();
        for (T t : list) {
            try {
                res.add(ow.writeValueAsString(t));
            } catch (JsonProcessingException e) {
                System.out.println("jsonprocessing error!!");
            }
        }
        return res;
    }

    public static Instant convertDoubleToInstant(Double d) {
        if (d == null) {
            return null;
        }
        long secondsSinceEpoch = (long) d.doubleValue();
        double fractionalPart = d - secondsSinceEpoch;
        long nanoAdjustment = (long) (fractionalPart * 1_000_000_000);
        return Instant.ofEpochSecond(secondsSinceEpoch, nanoAdjustment);
    }

    public static Instant convertDoubleToInstantWithBigDecimal(String d) {
        if (d == null) {
            return null;
        }
        BigDecimal bigDecimalValue = new BigDecimal(d);
        long secondsSinceEpoch = bigDecimalValue.longValue();
        BigDecimal fractionalPart = bigDecimalValue.remainder(BigDecimal.ONE);
        long nanoAdjustment = fractionalPart.multiply(Constants.ONE_BILLION).longValue();
        return Instant.ofEpochSecond(secondsSinceEpoch, nanoAdjustment);
    }

    public static OffsetDateTime convertDoubleToOffSetDateTime(Double d) {
        if (d == null) {
            return null;
        }
        return convertInstantToOffsetDateTime(convertDoubleToInstant(d));
    }

    public static Double convertInstantToDouble(Instant i) {
        if (i == null) {
            return null;
        }
        return (Double) (i.getEpochSecond() + (i.getNano() / 1_000_000_000.0));
    }

    public static OffsetDateTime convertInstantToOffsetDateTime(Instant i) {
        if (i == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(i, ZoneId.systemDefault());
    }

    public static Instant convertOffsetDateTimeToInstant(OffsetDateTime date) {
        if (date == null) {
            return null;
        }
        return date.toInstant();
    }

    public static Double convertOffsetDateTimeToDouble(OffsetDateTime date) {
        if (date == null) {
            return null;
        }
        return convertInstantToDouble(date.toInstant());
    }

    public static Float convertDoubleToFloat(Double d) {
        if (d == null) {
            return null;
        }
        return (float) d.doubleValue();
    }

    public static String encodeEllipsoidPointWithUncertaintyCircle(Float latitude, Float longitude, Integer uncertaintyLevel) {
        if (latitude == null || longitude == null || uncertaintyLevel == null || uncertaintyLevel < 0 || uncertaintyLevel > 127) {
            return null;
        }
        StringBuilder uncertainty = new StringBuilder(Integer.toBinaryString(encodeInteger(uncertaintyLevel, 7)));
        while (uncertainty.length() < 7) {
            uncertainty.insert(0, "0");
        }
        String encodedLatitude = encodeCoordinate(latitude);
        String encodedLongitude = encodeCoordinate(longitude);

        return Constants.encodeShapeTypeMap.get("PointUncertaintyCircle") + "1111" + encodedLatitude + encodedLongitude + "0" + uncertainty;
    }

    public static PointUncertaintyCircle decodeEllipsoidPointWithUncertaintyCircle(String encodedShape) {
        if (encodedShape == null || encodedShape.length() != 56) {
            return null;
        }
        String encodedLatitude = encodedShape.substring(0, 24);
        String encodedLongitude = encodedShape.substring(24, 48);
        String uncertainty = encodedShape.substring(50);

        PointUncertaintyCircle result = new PointUncertaintyCircle();
        result.point(new GeographicalCoordinates()
                        .lat(decodeCoordinate(encodedLatitude))
                        .lon(decodeCoordinate(encodedLongitude)))
                .uncertainty(decodeUncertaintyLevel(Integer.parseInt(uncertainty, 2)))
                .shape(new SupportedGADShapes()
                        .supportedGADShapes(SupportedGADShapes.SupportedGADShapesEnum.PointUncertaintyCircle));
        return result;
    }

    public static int encodeInteger(int inputValue, int numberOfBits) {
        return Math.min((1 << numberOfBits) - 1, Math.max(0, inputValue));
    }

    public static final DecimalFormat singlePrecisionFormat = new DecimalFormat("#.######");

    public static String encodeFloatSinglePrecision(double x) {

        String signedBit = x > 0.0F ? "0" : "1";
        int intValue = Math.abs((int) x);
        String integerDigits = Integer.toBinaryString(intValue);
        int exponent = integerDigits.length() + 126;
        StringBuilder exponentDigits = new StringBuilder(Integer.toBinaryString(exponent));
        while (exponentDigits.length() < 8) {
            exponentDigits.insert(0, "0");
        }

        String floatDecimalDigits = singlePrecisionFormat.format(Math.abs(x) - intValue);
        float remainder = Float.parseFloat(floatDecimalDigits);
        StringBuilder floatDigits = new StringBuilder();

        while (remainder > 0.0F && floatDigits.length() + integerDigits.length() - 1 < 23) {
            remainder *= 2;
            intValue = (int) remainder;
            floatDigits.append(intValue);
            remainder = Float.parseFloat(singlePrecisionFormat.format(remainder - intValue));
        }
        StringBuilder mantissa = new StringBuilder(integerDigits.substring(1) + floatDigits);
        while (mantissa.length() < 23) {
            mantissa.append("0");
        }

        return signedBit + exponentDigits + mantissa;
    }

    public static float decodeFloatSinglePrecision(String x) {
        if (x == null || x.length() != 32) {
            return Float.NaN;
        }
        String signedBit = x.substring(0, 1);
        String exponentBits = x.substring(1, 9);
        String mantissaBits = x.substring(9);

        int exponent = Integer.parseInt(exponentBits, 2) - 127;
        float mantissa = 1.0F;
        for (int i = 0; i < mantissaBits.length(); i++) {
            if (mantissaBits.charAt(i) == '1') {
                mantissa += (float) Math.pow(2.0F, -1.0F * (i + 1));
            }
        }

        float result = (float) (mantissa * Math.pow(2.0F, exponent));
        result = signedBit.equals("0") ? result : -1.0F * result;
        return Float.parseFloat(singlePrecisionFormat.format(result));
    }

    public static Double decodeUncertaintyLevel(Integer uncertaintyLevel) {
        if (uncertaintyLevel == null || uncertaintyLevel < 0 || uncertaintyLevel > 127) {
            return null;
        }
        if (uncertaintyLevel == 0 || uncertaintyLevel == 1 || uncertaintyLevel == 2) {
            return uncertaintyLevel.doubleValue();
        }

        return 10.0 * (Math.pow(1.1, uncertaintyLevel) - 1.0);
    }

    public static String encodeCoordinate(double x) {
        if (x < -180.0 || x > 180.0) {
            return null;
        }
        String signedBit = x > 0.0F ? "0" : "1";
        int intValue = Math.abs((int) x);
        StringBuilder integerDigits = new StringBuilder(Integer.toBinaryString(intValue));
        while (integerDigits.length() < 8) {
            integerDigits.insert(0, "0");
        }

        String floatDecimalDigits = singlePrecisionFormat.format(Math.abs(x) - intValue);
        double remainder = Double.parseDouble(floatDecimalDigits);
        StringBuilder floatDigits = new StringBuilder();

        while (Double.parseDouble(singlePrecisionFormat.format(remainder)) > 0.0F && floatDigits.length() + integerDigits.length() < 23) {
            remainder *= 2;
            intValue = (int) remainder;
            floatDigits.append(intValue);
            remainder = remainder - intValue;
        }
        StringBuilder mantissa = new StringBuilder(integerDigits + floatDigits.toString());
        while (mantissa.length() < 23) {
            mantissa.append("0");
        }

        return signedBit + mantissa;
    }

    public static Double decodeCoordinate(String x) {
        if (x == null || x.length() != 24) {
            return null;
        }
        String signedBit = x.substring(0, 1);
        String floatBits = x.substring(9);
        int intValue = Integer.parseInt(x.substring(1, 9), 2);

        double floatValue = 0.0;
        for (int i = 0; i < floatBits.length(); i++) {
            if (floatBits.charAt(i) == '1') {
                floatValue += Math.pow(2.0, -1.0 * (i + 1));
            }
        }

        double result = floatValue + (double) intValue;
        result = signedBit.equals("0") ? result : -1.0F * result;
        return Double.parseDouble(singlePrecisionFormat.format(result));
    }

    public static UeMobility mapNefUeStateToUeMobility(NefUeState nefUeState, NefCell nefCell) {
        UeMobility ueMobility = new UeMobility();

        ueMobility.time(Instant.now()).supi(nefUeState.getSupi());
        UserLocation userLocation = new UserLocation();

        NrLocation nrLocation = new NrLocation();

        String geographicalInformation = encodeEllipsoidPointWithUncertaintyCircle(nefUeState.getLatitude(),
                nefUeState.getLongitude(), 3);
        PlmnId plmnId = parsePlmnId(nefUeState.getMcc(), nefUeState.getMnc());
        nrLocation.ueLocationTimestamp(OffsetDateTime.now())
                .ncgi(new Ncgi()
                        .nrCellId(nefUeState.getCell_id_hex())
                        .plmnId(plmnId))
                .globalGnbId(new GlobalRanNodeId()
                        .ngeNbId("LMacroNGeNB-" + nefUeState.getGnb_id_hex())
                        .plmnId(plmnId))
                .geographicalInformation(geographicalInformation);
        if (nefCell != null) {
            nrLocation.cellLocation(mapNefCellLocation(nefCell));
        }
        userLocation.nrLocation(nrLocation);

        N3gaLocation n3gaLocation = new N3gaLocation();
        n3gaLocation.ueIpv4Addr(nefUeState.getIp_address_v4())
                .ueIpv6Addr(nefUeState.getIp_address_v6())
                .ueIpv4Addr(nefUeState.getIp_address_v4());
        userLocation.n3gaLocation(n3gaLocation);

        ueMobility.addLocInfosItem(new LocationInfo().loc(userLocation));
        return ueMobility;
    }

    public static PlmnId parsePlmnId(String mcc, String mnc) {
        StringBuilder mccSb = new StringBuilder(mcc);
        while (mccSb.length() < 3) {
            mccSb.insert(0, "0");
        }
        StringBuilder mncSb = new StringBuilder(mnc);
        while (mncSb.length() < 2) {
            mncSb.insert(0, "0");
        }
        return new PlmnId().mcc(mccSb.toString()).mnc(mncSb.toString());
    }

    public static PlmnId getNefScenarioPlmnId(NefScenario nefScenario) {
        if (nefScenario.getUEs().isEmpty() ||
                nefScenario.getUEs().getFirst() == null ||
                nefScenario.getUEs().getFirst().getMcc() == null ||
                nefScenario.getUEs().getFirst().getMnc() == null) return null;

        String mcc = nefScenario.getUEs().getFirst().getMcc().toString();
        String mnc = nefScenario.getUEs().getFirst().getMnc().toString();
        return parsePlmnId(mcc, mnc);
    }

    public static NetworkAreaInfo mapNefCellToAOI(NefCell nefCell, List<NefgNB> nefgNBs, PlmnId plmnId) {
        return new NetworkAreaInfo()
                .ncgis(List.of(new Ncgi()
                        .nrCellId(nefCell.getCell_id())
                        .plmnId(plmnId)))
                .gRanNodeIds(List.of(new GlobalRanNodeId()
                        .ngeNbId("LMacroNGeNB-" + nefgNBs.stream()
                                .filter(gnB -> gnB.getGNB_id().endsWith(nefCell.getGNB_id().toString()))
                                .findFirst().orElse(new NefgNB())
                                .getGNB_id())
                        .plmnId(plmnId)));
    }

    public static void removeAoIDuplicates(NetworkAreaInfo aoi) {
        if (aoi.getNcgis() != null) {
            aoi.setNcgis(new ArrayList<>(aoi.getNcgis().stream().distinct().toList()));
        }
        if (aoi.getGRanNodeIds() != null) {
            aoi.setGRanNodeIds(new ArrayList<>(aoi.getGRanNodeIds().stream().distinct().toList()));
        }
        if (aoi.getEcgis() != null) {
            aoi.setEcgis(new ArrayList<>(aoi.getEcgis().stream().distinct().toList()));
        }
        if (aoi.getTais() != null) {
            aoi.setTais(new ArrayList<>(aoi.getTais().stream().distinct().toList()));
        }
    }

    public static NetworkAreaInfo concatenateAoIs(List<NetworkAreaInfo> aois, UUID id) {
        NetworkAreaInfo result = new NetworkAreaInfo().id(id);
        for (NetworkAreaInfo aoi : aois) {
            if (aoi.getNcgis() != null) {
                aoi.getNcgis().forEach(result::addNcgisItem);
            }
            if (aoi.getGRanNodeIds() != null) {
                aoi.getGRanNodeIds().forEach(result::addGRanNodeIdsItem);
            }
            if (aoi.getEcgis() != null) {
                aoi.getEcgis().forEach(result::addEcgisItem);
            }
            if (aoi.getTais() != null) {
                aoi.getTais().forEach(result::addTaisItem);
            }
        }
        removeAoIDuplicates(result);
        return result;
    }

    public static EllipsoidArc mapNefCellLocation(NefCell nefCell) {
        EllipsoidArc result = new EllipsoidArc()
                .point(new GeographicalCoordinates()
                        .lat(Double.valueOf(nefCell.getLatitude()))
                        .lon(Double.valueOf(nefCell.getLongitude())
                        ))
                .innerRadius(Math.round(nefCell.getRadius()))
                .includedAngle(360)
                .offsetAngle(0)
                .uncertaintyRadius(0.0);
        result.setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapes.SupportedGADShapesEnum.EllipsoidArc));
        return result;
    }

    public static NetworkAreaInfo mapUeMobilityToAOI(UeMobility ueMobility) {
        NetworkAreaInfo result = new NetworkAreaInfo();
        if (ueMobility.getLocInfos() != null) {
            for (LocationInfo locationInfo : ueMobility.getLocInfos()) {
                UserLocation userLocation = locationInfo.getLoc();
                if (userLocation != null) {

                    toOptional(userLocation.getNrLocation()).ifPresent( nrLocation -> {
                        toOptional(nrLocation.getNcgi()).ifPresent(result::addNcgisItem);
                        toOptional(nrLocation.getGlobalGnbId()).ifPresent(result::addGRanNodeIdsItem);
                        toOptional(nrLocation.getTai()).ifPresent(result::addTaisItem);
                    });
                    toOptional(userLocation.getEutraLocation()).ifPresent( eutraLocation -> {
                        toOptional(eutraLocation.getEcgi()).ifPresent(result::addEcgisItem);
                        toOptional(eutraLocation.getGlobalENbId()).ifPresent(result::addGRanNodeIdsItem);
                        toOptional(eutraLocation.getGlobalNgenbId()).ifPresent(result::addGRanNodeIdsItem);
                        toOptional(eutraLocation.getTai()).ifPresent(result::addTaisItem);
                    });
                    toOptional(userLocation.getN3gaLocation()).ifPresent( n3gaLocation -> {
                        toOptional(n3gaLocation.getN3gppTai()).ifPresent(result::addTaisItem);
                    });
                }
            }
        }
        return result;
    }

    public static UeCommunication mapNefUeStateToUeCommunication(NefUeState nefUeState) {
        UeCommunication ueCommunication = new UeCommunication();
        ueCommunication
                .supi(nefUeState.getSupi())
                .time(Instant.now())
                .trafChar(new TrafficCharacterization()
                        .appId(nefUeState.getExternal_identifier())
                        .dnn(nefUeState.getDnn())
                        .addFDescsItem(new IpEthFlowDescription()
                                .ethTrafficFilter(new EthFlowDescription()
                                        .sourceMacAddr(nefUeState.getMac_address())
                                        .ethType("0800"))
                                .ipTrafficFilter(IpFilterRule.builder()
                                        .code(507)
                                        .vendorId(nefUeState.getOwner_id())
                                        .ipVersion("4")
                                        .sourceIpAddr(new IpAddr().ipv4Addr(nefUeState.getIp_address_v4()))
                                        .sourceIpAddrMask(new IpAddr().ipv4Addr("255.255.255.0"))
                                        .transportProtocol(new TransportProtocol().transportProtocol(TransportProtocol.TransportProtocolEnum.TCP))
                                        .direction(new FlowDirection().fDir(FlowDirection.FlowDirectionEnum.UPLINK))
                                        .build()
                                        .toAvp())));

        return ueCommunication;
    }

    public static Double setAccuracy(Double input, DecimalFormat df) {
        return toOptional(input).map(df::format).map(Double::parseDouble).orElse(null);
    }

    public static List<Double> convertGpsToECEF(double lat, double lon, double alt) {

        double a = 6378.1;
        double b = 6356.8;
        double N;
        double b2DivA2 = Math.pow(b, 2) / Math.pow(a, 2);
        double e = 1 - b2DivA2;
        N = a / (Math.sqrt(1.0 - (e * Math.pow(Math.sin(Math.toRadians(lat)), 2))));
        double cosLatRad = Math.cos(Math.toRadians(lat));
        double cosLongiRad = Math.cos(Math.toRadians(lon));
        double sinLatRad = Math.sin(Math.toRadians(lat));
        double sinLongiRad = Math.sin(Math.toRadians(lon));
        double x = (N + 0.001 * alt) * cosLatRad * cosLongiRad;
        double y = (N + 0.001 * alt) * cosLatRad * sinLongiRad;
        double z = (b2DivA2 * N + 0.001 * alt) * sinLatRad;

        List<Double> ecef = new ArrayList<>();
        ecef.add(x);
        ecef.add(y);
        ecef.add(z);

        return ecef;
    }


    public static List<Double> convertECEFtoENU(List<Double> ecefUser, List<Double> ecefPOI, double lat, double longi) {

        double cosLatRad = Math.cos(Math.toRadians(lat));
        double cosLongiRad = Math.cos(Math.toRadians(longi));
        double sinLatRad = Math.sin(Math.toRadians(lat));
        double sinLongiRad = Math.sin(Math.toRadians(longi));


        List<Double> vector = new ArrayList<>();

        vector.add(ecefUser.get(0) - ecefPOI.get(0));
        vector.add(ecefUser.get(1) - ecefPOI.get(1));
        vector.add(ecefUser.get(2) - ecefPOI.get(2));

        double e = vector.get(0) * (-sinLongiRad) + vector.get(1) * (cosLongiRad);
        double n = vector.get(0) * (-sinLatRad) * (cosLongiRad) + vector.get(1) * (-sinLatRad) * (sinLongiRad) + vector.get(2) * cosLatRad;
        double u = vector.get(0) * (cosLatRad) * (cosLongiRad) + vector.get(1) * (cosLatRad) * (sinLongiRad) + vector.get(2) * sinLatRad;


        List<Double> enu = new ArrayList<>();
        enu.add(e);
        enu.add(n);
        enu.add(u);

        return enu;
    }

    public static List<Double> convertENUtoECEF(List<Double> ecefUser, List<Double> enuPOI, double lat, double longi) {

        double cosLatRad = Math.cos(Math.toRadians(lat));
        double cosLongiRad = Math.cos(Math.toRadians(longi));
        double sinLatRad = Math.sin(Math.toRadians(lat));
        double sinLongiRad = Math.sin(Math.toRadians(longi));

        double x = enuPOI.get(0) * (-sinLongiRad) + enuPOI.get(1) * (cosLongiRad);
        double y = enuPOI.get(0) * (-sinLatRad) * (cosLongiRad) + enuPOI.get(1) * (-sinLatRad) * (sinLongiRad) + enuPOI.get(2) * cosLatRad;
        double z = enuPOI.get(0) * (cosLatRad) * (cosLongiRad) + enuPOI.get(1) * (cosLatRad) * (sinLongiRad) + enuPOI.get(2) * sinLatRad;

        List<Double> ecef = new ArrayList<>();

        ecef.add(ecefUser.get(0) + x);
        ecef.add(ecefUser.get(1) + y);
        ecef.add(ecefUser.get(2) + z);

        return ecef;
    }

    /**
     * Converts a docker id with format docker/id/[first 32 digits] to a UUID
     *
     * @param dockerId the docker id
     * @return the UUID
     */
    public static String convertDockerIdToUUID(String dockerId) {
        int start = getStartOfDigitsInDockerId(dockerId);
        String uuid = dockerId.substring(start, start + 32).replaceFirst(uuidFromDockerId, "$1-$2-$3-$4-$5");
        uuid = uuid.substring(0, 14) + "4" + uuid.substring(15);
        uuid = uuid.substring(0, 19) + "8" + uuid.substring(20);
        return uuid;
    }

    /**
     * Returns the start index of the digits in the docker id with format docker/id/[digits]
     *
     * @param dockerId the docker id
     * @return the start index of the digits in the docker id
     */
    public static int getStartOfDigitsInDockerId(String dockerId) {
        String modifier = "docker-";
        int st_index = dockerId.indexOf(modifier);
        // in windows docker desktop it is usually formatted with slash instead of hyphen as below:
        if (st_index == -1 || dockerId.charAt(st_index + modifier.length()) == 'r') {
            modifier = "docker/";
            st_index = dockerId.indexOf(modifier);
        }
        return st_index + modifier.length();
    }
}
