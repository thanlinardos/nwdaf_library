package io.nwdaf.eventsubscription.customModel;

import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class WakeUpMessage {
    private NwdafEventEnum requestedEvent;
    // (in seconds)
    private Integer requestedOffset;

    public String toString(){
        return "{\"event\":\""+ParserUtil.safeParseString(requestedEvent)+"\",\"offset\":\""+ParserUtil.safeParseString(requestedOffset)+"\"}";
    }
}
