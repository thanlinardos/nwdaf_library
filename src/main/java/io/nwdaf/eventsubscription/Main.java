package io.nwdaf.eventsubscription;

import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.nwdaf.eventsubscription.model.*;
import io.nwdaf.eventsubscription.model.NFType.NFTypeEnum;
import io.nwdaf.eventsubscription.utilities.Constants;
import io.nwdaf.eventsubscription.utilities.DummyDataGenerator;
import io.nwdaf.eventsubscription.utilities.Regex;

public class Main {
    public static void main(String args[]) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        List<Integer> eventConsumeCounters = new ArrayList<>(Constants.supportedEvents.size());
        System.out.println(eventConsumeCounters);

    }
}
