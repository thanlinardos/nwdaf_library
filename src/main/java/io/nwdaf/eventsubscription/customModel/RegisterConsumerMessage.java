package io.nwdaf.eventsubscription.customModel;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterConsumerMessage {
    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private UUID consumerId;
    @Builder.Default
    private Boolean leader = false;

    public String toString() {
        return "{\"timestamp\":\"" + timestamp
                + "\",\"consumerId\":\"" + consumerId
                + "\",\"leader\":\"" + leader + "\"}";
    }

    public static RegisterConsumerMessage fromString(String input) {
        RegisterConsumerMessage result = new RegisterConsumerMessage();
        String[] attributes = input.substring(1, input.length() - 1).split("\",");

        result.setTimestamp(OffsetDateTime.parse(attributes[0].split(":\"")[1]));
        result.setConsumerId(UUID.fromString(attributes[1].split(":\"")[1]));
        result.setLeader(Boolean.parseBoolean(attributes[2].split(":\"")[1].replace("\"", "")));

        return result;
    }
}
