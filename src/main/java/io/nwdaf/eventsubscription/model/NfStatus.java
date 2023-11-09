package io.nwdaf.eventsubscription.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains the percentage of time spent on various NF states.
 */
@Schema(description = "Contains the percentage of time spent on various NF states.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class NfStatus implements AnyOfNfStatus {
	@JsonProperty("statusRegistered")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer statusRegistered = null;

	@JsonProperty("statusUnregistered")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer statusUnregistered = null;

	@JsonProperty("statusUndiscoverable")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer statusUndiscoverable = null;

	public NfStatus statusRegistered(Integer statusRegistered) {
		this.statusRegistered = statusRegistered;
		return this;
	}

	/**
	 * Unsigned integer indicating Sampling Ratio (see clauses 4.15.1 of 3GPP TS
	 * 23.502), expressed in percent.
	 * minimum: 1
	 * maximum: 100
	 * 
	 * @return statusRegistered
	 **/
	@Schema(description = "Unsigned integer indicating Sampling Ratio (see clauses 4.15.1 of 3GPP TS 23.502), expressed in percent.  ")

	@Min(1)
	@Max(100)
	public Integer getStatusRegistered() {
		return statusRegistered;
	}

	public void setStatusRegistered(Integer statusRegistered) {
		this.statusRegistered = statusRegistered;
	}

	public NfStatus statusUnregistered(Integer statusUnregistered) {
		this.statusUnregistered = statusUnregistered;
		return this;
	}

	/**
	 * Unsigned integer indicating Sampling Ratio (see clauses 4.15.1 of 3GPP TS
	 * 23.502), expressed in percent.
	 * minimum: 1
	 * maximum: 100
	 * 
	 * @return statusUnregistered
	 **/
	@Schema(description = "Unsigned integer indicating Sampling Ratio (see clauses 4.15.1 of 3GPP TS 23.502), expressed in percent.  ")

	@Min(1)
	@Max(100)
	public Integer getStatusUnregistered() {
		return statusUnregistered;
	}

	public void setStatusUnregistered(Integer statusUnregistered) {
		this.statusUnregistered = statusUnregistered;
	}

	public NfStatus statusUndiscoverable(Integer statusUndiscoverable) {
		this.statusUndiscoverable = statusUndiscoverable;
		return this;
	}

	/**
	 * Unsigned integer indicating Sampling Ratio (see clauses 4.15.1 of 3GPP TS
	 * 23.502), expressed in percent.
	 * minimum: 1
	 * maximum: 100
	 * 
	 * @return statusUndiscoverable
	 **/
	@Schema(description = "Unsigned integer indicating Sampling Ratio (see clauses 4.15.1 of 3GPP TS 23.502), expressed in percent.  ")

	@Min(1)
	@Max(100)
	public Integer getStatusUndiscoverable() {
		return statusUndiscoverable;
	}

	public void setStatusUndiscoverable(Integer statusUndiscoverable) {
		this.statusUndiscoverable = statusUndiscoverable;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NfStatus nfStatus = (NfStatus) o;
		return Objects.equals(this.statusRegistered, nfStatus.statusRegistered) &&
				Objects.equals(this.statusUnregistered, nfStatus.statusUnregistered) &&
				Objects.equals(this.statusUndiscoverable, nfStatus.statusUndiscoverable);
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusRegistered, statusUnregistered, statusUndiscoverable);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NfStatus {\n");

		sb.append("    statusRegistered: ").append(toIndentedString(statusRegistered)).append("\n");
		sb.append("    statusUnregistered: ").append(toIndentedString(statusUnregistered)).append("\n");
		sb.append("    statusUndiscoverable: ").append(toIndentedString(statusUndiscoverable)).append("\n");
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
		map.put("statusRegistered", this.statusRegistered);
		map.put("statusUnregistered", this.statusUnregistered);
		map.put("statusUndiscoverable", this.statusUndiscoverable);
		return map;
	}

	public static NfStatus fromMap(Map<String, Object> map) {
		if(map==null) {
			return null;
		}
		NfStatus result = new NfStatus();
    	result.setStatusRegistered((Integer) map.get("statusRegistered"));
    	result.setStatusUndiscoverable((Integer) map.get("statusUndiscoverable"));
		result.setStatusUnregistered((Integer) map.get("statusUnregistered"));
		return result;
	}
}
