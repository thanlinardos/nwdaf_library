package io.nwdaf.eventsubscription.utilities;

import java.util.List;
import java.util.Objects;

import io.nwdaf.eventsubscription.model.NetworkAreaInfo;
import io.nwdaf.eventsubscription.model.NnwdafEventsSubscriptionNotification;

public class CheckUtil {
    // checks if input string is neither null nor empty string ("")
    public static Boolean checkNotNullNorEmptyString(String in){
        if(in!=null && !in.equals("")){
            return true;
        }
        return false;
    }
    // checks if left parameter list contains all the elements of the list on the right
    public static <T extends Object> Boolean listInside(List<T> l1, List<T> l2){
        for(int i=0;i<l2.size();i++){
            if(!l1.contains(l2)){
                return false;
            }
        }
        return true;
    }
    // contains at least 1 non null item
    public static <T> Boolean safeCheckContainsNotNull(List<T> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i)!=null){
                return true;
            }
        }
        return false;
    }

    // does all 3 necessary checks on a list (not null, size>0, at least 1 non null item)
    public static <T> Boolean safeCheckListNotEmpty(List<T> list){
        if(list!=null && list.size()>0 && safeCheckContainsNotNull(list)){
            return true;
        }
        return false;
    }
    public static Boolean safeCheckEquals(String value,String comparisonValue) {
        if (value == null) {
            return false;
        }
        try{
            return value.equalsIgnoreCase(comparisonValue);
        }catch(Exception e){
            return false;
        }
    }

    public static <T> Boolean safeCheckObjectsEquals(T o1, T o2){
        if(o1 == null || o2 == null){
            if(o1 == o2){
                return true;
            }
            return false;
        }
        else{
            return Objects.equals(o1,o2);
        }
    }

    public static Boolean safeCheckNetworkAreaNotEmpty(NetworkAreaInfo area){
        if(area == null){
            return false;
        }
        return CheckUtil.safeCheckListNotEmpty(area.getEcgis()) || CheckUtil.safeCheckListNotEmpty(area.getNcgis()) || 
			   CheckUtil.safeCheckListNotEmpty(area.getGRanNodeIds()) || CheckUtil.safeCheckListNotEmpty(area.getTais());
    }

    public static Boolean safeCheckEventNotificationWithinMilli(NnwdafEventsSubscriptionNotification notification, long milliseconds) {
        if(notification!= null && notification.getEventNotifications()!=null && notification.getEventNotifications().size()>0 && notification.getEventNotifications().get(0)!=null &&
           notification.getEventNotifications().get(0).getTimeStampGen()!=null) {
            long notificationSeconds = notification.getEventNotifications().get(0).getTimeStampGen().toInstant().toEpochMilli();
            if(notificationSeconds<=milliseconds) {
                return true;
            }
        }
        return false;
    }
}
