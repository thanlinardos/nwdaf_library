package io.nwdaf.eventsubscription.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NefEvent {

    UE_MOBILITY("UE_MOBILITY"),
    UE_COMM("UE_COMM"),
    SVC_EXPERIENCE("SVC_EXPERIENCE"),
    EXCEPTIONS("EXCEPTIONS"),
    USER_DATA_CONGESTION("USER_DATA_CONGESTION"),
    PERF_DATA("PERF_DATA"),
    DISPERSION("DISPERSION"),
    COLLECTIVE_BEHAVIOUR("COLLECTIVE_BEHAVIOUR"),
    MS_QOE_METRICS("MS_QOE_METRICS"),
    MS_CONSUMPTION("MS_CONSUMPTION"),
    MS_NET_ASSIST_INVOCATION("MS_NET_ASSIST_INVOCATION"),
    MS_DYN_POLICY_INVOCATION("MS_DYN_POLICY_INVOCATION"),
    MS_ACCESS_ACTIVITY("MS_ACCESS_ACTIVITY");

    private final String value;

    NefEvent(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static NefEvent fromValue(String text) {
        for (NefEvent e : NefEvent.values()) {
            if (String.valueOf(e.value).equals(text)) {
                return e;
            }
        }
        return null;
    }

}
