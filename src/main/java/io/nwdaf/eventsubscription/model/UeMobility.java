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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents UE mobility information.
 */
@Schema(description = "Represents UE mobility information.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class UeMobility implements Serializable {
	private Instant time;

	@JsonProperty("ts")
	private OffsetDateTime ts = null;

	@JsonProperty("recurringTime")
	private ScheduledCommunicationTime recurringTime = null;

	@JsonProperty("duration")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer duration = null;

	@JsonProperty("durationVariance")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double durationVariance = null;

	@JsonProperty("locInfos")
	@Valid
	private List<LocationInfo> locInfos = new ArrayList<LocationInfo>();

	// list of aois the ue has visited matching the location infos list (for each
	// user location match it to an aoi or if it doesnt exist create a new one for
	// this location)
	@JsonProperty("areaOfInterestIds")
	private List<UUID> areaOfInterestIds = new ArrayList<>();

	@JsonProperty("supi")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String supi = null;

	@JsonProperty("intGroupId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String intGroupId = null;

	public UeMobility ts(OffsetDateTime ts) {
		this.ts = ts;
		return this;
	}

	/**
	 * string with format 'date-time' as defined in OpenAPI.
	 * 
	 * @return ts
	 **/
	@Schema(description = "string with format 'date-time' as defined in OpenAPI.")

	@Valid
	public OffsetDateTime getTs() {
		return ts;
	}

	public void setTs(OffsetDateTime ts) {
		this.ts = ts;
	}

	public UeMobility recurringTime(ScheduledCommunicationTime recurringTime) {
		this.recurringTime = recurringTime;
		return this;
	}

	/**
	 * Get recurringTime
	 * 
	 * @return recurringTime
	 **/
	@Schema(description = "")

	@Valid
	public ScheduledCommunicationTime getRecurringTime() {
		return recurringTime;
	}

	public void setRecurringTime(ScheduledCommunicationTime recurringTime) {
		this.recurringTime = recurringTime;
	}

	public UeMobility duration(Integer duration) {
		this.duration = duration;
		return this;
	}

	/**
	 * indicating a time in seconds.
	 * 
	 * @return duration
	 **/
	@Schema(description = "indicating a time in seconds.")

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public UeMobility durationVariance(Double durationVariance) {
		this.durationVariance = durationVariance;
		return this;
	}

	/**
	 * string with format 'float' as defined in OpenAPI.
	 * 
	 * @return durationVariance
	 **/
	@Schema(description = "string with format 'float' as defined in OpenAPI.")

	public Double getDurationVariance() {
		return durationVariance;
	}

	public void setDurationVariance(Double durationVariance) {
		this.durationVariance = durationVariance;
	}

	public UeMobility locInfos(List<LocationInfo> locInfos) {
		this.locInfos = locInfos;
		return this;
	}

	public UeMobility addLocInfosItem(LocationInfo locInfosItem) {
		this.locInfos.add(locInfosItem);
		return this;
	}

	/**
	 * Get locInfos
	 * 
	 * @return locInfos
	 **/
	@Schema(required = true, description = "")
	@NotNull
	@Valid
	@Size(min = 1)
	public List<LocationInfo> getLocInfos() {
		return locInfos;
	}

	public void setLocInfos(List<LocationInfo> locInfos) {
		this.locInfos = locInfos;
	}

	public UeMobility areaOfInterestIds(List<UUID> areaOfInterestIds) {
		this.areaOfInterestIds = areaOfInterestIds;
		return this;
	}

	public UeMobility addAreaOfInterestIdsItem(UUID areaOfInterestIdsItem) {
		this.areaOfInterestIds.add(areaOfInterestIdsItem);
		return this;
	}

	/**
	 * string with format 'UUID' as defined in OpenAPI.
	 * 
	 * @return areaOfInterestId
	 **/
	@Schema(description = "string with format 'UUID' as defined in OpenAPI.")

	public List<UUID> getAreaOfInterestIds() {
		return areaOfInterestIds;
	}

	public void setAreaOfInterestIds(List<UUID> areaOfInterestIds) {
		this.areaOfInterestIds = areaOfInterestIds;
	}

	public UeMobility supi(String supi) {
		this.supi = supi;
		return this;
	}

	/**
	 * string with format 'SUPI' as defined in 3GPP.
	 * 
	 * @return supi
	 **/
	@Schema(description = "string with format 'SUPI' as defined in 3GPP.")
	public String getSupi() {
		return supi;
	}

	public void setSupi(String supi) {
		this.supi = supi;
	}

	public UeMobility intGroupId(String intGroupId) {
		this.intGroupId = intGroupId;
		return this;
	}

	/**
	 * string with format 'intGroupId' as defined in 3GPP.
	 * 
	 * @return intGroupId
	 **/
	@Schema(description = "string with format 'intGroupId' as defined in 3GPP.")
	public String getIntGroupId() {
		return intGroupId;
	}

	public void setIntGroupId(String intGroupId) {
		this.intGroupId = intGroupId;
	}

	public UeMobility time(Instant time) {
		this.time = time;
		this.ts = OffsetDateTime.ofInstant(time, TimeZone.getDefault().toZoneId());
		return this;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
		this.ts = OffsetDateTime.ofInstant(time, TimeZone.getDefault().toZoneId());
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UeMobility ueMobility = (UeMobility) o;
		return Objects.equals(this.ts, ueMobility.ts) &&
				Objects.equals(this.recurringTime, ueMobility.recurringTime) &&
				Objects.equals(this.duration, ueMobility.duration) &&
				Objects.equals(this.durationVariance, ueMobility.durationVariance) &&
				Objects.equals(this.locInfos, ueMobility.locInfos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ts, recurringTime, duration, durationVariance, locInfos);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UeMobility {\n");

		sb.append("    areaOfInterestIds: ").append(toIndentedString(areaOfInterestIds)).append("\n");
		sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
		sb.append("    intGroupId: ").append(toIndentedString(intGroupId)).append("\n");
		sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
		sb.append("    recurringTime: ").append(toIndentedString(recurringTime)).append("\n");
		sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
		sb.append("    durationVariance: ").append(toIndentedString(durationVariance)).append("\n");
		sb.append("    locInfos: ").append(toIndentedString(locInfos)).append("\n");
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
		if (this.getRecurringTime() != null) {
			map.put("recurringTime", this.getRecurringTime().toMap());
		}
		map.put("duration", this.getDuration());
		map.put("durationVariance", this.getDurationVariance());
		List<Map<String, Object>> locMapList = new ArrayList<>();
		if (this.locInfos != null) {
			for (int i = 0; i < this.locInfos.size(); i++) {
				if (this.locInfos.get(i) != null) {
					locMapList.add(this.locInfos.get(i).toMap());
				}
			}
		}
		map.put("locInfos", locMapList);
		map.put("areaOfInterestIds", this.getAreaOfInterestIds());
		map.put("supi", this.getSupi());
		map.put("intGroupId", this.getIntGroupId());
		return map;
	}

	public static UeMobility fromMap(Map<String, Object> map) {
		if (map == null) {
			return null;
		}
		UeMobility result = new UeMobility();
		result.setTime(ConvertUtil.convertDoubleToInstant((Double) map.get("time")));
		result.setRecurringTime(ScheduledCommunicationTime.fromMap((Map<String, Object>) map.get("recurringTime")));
		result.setDuration((Integer) map.get("duration"));
		result.setDurationVariance((Double) map.get("durationVariance"));
		List<Map<String, Object>> locInfos = (List<Map<String, Object>>) map.get("locInfos");
		for (Map<String, Object> locInfo : locInfos) {
			result.addLocInfosItem(LocationInfo.fromMap(locInfo));
		}
		result.setAreaOfInterestIds((List<UUID>) map.get("areaOfInterestIds"));
		result.setSupi((String) map.get("supi"));
		result.setIntGroupId((String) map.get("intGroupId"));
		return result;
	}
}
