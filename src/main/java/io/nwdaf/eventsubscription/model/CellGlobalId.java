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
 * Contains a Cell Global Identification as defined in 3GPP TS 23.003, clause
 * 4.3.1.
 */
@Schema(description = "Contains a Cell Global Identification as defined in 3GPP TS 23.003, clause 4.3.1.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class CellGlobalId {
	@JsonProperty("plmnId")
	private PlmnId plmnId = null;

	@JsonProperty("lac")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lac = null;

	@JsonProperty("cellId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String cellId = null;

	public CellGlobalId plmnId(PlmnId plmnId) {
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

	public CellGlobalId lac(String lac) {
		this.lac = lac;
		return this;
	}

	/**
	 * Get lac
	 * 
	 * @return lac
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Pattern(regexp = "^[A-Fa-f0-9]{4}$")
	public String getLac() {
		return lac;
	}

	public void setLac(String lac) {
		this.lac = lac;
	}

	public CellGlobalId cellId(String cellId) {
		this.cellId = cellId;
		return this;
	}

	/**
	 * Get cellId
	 * 
	 * @return cellId
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Pattern(regexp = "^[A-Fa-f0-9]{4}$")
	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CellGlobalId cellGlobalId = (CellGlobalId) o;
		return Objects.equals(this.plmnId, cellGlobalId.plmnId) &&
				Objects.equals(this.lac, cellGlobalId.lac) &&
				Objects.equals(this.cellId, cellGlobalId.cellId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(plmnId, lac, cellId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CellGlobalId {\n");

		sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
		sb.append("    lac: ").append(toIndentedString(lac)).append("\n");
		sb.append("    cellId: ").append(toIndentedString(cellId)).append("\n");
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
		map.put("cellId", this.cellId);
		map.put("lac", this.lac);
		return map;
	}


	public static CellGlobalId fromMap(Map<String, Object> map) {
		if(map==null) {
			return null;
		}
		CellGlobalId result = new CellGlobalId();
		result.setCellId((String) map.get("cellId"));
		result.setLac((String) map.get("lac"));
		result.setPlmnId(PlmnId.fromMap((Map<String, Object>) map.get("plmnId")));
		return result;
	}
}
