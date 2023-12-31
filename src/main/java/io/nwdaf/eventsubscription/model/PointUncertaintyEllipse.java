package io.nwdaf.eventsubscription.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Ellipsoid point with uncertainty ellipse.
 */
@Schema(description = "Ellipsoid point with uncertainty ellipse.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

@JsonTypeName("PointUncertaintyEllipse")
public class PointUncertaintyEllipse extends GADShape implements GeographicArea {
	@JsonProperty("point")
	private GeographicalCoordinates point = null;

	@JsonProperty("uncertaintyEllipse")
	private UncertaintyEllipse uncertaintyEllipse = null;

	@JsonProperty("confidence")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer confidence = null;

	public PointUncertaintyEllipse point(GeographicalCoordinates point) {
		this.point = point;
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

	public PointUncertaintyEllipse uncertaintyEllipse(UncertaintyEllipse uncertaintyEllipse) {
		this.uncertaintyEllipse = uncertaintyEllipse;
		return this;
	}

	/**
	 * Get uncertaintyEllipse
	 * 
	 * @return uncertaintyEllipse
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public UncertaintyEllipse getUncertaintyEllipse() {
		return uncertaintyEllipse;
	}

	public void setUncertaintyEllipse(UncertaintyEllipse uncertaintyEllipse) {
		this.uncertaintyEllipse = uncertaintyEllipse;
	}

	public PointUncertaintyEllipse confidence(Integer confidence) {
		this.confidence = confidence;
		return this;
	}

	/**
	 * Indicates value of confidence.
	 * minimum: 0
	 * maximum: 100
	 * 
	 * @return confidence
	 **/
	@Schema(required = true, description = "Indicates value of confidence.")
	@NotNull

	@Min(0)
	@Max(100)
	public Integer getConfidence() {
		return confidence;
	}

	public void setConfidence(Integer confidence) {
		this.confidence = confidence;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PointUncertaintyEllipse pointUncertaintyEllipse = (PointUncertaintyEllipse) o;
		return Objects.equals(this.point, pointUncertaintyEllipse.point) &&
				Objects.equals(this.uncertaintyEllipse, pointUncertaintyEllipse.uncertaintyEllipse) &&
				Objects.equals(this.confidence, pointUncertaintyEllipse.confidence) &&
				super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(point, uncertaintyEllipse, confidence, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PointUncertaintyEllipse {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    point: ").append(toIndentedString(point)).append("\n");
		sb.append("    uncertaintyEllipse: ").append(toIndentedString(uncertaintyEllipse)).append("\n");
		sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
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
}
