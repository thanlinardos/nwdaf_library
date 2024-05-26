package io.nwdaf.eventsubscription.utilities;

import java.util.List;
import java.util.Objects;

import io.nwdaf.eventsubscription.model.NetworkAreaInfo;
import io.nwdaf.eventsubscription.model.NnwdafEventsSubscriptionNotification;
import io.nwdaf.eventsubscription.model.NwdafEvent;

import static io.nwdaf.eventsubscription.utilities.Constants.naiRegex;
import static io.nwdaf.eventsubscription.utilities.Constants.nsiRegex;

public class CheckUtil {
    // checks if input string is neither null nor empty string ("")
    public static Boolean checkNotNullNorEmptyString(String in) {
        return in != null && !in.isEmpty();
    }

    // checks if left parameter list contains all the elements of the list on the right
    public static <T> Boolean listInside(List<T> l1, List<T> l2) {
        for (int i = 0; i < l2.size(); i++) {
            if (!l1.contains(l2)) {
                return false;
            }
        }
        return true;
    }

    public static <T> Boolean safeCheckContainsNotNull(List<T> list) {
        for (T t : list) {
            if (t != null) {
                return true;
            }
        }
        return false;
    }

    public static <T> Boolean safeCheckListNotEmpty(List<T> list) {
        return list != null && !list.isEmpty() && safeCheckContainsNotNull(list);
    }

    public static <T> Boolean safeCheckListEmpty(List<T> list) {
        return list == null || list.isEmpty() || !safeCheckContainsNotNull(list);
    }

    public static Boolean safeCheckOneOfListsNotEmpty(List<?>... lists) {
        for (List<?> list : lists) {
            if (safeCheckListNotEmpty(list)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean safeCheckListsNotEmpty(List<?>... lists) {
        for (List<?> list : lists) {
            if (!safeCheckListNotEmpty(list)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean safeCheckEquals(String value, String comparisonValue) {
        if (value == null) {
            return false;
        }
        try {
            return value.equalsIgnoreCase(comparisonValue);
        } catch (Exception e) {
            return false;
        }
    }

    public static <T> Boolean safeCheckObjectsEquals(T o1, T o2) {
        if (o1 == null || o2 == null) {
            return o1 == o2;
        } else {
            return Objects.equals(o1, o2);
        }
    }

    public static Boolean safeCheckNetworkAreaNotEmpty(NetworkAreaInfo area) {
        if (area == null) {
            return false;
        }
        return CheckUtil.safeCheckListNotEmpty(area.getEcgis()) || CheckUtil.safeCheckListNotEmpty(area.getNcgis()) ||
                CheckUtil.safeCheckListNotEmpty(area.getGRanNodeIds()) || CheckUtil.safeCheckListNotEmpty(area.getTais());
    }

    public static Boolean safeCheckEventNotificationWithinMilli(NnwdafEventsSubscriptionNotification notification,
                                                                long milliseconds,
                                                                long now) {
        if (notification != null && notification.getEventNotifications() != null &&
                !notification.getEventNotifications().isEmpty() &&
                notification.getEventNotifications().getFirst() != null &&
                notification.getEventNotifications().getFirst().getTimeStampGen() != null) {
            long notificationMilliSeconds = now - notification.getEventNotifications().getFirst()
                    .getTimeStampGen().toInstant().toEpochMilli();
            return notificationMilliSeconds <= milliseconds;
        }
        return false;
    }

    public static Boolean safeCheckEqualsEvent(NwdafEvent e1, NwdafEvent e2) {
        if (e1 != null && e2 != null && e1.getEvent() != null && e2.getEvent() != null) {
            return e1.getEvent().equals(e2.getEvent());
        }
        return false;
    }

    public static boolean isValidSupi(String supi) {
        return supi.matches(nsiRegex) || supi.matches(naiRegex);
    }
}
