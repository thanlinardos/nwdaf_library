package io.nwdaf.eventsubscription.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CollectiveBehaviourFilterType {

    COLLECTIVE_ATTRIBUTE("COLLECTIVE_ATTRIBUTE"),
    DATA_PROCESSING("DATA_PROCESSING");

    private final String value;

    CollectiveBehaviourFilterType(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static CollectiveBehaviourFilterType fromValue(String text) {
        for (CollectiveBehaviourFilterType e : CollectiveBehaviourFilterType.values()) {
            if (String.valueOf(e.value).equals(text)) {
                return e;
            }
        }
        return null;
    }
}
