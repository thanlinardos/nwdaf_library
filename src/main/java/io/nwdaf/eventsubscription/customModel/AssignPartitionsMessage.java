package io.nwdaf.eventsubscription.customModel;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignPartitionsMessage {
    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private UUID consumerId;
    @Builder.Default
    private Boolean leader = false;
    private Integer partitionIndex;

    public String toString() {
        return "{\"timestamp\":\"" + timestamp
                + "\",\"consumerId\":\"" + consumerId
                + "\",\"leader\":\"" + leader + "\""
                + ",\"partitionIndex\":\"" + partitionIndex + "\"}";
    }

    public static AssignPartitionsMessage fromString(String input) {
        AssignPartitionsMessage result = new AssignPartitionsMessage();
        String[] attributes = input.substring(1, input.length() - 1).split("\",");

        result.setTimestamp(OffsetDateTime.parse(attributes[0].split(":\"")[1]));
        result.setConsumerId(UUID.fromString(attributes[1].split(":\"")[1]));
        result.setLeader(Boolean.parseBoolean(attributes[2].split(":\"")[1].replace("\"", "")));
        result.setPartitionIndex(Integer.parseInt(attributes[3].split(":\"")[1].replace("\"", "")));

        return result;
    }
}