package io.nwdaf.eventsubscription.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Ellipsoid point with uncertainty circle.
 */
@Schema(description = "Ellipsoid point with uncertainty circle.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

@JsonTypeName("PointUncertaintyCircle")
public class PointUncertaintyCircle extends GADShape implements GeographicArea {
    @JsonProperty("point")
    private GeographicalCoordinates point = null;

    @JsonProperty("uncertainty")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double uncertainty = null;

    @JsonProperty("type")
    private String type = null;

    public PointUncertaintyCircle point(GeographicalCoordinates point) {
        this.point = point;
        return this;
    }

    public PointUncertaintyCircle PointUncertaintyCircle(Double longitude, Double latitude, Double uncertainty) {
        this.point = new GeographicalCoordinates();
        this.point.setLon(longitude);
        this.point.setLon(latitude);
        this.uncertainty = uncertainty;
        return this;
    }

    /**
     * Get point
     *
     * @return point
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public GeographicalCoordinates getPoint() {
        return point;
    }

    public void setPoint(GeographicalCoordinates point) {
        this.point = point;
    }

    public PointUncertaintyCircle uncertainty(Double uncertainty) {
        this.uncertainty = uncertainty;
        return this;
    }

    /**
     * Indicates value of uncertainty.
     * minimum: 0
     *
     * @return uncertainty
     **/
    @Schema(required = true, description = "Indicates value of uncertainty.")

    public Double getUncertainty() {
        return uncertainty;
    }

    public void setUncertainty(Double uncertainty) {
        this.uncertainty = uncertainty;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PointUncertaintyCircle pointUncertaintyCircle = (PointUncertaintyCircle) o;
        return Objects.equals(this.point, pointUncertaintyCircle.point) &&
                Objects.equals(this.uncertainty, pointUncertaintyCircle.uncertainty) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, uncertainty, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PointUncertaintyCircle {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    point: ").append(toIndentedString(point)).append("\n");
        sb.append("    uncertainty: ").append(toIndentedString(uncertainty)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    @Override
    public String getType() {
        return getClass().getSimpleName();
    }

    public void setType(String type) {
        this.type = getClass().getSimpleName();
    }

    public PointUncertaintyCircle type(String type) {
        this.type = getClass().getSimpleName();
        return this;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        if (point != null) {
            map.put("point", point.toMap());
        }
        map.put("uncertainty", uncertainty);
        if (getShape() != null) {
            map.put("shape", getShape().toMap());
        }
        if (getType() != null) {
            map.put("type", getType());
        }
        return map;
    }

    public static PointUncertaintyCircle fromMap(Map<String, Object> map) {
        PointUncertaintyCircle obj = new PointUncertaintyCircle();
        obj.setPoint(GeographicalCoordinates.fromMap((Map<String, Object>) map.get("point")));
        obj.setUncertainty((Double) map.get("uncertainty"));
        obj.setShape(SupportedGADShapes.fromMap((Map<String, Object>) map.get("shape")));
        obj.setType((String) map.get("type"));
        return obj;
    }
}
