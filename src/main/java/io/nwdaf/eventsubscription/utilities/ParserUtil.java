package io.nwdaf.eventsubscription.utilities;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

import io.nwdaf.eventsubscription.model.NfLoadLevelInformation;
import io.nwdaf.eventsubscription.model.ThresholdLevel;

public class ParserUtil {
    public static Integer safeParseInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

    public static Float safeParseFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

    public static Double safeParseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

    public static OffsetDateTime safeParseOffsetDateTime(String str) {
        try {
            return OffsetDateTime.parse(str);
        } catch (DateTimeParseException | NullPointerException e) {
            return null;
        }
    }

    public static UUID safeParseUUID(String str) {
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException | NullPointerException e) {
            return null;
        }
    }

    public static Boolean safeParseBoolean(String value) {
        if (value == null) {
            return null;
        }

        return Boolean.parseBoolean(value);
    }

    public static String safeParseString(Object o) {
        if (o == null) {
            return null;
        }

        return o.toString();
    }

    public static List<String> safeParseListString(List<Object> l) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            res.add(safeParseString(l.get(i)));
        }
        return res;
    }

    public static Long safeParseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static <T> List<String> parseListToFilterList(List<T> list, String name) {
        List<String> filterList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                continue;
            }
            if (list.get(i).getClass().equals(Integer.class) || list.get(i).toString().startsWith("{")) {
                filterList.add("{\"" + name + "\":" + list.get(i) + "}");
            } else {
                filterList.add("{\"" + name + "\":\"" + list.get(i) + "\"}");
            }
        }
        return filterList;
    }

    public static String parseQuerryFilter(List<String> filterList) {
        StringBuilder res = new StringBuilder("(");
        if (filterList == null || filterList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < filterList.size(); i++) {
            res.append("data @> cast('").append(filterList.get(i)).append("' as jsonb)");
            if (i != filterList.size() - 1) {
                res.append(" or ");
            }
        }
        res.append(")");
        return res.toString();
    }

    public static String parseQuerryFilterContains(List<String> filterList, String subProperty) {
        String res = "(";
        if (filterList == null || filterList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < filterList.size(); i++) {
            res += "data->'" + subProperty + "' @> '\"" + filterList.get(i) + "\"'";
            if (i != filterList.size() - 1) {
                res += " or ";
            }
        }
        res += ")";
        return res;
    }

    public static String parseQuerryFilterListContains(List<String> filterList, String subProperty) {
        String res = "(";
        if (filterList == null || filterList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < filterList.size(); i++) {
            res += "data->'" + subProperty + "' @> '[\"" + filterList.get(i) + "\"]'";
            if (i != filterList.size() - 1) {
                res += " or ";
            }
        }
        res += ")";
        return res;
    }

    // remove edge cases from list of filters
    public static List<String> parseObjectListToFilterList(List<String> list) {
        List<String> filterList = new ArrayList<>();
        if (list == null) {
            return null;
        }
        for (String s : list) {
            if (s == null || Objects.equals(s, "") || Objects.equals(s, "{}")) {
                continue;
            } else {
                filterList.add(s);
            }
        }
        return filterList;
    }

    public static <T> Boolean safeParseContains(List<T> list, T item) {
        if (list != null && !list.isEmpty() && list.contains(item)) {
            return true;
        }
        return false;
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    // get only the current time nfloadlevelinfo (remove past offset nfloadlevelinfos)
    public static List<NfLoadLevelInformation> parsePresentNfLoadLevelInformations(List<NfLoadLevelInformation> nfLoadLevelInformations) {
        List<NfLoadLevelInformation> res = new ArrayList<>();
        OffsetDateTime latest = nfLoadLevelInformations.getFirst().getTimeStamp();
        for (int i = 1; i < nfLoadLevelInformations.size(); i++) {
            if (nfLoadLevelInformations.get(i).getTimeStamp().isAfter(latest)) {
                latest = nfLoadLevelInformations.get(i).getTimeStamp();
            }
        }
        for (NfLoadLevelInformation nfLoadLevelInformation : nfLoadLevelInformations) {
            if (!nfLoadLevelInformation.getTimeStamp().isBefore(latest.minusNanos(Constants.MIN_PERIOD_NANOS / 2))) {
                res.add(nfLoadLevelInformation);
            }
        }
        return res;
    }

    public static List<String> parseThresholdLevelToStringArray(ThresholdLevel thresholdLevel) {
        if (thresholdLevel == null) {
            return null;
        }
        return new ArrayList<>(Arrays.asList(safeParseString(thresholdLevel.getCongLevel()),
                safeParseString(thresholdLevel.getNfLoadLevel()),
                safeParseString(thresholdLevel.getNfCpuUsage()),
                safeParseString(thresholdLevel.getNfMemoryUsage()),
                safeParseString(thresholdLevel.getNfStorageUsage()),
                safeParseString(thresholdLevel.getAvgTrafficRate()),
                safeParseString(thresholdLevel.getMaxTrafficRate()),
                safeParseString(thresholdLevel.getAvgPacketDelay()),
                safeParseString(thresholdLevel.getMaxPacketDelay()),
                safeParseString(thresholdLevel.getAvgPacketLossRate()),
                safeParseString(thresholdLevel.getSvcExpLevel())
        ));
    }
}