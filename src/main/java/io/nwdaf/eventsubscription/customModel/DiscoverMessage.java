package io.nwdaf.eventsubscription.customModel;

import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class DiscoverMessage {
    private NwdafEventEnum requestedEvent;
    // (in seconds)
    private Integer requestedOffset;
    private Boolean hasData;
    // (in seconds)
    private Integer availableOffset;
    // (in seconds)
    private Integer expectedWaitTime; 

    public String toString(){
        return "{\"event\":\""+ParserUtil.safeParseString(requestedEvent)
            +"\",\"offset\":\""+ParserUtil.safeParseString(requestedOffset)+"\""
            +"\",\"hasData\":\""+ParserUtil.safeParseString(hasData)+"\""
            +"\",\"availableOffset\":\""+ParserUtil.safeParseString(availableOffset)+"\""
            +"\",\"expectedWaitTime\":\""+ParserUtil.safeParseString(expectedWaitTime)+"\"}";
    }
}
