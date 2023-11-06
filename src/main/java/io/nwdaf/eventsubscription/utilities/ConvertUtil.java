package io.nwdaf.eventsubscription.utilities;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ConvertUtil {
    // converts empty string to null
    public static String convertEmptyStringToNull(String in) {
        if (in == null) {
            return null;
        }
        if (in.equals("")) {
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
        for (int i = 0; i < list.size(); i++) {
            try {
                res.add(ow.writeValueAsString(list.get(i)));
            } catch (JsonProcessingException e) {
                System.out.println("jsonprocessing error!!");
                continue;
            }
        }
        // System.out.println("object list: "+res);
        return res;
    }

    public static Instant convertDoubleToInstant(Double d) {
        if (d == null) {
            return null;
        }
        long secondsSinceEpoch = (long) d.doubleValue();
        double fractionalPart = d.doubleValue() - secondsSinceEpoch;
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
        return OffsetDateTime.ofInstant(i,ZoneId.systemDefault());
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
        if(d==null) {
            return null;
        }
        return Float.valueOf((float) d.doubleValue());
    }
}
