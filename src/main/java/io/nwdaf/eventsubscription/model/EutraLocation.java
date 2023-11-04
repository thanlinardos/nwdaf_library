package io.nwdaf.eventsubscription.model;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains the E-UTRA user location.
 */
@Schema(description = "Contains the E-UTRA user location.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class EutraLocation {
	@JsonProperty("tai")
	private Tai tai = null;

	@JsonProperty("ignoreTai")
	private Boolean ignoreTai = false;

	@JsonProperty("ecgi")
	private Ecgi ecgi = null;

	@JsonProperty("ignoreEcgi")
	private Boolean ignoreEcgi = false;

	@JsonProperty("ageOfLocationInformation")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer ageOfLocationInformation = null;

	@JsonProperty("ueLocationTimestamp")
	private OffsetDateTime ueLocationTimestamp = null;

	@JsonProperty("geographicalInformation")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String geographicalInformation = null;

	@JsonProperty("geodeticInformation")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String geodeticInformation = null;

	@JsonProperty("globalNgenbId")
	private GlobalRanNodeId globalNgenbId = null;

	@JsonProperty("globalENbId")
	private GlobalRanNodeId globalENbId = null;

	public EutraLocation tai(Tai tai) {
		this.tai = tai;
		return this;
	}

	/**
	 * Get tai
	 * 
	 * @return tai
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Tai getTai() {
		return tai;
	}

	public void setTai(Tai tai) {
		this.tai = tai;
	}

	public EutraLocation ignoreTai(Boolean ignoreTai) {
		this.ignoreTai = ignoreTai;
		return this;
	}

	/**
	 * Get ignoreTai
	 * 
	 * @return ignoreTai
	 **/
	@Schema(description = "")

	public Boolean isIgnoreTai() {
		return ignoreTai;
	}

	public void setIgnoreTai(Boolean ignoreTai) {
		this.ignoreTai = ignoreTai;
	}

	public EutraLocation ecgi(Ecgi ecgi) {
		this.ecgi = ecgi;
		return this;
	}

	/**
	 * Get ecgi
	 * 
	 * @return ecgi
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Ecgi getEcgi() {
		return ecgi;
	}

	public void setEcgi(Ecgi ecgi) {
		this.ecgi = ecgi;
	}

	public EutraLocation ignoreEcgi(Boolean ignoreEcgi) {
		this.ignoreEcgi = ignoreEcgi;
		return this;
	}

	/**
	 * This flag when present shall indicate that the Ecgi shall be ignored When
	 * present, it shall be set as follows: - true: ecgi shall be ignored. - false
	 * (default): ecgi shall not be ignored.
	 * 
	 * @return ignoreEcgi
	 **/
	@Schema(description = "This flag when present shall indicate that the Ecgi shall be ignored When present, it shall be set as follows: - true: ecgi shall be ignored. - false (default): ecgi shall not be ignored. ")

	public Boolean isIgnoreEcgi() {
		return ignoreEcgi;
	}

	public void setIgnoreEcgi(Boolean ignoreEcgi) {
		this.ignoreEcgi = ignoreEcgi;
	}

	public EutraLocation ageOfLocationInformation(Integer ageOfLocationInformation) {
		this.ageOfLocationInformation = ageOfLocationInformation;
		return this;
	}

	/**
	 * The value represents the elapsed time in minutes since the last network
	 * contact of the mobile station. Value \"0\" indicates that the location
	 * information was obtained after a successful paging procedure for Active
	 * Location Retrieval when the UE is in idle mode or after a successful NG-RAN
	 * location reporting procedure with the eNB when the UE is in connected mode.
	 * Any other value than \"0\" indicates that the location information is the
	 * last known one. See 3GPP TS 29.002 clause 17.7.8.
	 * minimum: 0
	 * maximum: 32767
	 * 
	 * @return ageOfLocationInformation
	 **/
	@Schema(description = "The value represents the elapsed time in minutes since the last network contact of the mobile station.  Value \"0\" indicates that the location information was obtained after a successful paging procedure for Active Location Retrieval when the UE is in idle mode or after a successful NG-RAN location reporting procedure with the eNB when the UE is in connected mode.  Any other value than \"0\" indicates that the location information is the last known one.  See 3GPP TS 29.002 clause 17.7.8. ")

	@Min(0)
	@Max(32767)
	public Integer getAgeOfLocationInformation() {
		return ageOfLocationInformation;
	}

	public void setAgeOfLocationInformation(Integer ageOfLocationInformation) {
		this.ageOfLocationInformation = ageOfLocationInformation;
	}

	public EutraLocation ueLocationTimestamp(OffsetDateTime ueLocationTimestamp) {
		this.ueLocationTimestamp = ueLocationTimestamp;
		return this;
	}

	/**
	 * string with format 'date-time' as defined in OpenAPI.
	 * 
	 * @return ueLocationTimestamp
	 **/
	@Schema(description = "string with format 'date-time' as defined in OpenAPI.")

	@Valid
	public OffsetDateTime getUeLocationTimestamp() {
		return ueLocationTimestamp;
	}

	public void setUeLocationTimestamp(OffsetDateTime ueLocationTimestamp) {
		this.ueLocationTimestamp = ueLocationTimestamp;
	}

	public EutraLocation geographicalInformation(String geographicalInformation) {
		this.geographicalInformation = geographicalInformation;
		return this;
	}

	/**
	 * Refer to geographical Information. See 3GPP TS 23.032 clause 7.3.2. Only the
	 * description of an ellipsoid point with uncertainty circle is allowed to be
	 * used.
	 * 
	 * @return geographicalInformation
	 **/
	@Schema(description = "Refer to geographical Information. See 3GPP TS 23.032 clause 7.3.2. Only the description of an ellipsoid point with uncertainty circle is allowed to be used. ")

	@Pattern(regexp = "^[0-9A-F]{16}$")
	public String getGeographicalInformation() {
		return geographicalInformation;
	}

	public void setGeographicalInformation(String geographicalInformation) {
		this.geographicalInformation = geographicalInformation;
	}

	public EutraLocation geodeticInformation(String geodeticInformation) {
		this.geodeticInformation = geodeticInformation;
		return this;
	}

	/**
	 * Refers to Calling Geodetic Location. See ITU-T Recommendation Q.763 (1999)
	 * [24] clause 3.88.2. Only the description of an ellipsoid point with
	 * uncertainty circle is allowed to be used.
	 * 
	 * @return geodeticInformation
	 **/
	@Schema(description = "Refers to Calling Geodetic Location. See ITU-T Recommendation Q.763 (1999) [24] clause 3.88.2. Only the description of an ellipsoid point with uncertainty circle is allowed to be used. ")

	@Pattern(regexp = "^[0-9A-F]{20}$")
	public String getGeodeticInformation() {
		return geodeticInformation;
	}

	public void setGeodeticInformation(String geodeticInformation) {
		this.geodeticInformation = geodeticInformation;
	}

	public EutraLocation globalNgenbId(GlobalRanNodeId globalNgenbId) {
		this.globalNgenbId = globalNgenbId;
		return this;
	}

	/**
	 * Get globalNgenbId
	 * 
	 * @return globalNgenbId
	 **/
	@Schema(description = "")

	@Valid
	public GlobalRanNodeId getGlobalNgenbId() {
		return globalNgenbId;
	}

	public void setGlobalNgenbId(GlobalRanNodeId globalNgenbId) {
		this.globalNgenbId = globalNgenbId;
	}

	public EutraLocation globalENbId(GlobalRanNodeId globalENbId) {
		this.globalENbId = globalENbId;
		return this;
	}

	/**
	 * Get globalENbId
	 * 
	 * @return globalENbId
	 **/
	@Schema(description = "")

	@Valid
	public GlobalRanNodeId getGlobalENbId() {
		return globalENbId;
	}

	public void setGlobalENbId(GlobalRanNodeId globalENbId) {
		this.globalENbId = globalENbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EutraLocation eutraLocation = (EutraLocation) o;
		return Objects.equals(this.tai, eutraLocation.tai) &&
				Objects.equals(this.ignoreTai, eutraLocation.ignoreTai) &&
				Objects.equals(this.ecgi, eutraLocation.ecgi) &&
				Objects.equals(this.ignoreEcgi, eutraLocation.ignoreEcgi) &&
				Objects.equals(this.ageOfLocationInformation, eutraLocation.ageOfLocationInformation) &&
				Objects.equals(this.ueLocationTimestamp, eutraLocation.ueLocationTimestamp) &&
				Objects.equals(this.geographicalInformation, eutraLocation.geographicalInformation) &&
				Objects.equals(this.geodeticInformation, eutraLocation.geodeticInformation) &&
				Objects.equals(this.globalNgenbId, eutraLocation.globalNgenbId) &&
				Objects.equals(this.globalENbId, eutraLocation.globalENbId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tai, ignoreTai, ecgi, ignoreEcgi, ageOfLocationInformation, ueLocationTimestamp,
				geographicalInformation, geodeticInformation, globalNgenbId, globalENbId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EutraLocation {\n");

		sb.append("    tai: ").append(toIndentedString(tai)).append("\n");
		sb.append("    ignoreTai: ").append(toIndentedString(ignoreTai)).append("\n");
		sb.append("    ecgi: ").append(toIndentedString(ecgi)).append("\n");
		sb.append("    ignoreEcgi: ").append(toIndentedString(ignoreEcgi)).append("\n");
		sb.append("    ageOfLocationInformation: ").append(toIndentedString(ageOfLocationInformation)).append("\n");
		sb.append("    ueLocationTimestamp: ").append(toIndentedString(ueLocationTimestamp)).append("\n");
		sb.append("    geographicalInformation: ").append(toIndentedString(geographicalInformation)).append("\n");
		sb.append("    geodeticInformation: ").append(toIndentedString(geodeticInformation)).append("\n");
		sb.append("    globalNgenbId: ").append(toIndentedString(globalNgenbId)).append("\n");
		sb.append("    globalENbId: ").append(toIndentedString(globalENbId)).append("\n");
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
		if (this.ecgi != null) {
			map.put("ecgi", this.ecgi.toMap());
		}
		if (this.globalENbId != null) {
			map.put("globalENbId", this.globalENbId.toMap());
		}
		if (this.globalNgenbId != null) {
			map.put("globalNgenbId", this.globalNgenbId.toMap());
		}
		if (this.tai != null) {
			map.put("tai", this.tai.toMap());
		}
		map.put("ueLocationTimestamp", ConvertUtil.convertOffsetDateTimeToDouble(this.ueLocationTimestamp));
		map.put("ageOfLocationInformation", this.ageOfLocationInformation);
		map.put("geodeticInformation", this.geodeticInformation);
		map.put("geographicalInformation", this.geographicalInformation);
		map.put("ignoreEcgi", this.ignoreEcgi);
		map.put("ignoreTai", this.ignoreTai);
		return map;
	}

	public static EutraLocation fromMap(Map<String, Object> map) {
		if(map==null) {
			return null;
		}
		EutraLocation result = new EutraLocation();
		result.setAgeOfLocationInformation((Integer) map.get("ageOfLocationInformation"));
		result.setEcgi(Ecgi.fromMap((Map<String, Object>)map.get("ecgi")));
		result.setGeodeticInformation((String) map.get("geodeticInformation"));
		result.setGeographicalInformation((String) map.get("geographicalInformation"));
		result.setGlobalENbId(GlobalRanNodeId.fromMap((Map<String, Object>) map.get("globalENbId")));
		result.setGlobalNgenbId(GlobalRanNodeId.fromMap((Map<String, Object>) map.get("globalNgenbId")));
		result.setIgnoreEcgi((Boolean) map.get("ignoreEcgi"));
		result.setIgnoreTai((Boolean) map.get("ignoreTai"));
		result.setTai(Tai.fromMap((Map<String,Object>) map.get("tai")));
		result.setUeLocationTimestamp(ConvertUtil.convertDoubleToOffSetDateTime((Double) map.get("ueLocationTimestamp")));
		return result;
	}
}
