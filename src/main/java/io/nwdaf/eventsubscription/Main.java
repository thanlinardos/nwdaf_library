package io.nwdaf.eventsubscription;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.nwdaf.eventsubscription.model.NfLoadLevelInformation;
import io.nwdaf.eventsubscription.model.Snssai;

public class Main {
    public static void main(String args[]) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        NfLoadLevelInformation nfLoadLevelInformation = new NfLoadLevelInformation()
                .nfInstanceId(UUID.randomUUID())
                .nfSetId("setxyz")
                .confidence(100)
                .nfCpuUsage(23)
                .snssai(new Snssai().sd("sd").sst(12));
        System.out.println();
        System.out.println(nfLoadLevelInformation.toMap());
        System.out.println();
        System.out.println(objectMapper.convertValue(nfLoadLevelInformation,new TypeReference<Map<String, Object>>() {}));
        System.out.println();System.out.println();
        System.out.println(objectMapper.readValue((new JSONObject(nfLoadLevelInformation.toMap())).toString(),NfLoadLevelInformation.class));
    }
}
