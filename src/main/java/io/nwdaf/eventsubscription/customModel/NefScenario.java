package io.nwdaf.eventsubscription.customModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NefScenario {

    @JsonProperty("gNBs")
    List<NefgNB> gNBs;

    List<NefCell> cells;

    @JsonProperty("UEs")
    List<NefUe> UEs;

    List<NefPath> paths;

    List<UePathAssociation> ue_path_association;
}
