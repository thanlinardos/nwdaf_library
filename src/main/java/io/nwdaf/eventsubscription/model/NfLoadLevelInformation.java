package io.nwdaf.eventsubscription.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents load level information of a given NF instance.
 */
@Schema(description = "Represents load level information of a given NF instance.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class NfLoadLevelInformation implements Serializable {
	private Instant time;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("thresholdProperty")
	private String thresholdProperty = null;

	@JsonProperty("thresholdValue")
	private Integer thresholdValue = null;

	@JsonProperty("areaOfInterestId")
	private UUID areaOfInterestId = null;

	@JsonProperty("supis")
	private List<String> supis = new ArrayList<>();

	@JsonProperty("nfType")
	private NFType nfType = null;

	@JsonProperty("serviceId")
	private String serviceId = null;

	@JsonProperty("nfInstanceId")
	private UUID nfInstanceId = null;

	@JsonProperty("nfSetId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nfSetId = null;

	@JsonProperty("nfStatus")
	private NfStatus nfStatus = null;

	@JsonProperty("nfCpuUsage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer nfCpuUsage = null;

	@JsonProperty("nfMemoryUsage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer nfMemoryUsage = null;

	@JsonProperty("nfStorageUsage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer nfStorageUsage = null;

	@JsonProperty("nfLoadLevelAverage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer nfLoadLevelAverage = null;

	@JsonProperty("nfLoadLevelpeak")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer nfLoadLevelpeak = null;

	@JsonProperty("nfLoadAvgInAoi")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer nfLoadAvgInAoi = null;

	@JsonProperty("snssai")
	private Snssai snssai = null;

	@JsonProperty("confidence")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer confidence = null;

	public NfLoadLevelInformation areaOfInterestId(UUID id) {
		this.areaOfInterestId = id;
		return this;
	}

	public UUID getAreaOfInterestId() {
		return this.areaOfInterestId;
	}

	public void setAreaOfInterestId(UUID id) {
		this.areaOfInterestId = id;
	}

	public NfLoadLevelInformation nfType(NFType nfType) {
		this.nfType = nfType;
		return this;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
		this.timeStamp = OffsetDateTime.ofInstant(time, TimeZone.getDefault().toZoneId());
	}

	public NfLoadLevelInformation time(Instant time) {
		this.time = time;
		this.timeStamp = OffsetDateTime.ofInstant(time, TimeZone.getDefault().toZoneId());
		return this;
	}

	/**
	 * Get nfType
	 * 
	 * @return nfType
	 **/
	@Schema(description = "")

	@Valid
	public NFType getNfType() {
		return nfType;
	}

	public void setNfType(NFType nfType) {
		this.nfType = nfType;
	}

	public NfLoadLevelInformation nfInstanceId(UUID nfInstanceId) {
		this.nfInstanceId = nfInstanceId;
		return this;
	}

	/**
	 * String uniquely identifying a NF instance. The format of the NF Instance ID
	 * shall be a Universally Unique Identifier (UUID) version 4, as described in
	 * IETF RFC 4122.
	 * 
	 * @return nfInstanceId
	 **/
	@Schema(required = true, description = "String uniquely identifying a NF instance. The format of the NF Instance ID shall be a  Universally Unique Identifier (UUID) version 4, as described in IETF RFC 4122.  ")
	@NotNull

	@Valid
	public UUID getNfInstanceId() {
		return nfInstanceId;
	}

	public void setNfInstanceId(UUID nfInstanceId) {
		this.nfInstanceId = nfInstanceId;
	}

	public NfLoadLevelInformation nfSetId(String nfSetId) {
		this.nfSetId = nfSetId;
		return this;
	}

	/**
	 * NF Set Identifier (see clause 28.12 of 3GPP TS 23.003), formatted as the
	 * following string \"set<Set ID>.<nftype>set.5gc.mnc<MNC>.mcc<MCC>\", or
	 * \"set<SetID>.<NFType>set.5gc.nid<NID>.mnc<MNC>.mcc<MCC>\" with <MCC> encoded
	 * as defined in clause 5.4.2 (\"Mcc\" data type definition) <MNC> encoding the
	 * Mobile Network Code part of the PLMN, comprising 3 digits. If there are only
	 * 2 significant digits in the MNC, one \"0\" digit shall be inserted at the
	 * left side to fill the 3 digits coding of MNC. Pattern: '^[0-9]{3}$' <NFType>
	 * encoded as a value defined in Table 6.1.6.3.3-1 of 3GPP TS 29.510 but with
	 * lower case characters <Set ID> encoded as a string of characters consisting
	 * of alphabetic characters (A-Z and a-z), digits (0-9) and/or the hyphen (-)
	 * and that shall end with either an alphabetic character or a digit.
	 * 
	 * @return nfSetId
	 **/
	@Schema(description = "NF Set Identifier (see clause 28.12 of 3GPP TS 23.003), formatted as the following string \"set<Set ID>.<nftype>set.5gc.mnc<MNC>.mcc<MCC>\", or  \"set<SetID>.<NFType>set.5gc.nid<NID>.mnc<MNC>.mcc<MCC>\" with  <MCC> encoded as defined in clause 5.4.2 (\"Mcc\" data type definition)  <MNC> encoding the Mobile Network Code part of the PLMN, comprising 3 digits.    If there are only 2 significant digits in the MNC, one \"0\" digit shall be inserted    at the left side to fill the 3 digits coding of MNC.  Pattern: '^[0-9]{3}$' <NFType> encoded as a value defined in Table 6.1.6.3.3-1 of 3GPP TS 29.510 but    with lower case characters <Set ID> encoded as a string of characters consisting of    alphabetic characters (A-Z and a-z), digits (0-9) and/or the hyphen (-) and that    shall end with either an alphabetic character or a digit.  ")

	public String getNfSetId() {
		return nfSetId;
	}

	public void setNfSetId(String nfSetId) {
		this.nfSetId = nfSetId;
	}

	public NfLoadLevelInformation nfStatus(NfStatus nfStatus) {
		this.nfStatus = nfStatus;
		return this;
	}

	/**
	 * Get nfStatus
	 * 
	 * @return nfStatus
	 **/
	@Schema(description = "")

	@Valid
	public NfStatus getNfStatus() {
		return nfStatus;
	}

	public void setNfStatus(NfStatus nfStatus) {
		this.nfStatus = nfStatus;
	}

	public NfLoadLevelInformation nfCpuUsage(Integer nfCpuUsage) {
		this.nfCpuUsage = nfCpuUsage;
		return this;
	}

	/**
	 * Get nfCpuUsage
	 * 
	 * @return nfCpuUsage
	 **/
	@Schema(description = "")

	public Integer getNfCpuUsage() {
		return nfCpuUsage;
	}

	public void setNfCpuUsage(Integer nfCpuUsage) {
		this.nfCpuUsage = nfCpuUsage;
	}

	public NfLoadLevelInformation nfMemoryUsage(Integer nfMemoryUsage) {
		this.nfMemoryUsage = nfMemoryUsage;
		return this;
	}

	/**
	 * Get nfMemoryUsage
	 * 
	 * @return nfMemoryUsage
	 **/
	@Schema(description = "")

	public Integer getNfMemoryUsage() {
		return nfMemoryUsage;
	}

	public void setNfMemoryUsage(Integer nfMemoryUsage) {
		this.nfMemoryUsage = nfMemoryUsage;
	}

	public NfLoadLevelInformation nfStorageUsage(Integer nfStorageUsage) {
		this.nfStorageUsage = nfStorageUsage;
		return this;
	}

	/**
	 * Get nfStorageUsage
	 * 
	 * @return nfStorageUsage
	 **/
	@Schema(description = "")

	public Integer getNfStorageUsage() {
		return nfStorageUsage;
	}

	public void setNfStorageUsage(Integer nfStorageUsage) {
		this.nfStorageUsage = nfStorageUsage;
	}

	public NfLoadLevelInformation nfLoadLevelAverage(Integer nfLoadLevelAverage) {
		this.nfLoadLevelAverage = nfLoadLevelAverage;
		return this;
	}

	/**
	 * Get nfLoadLevelAverage
	 * 
	 * @return nfLoadLevelAverage
	 **/
	@Schema(description = "")

	public Integer getNfLoadLevelAverage() {
		return nfLoadLevelAverage;
	}

	public void setNfLoadLevelAverage(Integer nfLoadLevelAverage) {
		this.nfLoadLevelAverage = nfLoadLevelAverage;
	}

	public NfLoadLevelInformation nfLoadLevelpeak(Integer nfLoadLevelpeak) {
		this.nfLoadLevelpeak = nfLoadLevelpeak;
		return this;
	}

	/**
	 * Get nfLoadLevelpeak
	 * 
	 * @return nfLoadLevelpeak
	 **/
	@Schema(description = "")

	public Integer getNfLoadLevelpeak() {
		return nfLoadLevelpeak;
	}

	public void setNfLoadLevelpeak(Integer nfLoadLevelpeak) {
		this.nfLoadLevelpeak = nfLoadLevelpeak;
	}

	public NfLoadLevelInformation nfLoadAvgInAoi(Integer nfLoadAvgInAoi) {
		this.nfLoadAvgInAoi = nfLoadAvgInAoi;
		return this;
	}

	/**
	 * Get nfLoadAvgInAoi
	 * 
	 * @return nfLoadAvgInAoi
	 **/
	@Schema(description = "")

	public Integer getNfLoadAvgInAoi() {
		return nfLoadAvgInAoi;
	}

	public void setNfLoadAvgInAoi(Integer nfLoadAvgInAoi) {
		this.nfLoadAvgInAoi = nfLoadAvgInAoi;
	}

	public NfLoadLevelInformation snssai(Snssai snssai) {
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

	public NfLoadLevelInformation confidence(Integer confidence) {
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

	public NfLoadLevelInformation supis(List<String> supis) {
		this.supis = supis;
		return this;
	}

	public NfLoadLevelInformation addSupi(String supi) {
		if (this.supis == null) {
			this.supis = new ArrayList<String>();
		}
		this.supis.add(supi);
		return this;
	}

	/**
	 * Contains a list of Supis that this nf instance serves.
	 * 
	 * @return supis
	 **/
	@Schema(description = "Contains a list of Supis that this nf instance serves.")
	@Valid
	public List<String> getSupis() {
		return supis;
	}

	public void setSupis(List<String> supis) {
		this.supis = supis;
	}

	public NfLoadLevelInformation serviceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getThresholdProperty() {
		return thresholdProperty;
	}

	public void setThresholdProperty(String thresholdProperty) {
		this.thresholdProperty = thresholdProperty;
	}

	public Integer getThresholdValue() {
		return thresholdValue;
	}

	public void setThresholdValue(Integer thresholdValue) {
		this.thresholdValue = thresholdValue;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NfLoadLevelInformation nfLoadLevelInformation = (NfLoadLevelInformation) o;
		return Objects.equals(this.nfType, nfLoadLevelInformation.nfType) &&
				Objects.equals(this.areaOfInterestId, nfLoadLevelInformation.areaOfInterestId) &&
				Objects.equals(this.nfInstanceId, nfLoadLevelInformation.nfInstanceId) &&
				Objects.equals(this.nfSetId, nfLoadLevelInformation.nfSetId) &&
				Objects.equals(this.serviceId, nfLoadLevelInformation.serviceId) &&
				Objects.equals(this.nfStatus, nfLoadLevelInformation.nfStatus) &&
				Objects.equals(this.nfCpuUsage, nfLoadLevelInformation.nfCpuUsage) &&
				Objects.equals(this.nfMemoryUsage, nfLoadLevelInformation.nfMemoryUsage) &&
				Objects.equals(this.nfStorageUsage, nfLoadLevelInformation.nfStorageUsage) &&
				Objects.equals(this.nfLoadLevelAverage, nfLoadLevelInformation.nfLoadLevelAverage) &&
				Objects.equals(this.nfLoadLevelpeak, nfLoadLevelInformation.nfLoadLevelpeak) &&
				Objects.equals(this.nfLoadAvgInAoi, nfLoadLevelInformation.nfLoadAvgInAoi) &&
				Objects.equals(this.snssai, nfLoadLevelInformation.snssai) &&
				Objects.equals(this.confidence, nfLoadLevelInformation.confidence) &&
				Objects.equals(this.supis, nfLoadLevelInformation.supis);
	}

	@Override
	public int hashCode() {
		return Objects.hash(areaOfInterestId, nfType, nfInstanceId, nfSetId, serviceId, nfStatus, nfCpuUsage, nfMemoryUsage,
				nfStorageUsage, nfLoadLevelAverage, nfLoadLevelpeak, nfLoadAvgInAoi, snssai, confidence, supis);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NfLoadLevelInformation {\n");

		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    thresholdProperty: ").append(toIndentedString(thresholdProperty)).append("\n");
		sb.append("    thresholdValue: ").append(toIndentedString(thresholdValue)).append("\n");
		sb.append("    areaOfInterestId: ").append(toIndentedString(areaOfInterestId)).append("\n");
		sb.append("    nfType: ").append(toIndentedString(nfType)).append("\n");
		sb.append("    nfInstanceId: ").append(toIndentedString(nfInstanceId)).append("\n");
		sb.append("    nfSetId: ").append(toIndentedString(nfSetId)).append("\n");
		sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
		sb.append("    nfStatus: ").append(toIndentedString(nfStatus)).append("\n");
		sb.append("    nfCpuUsage: ").append(toIndentedString(nfCpuUsage)).append("\n");
		sb.append("    nfMemoryUsage: ").append(toIndentedString(nfMemoryUsage)).append("\n");
		sb.append("    nfStorageUsage: ").append(toIndentedString(nfStorageUsage)).append("\n");
		sb.append("    nfLoadLevelAverage: ").append(toIndentedString(nfLoadLevelAverage)).append("\n");
		sb.append("    nfLoadLevelpeak: ").append(toIndentedString(nfLoadLevelpeak)).append("\n");
		sb.append("    nfLoadAvgInAoi: ").append(toIndentedString(nfLoadAvgInAoi)).append("\n");
		sb.append("    snssai: ").append(toIndentedString(snssai)).append("\n");
		sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
		sb.append("    supis: ").append(toIndentedString(supis)).append("\n");
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
		map.put("time", ConvertUtil.convertInstantToDouble(this.getTime()));
		map.put("thresholdProperty", this.getThresholdProperty());
		map.put("thresholdValue", this.getThresholdValue());
		map.put("areaOfInterestId", ParserUtil.safeParseString(this.getAreaOfInterestId()));
		map.put("supis", this.getSupis());
		if(this.getNfType()!=null) {
			map.put("nfType", this.getNfType().toMap());
		}
		map.put("nfInstanceId", ParserUtil.safeParseString(this.getNfInstanceId()));
		map.put("nfSetId", this.getNfSetId());
		map.put("serviceId", this.getServiceId());
		if(this.getNfStatus()!=null) {
			map.put("nfStatus", this.getNfStatus().toMap());
		}
		map.put("nfCpuUsage", this.getNfCpuUsage());
		map.put("nfMemoryUsage", this.getNfMemoryUsage());
		map.put("nfStorageUsage", this.getNfStorageUsage());
		map.put("nfLoadLevelAverage", this.getNfLoadLevelAverage());
		map.put("nfLoadLevelpeak", this.getNfLoadLevelpeak());
		map.put("nfLoadAvgInAoi", this.getNfLoadAvgInAoi());
		if(this.getSnssai()!=null) {
			map.put("snssai", this.getSnssai().toMap());
		}
		map.put("confidence", this.getConfidence());
		return map;
	}

	public static NfLoadLevelInformation fromMap(Map<String, Object> map) {
		if(map==null) {
			return null;
		}
		NfLoadLevelInformation result = new NfLoadLevelInformation();
		try {
			result.setTime(ConvertUtil.convertDoubleToInstant((Double) map.get("time")));
		} catch (ClassCastException e) {
			result.setTime(ConvertUtil.convertDoubleToInstant(Double.valueOf((Integer) map.get("time"))));
		}
		result.setThresholdProperty((String) map.get("thresholdProperty"));
		result.setThresholdValue((Integer) map.get("thresholdValue"));
		result.setAreaOfInterestId(ParserUtil.safeParseUUID((String) map.get("areaOfInterestId")));
		result.setSupis((List<String>) map.get("supis"));
		result.setNfType(NFType.fromMap((Map<String, Object>) map.get("nfType")));
		result.setNfInstanceId(ParserUtil.safeParseUUID((String) map.get("nfInstanceId")));
		result.setNfSetId((String) map.get("nfSetId"));
		result.setServiceId((String) map.get("serviceId"));
		result.setNfStatus(NfStatus.fromMap((Map<String,Object>) map.get("nfStatus")));
		result.setNfCpuUsage((Integer) map.get("nfCpuUsage"));
		result.setNfMemoryUsage((Integer) map.get("nfMemoryUsage"));
		result.setNfStorageUsage((Integer) map.get("nfStorageUsage"));
		result.setNfLoadLevelAverage((Integer) map.get("nfLoadLevelAverage"));
		result.setNfLoadLevelpeak((Integer) map.get("nfLoadLevelpeak"));
		result.setNfLoadAvgInAoi((Integer) map.get("nfLoadAvgInAoi"));
		result.setSnssai(Snssai.fromMap((Map<String,Object>) map.get("snssai")));
		result.setConfidence((Integer) map.get("confidence"));
		return result;
	}
}
