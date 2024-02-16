package io.nwdaf.eventsubscription.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NefEventFilter {
    private TargetUeIdentification tgtUe;

    private List<String> appIds;

    private NetworkAreaInfo locArea;

    private List<CollectiveBehaviourFilter> collAttrs;
}
