package io.nwdaf.eventsubscription.model;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Exactly one of cgi, sai or lai shall be present.
 */
@Schema(description = "Exactly one of cgi, sai or lai shall be present.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")


public class UtraLocation implements OneOfUtraLocation {
    @JsonProperty("cgi")
    private CellGlobalId cgi = null;

    @JsonProperty("sai")
    private ServiceAreaId sai = null;

    @JsonProperty("lai")
    private LocationAreaId lai = null;

    @JsonProperty("rai")
    private RoutingAreaId rai = null;

    @JsonProperty("ageOfLocationInformation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer ageOfLocationInformation
            = null;

    @JsonProperty("ueLocationTimestamp")
    private OffsetDateTime ueLocationTimestamp = null;

    @JsonProperty("geographicalInformation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String geographicalInformation
            = null;

    @JsonProperty("geodeticInformation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String geodeticInformation
            = null;

    @JsonProperty("cellLocation")
    private EllipsoidArc cellLocation = null;

    public UtraLocation cgi(CellGlobalId cgi) {
        this.cgi = cgi;
        return this;
    }

    /**
     * Get cgi
     *
     * @return cgi
     **/
    @Schema(description = "")

    @Valid
    public CellGlobalId getCgi() {
        return cgi;
    }

    public void setCgi(CellGlobalId cgi) {
        this.cgi = cgi;
    }

    public UtraLocation sai(ServiceAreaId sai) {
        this.sai = sai;
        return this;
    }

    /**
     * Get sai
     *
     * @return sai
     **/
    @Schema(description = "")

    @Valid
    public ServiceAreaId getSai() {
        return sai;
    }

    public void setSai(ServiceAreaId sai) {
        this.sai = sai;
    }

    public UtraLocation lai(LocationAreaId lai) {
        this.lai = lai;
        return this;
    }

    /**
     * Get lai
     *
     * @return lai
     **/
    @Schema(description = "")

    @Valid
    public LocationAreaId getLai() {
        return lai;
    }

    public void setLai(LocationAreaId lai) {
        this.lai = lai;
    }

    public UtraLocation rai(RoutingAreaId rai) {
        this.rai = rai;
        return this;
    }

    /**
     * Get rai
     *
     * @return rai
     **/
    @Schema(description = "")

    @Valid
    public RoutingAreaId getRai() {
        return rai;
    }

    public void setRai(RoutingAreaId rai) {
        this.rai = rai;
    }

    public UtraLocation ageOfLocationInformation(Integer ageOfLocationInformation) {
        this.ageOfLocationInformation = ageOfLocationInformation;
        return this;
    }

    /**
     * The value represents the elapsed time in minutes since the last network contact of the mobile station.  Value \"0\" indicates that the location information was obtained after a successful paging procedure for  Active Location Retrieval when the UE is in idle mode  or after a successful location reporting procedure  the UE is in connected mode. Any other value than \"0\" indicates that the location information is the last known one.  See 3GPP TS 29.002 clause 17.7.8.
     * minimum: 0
     * maximum: 32767
     *
     * @return ageOfLocationInformation
     **/
    @Schema(description = "The value represents the elapsed time in minutes since the last network contact of the mobile station.  Value \"0\" indicates that the location information was obtained after a successful paging procedure for  Active Location Retrieval when the UE is in idle mode  or after a successful location reporting procedure  the UE is in connected mode. Any other value than \"0\" indicates that the location information is the last known one.  See 3GPP TS 29.002 clause 17.7.8. ")

    @Min(0)
    @Max(32767)
    public Integer getAgeOfLocationInformation() {
        return ageOfLocationInformation;
    }

    public void setAgeOfLocationInformation(Integer ageOfLocationInformation) {
        this.ageOfLocationInformation = ageOfLocationInformation;
    }

    public UtraLocation ueLocationTimestamp(OffsetDateTime ueLocationTimestamp) {
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

    public UtraLocation geographicalInformation(String geographicalInformation) {
        this.geographicalInformation = geographicalInformation;
        return this;
    }

    /**
     * Refer to geographical Information.See 3GPP TS 23.032 clause 7.3.2. Only the description of an ellipsoid point with uncertainty circle is allowed to be used.
     *
     * @return geographicalInformation
     **/
    @Schema(description = "Refer to geographical Information.See 3GPP TS 23.032 clause 7.3.2. Only the description of an ellipsoid point with uncertainty circle is allowed to be used. ")

    @Pattern(regexp = "^[0-9A-F]{16}$")
    public String getGeographicalInformation() {
        return geographicalInformation;
    }

    public void setGeographicalInformation(String geographicalInformation) {
        this.geographicalInformation = geographicalInformation;
    }

    public UtraLocation geodeticInformation(String geodeticInformation) {
        this.geodeticInformation = geodeticInformation;
        return this;
    }

    /**
     * Refers to Calling Geodetic Location. See ITU-T Recommendation Q.763 (1999) clause 3.88.2. Only the description of an ellipsoid point with uncertainty circle is allowed to be used.
     *
     * @return geodeticInformation
     **/
    @Schema(description = "Refers to Calling Geodetic Location. See ITU-T Recommendation Q.763 (1999) clause 3.88.2. Only the description of an ellipsoid point with uncertainty circle is allowed to be used. ")

    @Pattern(regexp = "^[0-9A-F]{20}$")
    public String getGeodeticInformation() {
        return geodeticInformation;
    }

    public void setGeodeticInformation(String geodeticInformation) {
        this.geodeticInformation = geodeticInformation;
    }

    public UtraLocation cellLocation(EllipsoidArc cellLocation) {
        this.cellLocation = cellLocation;
        return this;
    }

    /**
     * Get cellLocation
     *
     * @return cellLocation
     **/
    @Schema(description = "")

    @Valid
    public EllipsoidArc getCellLocation() {
        return cellLocation;
    }

    public void setCellLocation(EllipsoidArc cellLocation) {
        this.cellLocation = cellLocation;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UtraLocation utraLocation = (UtraLocation) o;
        return Objects.equals(this.cgi, utraLocation.cgi) &&
                Objects.equals(this.sai, utraLocation.sai) &&
                Objects.equals(this.lai, utraLocation.lai) &&
                Objects.equals(this.rai, utraLocation.rai) &&
                Objects.equals(this.ageOfLocationInformation, utraLocation.ageOfLocationInformation) &&
                Objects.equals(this.ueLocationTimestamp, utraLocation.ueLocationTimestamp) &&
                Objects.equals(this.geographicalInformation, utraLocation.geographicalInformation) &&
                Objects.equals(this.geodeticInformation, utraLocation.geodeticInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cgi, sai, lai, rai, ageOfLocationInformation, ueLocationTimestamp, geographicalInformation, geodeticInformation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UtraLocation {\n");

        sb.append("    cgi: ").append(toIndentedString(cgi)).append("\n");
        sb.append("    sai: ").append(toIndentedString(sai)).append("\n");
        sb.append("    lai: ").append(toIndentedString(lai)).append("\n");
        sb.append("    rai: ").append(toIndentedString(rai)).append("\n");
        sb.append("    ageOfLocationInformation: ").append(toIndentedString(ageOfLocationInformation)).append("\n");
        sb.append("    ueLocationTimestamp: ").append(toIndentedString(ueLocationTimestamp)).append("\n");
        sb.append("    geographicalInformation: ").append(toIndentedString(geographicalInformation)).append("\n");
        sb.append("    geodeticInformation: ").append(toIndentedString(geodeticInformation)).append("\n");
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
        if (this.cgi != null) {
            map.put("cgi", this.cgi.toMap());
        }
        if (this.lai != null) {
            map.put("lai", this.lai.toMap());
        }
        if (this.rai != null) {
            map.put("rai", this.rai.toMap());
        }
        if (this.sai != null) {
            map.put("sai", this.sai.toMap());
        }
        map.put("ueLocationTimestamp", ConvertUtil.convertOffsetDateTimeToDouble(this.ueLocationTimestamp));
        map.put("ageOfLocationInformation", this.ageOfLocationInformation);
        map.put("geodeticInformation", this.geodeticInformation);
        map.put("geographicalInformation", this.geographicalInformation);
        if (this.cellLocation != null) {
            map.put("cellLocation", this.cellLocation.toMap());
        }
        return map;
    }

    public static UtraLocation fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        UtraLocation result = new UtraLocation();
        result.setAgeOfLocationInformation((Integer) map.get("ageOfLocationInformation"));
        result.setCgi(CellGlobalId.fromMap((Map<String, Object>) map.get("cgi")));
        result.setRai(RoutingAreaId.fromMap((Map<String, Object>) map.get("rai")));
        result.setLai(LocationAreaId.fromMap((Map<String, Object>) map.get("lai")));
        result.setSai(ServiceAreaId.fromMap((Map<String, Object>) map.get("sai")));
        result.setGeodeticInformation((String) map.get("geodeticInformation"));
        result.setGeographicalInformation((String) map.get("geographicalInformation"));
        result.setUeLocationTimestamp(ConvertUtil.convertDoubleToOffSetDateTime((Double) map.get("ueLocationTimestamp")));
        result.setCellLocation(EllipsoidArc.fromMap((Map<String, Object>) map.get("cellLocation")));
        return result;
    }
}
