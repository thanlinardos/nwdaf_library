package io.nwdaf.eventsubscription.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TargetUeIdentification {

    private List<String> supis;

    private List<String> interGroupIds;

    private Boolean anyUeId;
}
