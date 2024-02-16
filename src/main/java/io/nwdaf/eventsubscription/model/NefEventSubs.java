package io.nwdaf.eventsubscription.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NefEventSubs {

    private NefEvent event;

    private NefEventFilter eventFilter;

    private String supi;

    private String interGroupId;

    private String appId;

    private List<CommunicationCollection> comms;
}
