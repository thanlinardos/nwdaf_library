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

import io.nwdaf.eventsubscription.utilities.CheckUtil;
import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains the tracking area identity as described in 3GPP 23.003
 */
@Schema(description = "Contains the tracking area identity as described in 3GPP 23.003")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")


public class Tai   {
  @JsonProperty("plmnId")
  private PlmnId plmnId = null;

  @JsonProperty("tac")
  @JsonInclude(JsonInclude.Include.NON_NULL)
private String tac
 = null;

  @JsonProperty("nid")
  @JsonInclude(JsonInclude.Include.NON_NULL)
private String nid
 = null;

  public Tai plmnId(PlmnId plmnId) {
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

  public Tai tac(String tac) {
    this.tac = ConvertUtil.convertEmptyStringToNull(tac);
    return this;
  }

  /**
   * 2 or 3-octet string identifying a tracking area code as specified in clause 9.3.3.10  of 3GPP TS 38.413, in hexadecimal representation. Each character in the string shall  take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4 bits. The most significant character representing the 4 most significant bits of the TAC shall  appear first in the string, and the character representing the 4 least significant bit  of the TAC shall appear last in the string.  
   * @return tac
   **/
  @Schema(required = true, description = "2 or 3-octet string identifying a tracking area code as specified in clause 9.3.3.10  of 3GPP TS 38.413, in hexadecimal representation. Each character in the string shall  take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4 bits. The most significant character representing the 4 most significant bits of the TAC shall  appear first in the string, and the character representing the 4 least significant bit  of the TAC shall appear last in the string.  ")
      @NotNull

  @Pattern(regexp="(^[A-Fa-f0-9]{4}$)|(^[A-Fa-f0-9]{6}$)")   public String getTac() {
    return tac;
  }

  public void setTac(String tac) {
    this.tac = ConvertUtil.convertEmptyStringToNull(tac);
  }

  public Tai nid(String nid) {
    this.nid = ConvertUtil.convertEmptyStringToNull(nid);
    return this;
  }

  /**
   * This represents the Network Identifier, which together with a PLMN ID is used to identify an SNPN (see 3GPP TS 23.003 and 3GPP TS 23.501 clause 5.30.2.1).  
   * @return nid
   **/
  @Schema(description = "This represents the Network Identifier, which together with a PLMN ID is used to identify an SNPN (see 3GPP TS 23.003 and 3GPP TS 23.501 clause 5.30.2.1).  ")
  
  @Pattern(regexp="^[A-Fa-f0-9]{11}$")   public String getNid() {
    return nid;
  }

  public void setNid(String nid) {
    this.nid = ConvertUtil.convertEmptyStringToNull(nid);
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tai tai = (Tai) o;
    return CheckUtil.safeCheckObjectsEquals(this.plmnId, tai.plmnId) &&
           CheckUtil.safeCheckObjectsEquals(this.tac, tai.tac) &&
           CheckUtil.safeCheckObjectsEquals(this.nid, tai.nid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, tac, nid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tai {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    tac: ").append(toIndentedString(tac)).append("\n");
    sb.append("    nid: ").append(toIndentedString(nid)).append("\n");
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
		map.put("tac", this.tac);
		map.put("nid", this.nid);
		return map;
	}

  public static Tai fromMap(Map<String, Object> map) {
    if(map==null) {
			return null;
		}
		Tai result = new Tai();
		result.setTac((String) map.get("tac"));
		result.setNid((String) map.get("nid"));
		result.setPlmnId(PlmnId.fromMap((Map<String, Object>) map.get("plmnId")));
		return result;
	}
}
