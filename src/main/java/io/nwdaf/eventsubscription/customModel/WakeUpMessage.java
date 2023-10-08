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
public class WakeUpMessage {
    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private NwdafEventEnum requestedEvent;
    // (in seconds)
    private Integer requestedOffset;

    public String toString(){
        return "{\"timestamp\":\"" + timestamp
                +"\"requestedEvent\":\"" + ParserUtil.safeParseString(requestedEvent)
                +"\",\"requestedOffset\":\"" + ParserUtil.safeParseString(requestedOffset)+"\"}";
    }
}
