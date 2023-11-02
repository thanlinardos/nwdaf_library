package io.nwdaf.eventsubscription.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Common base type for GAD shapes.
 */
@Schema(description = "Common base type for GAD shapes.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "shape", visible = true)
@JsonSubTypes({
		@JsonSubTypes.Type(value = Point.class, name = "Point"),
		@JsonSubTypes.Type(value = PointUncertaintyCircle.class, name = "PointUncertaintyCircle"),
		@JsonSubTypes.Type(value = PointUncertaintyEllipse.class, name = "PointUncertaintyEllipse"),
		@JsonSubTypes.Type(value = Polygon.class, name = "Polygon"),
		@JsonSubTypes.Type(value = PointAltitude.class, name = "PointAltitude"),
		@JsonSubTypes.Type(value = PointAltitudeUncertainty.class, name = "PointAltitudeUncertainty"),
		@JsonSubTypes.Type(value = EllipsoidArc.class, name = "EllipsoidArc"),
		@JsonSubTypes.Type(value = Local2dPointUncertaintyEllipse.class, name = "Local2dPointUncertaintyEllipse"),
		@JsonSubTypes.Type(value = Local3dPointUncertaintyEllipsoid.class, name = "Local3dPointUncertaintyEllipsoid"),
})

public class GADShape {
	@JsonTypeId
	private SupportedGADShapes shape = null;

	public GADShape shape(SupportedGADShapes shape) {
		this.shape = shape;
		return this;
	}

	/**
	 * Get shape
	 * 
	 * @return shape
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public SupportedGADShapes getShape() {
		return shape;
	}

	public void setShape(SupportedGADShapes shape) {
		this.shape = shape;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GADShape gaDShape = (GADShape) o;
		return Objects.equals(this.shape, gaDShape.shape);
	}

	@Override
	public int hashCode() {
		return Objects.hash(shape);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GADShape {\n");

		sb.append("    shape: ").append(toIndentedString(shape)).append("\n");
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
}
