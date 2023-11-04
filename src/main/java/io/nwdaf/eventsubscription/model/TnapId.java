package io.nwdaf.eventsubscription.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contain the TNAP Identifier see clause5.6.2 of 3GPP TS 23.501.
 */
@Schema(description = "Contain the TNAP Identifier see clause5.6.2 of 3GPP TS 23.501.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")


public class TnapId   {
  @JsonProperty("ssId")
  @JsonInclude(JsonInclude.Include.NON_NULL)
private String ssId
 = null;

  @JsonProperty("bssId")
  @JsonInclude(JsonInclude.Include.NON_NULL)
private String bssId
 = null;

  @JsonProperty("civicAddress")
  @Schema(type = "string", format = "byte",description = "string with format 'bytes' as defined in OpenAPI")
  private byte[] civicAddress = null;

  public TnapId ssId(String ssId) {
    this.ssId = ssId;
    return this;
  }

  /**
   * This IE shall be present if the UE is accessing the 5GC via a trusted WLAN access network.When present, it shall contain the SSID of the access point to which the UE is attached, that is received over NGAP,  see IEEE Std 802.11-2012.  
   * @return ssId
   **/
  @Schema(description = "This IE shall be present if the UE is accessing the 5GC via a trusted WLAN access network.When present, it shall contain the SSID of the access point to which the UE is attached, that is received over NGAP,  see IEEE Std 802.11-2012.  ")
  
    public String getSsId() {
    return ssId;
  }

  public void setSsId(String ssId) {
    this.ssId = ssId;
  }

  public TnapId bssId(String bssId) {
    this.bssId = bssId;
    return this;
  }

  /**
   * When present, it shall contain the BSSID of the access point to which the UE is attached, that is received over NGAP, see IEEE Std 802.11-2012.  
   * @return bssId
   **/
  @Schema(description = "When present, it shall contain the BSSID of the access point to which the UE is attached, that is received over NGAP, see IEEE Std 802.11-2012.  ")
  
    public String getBssId() {
    return bssId;
  }

  public void setBssId(String bssId) {
    this.bssId = bssId;
  }

  public TnapId civicAddress(String civicAddressString) {
    this.civicAddress = Base64.decodeBase64(civicAddressString);
    return this;
  }

  /**
   * string with format 'bytes' as defined in OpenAPI
   * @return civicAddress
   **/
  
    public byte[] getCivicAddress() {
    return civicAddress;
  }

  public void setCivicAddress(String civicAddressString) {
    this.civicAddress = Base64.decodeBase64(civicAddressString);
  }

  public void setCivicAddressRaw(byte[] civicAddress) {
    this.civicAddress = civicAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TnapId tnapId = (TnapId) o;
    return Objects.equals(this.ssId, tnapId.ssId) &&
        Objects.equals(this.bssId, tnapId.bssId) &&
        Objects.equals(this.civicAddress, tnapId.civicAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ssId, bssId, civicAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TnapId {\n");
    
    sb.append("    ssId: ").append(toIndentedString(ssId)).append("\n");
    sb.append("    bssId: ").append(toIndentedString(bssId)).append("\n");
    sb.append("    civicAddress: ").append(toIndentedString(civicAddress)).append("\n");
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
		map.put("bssId",this.bssId);
    map.put("ssId",this.ssId);
    map.put("civicAddress", this.civicAddress);
		return map;
	}

	public static TnapId fromMap(Map<String, Object> map) {
		if(map==null) {
			return null;
		}
		TnapId result = new TnapId();
		result.setBssId((String) map.get("bssId"));
    result.setSsId((String) map.get("ssId"));
    result.setCivicAddressRaw((byte[]) map.get("civicAddress"));
		return result;
	}
}
