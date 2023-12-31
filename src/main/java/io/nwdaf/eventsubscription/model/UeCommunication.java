package io.nwdaf.eventsubscription.model;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import io.nwdaf.eventsubscription.utilities.Regex;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents UE communication information.
 */
@Schema(description = "Represents UE communication information.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")


public class UeCommunication {

    private Instant time;
    @JsonProperty("commDur")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer commDur
            = null;

    @JsonProperty("commDurVariance")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double commDurVariance
            = null;

    @JsonProperty("perioTime")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer perioTime
            = null;

    @JsonProperty("perioTimeVariance")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double perioTimeVariance
            = null;

    @JsonProperty("ts")
    private OffsetDateTime ts = null;

    @JsonProperty("tsVariance")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double tsVariance
            = null;

    @JsonProperty("recurringTime")
    private ScheduledCommunicationTime recurringTime = null;

    @JsonProperty("trafChar")
    private TrafficCharacterization trafChar = null;

    @JsonProperty("ratio")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer ratio
            = null;

    @JsonProperty("perioCommInd")
    private Boolean perioCommInd = null;

    @JsonProperty("confidence")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer confidence
            = null;

    @JsonProperty("anaOfAppList")
    private AppListForUeComm anaOfAppList = null;

    @JsonProperty("sessInactTimer")
    private SessInactTimerForUeComm sessInactTimer = null;

    @JsonProperty("supi")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Pattern(regexp = Regex.supi)
    private String supi = null;

