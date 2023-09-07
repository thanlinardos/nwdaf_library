package io.nwdaf.eventsubscription.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the ID/address/FQDN of the UPF.
 */
@Schema(description = "Represents the ID/address/FQDN of the UPF.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")


public class UpfInformation   {
  @JsonProperty("upfId")
  @JsonInclude(JsonInclude.Include.NON_NULL)
private String upfId
 = null;

  @JsonProperty("upfAddr")
  private AddrFqdn upfAddr = null;

  public UpfInformation upfId(String upfId) {
    this.upfId = upfId;
    return this;
  }

  /**
   * Get upfId
   * @return upfId
   **/
  @Schema(description = "")
  
    public String getUpfId() {
    return upfId;
  }

  public void setUpfId(String upfId) {
    this.upfId = upfId;
  }

  public UpfInformation upfAddr(AddrFqdn upfAddr) {
    this.upfAddr = upfAddr;
    return this;
  }

  /**
   * Get upfAddr
   * @return upfAddr
   **/
  @Schema(description = "")
  
    @Valid
    public AddrFqdn getUpfAddr() {
    return upfAddr;
  }

  public void setUpfAddr(AddrFqdn upfAddr) {
    this.upfAddr = upfAddr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpfInformation upfInformation = (UpfInformation) o;
    return Objects.equals(this.upfId, upfInformation.upfId) &&
        Objects.equals(this.upfAddr, upfInformation.upfAddr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(upfId, upfAddr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpfInformation {\n");
    
    sb.append("    upfId: ").append(toIndentedString(upfId)).append("\n");
    sb.append("    upfAddr: ").append(toIndentedString(upfAddr)).append("\n");
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
