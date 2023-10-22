package io.nwdaf.eventsubscription;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.nwdaf.eventsubscription.customModel.DiscoverMessage;
import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;

public class Main {
    public static void main(String args[]) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        DiscoverMessage msg = DiscoverMessage.builder().availableOffset(12).requestedEvent(NwdafEventEnum.NF_LOAD).availableOffset(1).expectedWaitTime(12).hasData(true).requestedOffset(12).build();
        String msg_str = msg.toString();
        DiscoverMessage originalMsg = objectMapper.reader().readValue(msg_str,DiscoverMessage.class);
        System.out.println(originalMsg.toString());
    }
}
