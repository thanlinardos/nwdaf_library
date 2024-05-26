package io.nwdaf.eventsubscription.customModel;

import io.nwdaf.eventsubscription.utilities.ParserUtil;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignSubscriptionsMessage {
    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private UUID notifierId;
    @Builder.Default
    private Boolean leader = false;
    private List<Long> subscriptionIds;

    public String toString() {
        return "{\"timestamp\":\"" + timestamp
                + "\",\"notifierId\":\"" + notifierId
                + "\",\"leader\":\"" + leader + "\""
                + "\",\"subscriptionIds\":" + subscriptionIds.stream().map(id -> "\"" + id + "\"").toList() + "}";
    }

    public static AssignSubscriptionsMessage fromString(String input) {
        AssignSubscriptionsMessage result = new AssignSubscriptionsMessage();
        String[] attributes = input.substring(1, input.length() - 1).split("\",");

        result.setTimestamp(OffsetDateTime.parse(attributes[0].split(":\"")[1]));
        result.setNotifierId(UUID.fromString(attributes[1].split(":\"")[1]));
        result.setLeader(Boolean.parseBoolean(attributes[2].split(":\"")[1].replace("\"", "")));
        List<String> ids = Arrays.stream(input.split("subscriptionIds\":")[1]
                        .replace("[", "")
                        .replace("]", "")
                        .replace("}", "")
                        .split(","))
                .map(str -> str
                        .replace("\"", "")
                        .replace("\"", "")
                        .replace(" ", ""))
                .toList();
        result.setSubscriptionIds(ids.stream().map(ParserUtil::safeParseLong).toList());

        return result;
    }
}
