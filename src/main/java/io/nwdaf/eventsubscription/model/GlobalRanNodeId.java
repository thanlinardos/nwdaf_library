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
 * One of the six attributes n3IwfId, gNbIdm, ngeNbId, wagfId, tngfId, eNbId
 * shall be present.
 */
@Schema(description = "One of the six attributes n3IwfId, gNbIdm, ngeNbId, wagfId, tngfId, eNbId shall be present. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class GlobalRanNodeId implements OneOfGlobalRanNodeId {
	@JsonProperty("plmnId")
	private PlmnId plmnId = null;

	@JsonProperty("n3IwfId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String n3IwfId = null;

	@JsonProperty("gNbId")
	private GNbId gNbId = null;

	@JsonProperty("ngeNbId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ngeNbId = null;

	@JsonProperty("wagfId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String wagfId = null;

	@JsonProperty("tngfId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String tngfId = null;

	@JsonProperty("nid")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nid = null;

	@JsonProperty("eNbId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String eNbId = null;

	public GlobalRanNodeId plmnId(PlmnId plmnId) {
		this.plmnId = plmnId;
		return this;
	}

	/**
	 * Get plmnId
	 * 
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

	public GlobalRanNodeId n3IwfId(String n3IwfId) {
		this.n3IwfId = ConvertUtil.convertEmptyStringToNull(n3IwfId);
		return this;
	}

	/**
	 * This represents the identifier of the N3IWF ID as specified in clause
	 * 9.3.1.57 of 3GPP TS 38.413 in hexadecimal representation. Each character in
	 * the string shall take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to
	 * \"F\" and shall represent 4 bits. The most significant character representing
	 * the 4 most significant bits of the N3IWF ID shall appear first in the string,
	 * and the character representing the 4 least significant bit of the N3IWF ID
	 * shall appear last in the string.
	 * 
	 * @return n3IwfId
	 **/
	@Schema(description = "This represents the identifier of the N3IWF ID as specified in clause 9.3.1.57 of  3GPP TS 38.413 in hexadecimal representation. Each character in the string shall take a value  of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4 bits. The most significant  character representing the 4 most significant bits of the N3IWF ID shall appear first in the  string, and the character representing the 4 least significant bit of the N3IWF ID shall  appear last in the string.  ")

	@Pattern(regexp = "^[A-Fa-f0-9]+$")
	public String getN3IwfId() {
		return n3IwfId;
	}

	public void setN3IwfId(String n3IwfId) {
		this.n3IwfId = ConvertUtil.convertEmptyStringToNull(n3IwfId);
	}

	public GlobalRanNodeId gNbId(GNbId gNbId) {
		this.gNbId = gNbId;
		return this;
	}

	/**
	 * Get gNbId
	 * 
	 * @return gNbId
	 **/
	@Schema(description = "")

	@Valid
	public GNbId getGNbId() {
		return gNbId;
	}

	public void setGNbId(GNbId gNbId) {
		this.gNbId = gNbId;
	}

	public GlobalRanNodeId ngeNbId(String ngeNbId) {
		this.ngeNbId = ConvertUtil.convertEmptyStringToNull(ngeNbId);
		return this;
	}

	/**
	 * This represents the identifier of the ng-eNB ID as specified in clause
	 * 9.3.1.8 of 3GPP TS 38.413. The value of the ng-eNB ID shall be encoded in
	 * hexadecimal representation. Each character in the string shall take a value
	 * of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4
	 * bits. The padding 0 shall be added to make multiple nibbles, so the most
	 * significant character representing the padding 0 if required together with
	 * the 4 most significant bits of the ng-eNB ID shall appear first in the
	 * string, and the character representing the 4 least significant bit of the
	 * ng-eNB ID (to form a nibble) shall appear last in the string.
	 * 
	 * @return ngeNbId
	 **/
	@Schema(example = "SMacroNGeNB-34B89", description = "This represents the identifier of the ng-eNB ID as specified in clause 9.3.1.8 of  3GPP TS 38.413. The value of the ng-eNB ID shall be encoded in hexadecimal representation.  Each character in the string shall take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and  shall represent 4 bits. The padding 0 shall be added to make multiple nibbles, so the most  significant character representing the padding 0 if required together with the 4 most  significant bits of the ng-eNB ID shall appear first in the string, and the character  representing the 4 least significant bit of the ng-eNB ID (to form a nibble) shall appear last  in the string.  ")

	@Pattern(regexp = "^(MacroNGeNB-[A-Fa-f0-9]{5}|LMacroNGeNB-[A-Fa-f0-9]{6}|SMacroNGeNB-[A-Fa-f0-9]{5})$")
	public String getNgeNbId() {
		return ngeNbId;
	}

	public void setNgeNbId(String ngeNbId) {
		this.ngeNbId = ConvertUtil.convertEmptyStringToNull(ngeNbId);
	}

	public GlobalRanNodeId wagfId(String wagfId) {
		this.wagfId = ConvertUtil.convertEmptyStringToNull(wagfId);
		return this;
	}

	/**
	 * This represents the identifier of the W-AGF ID as specified in clause
	 * 9.3.1.162 of 3GPP TS 38.413 in hexadecimal representation. Each character in
	 * the string shall take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to
	 * \"F\" and shall represent 4 bits. The most significant character representing
	 * the 4 most significant bits of the W-AGF ID shall appear first in the string,
	 * and the character representing the 4 least significant bit of the W-AGF ID
	 * shall appear last in the string.
	 * 
	 * @return wagfId
	 **/
	@Schema(description = "This represents the identifier of the W-AGF ID as specified in clause 9.3.1.162 of  3GPP TS 38.413 in hexadecimal representation. Each character in the string shall take a value  of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4 bits. The most significant  character representing the 4 most significant bits of the W-AGF ID shall appear first in the  string, and the character representing the 4 least significant bit of the W-AGF ID shall  appear last in the string.  ")

	@Pattern(regexp = "^[A-Fa-f0-9]+$")
	public String getWagfId() {
		return wagfId;
	}

	public void setWagfId(String wagfId) {
		this.wagfId = ConvertUtil.convertEmptyStringToNull(wagfId);
	}

	public GlobalRanNodeId tngfId(String tngfId) {
		this.tngfId = ConvertUtil.convertEmptyStringToNull(tngfId);
		return this;
	}

	/**
	 * This represents the identifier of the TNGF ID as specified in clause
	 * 9.3.1.161 of 3GPP TS 38.413 in hexadecimal representation. Each character in
	 * the string shall take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to
	 * \"F\" and shall represent 4 bits. The most significant character representing
	 * the 4 most significant bits of the TNGF ID shall appear first in the string,
	 * and the character representing the 4 least significant bit of the TNGF ID
	 * shall appear last in the string.
	 * 
	 * @return tngfId
	 **/
	@Schema(description = "This represents the identifier of the TNGF ID as specified in clause 9.3.1.161 of  3GPP TS 38.413  in hexadecimal representation. Each character in the string shall take a value of \"0\" to \"9\", \"a\"  to \"f\" or \"A\" to \"F\" and shall represent 4 bits. The most significant character representing the  4 most significant bits of the TNGF ID shall appear first in the string, and the character  representing the 4 least significant bit of the TNGF ID shall appear last in the string.  ")

	@Pattern(regexp = "^[A-Fa-f0-9]+$")
	public String getTngfId() {
		return tngfId;
	}

	public void setTngfId(String tngfId) {
		this.tngfId = ConvertUtil.convertEmptyStringToNull(tngfId);
	}

	public GlobalRanNodeId nid(String nid) {
		this.nid = ConvertUtil.convertEmptyStringToNull(nid);
		return this;
	}

	/**
	 * This represents the Network Identifier, which together with a PLMN ID is used
	 * to identify an SNPN (see 3GPP TS 23.003 and 3GPP TS 23.501 clause 5.30.2.1).
	 * 
	 * @return nid
	 **/
	@Schema(description = "This represents the Network Identifier, which together with a PLMN ID is used to identify an SNPN (see 3GPP TS 23.003 and 3GPP TS 23.501 clause 5.30.2.1).  ")

	@Pattern(regexp = "^[A-Fa-f0-9]{11}$")
	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = ConvertUtil.convertEmptyStringToNull(nid);
	}

	public GlobalRanNodeId eNbId(String eNbId) {
		this.eNbId = ConvertUtil.convertEmptyStringToNull(eNbId);
		return this;
	}

	/**
	 * This represents the identifier of the eNB ID as specified in clause 9.2.1.37
	 * of 3GPP TS 36.413. The string shall be formatted with the following pattern
	 * '^('MacroeNB-[A-Fa-f0-9]{5}|LMacroeNB-[A-Fa-f0-9]{6}|SMacroeNB-[A-Fa-f0-9]{5}
	 * |HomeeNB-[A-Fa-f0-9]{7})$'. The value of the eNB ID shall be encoded in
	 * hexadecimal representation. Each character in the string shall take a value
	 * of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4
	 * bits. The padding 0 shall be added to make multiple nibbles, so the most
	 * significant character representing the padding 0 if required together with
	 * the 4 most significant bits of the eNB ID shall appear first in the string,
	 * and the character representing the 4 least significant bit of the eNB ID (to
	 * form a nibble) shall appear last in the string.
	 * 
	 * @return eNbId
	 **/
	@Schema(description = "This represents the identifier of the eNB ID as specified in clause 9.2.1.37 of  3GPP TS 36.413. The string shall be formatted with the following pattern  '^('MacroeNB-[A-Fa-f0-9]{5}|LMacroeNB-[A-Fa-f0-9]{6}|SMacroeNB-[A-Fa-f0-9]{5} |HomeeNB-[A-Fa-f0-9]{7})$'. The value of the eNB ID shall be encoded in hexadecimal representation. Each character in the  string shall take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4 bits.  The padding 0 shall be added to make multiple nibbles, so the most significant character  representing the padding 0 if required together with the 4 most significant bits of the eNB ID  shall appear first in the string, and the character representing the 4 least significant bit  of the eNB ID (to form a nibble) shall appear last in the string. ")

	@Pattern(regexp = "^(MacroeNB-[A-Fa-f0-9]{5}|LMacroeNB-[A-Fa-f0-9]{6}|SMacroeNB-[A-Fa-f0-9]{5}|HomeeNB-[A-Fa-f0-9]{7})$")
	public String getENbId() {
		return eNbId;
	}

	public void setENbId(String eNbId) {
		this.eNbId = ConvertUtil.convertEmptyStringToNull(eNbId);
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GlobalRanNodeId globalRanNodeId = (GlobalRanNodeId) o;
		return CheckUtil.safeCheckObjectsEquals(this.plmnId, globalRanNodeId.plmnId) &&
				CheckUtil.safeCheckObjectsEquals(this.n3IwfId, globalRanNodeId.n3IwfId) &&
				CheckUtil.safeCheckObjectsEquals(this.gNbId, globalRanNodeId.gNbId) &&
				CheckUtil.safeCheckObjectsEquals(this.ngeNbId, globalRanNodeId.ngeNbId) &&
				CheckUtil.safeCheckObjectsEquals(this.wagfId, globalRanNodeId.wagfId) &&
				CheckUtil.safeCheckObjectsEquals(this.tngfId, globalRanNodeId.tngfId) &&
				CheckUtil.safeCheckObjectsEquals(this.nid, globalRanNodeId.nid) &&
				CheckUtil.safeCheckObjectsEquals(this.eNbId, globalRanNodeId.eNbId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(plmnId, n3IwfId, gNbId, ngeNbId, wagfId, tngfId, nid, eNbId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GlobalRanNodeId {\n");

		sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
		sb.append("    n3IwfId: ").append(toIndentedString(n3IwfId)).append("\n");
		sb.append("    gNbId: ").append(toIndentedString(gNbId)).append("\n");
		sb.append("    ngeNbId: ").append(toIndentedString(ngeNbId)).append("\n");
		sb.append("    wagfId: ").append(toIndentedString(wagfId)).append("\n");
		sb.append("    tngfId: ").append(toIndentedString(tngfId)).append("\n");
		sb.append("    nid: ").append(toIndentedString(nid)).append("\n");
		sb.append("    eNbId: ").append(toIndentedString(eNbId)).append("\n");
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
		if (this.gNbId != null) {
			map.put("gNbId", this.gNbId.toMap());
		}
		map.put("eNbId", this.eNbId);
		map.put("n3IwfId", this.n3IwfId);
		map.put("ngeNbId", this.ngeNbId);
		map.put("tngfId", this.tngfId);
		map.put("wagfId", this.wagfId);
		map.put("nid", this.nid);
		return map;
	}

	public static GlobalRanNodeId fromMap(Map<String, Object> map) {
		if(map==null) {
			return null;
		}
		GlobalRanNodeId result = new GlobalRanNodeId();
		result.setENbId((String) map.get("eNbId"));
		result.setGNbId(GNbId.fromMap((Map<String, Object>) map.get("gNbId")));
		result.setN3IwfId((String) map.get("n3IwfId"));
		result.setNgeNbId((String) map.get("ngeNbId"));
		result.setWagfId((String) map.get("wagfId"));
		result.setTngfId((String) map.get("tngfId"));
		result.setNid((String) map.get("nid"));
		result.setPlmnId(PlmnId.fromMap((Map<String, Object>) map.get("plmnId")));
		return result;
	}
}
