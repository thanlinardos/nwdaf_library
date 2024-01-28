package io.nwdaf.eventsubscription.utilities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.nwdaf.eventsubscription.customModel.NefUeState;
import io.nwdaf.eventsubscription.model.*;

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
        String uncertainty = Integer.toBinaryString(encodeInteger(uncertaintyLevel, 7));
        while (uncertainty.length() < 7) {
            uncertainty = "0" + uncertainty;
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
        String exponentDigits = Integer.toBinaryString(exponent);
        while (exponentDigits.length() < 8) {
            exponentDigits = "0" + exponentDigits;
        }

        String floatDecimalDigits = singlePrecisionFormat.format(Math.abs(x) - intValue);
        float remainder = Float.parseFloat(floatDecimalDigits);
        String floatDigits = "";

        while (remainder > 0.0F && floatDigits.length() + integerDigits.length() - 1 < 23) {
            remainder *= 2;
            intValue = (int) remainder;
            floatDigits += intValue;
            remainder = Float.parseFloat(singlePrecisionFormat.format(remainder - intValue));
        }
        String mantissa = integerDigits.substring(1) + floatDigits;
        while (mantissa.length() < 23) {
            mantissa += "0";
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
        String integerDigits = Integer.toBinaryString(intValue);
        while (integerDigits.length() < 8) {
            integerDigits = "0" + integerDigits;
        }

        String floatDecimalDigits = singlePrecisionFormat.format(Math.abs(x) - intValue);
        double remainder = Double.parseDouble(floatDecimalDigits);
        String floatDigits = "";

        while (Double.parseDouble(singlePrecisionFormat.format(remainder)) > 0.0F && floatDigits.length() + integerDigits.length() < 23) {
            remainder *= 2;
            intValue = (int) remainder;
            floatDigits += intValue;
            remainder = remainder - intValue;
        }
        String mantissa = integerDigits + floatDigits;
        while (mantissa.length() < 23) {
            mantissa += "0";
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

    public static UeMobility mapNefUeStateToUeMobility(NefUeState nefUeState) {
        UeMobility ueMobility = new UeMobility();

        String geographicalInformation = ConvertUtil.encodeEllipsoidPointWithUncertaintyCircle(nefUeState.getLatitude(), nefUeState.getLongitude(), 3);

        ueMobility.time(Instant.now()).supi(nefUeState.getSupi());
        UserLocation userLocation = new UserLocation();
        NrLocation nrLocation = new NrLocation();
        nrLocation.ueLocationTimestamp(OffsetDateTime.now())
                .ncgi(new Ncgi()
                        .nrCellId(nefUeState.getCell_id_hex())
                        .plmnId(new PlmnId()
                                .mcc(nefUeState.getMcc())
                                .mnc(nefUeState.getMnc())))
                .globalGnbId(new GlobalRanNodeId()
                        .ngeNbId("LMacroNGeNB-" + nefUeState.getGnb_id_hex()))
                .geographicalInformation(geographicalInformation);
        userLocation.nrLocation(nrLocation);
        N3gaLocation n3gaLocation = new N3gaLocation();
        n3gaLocation.ueIpv4Addr(nefUeState.getIp_address_v4())
                .ueIpv6Addr(nefUeState.getIp_address_v6())
                .ueIpv4Addr(nefUeState.getIp_address_v4());
        userLocation.n3gaLocation(n3gaLocation);

        ueMobility.addLocInfosItem(new LocationInfo().loc(userLocation));
        return ueMobility;
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
        if (input == null) {
            return null;
        }
        return Double.parseDouble(df.format(input));
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
}
