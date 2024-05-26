package io.nwdaf.eventsubscription.customModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum KafkaTopic {
    DISCOVER("DISCOVER"),
    WAKE_UP("WAKE_UP"),
    NF_LOAD("NF_LOAD"),
    UE_MOBILITY("UE_MOBILITY"),
    UE_COMM("UE_COMM"),
    REGISTER_NOTIFIER("REGISTER_NOTIFIER"),
    ASSIGN_SUBS("ASSIGN_SUBS"),
    REGISTER_CONSUMER("REGISTER_CONSUMER"),
    ASSIGN_PARTITIONS("ASSIGN_PARTITIONS"),
    NEF_SCENARIO("NEF_SCENARIO");

    private final String value;

    KafkaTopic(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static KafkaTopic fromValue(String text) {
        for (KafkaTopic t : KafkaTopic.values()) {
            if (String.valueOf(t.value).equals(text)) {
                return t;
            }
        }
        return null;
    }
}
