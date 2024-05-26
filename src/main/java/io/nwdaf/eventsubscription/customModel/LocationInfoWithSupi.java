package io.nwdaf.eventsubscription.customModel;


import io.nwdaf.eventsubscription.model.LocationInfo;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationInfoWithSupi extends LocationInfo {

    public LocationInfoWithSupi(String supi, LocationInfo locationInfo) {
        super(locationInfo.getLoc(), locationInfo.getRatio(), locationInfo.getConfidence());
        this.supi = supi;
    }

    private String supi;
}
