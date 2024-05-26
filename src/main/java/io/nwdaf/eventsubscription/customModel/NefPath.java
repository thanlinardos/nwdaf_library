package io.nwdaf.eventsubscription.customModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NefPath {

    private Integer id;

    private String description;

    private NefPoint start_point;

    private NefPoint end_point;

    private String color;

    private List<NefPoint> points;
}
