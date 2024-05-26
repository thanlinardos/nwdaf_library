package io.nwdaf.eventsubscription.customModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NefgNB {

    @JsonProperty("gNB_id")
    private String gNB_id;

    private String name;

    private String description;

    private String location;
}
