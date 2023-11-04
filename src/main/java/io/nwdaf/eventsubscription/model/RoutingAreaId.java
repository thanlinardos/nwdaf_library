package io.nwdaf.eventsubscription.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains a Routing Area Identification as defined in 3GPP TS 23.003, clause 4.2.
 */
@Schema(description = "Contains a Routing Area Identification as defined in 3GPP TS 23.003, clause 4.2.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")


public class RoutingAreaId   {
  @JsonProperty("plmnId")
  private PlmnId plmnId = null;

  @JsonProperty("lac")
  @JsonInclude(JsonInclude.Include.NON_NULL)
private String lac
 = null;

  @JsonProperty("rac")
  @JsonInclude(JsonInclude.Include.NON_NULL)
private String rac
 = null;

  public RoutingAreaId plmnId(PlmnId plmnId) {
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

  public RoutingAreaId lac(String lac) {
    this.lac = lac;
    return this;
  }

  /**
   * Location Area Code
   * @return lac
   **/
  @Schema(required = true, description = "Location Area Code")
      @NotNull

  @Pattern(regexp="^[A-Fa-f0-9]{4}$")   public String getLac() {
    return lac;
  }

  public void setLac(String lac) {
    this.lac = lac;
  }

  public RoutingAreaId rac(String rac) {
    this.rac = rac;
    return this;
  }

  /**
   * Routing Area Code
   * @return rac
   **/
  @Schema(required = true, description = "Routing Area Code")
      @NotNull

  @Pattern(regexp="^[A-Fa-f0-9]{2}$")   public String getRac() {
    return rac;
  }

  public void setRac(String rac) {
    this.rac = rac;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoutingAreaId routingAreaId = (RoutingAreaId) o;
    return Objects.equals(this.plmnId, routingAreaId.plmnId) &&
        Objects.equals(this.lac, routingAreaId.lac) &&
        Objects.equals(this.rac, routingAreaId.rac);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, lac, rac);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoutingAreaId {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    lac: ").append(toIndentedString(lac)).append("\n");
    sb.append("    rac: ").append(toIndentedString(rac)).append("\n");
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

  public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		if (this.plmnId != null) {
			map.put("plmnId", this.plmnId.toMap());
		}
		map.put("lac", this.lac);
		map.put("rac", this.rac);
		return map;
	}

  public static RoutingAreaId fromMap(Map<String, Object> map) {
    if(map==null) {
			return null;
		}
		RoutingAreaId result = new RoutingAreaId();
		result.setLac((String) map.get("lac"));
		result.setRac((String) map.get("rac"));
		result.setPlmnId(PlmnId.fromMap((Map<String, Object>) map.get("plmnId")));
		return result;
	}
}
