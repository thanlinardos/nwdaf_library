package io.nwdaf.eventsubscription.customModel;

import java.time.OffsetDateTime;
import java.util.UUID;

import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;
import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static io.nwdaf.eventsubscription.utilities.ConvertUtil.convertDoubleToOffSetDateTime;
import static io.nwdaf.eventsubscription.utilities.ParserUtil.safeParseDouble;
import static io.nwdaf.eventsubscription.utilities.ParserUtil.safeParseLong;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WakeUpMessage {
    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private NwdafEventEnum requestedEvent;
    private UUID nfInstancedId;
    // (in seconds)
    private Long requestedOffset;

    public String toString() {
        return "{\"timestamp\":\"" + timestamp
                + "\",\"requestedEvent\":\"" + ParserUtil.safeParseString(requestedEvent)
                + "\",\"nfInstancedId\":\"" + ParserUtil.safeParseString(nfInstancedId)
                + "\",\"requestedOffset\":\"" + ParserUtil.safeParseString(requestedOffset) + "\"}";
    }

    public static WakeUpMessage fromString(String input) {
        String[] attributes = input.substring(1, input.length() - 1).split(",");
        return WakeUpMessage
                .builder()
                .timestamp(convertDoubleToOffSetDateTime(safeParseDouble(attributes[0].split(":")[1])))
                .requestedEvent(NwdafEventEnum.valueOf(attributes[1].split(":")[1].replace("\"", "")))
                .nfInstancedId(UUID.fromString(attributes[2].split(":")[1].replace("\"", "")))
                .requestedOffset(safeParseLong((attributes[3].split(":")[1])))
                .build();
    }
}