    @JsonProperty("intGroupId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Pattern(regexp = Regex.group_id)
    private String intGroupId = null;

    @JsonProperty("areaOfInterestId")
    private UUID areaOfInterestId = null;

    public UeCommunication commDur(Integer commDur) {
        this.commDur = commDur;
        return this;
    }

    /**
     * indicating a time in seconds.
     *
     * @return commDur
     **/
    @Schema(description = "indicating a time in seconds.")

    public Integer getCommDur() {
        return commDur;
    }

    public void setCommDur(Integer commDur) {
        this.commDur = commDur;
    }

    public UeCommunication commDurVariance(Double commDurVariance) {
        this.commDurVariance = commDurVariance;
        return this;
    }

    /**
     * string with format 'float' as defined in OpenAPI.
     *
     * @return commDurVariance
     **/
    @Schema(description = "string with format 'float' as defined in OpenAPI.")

    public Double getCommDurVariance() {
        return commDurVariance;
    }

    public void setCommDurVariance(Double commDurVariance) {
        this.commDurVariance = commDurVariance;
    }

    public UeCommunication perioTime(Integer perioTime) {
        this.perioTime = perioTime;
        return this;
    }

    /**
     * indicating a time in seconds.
     *
     * @return perioTime
     **/
    @Schema(description = "indicating a time in seconds.")

    public Integer getPerioTime() {
        return perioTime;
    }

    public void setPerioTime(Integer perioTime) {
        this.perioTime = perioTime;
    }

    public UeCommunication perioTimeVariance(Double perioTimeVariance) {
        this.perioTimeVariance = perioTimeVariance;
        return this;
    }

    /**
     * string with format 'float' as defined in OpenAPI.
     *
     * @return perioTimeVariance
     **/
    @Schema(description = "string with format 'float' as defined in OpenAPI.")

    public Double getPerioTimeVariance() {
        return perioTimeVariance;
    }

    public void setPerioTimeVariance(Double perioTimeVariance) {
        this.perioTimeVariance = perioTimeVariance;
    }

    public UeCommunication ts(OffsetDateTime ts) {
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

    public UeCommunication tsVariance(Double tsVariance) {
        this.tsVariance = tsVariance;
        return this;
    }

    /**
     * string with format 'float' as defined in OpenAPI.
     *
     * @return tsVariance
     **/
    @Schema(description = "string with format 'float' as defined in OpenAPI.")

    public Double getTsVariance() {
        return tsVariance;
    }

    public void setTsVariance(Double tsVariance) {
        this.tsVariance = tsVariance;
    }

    public UeCommunication recurringTime(ScheduledCommunicationTime recurringTime) {
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

    public UeCommunication trafChar(TrafficCharacterization trafChar) {
        this.trafChar = trafChar;
        return this;
    }

    /**
     * Get trafChar
     *
     * @return trafChar
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public TrafficCharacterization getTrafChar() {
        return trafChar;
    }

    public void setTrafChar(TrafficCharacterization trafChar) {
        this.trafChar = trafChar;
    }

    public UeCommunication ratio(Integer ratio) {
        this.ratio = ratio;
        return this;
    }

    /**
     * Unsigned integer indicating Sampling Ratio (see clauses 4.15.1 of 3GPP TS 23.502), expressed in percent.
     * minimum: 1
     * maximum: 100
     *
     * @return ratio
     **/
    @Schema(description = "Unsigned integer indicating Sampling Ratio (see clauses 4.15.1 of 3GPP TS 23.502), expressed in percent.  ")

    @Min(1)
    @Max(100)
    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    public UeCommunication perioCommInd(Boolean perioCommInd) {
        this.perioCommInd = perioCommInd;
        return this;
    }

    /**
     * Get perioCommInd
     *
     * @return perioCommInd
     **/
    @Schema(description = "")

    public Boolean isPerioCommInd() {
        return perioCommInd;
    }

    public void setPerioCommInd(Boolean perioCommInd) {
        this.perioCommInd = perioCommInd;
    }

    public UeCommunication confidence(Integer confidence) {
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

    public UeCommunication anaOfAppList(AppListForUeComm anaOfAppList) {
        this.anaOfAppList = anaOfAppList;
        return this;
    }

    /**
     * Get anaOfAppList
     *
     * @return anaOfAppList
     **/
    @Schema(description = "")

    @Valid
    public AppListForUeComm getAnaOfAppList() {
        return anaOfAppList;
    }

    public void setAnaOfAppList(AppListForUeComm anaOfAppList) {
        this.anaOfAppList = anaOfAppList;
    }

    public UeCommunication sessInactTimer(SessInactTimerForUeComm sessInactTimer) {
        this.sessInactTimer = sessInactTimer;
        return this;
    }

    /**
     * Get sessInactTimer
     *
     * @return sessInactTimer
     **/
    @Schema(description = "")

    @Valid
    public SessInactTimerForUeComm getSessInactTimer() {
        return sessInactTimer;
    }

    public void setSessInactTimer(SessInactTimerForUeComm sessInactTimer) {
        this.sessInactTimer = sessInactTimer;
    }

    public UeCommunication time(Instant time) {
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

    public UeCommunication supi(String supi) {
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

    public UeCommunication intGroupId(String intGroupId) {
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

    public UeCommunication areaOfInterestId(UUID id) {
        this.areaOfInterestId = id;
        return this;
    }

    public UUID getAreaOfInterestId() {
        return this.areaOfInterestId;
    }

    public void setAreaOfInterestId(UUID id) {
        this.areaOfInterestId = id;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UeCommunication ueCommunication = (UeCommunication) o;
        return Objects.equals(this.commDur, ueCommunication.commDur) &&
                Objects.equals(this.commDurVariance, ueCommunication.commDurVariance) &&
                Objects.equals(this.perioTime, ueCommunication.perioTime) &&
                Objects.equals(this.perioTimeVariance, ueCommunication.perioTimeVariance) &&
                Objects.equals(this.ts, ueCommunication.ts) &&
                Objects.equals(this.tsVariance, ueCommunication.tsVariance) &&
                Objects.equals(this.recurringTime, ueCommunication.recurringTime) &&
                Objects.equals(this.trafChar, ueCommunication.trafChar) &&
                Objects.equals(this.ratio, ueCommunication.ratio) &&
                Objects.equals(this.perioCommInd, ueCommunication.perioCommInd) &&
                Objects.equals(this.confidence, ueCommunication.confidence) &&
                Objects.equals(this.anaOfAppList, ueCommunication.anaOfAppList) &&
                Objects.equals(this.sessInactTimer, ueCommunication.sessInactTimer) &&
                Objects.equals(this.supi, ueCommunication.supi) &&
                Objects.equals(this.intGroupId, ueCommunication.intGroupId) &&
                Objects.equals(this.areaOfInterestId, ueCommunication.areaOfInterestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commDur, commDurVariance, perioTime, perioTimeVariance, ts, tsVariance, recurringTime, trafChar, ratio, perioCommInd, confidence, anaOfAppList, sessInactTimer, supi , intGroupId, areaOfInterestId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UeCommunication {\n");

        sb.append("    commDur: ").append(toIndentedString(commDur)).append("\n");
        sb.append("    commDurVariance: ").append(toIndentedString(commDurVariance)).append("\n");
        sb.append("    perioTime: ").append(toIndentedString(perioTime)).append("\n");
        sb.append("    perioTimeVariance: ").append(toIndentedString(perioTimeVariance)).append("\n");
        sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
        sb.append("    tsVariance: ").append(toIndentedString(tsVariance)).append("\n");
        sb.append("    recurringTime: ").append(toIndentedString(recurringTime)).append("\n");
        sb.append("    trafChar: ").append(toIndentedString(trafChar)).append("\n");
        sb.append("    ratio: ").append(toIndentedString(ratio)).append("\n");
        sb.append("    perioCommInd: ").append(toIndentedString(perioCommInd)).append("\n");
        sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
        sb.append("    anaOfAppList: ").append(toIndentedString(anaOfAppList)).append("\n");
        sb.append("    sessInactTimer: ").append(toIndentedString(sessInactTimer)).append("\n");
        sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
        sb.append("    intGroupId: ").append(toIndentedString(intGroupId)).append("\n");
        sb.append("    areaOfInterestId: ").append(toIndentedString(areaOfInterestId)).append("\n");
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
        map.put("commDur", this.getCommDur());
        map.put("confidence", this.getConfidence());
        if(sessInactTimer!=null) {
            map.put("sessInactTimer", this.sessInactTimer.toMap());
        }
        if(trafChar!=null) {
            map.put("trafChar", this.trafChar.toMap());
        }
        if(anaOfAppList!=null) {
            map.put("anaOfAppList", this.anaOfAppList.toMap());
        }
        map.put("perioTime", this.getPerioTime());
        map.put("perioTimeVariance", this.getPerioTimeVariance());
        map.put("tsVariance", this.getTsVariance());
        map.put("ratio", this.getRatio());
        map.put("perioCommInd", this.isPerioCommInd());
        map.put("intGroupId", this.getIntGroupId());
        map.put("supi", this.getSupi());
        map.put("areaOfInterestId", ParserUtil.safeParseString(this.areaOfInterestId));
        return map;
    }

    public static UeCommunication fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        UeCommunication result = new UeCommunication();
        result.setTime(ConvertUtil.convertDoubleToInstant((Double) map.get("time")));
        result.setRecurringTime(ScheduledCommunicationTime.fromMap((Map<String, Object>) map.get("recurringTime")));
        result.setCommDur((Integer) map.get("commDur"));
        result.setConfidence((Integer) map.get("confidence"));
        result.setSessInactTimer(SessInactTimerForUeComm.fromMap((Map<String, Object>) map.get("sessInactTimer")));
        result.setPerioTime((Integer) map.get("perioTime"));
        result.setPerioTimeVariance((Double) map.get("perioTimeVariance"));
        result.setTsVariance((Double) map.get("tsVariance"));
        result.setTrafChar(TrafficCharacterization.fromMap((Map<String, Object>) map.get("trafChar")));
        result.setRatio((Integer) map.get("ratio"));
        result.setPerioCommInd((Boolean) map.get("perioCommInd"));
        result.setSupi((String) map.get("supi"));
        result.setIntGroupId((String) map.get("intGroupId"));
        result.setAreaOfInterestId(ParserUtil.safeParseUUID((String) map.get("areaOfInterestId")));
        result.setAnaOfAppList(AppListForUeComm.fromMap((Map<String, Object>) map.get("anaOfAppList")));
        return result;
    }
}
