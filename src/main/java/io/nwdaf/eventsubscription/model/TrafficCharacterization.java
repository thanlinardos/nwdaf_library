package io.nwdaf.eventsubscription.model;

import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.nwdaf.eventsubscription.utilities.Regex;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Identifies the detailed traffic characterization.
 */
@Schema(description = "Identifies the detailed traffic characterization.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")


public class TrafficCharacterization implements AnyOfTrafficCharacterization {
    @JsonProperty("dnn")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dnn
            = null;

    @JsonProperty("snssai")
    private Snssai snssai = null;

    @JsonProperty("appId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String appId = null;

    @JsonProperty("fDescs")
    @Valid
    private List<IpEthFlowDescription> fDescs = null;

    @JsonProperty("ulVol")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer ulVol = null;

    @JsonProperty("ulVolVariance")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double ulVolVariance = null;

    @JsonProperty("dlVol")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer dlVol = null;

    @JsonProperty("dlVolVariance")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double dlVolVariance = null;

    public TrafficCharacterization dnn(String dnn) {
        this.dnn = dnn;
        return this;
    }

    /**
     * String representing a Data Network as defined in clause 9A of 3GPP TS 23.003;  it shall contain either a DNN Network Identifier, or a full DNN with both the Network  Identifier and Operator Identifier, as specified in 3GPP TS 23.003 clause 9.1.1 and 9.1.2. It shall be coded as string in which the labels are separated by dots  (e.g. \"Label1.Label2.Label3\").
     *
     * @return dnn
     **/
    @Schema(description = "String representing a Data Network as defined in clause 9A of 3GPP TS 23.003;  it shall contain either a DNN Network Identifier, or a full DNN with both the Network  Identifier and Operator Identifier, as specified in 3GPP TS 23.003 clause 9.1.1 and 9.1.2. It shall be coded as string in which the labels are separated by dots  (e.g. \"Label1.Label2.Label3\"). ")
    @Pattern(regexp = Regex.dnn)
    public String getDnn() {
        return dnn;
    }

    public void setDnn(String dnn) {
        this.dnn = dnn;
    }

    public TrafficCharacterization snssai(Snssai snssai) {
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

    public TrafficCharacterization appId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * String providing an application identifier.
     *
     * @return appId
     **/
    @Schema(description = "String providing an application identifier.")

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public TrafficCharacterization fDescs(List<IpEthFlowDescription> fDescs) {
        this.fDescs = fDescs;
        return this;
    }

    public TrafficCharacterization addFDescsItem(IpEthFlowDescription fDescsItem) {
        if (this.fDescs == null) {
            this.fDescs = new ArrayList<IpEthFlowDescription>();
        }
        this.fDescs.add(fDescsItem);
        return this;
    }

    /**
     * Get fDescs
     *
     * @return fDescs
     **/
    @Schema(description = "")
    @Valid
    @Size(min = 1, max = 2)
    public List<IpEthFlowDescription> getFDescs() {
        return fDescs;
    }

    public void setFDescs(List<IpEthFlowDescription> fDescs) {
        this.fDescs = fDescs;
    }

    public TrafficCharacterization ulVol(Integer ulVol) {
        this.ulVol = ulVol;
        return this;
    }

    /**
     * Unsigned integer identifying a volume in units of bytes.
     * minimum: 0
     *
     * @return ulVol
     **/
    @Schema(description = "Unsigned integer identifying a volume in units of bytes.")

    public Integer getUlVol() {
        return ulVol;
    }

    public void setUlVol(Integer ulVol) {
        this.ulVol = ulVol;
    }

    public TrafficCharacterization ulVolVariance(Double ulVolVariance) {
        this.ulVolVariance = ulVolVariance;
        return this;
    }

    /**
     * string with format 'float' as defined in OpenAPI.
     *
     * @return ulVolVariance
     **/
    @Schema(description = "string with format 'float' as defined in OpenAPI.")

    public Double getUlVolVariance() {
        return ulVolVariance;
    }

    public void setUlVolVariance(Double ulVolVariance) {
        this.ulVolVariance = ulVolVariance;
    }

    public TrafficCharacterization dlVol(Integer dlVol) {
        this.dlVol = dlVol;
        return this;
    }

    /**
     * Unsigned integer identifying a volume in units of bytes.
     * minimum: 0
     *
     * @return dlVol
     **/
    @Schema(description = "Unsigned integer identifying a volume in units of bytes.")

    public Integer getDlVol() {
        return dlVol;
    }

    public void setDlVol(Integer dlVol) {
        this.dlVol = dlVol;
    }

    public TrafficCharacterization dlVolVariance(Double dlVolVariance) {
        this.dlVolVariance = dlVolVariance;
        return this;
    }

    /**
     * string with format 'float' as defined in OpenAPI.
     *
     * @return dlVolVariance
     **/
    @Schema(description = "string with format 'float' as defined in OpenAPI.")

    public Double getDlVolVariance() {
        return dlVolVariance;
    }

    public void setDlVolVariance(Double dlVolVariance) {
        this.dlVolVariance = dlVolVariance;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TrafficCharacterization trafficCharacterization = (TrafficCharacterization) o;
        return Objects.equals(this.dnn, trafficCharacterization.dnn) &&
                Objects.equals(this.snssai, trafficCharacterization.snssai) &&
                Objects.equals(this.appId, trafficCharacterization.appId) &&
                Objects.equals(this.fDescs, trafficCharacterization.fDescs) &&
                Objects.equals(this.ulVol, trafficCharacterization.ulVol) &&
                Objects.equals(this.ulVolVariance, trafficCharacterization.ulVolVariance) &&
                Objects.equals(this.dlVol, trafficCharacterization.dlVol) &&
                Objects.equals(this.dlVolVariance, trafficCharacterization.dlVolVariance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dnn, snssai, appId, fDescs, ulVol, ulVolVariance, dlVol, dlVolVariance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TrafficCharacterization {\n");

        sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
        sb.append("    snssai: ").append(toIndentedString(snssai)).append("\n");
        sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
        sb.append("    fDescs: ").append(toIndentedString(fDescs)).append("\n");
        sb.append("    ulVol: ").append(toIndentedString(ulVol)).append("\n");
        sb.append("    ulVolVariance: ").append(toIndentedString(ulVolVariance)).append("\n");
        sb.append("    dlVol: ").append(toIndentedString(dlVol)).append("\n");
        sb.append("    dlVolVariance: ").append(toIndentedString(dlVolVariance)).append("\n");
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
        map.put("dnn", this.dnn);
        map.put("appId", this.appId);
        map.put("ulVol", this.ulVol);
        map.put("ulVolVariance", this.ulVolVariance);
        map.put("dlVol", this.dlVol);
        map.put("dlVolVariance", this.dlVolVariance);
        if (this.snssai != null) {
            map.put("snssai",this.snssai.toMap());
        }
        List<Map<String, Object>> fDescsMapList = new ArrayList<>();
        if (this.fDescs != null) {
            for (int i = 0; i < this.fDescs.size(); i++) {
                if (this.fDescs.get(i) != null) {
                    fDescsMapList.add(this.fDescs.get(i).toMap());
                }
            }
        }
        map.put("fDescs",fDescsMapList);
        return map;
    }

    public static TrafficCharacterization fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        TrafficCharacterization result = new TrafficCharacterization();
        result.setDnn((String) map.get("dnn"));
        result.setAppId((String) map.get("appId"));
        result.setUlVol((Integer) map.get("ulVol"));
        result.setDlVol((Integer) map.get("dlVol"));
        result.setUlVolVariance((Double) map.get("ulVolVariance"));
        result.setDlVolVariance((Double) map.get("dlVolVariance"));
        result.setSnssai(Snssai.fromMap((Map<String, Object>) map.get("snssai")));
        List<Map<String, Object>> fDescs = (List<Map<String, Object>>) map.get("fDescs");
        for (Map<String, Object> fDesc : fDescs) {
            result.addFDescsItem(IpEthFlowDescription.fromMap(fDesc));
        }
        return result;
    }
}
