package io.nwdaf.eventsubscription.customModel;

import io.nwdaf.eventsubscription.model.EllipsoidArc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CellLocation {

    private String cellId;
    private CellLocationType type;
    private EllipsoidArc ellipsoidArc;
}
