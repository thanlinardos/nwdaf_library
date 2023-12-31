package io.nwdaf.eventsubscription.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the QoS Sustainability information.
 */
@Schema(description = "Represents the QoS Sustainability information.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class QosSustainabilityInfo implements OneOfQosSustainabilityInfo {
	@JsonProperty("areaInfo")
	private NetworkAreaInfo areaInfo = null;

	@JsonProperty("startTs")
	private OffsetDateTime startTs = null;

	@JsonProperty("endTs")
	private OffsetDateTime endTs = null;

	@JsonProperty("qosFlowRetThd")
	private RetainabilityThreshold qosFlowRetThd = null;

	@JsonProperty("ranUeThrouThd")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ranUeThrouThd = null;

	@JsonProperty("snssai")
	private Snssai snssai = null;

	@JsonProperty("confidence")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer confidence = null;

	public QosSustainabilityInfo areaInfo(NetworkAreaInfo areaInfo) {
		this.areaInfo = areaInfo;
		return this;
	}

	/**
	 * Get areaInfo
	 * 
	 * @return areaInfo
	 **/
	@Schema(description = "")

	@Valid
	public NetworkAreaInfo getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(NetworkAreaInfo areaInfo) {
		this.areaInfo = areaInfo;
	}

	public QosSustainabilityInfo startTs(OffsetDateTime startTs) {
		this.startTs = startTs;
		return this;
	}

	/**
	 * string with format 'date-time' as defined in OpenAPI.
	 * 
	 * @return startTs
	 **/
	@Schema(description = "string with format 'date-time' as defined in OpenAPI.")

	@Valid
	public OffsetDateTime getStartTs() {
		return startTs;
	}

	public void setStartTs(OffsetDateTime startTs) {
		this.startTs = startTs;
	}

	public QosSustainabilityInfo endTs(OffsetDateTime endTs) {
		this.endTs = endTs;
		return this;
	}

	/**
	 * string with format 'date-time' as defined in OpenAPI.
	 * 
	 * @return endTs
	 **/
	@Schema(description = "string with format 'date-time' as defined in OpenAPI.")

	@Valid
	public OffsetDateTime getEndTs() {
		return endTs;
	}

	public void setEndTs(OffsetDateTime endTs) {
		this.endTs = endTs;
	}

	public QosSustainabilityInfo qosFlowRetThd(RetainabilityThreshold qosFlowRetThd) {
		this.qosFlowRetThd = qosFlowRetThd;
		return this;
	}

	/**
	 * Get qosFlowRetThd
	 * 
	 * @return qosFlowRetThd
	 **/
	@Schema(description = "")

	@Valid
	public RetainabilityThreshold getQosFlowRetThd() {
		return qosFlowRetThd;
	}

	public void setQosFlowRetThd(RetainabilityThreshold qosFlowRetThd) {
		this.qosFlowRetThd = qosFlowRetThd;
	}

	public QosSustainabilityInfo ranUeThrouThd(String ranUeThrouThd) {
		this.ranUeThrouThd = ranUeThrouThd;
		return this;
	}

	/**
	 * String representing a bit rate; the prefixes follow the standard symbols from
	 * The International System of Units, and represent x1000 multipliers, with the
	 * exception that prefix \"K\" is used to represent the standard symbol \"k\".
	 * 
	 * @return ranUeThrouThd
	 **/
	@Schema(description = "String representing a bit rate; the prefixes follow the standard symbols from The International System of Units, and represent x1000 multipliers, with the exception that prefix \"K\" is used to represent the standard symbol \"k\". ")

	@Pattern(regexp = "^\\d+(\\.\\d+)? (bps|Kbps|Mbps|Gbps|Tbps)$")
	public String getRanUeThrouThd() {
		return ranUeThrouThd;
	}

	public void setRanUeThrouThd(String ranUeThrouThd) {
		this.ranUeThrouThd = ranUeThrouThd;
	}

	public QosSustainabilityInfo snssai(Snssai snssai) {
		this.snssai = snssai;
		return this;
	}

	/**
	 * Get snssai
	 * 
	 * @return snssai
	 **/
	@Schema(description = "")

	@Valid
	public Snssai getSnssai() {
		return snssai;
	}

	public void setSnssai(Snssai snssai) {
		this.snssai = snssai;
	}

	public QosSustainabilityInfo confidence(Integer confidence) {
		this.confidence = confidence;
		return this;
	}

	/**
	 * Unsigned Integer, i.e. only value 0 and integers above 0 are permissible.
	 * minimum: 0
	 * 
	 * @return confidence
	 **/
	@Schema(description = "Unsigned Integer, i.e. only value 0 and integers above 0 are permissible.")

	@Min(0)
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
		QosSustainabilityInfo qosSustainabilityInfo = (QosSustainabilityInfo) o;
		return Objects.equals(this.areaInfo, qosSustainabilityInfo.areaInfo) &&
				Objects.equals(this.startTs, qosSustainabilityInfo.startTs) &&
				Objects.equals(this.endTs, qosSustainabilityInfo.endTs) &&
				Objects.equals(this.qosFlowRetThd, qosSustainabilityInfo.qosFlowRetThd) &&
				Objects.equals(this.ranUeThrouThd, qosSustainabilityInfo.ranUeThrouThd) &&
				Objects.equals(this.snssai, qosSustainabilityInfo.snssai) &&
				Objects.equals(this.confidence, qosSustainabilityInfo.confidence);
	}

	@Override
	public int hashCode() {
		return Objects.hash(areaInfo, startTs, endTs, qosFlowRetThd, ranUeThrouThd, snssai, confidence);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class QosSustainabilityInfo {\n");

		sb.append("    areaInfo: ").append(toIndentedString(areaInfo)).append("\n");
		sb.append("    startTs: ").append(toIndentedString(startTs)).append("\n");
		sb.append("    endTs: ").append(toIndentedString(endTs)).append("\n");
		sb.append("    qosFlowRetThd: ").append(toIndentedString(qosFlowRetThd)).append("\n");
		sb.append("    ranUeThrouThd: ").append(toIndentedString(ranUeThrouThd)).append("\n");
		sb.append("    snssai: ").append(toIndentedString(snssai)).append("\n");
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
}
