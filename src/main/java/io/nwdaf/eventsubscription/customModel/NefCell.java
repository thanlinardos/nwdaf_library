package io.nwdaf.eventsubscription.customModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NefCell {

    private String cell_id;

    private String name;

    private String description;

    private Float latitude;

    private Float longitude;

    private Float radius;

    @JsonProperty("gNB_id")
    private Integer gNB_id;
}
