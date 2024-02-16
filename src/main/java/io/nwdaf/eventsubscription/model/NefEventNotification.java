package io.nwdaf.eventsubscription.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NefEventNotification {

    private NefEvent event;

    private OffsetDateTime timeStamp;

    private List<UeMobilityInfo> ueMobilityInfos;
}
