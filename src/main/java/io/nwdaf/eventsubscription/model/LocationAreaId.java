package io.nwdaf.eventsubscription.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains a Location area identification as defined in 3GPP TS 23.003, clause 4.1.
 */
@Schema(description = "Contains a Location area identification as defined in 3GPP TS 23.003, clause 4.1.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")


public class LocationAreaId   {
  @JsonProperty("plmnId")
  private PlmnId plmnId = null;

  @JsonProperty("lac")
  @JsonInclude(JsonInclude.Include.NON_NULL)
private String lac
 = null;

  public LocationAreaId plmnId(PlmnId plmnId) {
    this.plmnId = plmnId;
    return this;
  }

  /**
   * Get plmnId
   * @return plmnId
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public PlmnId getPlmnId() {
    return plmnId;
  }

  public void setPlmnId(PlmnId plmnId) {
    this.plmnId = plmnId;
  }

  public LocationAreaId lac(String lac) {
    this.lac = lac;
    return this;
  }

  /**
   * Location Area Code.
   * @return lac
   **/
  @Schema(required = true, description = "Location Area Code.")
      @NotNull

  @Pattern(regexp="^[A-Fa-f0-9]{4}$")   public String getLac() {
    return lac;
  }

  public void setLac(String lac) {
    this.lac = lac;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationAreaId locationAreaId = (LocationAreaId) o;
    return Objects.equals(this.plmnId, locationAreaId.plmnId) &&
        Objects.equals(this.lac, locationAreaId.lac);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, lac);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationAreaId {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    lac: ").append(toIndentedString(lac)).append("\n");
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
