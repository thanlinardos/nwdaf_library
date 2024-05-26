package io.nwdaf.eventsubscription.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains the Non-3GPP access user location.
 */
@Schema(description = "Contains the Non-3GPP access user location.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class N3gaLocation {
	@JsonProperty("n3gppTai")
	private Tai n3gppTai = null;

	@JsonProperty("n3IwfId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String n3IwfId = null;

	@JsonProperty("ueIpv4Addr")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ueIpv4Addr = null;

	@JsonProperty("ueIpv6Addr")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ueIpv6Addr = null;

	@JsonProperty("portNumber")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer portNumber = null;

	@JsonProperty("protocol")
	private TransportProtocol protocol = null;

	@JsonProperty("tnapId")
	private TnapId tnapId = null;

	@JsonProperty("twapId")
	private TwapId twapId = null;

	@JsonProperty("hfcNodeId")
	private HfcNodeId hfcNodeId = null;

	@JsonProperty("gli")
	private Gli gli = null;

	@JsonProperty("w5gbanLineType")
	private LineType w5gbanLineType = null;

	@JsonProperty("gci")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String gci = null;

	@JsonProperty("cellLocation")
	private EllipsoidArc cellLocation = null;

	public N3gaLocation n3gppTai(Tai n3gppTai) {
		this.n3gppTai = n3gppTai;
		return this;
	}

	/**
	 * Get n3gppTai
	 * 
	 * @return n3gppTai
	 **/
	@Schema(description = "")

	@Valid
	public Tai getN3gppTai() {
		return n3gppTai;
	}

	public void setN3gppTai(Tai n3gppTai) {
		this.n3gppTai = n3gppTai;
	}

	public N3gaLocation n3IwfId(String n3IwfId) {
		this.n3IwfId = n3IwfId;
		return this;
	}

	/**
	 * This IE shall contain the N3IWF identifier received over NGAP and shall be
	 * encoded as a string of hexadecimal characters. Each character in the string
	 * shall take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and
	 * shall represent 4 bits. The most significant character representing the 4
	 * most significant bits of the N3IWF ID shall appear first in the string, and
	 * the character representing the 4 least significant bit of the N3IWF ID shall
	 * appear last in the string.
	 * 
	 * @return n3IwfId
	 **/
	@Schema(description = "This IE shall contain the N3IWF identifier received over NGAP and shall be encoded as a  string of hexadecimal characters. Each character in the string shall take a value of \"0\"  to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4 bits. The most significant  character representing the 4 most significant bits of the N3IWF ID shall appear first in  the string, and the character representing the 4 least significant bit of the N3IWF ID  shall appear last in the string.  ")

	@Pattern(regexp = "^[A-Fa-f0-9]+$")
	public String getN3IwfId() {
		return n3IwfId;
	}

	public void setN3IwfId(String n3IwfId) {
		this.n3IwfId = n3IwfId;
	}

	public N3gaLocation ueIpv4Addr(String ueIpv4Addr) {
		this.ueIpv4Addr = ueIpv4Addr;
		return this;
	}

	/**
	 * String identifying a IPv4 address formatted in the 'dotted decimal' notation
	 * as defined in RFC 1166.
	 * 
	 * @return ueIpv4Addr
	 **/
	@Schema(example = "198.51.100.1", description = "String identifying a IPv4 address formatted in the 'dotted decimal' notation as defined in RFC 1166. ")

	@Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$")
	public String getUeIpv4Addr() {
		return ueIpv4Addr;
	}

	public void setUeIpv4Addr(String ueIpv4Addr) {
		this.ueIpv4Addr = ueIpv4Addr;
	}

	public N3gaLocation ueIpv6Addr(String ueIpv6Addr) {
		this.ueIpv6Addr = ueIpv6Addr;
		return this;
	}

	/**
	 * Get ueIpv6Addr
	 * 
	 * @return ueIpv6Addr
	 **/
	@Schema(description = "")

	public String getUeIpv6Addr() {
		return ueIpv6Addr;
	}

	public void setUeIpv6Addr(String ueIpv6Addr) {
		this.ueIpv6Addr = ueIpv6Addr;
	}

	public N3gaLocation portNumber(Integer portNumber) {
		this.portNumber = portNumber;
		return this;
	}

	/**
	 * Unsigned Integer, i.e. only value 0 and integers above 0 are permissible.
	 * minimum: 0
	 * 
	 * @return portNumber
	 **/
	@Schema(description = "Unsigned Integer, i.e. only value 0 and integers above 0 are permissible.")

	@Min(0)
	public Integer getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(Integer portNumber) {
		this.portNumber = portNumber;
	}

	public N3gaLocation protocol(TransportProtocol protocol) {
		this.protocol = protocol;
		return this;
	}

	/**
	 * Get protocol
	 * 
	 * @return protocol
	 **/
	@Schema(description = "")

	@Valid
	public TransportProtocol getProtocol() {
		return protocol;
	}

	public void setProtocol(TransportProtocol protocol) {
		this.protocol = protocol;
	}

	public N3gaLocation tnapId(TnapId tnapId) {
		this.tnapId = tnapId;
		return this;
	}

	/**
	 * Get tnapId
	 * 
	 * @return tnapId
	 **/
	@Schema(description = "")

	@Valid
	public TnapId getTnapId() {
		return tnapId;
	}

	public void setTnapId(TnapId tnapId) {
		this.tnapId = tnapId;
	}

	public N3gaLocation twapId(TwapId twapId) {
		this.twapId = twapId;
		return this;
	}

	/**
	 * Get twapId
	 * 
	 * @return twapId
	 **/
	@Schema(description = "")

	@Valid
	public TwapId getTwapId() {
		return twapId;
	}

	public void setTwapId(TwapId twapId) {
		this.twapId = twapId;
	}

	public N3gaLocation hfcNodeId(HfcNodeId hfcNodeId) {
		this.hfcNodeId = hfcNodeId;
		return this;
	}

	/**
	 * Get hfcNodeId
	 * 
	 * @return hfcNodeId
	 **/
	@Schema(description = "")

	@Valid
	public HfcNodeId getHfcNodeId() {
		return hfcNodeId;
	}

	public void setHfcNodeId(HfcNodeId hfcNodeId) {
		this.hfcNodeId = hfcNodeId;
	}

	public N3gaLocation gli(Gli gli) {
		this.gli = gli;
		return this;
	}

	/**
	 * Get gli
	 * 
	 * @return gli
	 **/
	@Schema(description = "")

	@Valid
	public Gli getGli() {
		return gli;
	}

	public void setGli(Gli gli) {
		this.gli = gli;
	}

	public N3gaLocation w5gbanLineType(LineType w5gbanLineType) {
		this.w5gbanLineType = w5gbanLineType;
		return this;
	}

	/**
	 * Get w5gbanLineType
	 * 
	 * @return w5gbanLineType
	 **/
	@Schema(description = "")

	@Valid
	public LineType getW5gbanLineType() {
		return w5gbanLineType;
	}

	public void setW5gbanLineType(LineType w5gbanLineType) {
		this.w5gbanLineType = w5gbanLineType;
	}

	public N3gaLocation gci(String gci) {
		this.gci = gci;
		return this;
	}

	/**
	 * Global Cable Identifier uniquely identifying the connection between the
	 * 5G-CRG or FN-CRG to the 5GS. See clause 28.15.4 of 3GPP TS 23.003. This shall
	 * be encoded as a string per clause 28.15.4 of 3GPP TS 23.003, and compliant
	 * with the syntax specified in clause 2.2 of IETF RFC 7542 for the username
	 * part of a NAI. The GCI value is specified in CableLabs WR-TR-5WWC-ARCH.
	 * 
	 * @return gci
	 **/
	@Schema(description = "Global Cable Identifier uniquely identifying the connection between the 5G-CRG or FN-CRG to the 5GS. See clause 28.15.4 of 3GPP TS 23.003. This shall be encoded as a string per clause 28.15.4 of 3GPP TS 23.003, and compliant with the syntax specified  in clause 2.2  of IETF RFC 7542 for the username part of a NAI. The GCI value is specified in CableLabs WR-TR-5WWC-ARCH. ")

	public String getGci() {
		return gci;
	}

	public void setGci(String gci) {
		this.gci = gci;
	}

	public N3gaLocation cellLocation(EllipsoidArc cellLocation) {
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
		N3gaLocation n3gaLocation = (N3gaLocation) o;
		return Objects.equals(this.n3gppTai, n3gaLocation.n3gppTai) &&
				Objects.equals(this.n3IwfId, n3gaLocation.n3IwfId) &&
				Objects.equals(this.ueIpv4Addr, n3gaLocation.ueIpv4Addr) &&
				Objects.equals(this.ueIpv6Addr, n3gaLocation.ueIpv6Addr) &&
				Objects.equals(this.portNumber, n3gaLocation.portNumber) &&
				Objects.equals(this.protocol, n3gaLocation.protocol) &&
				Objects.equals(this.tnapId, n3gaLocation.tnapId) &&
				Objects.equals(this.twapId, n3gaLocation.twapId) &&
				Objects.equals(this.hfcNodeId, n3gaLocation.hfcNodeId) &&
				Objects.equals(this.gli, n3gaLocation.gli) &&
				Objects.equals(this.w5gbanLineType, n3gaLocation.w5gbanLineType) &&
				Objects.equals(this.gci, n3gaLocation.gci);
	}

	@Override
	public int hashCode() {
		return Objects.hash(n3gppTai, n3IwfId, ueIpv4Addr, ueIpv6Addr, portNumber, protocol, tnapId, twapId, hfcNodeId,
				gli, w5gbanLineType, gci);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class N3gaLocation {\n");

		sb.append("    n3gppTai: ").append(toIndentedString(n3gppTai)).append("\n");
		sb.append("    n3IwfId: ").append(toIndentedString(n3IwfId)).append("\n");
		sb.append("    ueIpv4Addr: ").append(toIndentedString(ueIpv4Addr)).append("\n");
		sb.append("    ueIpv6Addr: ").append(toIndentedString(ueIpv6Addr)).append("\n");
		sb.append("    portNumber: ").append(toIndentedString(portNumber)).append("\n");
		sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
		sb.append("    tnapId: ").append(toIndentedString(tnapId)).append("\n");
		sb.append("    twapId: ").append(toIndentedString(twapId)).append("\n");
		sb.append("    hfcNodeId: ").append(toIndentedString(hfcNodeId)).append("\n");
		sb.append("    gli: ").append(toIndentedString(gli)).append("\n");
		sb.append("    w5gbanLineType: ").append(toIndentedString(w5gbanLineType)).append("\n");
		sb.append("    gci: ").append(toIndentedString(gci)).append("\n");
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
		if (this.hfcNodeId != null) {
			map.put("hfcNodeId", this.hfcNodeId.toMap());
		}
		if (this.protocol != null) {
			map.put("protocol", this.protocol.toMap());
		}
		if (this.n3gppTai != null) {
			map.put("n3gppTai", this.n3gppTai.toMap());
		}
		if (this.gli != null) {
			map.put("gli", this.gli.toMap());
		}
		if (this.tnapId != null) {
			map.put("tnapId", this.tnapId.toMap());
		}
		if (this.twapId != null) {
			map.put("twapId", this.twapId.toMap());
		}
		if (this.w5gbanLineType != null) {
			map.put("w5gbanLineType", this.w5gbanLineType.toMap());
		}
		map.put("gci", this.gci);
		map.put("n3IwfId", this.n3IwfId);
		map.put("portNumber", this.portNumber);
		map.put("ueIpv4Addr", this.ueIpv4Addr);
		map.put("ueIpv6Addr", this.ueIpv6Addr);
		if (this.cellLocation != null) {
			map.put("cellLocation", this.cellLocation.toMap());
		}
		return map;
	}

	public static N3gaLocation fromMap(Map<String, Object> map) {
		if(map==null) {
			return null;
		}
		N3gaLocation result = new N3gaLocation();
		result.setGci((String) map.get("gci"));
		result.setGli(Gli.fromMap((Map<String, Object>) map.get("gli")));
		result.setHfcNodeId(HfcNodeId.fromMap((Map<String, Object>) map.get("hfcNodeId")));
		result.setN3IwfId((String) map.get("n3IwfId"));
		result.setN3gppTai(Tai.fromMap((Map<String, Object>) map.get("tai")));
		result.setPortNumber((Integer) map.get("portNumber"));
		result.setProtocol(TransportProtocol.fromMap((Map<String, Object>) map.get("protocol")));
		result.setTnapId(TnapId.fromMap((Map<String, Object>) map.get("tnapId")));
		result.setTwapId(TwapId.fromMap((Map<String, Object>) map.get("twapId")));
		result.setUeIpv4Addr((String) map.get("ueIpv4Addr"));
		result.setUeIpv6Addr((String) map.get("ueIpv6Addr"));
		result.setW5gbanLineType(LineType.fromMap((Map<String,Object>) map.get("w5gbanLineType")));
		result.setCellLocation(EllipsoidArc.fromMap((Map<String, Object>) map.get("cellLocation")));
		return result;
	}
}
