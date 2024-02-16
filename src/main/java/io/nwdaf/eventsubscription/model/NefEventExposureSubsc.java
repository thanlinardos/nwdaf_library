package io.nwdaf.eventsubscription.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NefEventExposureSubsc {

    private String dataAccProfId;

    private List<NefEventSubs> eventsSubs;

    private ReportingInformation eventsRepInfo;

    private String notifUri;

    private List<NefEventNotification> eventNotifs;

    private String notifId;

    private String suppFeat;
}
