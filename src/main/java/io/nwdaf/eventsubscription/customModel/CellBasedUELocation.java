package io.nwdaf.eventsubscription.customModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CellBasedUELocation {

    private String supi;

    private CellLocation cellLocation;
}
