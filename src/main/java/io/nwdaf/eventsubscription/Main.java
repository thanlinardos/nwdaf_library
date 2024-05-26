package io.nwdaf.eventsubscription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static io.nwdaf.eventsubscription.utilities.ParserUtil.parseQuerryFilterContains;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<String> validVisitedAreas = List.of("788b8d88-226d-4254-9096-d3f1977a1bab", "b8b8d88-226d-4254-9096-d3f1977a1bab");
        String params = parseQuerryFilterContains(validVisitedAreas, "areaOfInterestIds");
        System.out.println(params);
    }
}
