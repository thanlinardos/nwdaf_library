package io.nwdaf.eventsubscription.customModel;

import java.time.OffsetDateTime;
import java.util.UUID;

import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static io.nwdaf.eventsubscription.utilities.ParserUtil.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class DiscoverMessage {
    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private NwdafEventEnum requestedEvent;
    private UUID collectorInstanceId;
    // (in seconds)
    private Long requestedOffset;
    private Boolean hasData;
    // (in seconds)
    private Long availableOffset;
    // (in seconds)
    private Long expectedWaitTime;

    public String toString(){
        return "{\"timestamp\":\"" + timestamp
                +"\",\"requestedEvent\":\"" + safeParseString(requestedEvent)
                +"\",\"collectorInstanceId\":\"" + safeParseString(collectorInstanceId)
                +"\",\"requestedOffset\":\"" + safeParseString(requestedOffset)
                +"\",\"hasData\":\"" + safeParseString(hasData)
                +"\",\"availableOffset\":\"" + safeParseString(availableOffset)
                +"\",\"expectedWaitTime\":\"" + safeParseString(expectedWaitTime)+"\"}";
    }

    public static DiscoverMessage fromString(String input) {
        DiscoverMessage result = new DiscoverMessage();
        String[] attributes = input.substring(1,input.length()-1).split("\",");

        result.setTimestamp(OffsetDateTime.parse(attributes[0].split(":\"")[1]));
        result.setRequestedEvent(NwdafEventEnum.valueOf(attributes[1].split(":\"")[1]));
        result.setCollectorInstanceId(UUID.fromString(attributes[2].split(":\"")[1]));
        result.setRequestedOffset(safeParseLong((attributes[3].split(":\"")[1])));
        result.setHasData(safeParseBoolean((attributes[4].split(":\"")[1])));
        result.setAvailableOffset(safeParseLong((attributes[5].split(":\"")[1])));
        result.setExpectedWaitTime(safeParseLong((attributes[6].split(":\"")[1].replace("\"",""))));

        return result;
    }
}
