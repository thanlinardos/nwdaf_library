package io.nwdaf.eventsubscription.model;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UeTrajectoryInfo {

    private OffsetDateTime ts;

    private UserLocation location;  // only EutraLocation and/or NrLocation
}
