package io.nwdaf.eventsubscription.customModel;

import java.time.OffsetDateTime;

import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class DiscoverMessage {
    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private NwdafEventEnum requestedEvent;
    // (in seconds)
    private Integer requestedOffset;
    private Boolean hasData;
    // (in seconds)
    private Integer availableOffset;
    // (in seconds)
    private Integer expectedWaitTime; 

    public String toString(){
        return "{\"timestamp\":\"" + timestamp
                +"\"requestedEvent\":\"" + ParserUtil.safeParseString(requestedEvent)
                +"\",\"requestedOffset\":\"" + ParserUtil.safeParseString(requestedOffset)+"\"}"
                +"\",\"hasData\":\"" + ParserUtil.safeParseString(hasData)+"\""
                +"\",\"availableOffset\":\"" + ParserUtil.safeParseString(availableOffset)+"\""
                +"\",\"expectedWaitTime\":\"" + ParserUtil.safeParseString(expectedWaitTime)+"\"}";
    }
}
