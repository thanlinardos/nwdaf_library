package io.nwdaf.eventsubscription;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.nwdaf.eventsubscription.customModel.DiscoverMessage;
import io.nwdaf.eventsubscription.customModel.WakeUpMessage;
import io.nwdaf.eventsubscription.model.*;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        DiscoverMessage discoverMessage = new DiscoverMessage();
        discoverMessage.setExpectedWaitTime(12);
        discoverMessage.setTimestamp(OffsetDateTime.now());
        discoverMessage.setHasData(true);
        discoverMessage.setAvailableOffset(100);
        discoverMessage.setRequestedOffset(100);
        discoverMessage.setRequestedEvent(NwdafEvent.NwdafEventEnum.NF_LOAD);
        String msg = discoverMessage.toString();
        System.out.println(DiscoverMessage.fromString(msg));

        WakeUpMessage wakeUpMessage = new WakeUpMessage();
        wakeUpMessage.setTimestamp(OffsetDateTime.now());
        wakeUpMessage.setRequestedEvent(NwdafEvent.NwdafEventEnum.NF_LOAD);
        wakeUpMessage.setRequestedOffset(100);
        String wakeUpString = wakeUpMessage.toString();
        System.out.println(WakeUpMessage.fromString(wakeUpString));
    }
}
