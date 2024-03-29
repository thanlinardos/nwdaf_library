package io.nwdaf.eventsubscription.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a notification on events that occurred.
 */
@Schema(description = "Represents a notification on events that occurred.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class EventNotification {
	@JsonProperty("event")
	private NwdafEvent event = null;

	@JsonProperty("start")
	private OffsetDateTime start = null;

	@JsonProperty("expiry")
	private OffsetDateTime expiry = null;

	@JsonProperty("timeStampGen")
	private OffsetDateTime timeStampGen = null;

	@JsonProperty("failNotifyCode")
	private NwdafFailureCode failNotifyCode = null;

	@JsonProperty("rvWaitTime")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long rvWaitTime = null;

	@JsonProperty("anaMetaInfo")
	private AnalyticsMetadataInfo anaMetaInfo = null;

	@JsonProperty("nfLoadLevelInfos")
	@Valid
	private List<NfLoadLevelInformation> nfLoadLevelInfos = null;

	@JsonProperty("nsiLoadLevelInfos")
	@Valid
	private List<NsiLoadLevelInfo> nsiLoadLevelInfos = null;

	@JsonProperty("sliceLoadLevelInfo")
	private SliceLoadLevelInformation sliceLoadLevelInfo = null;

	@JsonProperty("svcExps")
	@Valid
	private List<ServiceExperienceInfo> svcExps = null;

	@JsonProperty("qosSustainInfos")
	@Valid
	private List<QosSustainabilityInfo> qosSustainInfos = null;

	@JsonProperty("ueComms")
	@Valid
	private List<UeCommunication> ueComms = null;

	@JsonProperty("ueMobs")
	@Valid
	private List<UeMobility> ueMobs = null;

	@JsonProperty("userDataCongInfos")
	@Valid
	private List<UserDataCongestionInfo> userDataCongInfos = null;

	@JsonProperty("abnorBehavrs")
	@Valid
	private List<AbnormalBehaviour> abnorBehavrs = null;

	@JsonProperty("nwPerfs")
	@Valid
	private List<NetworkPerfInfo> nwPerfs = null;

	@JsonProperty("dnPerfInfos")
	@Valid
	private List<DnPerfInfo> dnPerfInfos = null;

	@JsonProperty("disperInfos")
	@Valid
	private List<DispersionInfo> disperInfos = null;

	@JsonProperty("redTransInfos")
	@Valid
	private List<RedundantTransmissionExpInfo> redTransInfos = null;

	@JsonProperty("wlanInfos")
	@Valid
	private List<WlanPerformanceInfo> wlanInfos = null;

	@JsonProperty("smccExps")
	@Valid
	private List<SmcceInfo> smccExps = null;

	public EventNotification event(NwdafEvent event) {
		this.event = event;
		return this;
	}

	/**
	 * Get event
	 * 
	 * @return event
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public NwdafEvent getEvent() {
		return event;
	}

	public void setEvent(NwdafEvent event) {
		this.event = event;
	}

	public EventNotification start(OffsetDateTime start) {
		this.start = start;
		return this;
	}

	/**
	 * string with format 'date-time' as defined in OpenAPI.
	 * 
	 * @return start
	 **/
	@Schema(description = "string with format 'date-time' as defined in OpenAPI.")

	@Valid
	public OffsetDateTime getStart() {
		return start;
	}

	public void setStart(OffsetDateTime start) {
		this.start = start;
	}

	public EventNotification expiry(OffsetDateTime expiry) {
		this.expiry = expiry;
		return this;
	}

	/**
	 * string with format 'date-time' as defined in OpenAPI.
	 * 
	 * @return expiry
	 **/
	@Schema(description = "string with format 'date-time' as defined in OpenAPI.")

	@Valid
	public OffsetDateTime getExpiry() {
		return expiry;
	}

	public void setExpiry(OffsetDateTime expiry) {
		this.expiry = expiry;
	}

	public EventNotification timeStampGen(OffsetDateTime timeStampGen) {
		this.timeStampGen = timeStampGen;
		return this;
	}

	/**
	 * string with format 'date-time' as defined in OpenAPI.
	 * 
	 * @return timeStampGen
	 **/
	@Schema(description = "string with format 'date-time' as defined in OpenAPI.")

	@Valid
	public OffsetDateTime getTimeStampGen() {
		return timeStampGen;
	}

	public void setTimeStampGen(OffsetDateTime timeStampGen) {
		this.timeStampGen = timeStampGen;
	}

	public EventNotification failNotifyCode(NwdafFailureCode failNotifyCode) {
		this.failNotifyCode = failNotifyCode;
		return this;
	}

	/**
	 * Get failNotifyCode
	 * 
	 * @return failNotifyCode
	 **/
	@Schema(description = "")

	@Valid
	public NwdafFailureCode getFailNotifyCode() {
		return failNotifyCode;
	}

	public void setFailNotifyCode(NwdafFailureCode failNotifyCode) {
		this.failNotifyCode = failNotifyCode;
	}

	public EventNotification rvWaitTime(Long rvWaitTime) {
		this.rvWaitTime = rvWaitTime;
		return this;
	}

	/**
	 * indicating a time in seconds.
	 * 
	 * @return rvWaitTime
	 **/
	@Schema(description = "indicating a time in seconds.")

	public Long getRvWaitTime() {
		return rvWaitTime;
	}

	public void setRvWaitTime(Long rvWaitTime) {
		this.rvWaitTime = rvWaitTime;
	}

	public EventNotification anaMetaInfo(AnalyticsMetadataInfo anaMetaInfo) {
		this.anaMetaInfo = anaMetaInfo;
		return this;
	}

	/**
	 * Get anaMetaInfo
	 * 
	 * @return anaMetaInfo
	 **/
	@Schema(description = "")

	@Valid
	public AnalyticsMetadataInfo getAnaMetaInfo() {
		return anaMetaInfo;
	}

	public void setAnaMetaInfo(AnalyticsMetadataInfo anaMetaInfo) {
		this.anaMetaInfo = anaMetaInfo;
	}

	public EventNotification nfLoadLevelInfos(List<NfLoadLevelInformation> nfLoadLevelInfos) {
		this.nfLoadLevelInfos = nfLoadLevelInfos;
		return this;
	}

	public EventNotification addNfLoadLevelInfosItem(NfLoadLevelInformation nfLoadLevelInfosItem) {
		if (this.nfLoadLevelInfos == null) {
			this.nfLoadLevelInfos = new ArrayList<NfLoadLevelInformation>();
		}
		this.nfLoadLevelInfos.add(nfLoadLevelInfosItem);
		return this;
	}

	/**
	 * Get nfLoadLevelInfos
	 * 
	 * @return nfLoadLevelInfos
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<NfLoadLevelInformation> getNfLoadLevelInfos() {
		return nfLoadLevelInfos;
	}

	public void setNfLoadLevelInfos(List<NfLoadLevelInformation> nfLoadLevelInfos) {
		this.nfLoadLevelInfos = nfLoadLevelInfos;
	}

	public EventNotification nsiLoadLevelInfos(List<NsiLoadLevelInfo> nsiLoadLevelInfos) {
		this.nsiLoadLevelInfos = nsiLoadLevelInfos;
		return this;
	}

	public EventNotification addNsiLoadLevelInfosItem(NsiLoadLevelInfo nsiLoadLevelInfosItem) {
		if (this.nsiLoadLevelInfos == null) {
			this.nsiLoadLevelInfos = new ArrayList<NsiLoadLevelInfo>();
		}
		this.nsiLoadLevelInfos.add(nsiLoadLevelInfosItem);
		return this;
	}

	/**
	 * Get nsiLoadLevelInfos
	 * 
	 * @return nsiLoadLevelInfos
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<NsiLoadLevelInfo> getNsiLoadLevelInfos() {
		return nsiLoadLevelInfos;
	}

	public void setNsiLoadLevelInfos(List<NsiLoadLevelInfo> nsiLoadLevelInfos) {
		this.nsiLoadLevelInfos = nsiLoadLevelInfos;
	}

	public EventNotification sliceLoadLevelInfo(SliceLoadLevelInformation sliceLoadLevelInfo) {
		this.sliceLoadLevelInfo = sliceLoadLevelInfo;
		return this;
	}

	/**
	 * Get sliceLoadLevelInfo
	 * 
	 * @return sliceLoadLevelInfo
	 **/
	@Schema(description = "")

	@Valid
	public SliceLoadLevelInformation getSliceLoadLevelInfo() {
		return sliceLoadLevelInfo;
	}

	public void setSliceLoadLevelInfo(SliceLoadLevelInformation sliceLoadLevelInfo) {
		this.sliceLoadLevelInfo = sliceLoadLevelInfo;
	}

	public EventNotification svcExps(List<ServiceExperienceInfo> svcExps) {
		this.svcExps = svcExps;
		return this;
	}

	public EventNotification addSvcExpsItem(ServiceExperienceInfo svcExpsItem) {
		if (this.svcExps == null) {
			this.svcExps = new ArrayList<ServiceExperienceInfo>();
		}
		this.svcExps.add(svcExpsItem);
		return this;
	}

	/**
	 * Get svcExps
	 * 
	 * @return svcExps
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<ServiceExperienceInfo> getSvcExps() {
		return svcExps;
	}

	public void setSvcExps(List<ServiceExperienceInfo> svcExps) {
		this.svcExps = svcExps;
	}

	public EventNotification qosSustainInfos(List<QosSustainabilityInfo> qosSustainInfos) {
		this.qosSustainInfos = qosSustainInfos;
		return this;
	}

	public EventNotification addQosSustainInfosItem(QosSustainabilityInfo qosSustainInfosItem) {
		if (this.qosSustainInfos == null) {
			this.qosSustainInfos = new ArrayList<QosSustainabilityInfo>();
		}
		this.qosSustainInfos.add(qosSustainInfosItem);
		return this;
	}

	/**
	 * Get qosSustainInfos
	 * 
	 * @return qosSustainInfos
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<QosSustainabilityInfo> getQosSustainInfos() {
		return qosSustainInfos;
	}

	public void setQosSustainInfos(List<QosSustainabilityInfo> qosSustainInfos) {
		this.qosSustainInfos = qosSustainInfos;
	}

	public EventNotification ueComms(List<UeCommunication> ueComms) {
		this.ueComms = ueComms;
		return this;
	}

	public EventNotification addUeCommsItem(UeCommunication ueCommsItem) {
		if (this.ueComms == null) {
			this.ueComms = new ArrayList<UeCommunication>();
		}
		this.ueComms.add(ueCommsItem);
		return this;
	}

	/**
	 * Get ueComms
	 * 
	 * @return ueComms
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<UeCommunication> getUeComms() {
		return ueComms;
	}

	public void setUeComms(List<UeCommunication> ueComms) {
		this.ueComms = ueComms;
	}

	public EventNotification ueMobs(List<UeMobility> ueMobs) {
		this.ueMobs = ueMobs;
		return this;
	}

	public EventNotification addUeMobsItem(UeMobility ueMobsItem) {
		if (this.ueMobs == null) {
			this.ueMobs = new ArrayList<UeMobility>();
		}
		this.ueMobs.add(ueMobsItem);
		return this;
	}

	/**
	 * Get ueMobs
	 * 
	 * @return ueMobs
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<UeMobility> getUeMobs() {
		return ueMobs;
	}

	public void setUeMobs(List<UeMobility> ueMobs) {
		this.ueMobs = ueMobs;
	}

	public EventNotification userDataCongInfos(List<UserDataCongestionInfo> userDataCongInfos) {
		this.userDataCongInfos = userDataCongInfos;
		return this;
	}

	public EventNotification addUserDataCongInfosItem(UserDataCongestionInfo userDataCongInfosItem) {
		if (this.userDataCongInfos == null) {
			this.userDataCongInfos = new ArrayList<UserDataCongestionInfo>();
		}
		this.userDataCongInfos.add(userDataCongInfosItem);
		return this;
	}

	/**
	 * Get userDataCongInfos
	 * 
	 * @return userDataCongInfos
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<UserDataCongestionInfo> getUserDataCongInfos() {
		return userDataCongInfos;
	}

	public void setUserDataCongInfos(List<UserDataCongestionInfo> userDataCongInfos) {
		this.userDataCongInfos = userDataCongInfos;
	}

	public EventNotification abnorBehavrs(List<AbnormalBehaviour> abnorBehavrs) {
		this.abnorBehavrs = abnorBehavrs;
		return this;
	}

	public EventNotification addAbnorBehavrsItem(AbnormalBehaviour abnorBehavrsItem) {
		if (this.abnorBehavrs == null) {
			this.abnorBehavrs = new ArrayList<AbnormalBehaviour>();
		}
		this.abnorBehavrs.add(abnorBehavrsItem);
		return this;
	}

	/**
	 * Get abnorBehavrs
	 * 
	 * @return abnorBehavrs
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<AbnormalBehaviour> getAbnorBehavrs() {
		return abnorBehavrs;
	}

	public void setAbnorBehavrs(List<AbnormalBehaviour> abnorBehavrs) {
		this.abnorBehavrs = abnorBehavrs;
	}

	public EventNotification nwPerfs(List<NetworkPerfInfo> nwPerfs) {
		this.nwPerfs = nwPerfs;
		return this;
	}

	public EventNotification addNwPerfsItem(NetworkPerfInfo nwPerfsItem) {
		if (this.nwPerfs == null) {
			this.nwPerfs = new ArrayList<NetworkPerfInfo>();
		}
		this.nwPerfs.add(nwPerfsItem);
		return this;
	}

	/**
	 * Get nwPerfs
	 * 
	 * @return nwPerfs
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<NetworkPerfInfo> getNwPerfs() {
		return nwPerfs;
	}

	public void setNwPerfs(List<NetworkPerfInfo> nwPerfs) {
		this.nwPerfs = nwPerfs;
	}

	public EventNotification dnPerfInfos(List<DnPerfInfo> dnPerfInfos) {
		this.dnPerfInfos = dnPerfInfos;
		return this;
	}

	public EventNotification addDnPerfInfosItem(DnPerfInfo dnPerfInfosItem) {
		if (this.dnPerfInfos == null) {
			this.dnPerfInfos = new ArrayList<DnPerfInfo>();
		}
		this.dnPerfInfos.add(dnPerfInfosItem);
		return this;
	}

	/**
	 * Get dnPerfInfos
	 * 
	 * @return dnPerfInfos
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<DnPerfInfo> getDnPerfInfos() {
		return dnPerfInfos;
	}

	public void setDnPerfInfos(List<DnPerfInfo> dnPerfInfos) {
		this.dnPerfInfos = dnPerfInfos;
	}

	public EventNotification disperInfos(List<DispersionInfo> disperInfos) {
		this.disperInfos = disperInfos;
		return this;
	}

	public EventNotification addDisperInfosItem(DispersionInfo disperInfosItem) {
		if (this.disperInfos == null) {
			this.disperInfos = new ArrayList<DispersionInfo>();
		}
		this.disperInfos.add(disperInfosItem);
		return this;
	}

	/**
	 * Get disperInfos
	 * 
	 * @return disperInfos
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<DispersionInfo> getDisperInfos() {
		return disperInfos;
	}

	public void setDisperInfos(List<DispersionInfo> disperInfos) {
		this.disperInfos = disperInfos;
	}

	public EventNotification redTransInfos(List<RedundantTransmissionExpInfo> redTransInfos) {
		this.redTransInfos = redTransInfos;
		return this;
	}

	public EventNotification addRedTransInfosItem(RedundantTransmissionExpInfo redTransInfosItem) {
		if (this.redTransInfos == null) {
			this.redTransInfos = new ArrayList<RedundantTransmissionExpInfo>();
		}
		this.redTransInfos.add(redTransInfosItem);
		return this;
	}

	/**
	 * Get redTransInfos
	 * 
	 * @return redTransInfos
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<RedundantTransmissionExpInfo> getRedTransInfos() {
		return redTransInfos;
	}

	public void setRedTransInfos(List<RedundantTransmissionExpInfo> redTransInfos) {
		this.redTransInfos = redTransInfos;
	}

	public EventNotification wlanInfos(List<WlanPerformanceInfo> wlanInfos) {
		this.wlanInfos = wlanInfos;
		return this;
	}

	public EventNotification addWlanInfosItem(WlanPerformanceInfo wlanInfosItem) {
		if (this.wlanInfos == null) {
			this.wlanInfos = new ArrayList<WlanPerformanceInfo>();
		}
		this.wlanInfos.add(wlanInfosItem);
		return this;
	}

	/**
	 * Get wlanInfos
	 * 
	 * @return wlanInfos
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<WlanPerformanceInfo> getWlanInfos() {
		return wlanInfos;
	}

	public void setWlanInfos(List<WlanPerformanceInfo> wlanInfos) {
		this.wlanInfos = wlanInfos;
	}

	public EventNotification smccExps(List<SmcceInfo> smccExps) {
		this.smccExps = smccExps;
		return this;
	}

	public EventNotification addSmccExpsItem(SmcceInfo smccExpsItem) {
		if (this.smccExps == null) {
			this.smccExps = new ArrayList<SmcceInfo>();
		}
		this.smccExps.add(smccExpsItem);
		return this;
	}

	/**
	 * Get smccExps
	 * 
	 * @return smccExps
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<SmcceInfo> getSmccExps() {
		return smccExps;
	}

	public void setSmccExps(List<SmcceInfo> smccExps) {
		this.smccExps = smccExps;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EventNotification eventNotification = (EventNotification) o;
		return Objects.equals(this.event, eventNotification.event) &&
				Objects.equals(this.start, eventNotification.start) &&
				Objects.equals(this.expiry, eventNotification.expiry) &&
				Objects.equals(this.timeStampGen, eventNotification.timeStampGen) &&
				Objects.equals(this.failNotifyCode, eventNotification.failNotifyCode) &&
				Objects.equals(this.rvWaitTime, eventNotification.rvWaitTime) &&
				Objects.equals(this.anaMetaInfo, eventNotification.anaMetaInfo) &&
				Objects.equals(this.nfLoadLevelInfos, eventNotification.nfLoadLevelInfos) &&
				Objects.equals(this.nsiLoadLevelInfos, eventNotification.nsiLoadLevelInfos) &&
				Objects.equals(this.sliceLoadLevelInfo, eventNotification.sliceLoadLevelInfo) &&
				Objects.equals(this.svcExps, eventNotification.svcExps) &&
				Objects.equals(this.qosSustainInfos, eventNotification.qosSustainInfos) &&
				Objects.equals(this.ueComms, eventNotification.ueComms) &&
				Objects.equals(this.ueMobs, eventNotification.ueMobs) &&
				Objects.equals(this.userDataCongInfos, eventNotification.userDataCongInfos) &&
				Objects.equals(this.abnorBehavrs, eventNotification.abnorBehavrs) &&
				Objects.equals(this.nwPerfs, eventNotification.nwPerfs) &&
				Objects.equals(this.dnPerfInfos, eventNotification.dnPerfInfos) &&
				Objects.equals(this.disperInfos, eventNotification.disperInfos) &&
				Objects.equals(this.redTransInfos, eventNotification.redTransInfos) &&
				Objects.equals(this.wlanInfos, eventNotification.wlanInfos) &&
				Objects.equals(this.smccExps, eventNotification.smccExps);
	}

	@Override
	public int hashCode() {
		return Objects.hash(event, start, expiry, timeStampGen, failNotifyCode, rvWaitTime, anaMetaInfo,
				nfLoadLevelInfos, nsiLoadLevelInfos, sliceLoadLevelInfo, svcExps, qosSustainInfos, ueComms, ueMobs,
				userDataCongInfos, abnorBehavrs, nwPerfs, dnPerfInfos, disperInfos, redTransInfos, wlanInfos, smccExps);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EventNotification {\n");

		sb.append("    event: ").append(toIndentedString(event)).append("\n");
		sb.append("    start: ").append(toIndentedString(start)).append("\n");
		sb.append("    expiry: ").append(toIndentedString(expiry)).append("\n");
		sb.append("    timeStampGen: ").append(toIndentedString(timeStampGen)).append("\n");
		sb.append("    failNotifyCode: ").append(toIndentedString(failNotifyCode)).append("\n");
		sb.append("    rvWaitTime: ").append(toIndentedString(rvWaitTime)).append("\n");
		sb.append("    anaMetaInfo: ").append(toIndentedString(anaMetaInfo)).append("\n");
		sb.append("    nfLoadLevelInfos: ").append(toIndentedString(nfLoadLevelInfos)).append("\n");
		sb.append("    nsiLoadLevelInfos: ").append(toIndentedString(nsiLoadLevelInfos)).append("\n");
		sb.append("    sliceLoadLevelInfo: ").append(toIndentedString(sliceLoadLevelInfo)).append("\n");
		sb.append("    svcExps: ").append(toIndentedString(svcExps)).append("\n");
		sb.append("    qosSustainInfos: ").append(toIndentedString(qosSustainInfos)).append("\n");
		sb.append("    ueComms: ").append(toIndentedString(ueComms)).append("\n");
		sb.append("    ueMobs: ").append(toIndentedString(ueMobs)).append("\n");
		sb.append("    userDataCongInfos: ").append(toIndentedString(userDataCongInfos)).append("\n");
		sb.append("    abnorBehavrs: ").append(toIndentedString(abnorBehavrs)).append("\n");
		sb.append("    nwPerfs: ").append(toIndentedString(nwPerfs)).append("\n");
		sb.append("    dnPerfInfos: ").append(toIndentedString(dnPerfInfos)).append("\n");
		sb.append("    disperInfos: ").append(toIndentedString(disperInfos)).append("\n");
		sb.append("    redTransInfos: ").append(toIndentedString(redTransInfos)).append("\n");
		sb.append("    wlanInfos: ").append(toIndentedString(wlanInfos)).append("\n");
		sb.append("    smccExps: ").append(toIndentedString(smccExps)).append("\n");
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
