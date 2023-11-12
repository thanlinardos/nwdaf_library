package io.nwdaf.eventsubscription.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.nwdaf.eventsubscription.utilities.Regex;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Identifies an AVP Ip filter rule. (clause 5.3.8 of 3GPP TS 29.214 [20] and clause 4.3 of
 * IETF RFC 6733 [52])
 */
@Schema(description = "Identifies an AVP Ip filter rule (clause 5.3.8 of 3GPP TS 29.214 [20] and clause 4.3 of IETF RFC 6733 [52])")
@Validated
@Getter
@Setter
@Builder
public class IpFilterRule {
    @JsonProperty("code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer code;

    @JsonProperty("vendorId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer vendorId;

    @JsonProperty("ipVersion")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Pattern(regexp = Regex.ipVersion)
    private String ipVersion;

    @JsonProperty("sourceIpAddr")
    private IpAddr sourceIpAddr;

    @JsonProperty("sourceIpAddrMask")
    private IpAddr sourceIpAddrMask;

    @JsonProperty("destIpAddr")
    private IpAddr destIpAddr;

    @JsonProperty("destIpAddrMask")
    private IpAddr destIpAddrMask;

    @JsonProperty("transportProtocol")
    private TransportProtocol transportProtocol;

    @JsonProperty("sourcePort")
    private Integer sourcePort;

    @JsonProperty("destinationPort")
    private Integer destinationPort;

    @JsonProperty("direction")
    private FlowDirection direction;

    public String toAvp() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPFilterRule AVP:");
        sb.append("\nCode: ").append(this.code);
        sb.append("\nVendor ID: ").append(this.vendorId);
        sb.append("\nIP Version: ").append(this.ipVersion);
        sb.append("\nIP Source Address: ");
        if (this.sourceIpAddr != null && this.ipVersion != null) {
            sb.append(this.ipVersion.equals("4") ? this.sourceIpAddr.getIpv4Addr() : this.sourceIpAddr.getIpv6Addr());
        }
        sb.append("\nIP Source Mask: ");
        if (this.sourceIpAddrMask != null && this.ipVersion != null) {
            sb.append(this.ipVersion.equals("4") ? this.sourceIpAddrMask.getIpv4Addr() : this.sourceIpAddrMask.getIpv6Addr());
        }
        sb.append("\nIP Destination Address: ");
        if (this.destIpAddr != null && this.ipVersion != null) {
            sb.append(this.ipVersion.equals("4") ? this.destIpAddr.getIpv4Addr() : this.destIpAddr.getIpv6Addr());
        }
        sb.append("\nIP Destination Mask: ");
        if (this.destIpAddrMask != null && this.ipVersion != null) {
            sb.append(this.ipVersion.equals("4") ? this.destIpAddrMask.getIpv4Addr() : this.destIpAddrMask.getIpv6Addr());
        }
        sb.append("\nProtocol: ");
        if (this.transportProtocol != null && this.transportProtocol.getTransportProtocol() != null) {
            sb.append(this.transportProtocol.getTransportProtocol().toString());
        }
        sb.append("\nSource Port: ").append(this.sourcePort);
        sb.append("\nDestination Port: ").append(this.destinationPort);
        if (this.direction != null) {
            sb.append("\nDirection: ").append(this.direction.getFDir());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IpFilterRule ipFilterRule = (IpFilterRule) o;
        return Objects.equals(this.code, ipFilterRule.code) &&
                Objects.equals(this.vendorId, ipFilterRule.vendorId) &&
                Objects.equals(this.ipVersion, ipFilterRule.ipVersion) &&
                Objects.equals(this.sourceIpAddr, ipFilterRule.sourceIpAddr) &&
                Objects.equals(this.sourceIpAddrMask, ipFilterRule.sourceIpAddrMask) &&
                Objects.equals(this.destIpAddr, ipFilterRule.destIpAddr) &&
                Objects.equals(this.destIpAddrMask, ipFilterRule.destIpAddrMask) &&
                Objects.equals(this.transportProtocol, ipFilterRule.transportProtocol) &&
                Objects.equals(this.sourcePort, ipFilterRule.sourcePort) &&
                Objects.equals(this.destinationPort, ipFilterRule.destinationPort) &&
                Objects.equals(this.direction, ipFilterRule.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, vendorId, ipVersion, sourceIpAddr, sourceIpAddrMask, destIpAddr, destIpAddrMask, transportProtocol, sourcePort, destinationPort, direction);
    }

    @Override
    public String toString() {

        return "class IpFilterRule {\n" +
                "    code: " + toIndentedString(code) + "\n" +
                "    vendorId: " + toIndentedString(vendorId) + "\n" +
                "    ipVersion: " + toIndentedString(ipVersion) + "\n" +
                "    sourceIpAddr: " + toIndentedString(sourceIpAddr) + "\n" +
                "    sourceIpAddrMask: " + toIndentedString(sourceIpAddrMask) + "\n" +
                "    destIpAddr: " + toIndentedString(destIpAddr) + "\n" +
                "    destIpAddrMask: " + toIndentedString(destIpAddrMask) + "\n" +
                "    transportProtocol: " + toIndentedString(transportProtocol) + "\n" +
                "    sourcePort: " + toIndentedString(sourcePort) + "\n" +
                "    destinationPort: " + toIndentedString(destinationPort) + "\n" +
                "    direction: " + toIndentedString(direction) + "\n" +
                "}";
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
