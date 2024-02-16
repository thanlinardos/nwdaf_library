package io.nwdaf.eventsubscription.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CollectiveBehaviourFilter {

    private CollectiveBehaviourFilterType type;

    private String value;

    private List<Boolean> listOfUeInd;
}
