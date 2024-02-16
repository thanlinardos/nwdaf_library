package io.nwdaf.eventsubscription.model;


import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommunicationCollection {

    private OffsetDateTime startTime;

    private OffsetDateTime endTime;

    private Integer ulVol;

    private Integer dlVol;
}
