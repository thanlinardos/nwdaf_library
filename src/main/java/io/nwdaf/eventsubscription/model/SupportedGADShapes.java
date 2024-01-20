package io.nwdaf.eventsubscription.model;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.nwdaf.eventsubscription.utilities.ParserUtil;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
/**
* Indicates supported GAD shapes.
*/
@Schema(description = "Indicates supported Geographical Area Description (GAD) Shapes.")
@Validated
public class SupportedGADShapes {
  public enum SupportedGADShapesEnum {
    Point("Point"),
    PointUncertaintyCircle("PointUncertaintyCircle"),
    PointUncertaintyEllipse("PointUncertaintyEllipse"),
    Polygon("Polygon"),
    PointAltitude("PointAltitude"),
    PointAltitudeUncertainty("PointAltitudeUncertainty"),
    EllipsoidArc("EllipsoidArc"),
    Local2dPointUncertaintyEllipse("Local2dPointUncertaintyEllipse"),
    Local3dPointUncertaintyEllipse("Local3dPointUncertaintyEllipse");
    private final String value;

    SupportedGADShapesEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SupportedGADShapesEnum fromValue(String text) {
      for (SupportedGADShapesEnum b : SupportedGADShapesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("supportedGADShapes")
  private SupportedGADShapesEnum supportedGADShapes = null;

  public SupportedGADShapes supportedGADShapes(SupportedGADShapesEnum supportedGADShapes){
    this.supportedGADShapes = supportedGADShapes;
    return this;
  }

  /** Get supportedGADShapes
  * @return supportedGADShapes
  **/
  @Schema(description="supportedGADShapes")

  public SupportedGADShapesEnum getSupportedGADShapes(){
    return supportedGADShapes;
  }

  public void setSupportedGADShapes(SupportedGADShapesEnum supportedGADShapes){
    this.supportedGADShapes = supportedGADShapes;
  }

   @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupportedGADShapes supportedGADShapesObject = (SupportedGADShapes) o;
    return Objects.equals(this.supportedGADShapes, supportedGADShapesObject.supportedGADShapes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportedGADShapes);
  }

  @Override
  public String toString() {
    return supportedGADShapes.toString();
  }

  public Map<String, Object> toMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("supportedGADShapes", ParserUtil.safeParseString(this.supportedGADShapes));
    return map;
  }

  public static SupportedGADShapes fromMap(Map<String, Object> map) {
    if(map==null) {
      return null;
    }
    SupportedGADShapes supportedGADShape = new SupportedGADShapes();
    supportedGADShape.setSupportedGADShapes(SupportedGADShapesEnum.fromValue((String)map.get("supportedGADShapes")));
    return supportedGADShape;
  }
}
