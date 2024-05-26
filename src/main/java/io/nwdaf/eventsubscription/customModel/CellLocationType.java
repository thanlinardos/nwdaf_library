package io.nwdaf.eventsubscription.customModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CellLocationType {
    NR_LOCATION("NR_LOCATION"),
    EUTRA_LOCATION("EUTRA_LOCATION"),
    N3GA_LOCATION("N3GA_LOCATION"),
    UTRA_LOCATION("UTRA_LOCATION"),
    GERA_LOCATION("GERA_LOCATION");

    private final String value;

    CellLocationType(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static CellLocationType fromValue(String text) {
        for (CellLocationType b : CellLocationType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
