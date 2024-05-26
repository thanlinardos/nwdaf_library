package io.nwdaf.eventsubscription.customModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @ToString
public class PointUncertaintyCircleResult {
    private Double latitude;
    private Double longitude;
    private Double uncertainty;
    private String supi;
}
