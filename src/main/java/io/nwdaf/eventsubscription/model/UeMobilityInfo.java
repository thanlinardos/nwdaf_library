package io.nwdaf.eventsubscription.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UeMobilityInfo {

    private String supi;

    private String appId;

    private List<UeTrajectoryInfo> ueTrajs;
}
