package io.nwdaf.eventsubscription.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.nwdaf.eventsubscription.utilities.ParserUtil.safeParseInteger;

/**
 * When Snssai needs to be converted to string (e.g. when used in maps as key),
 * the string shall be composed of one to three digits \&quot;sst\&quot;
 * optionally followed by \&quot;-\&quot; and 6 hexadecimal digits
 * \&quot;sd\&quot;.
 */
@Schema(description = "When Snssai needs to be converted to string (e.g. when used in maps as key), the string shall be composed of one to three digits \"sst\" optionally followed by \"-\" and 6 hexadecimal digits \"sd\". ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class Snssai {
	@JsonProperty("sst")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer sst = null;

	@JsonProperty("sd")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String sd = null;

	public Snssai sst(Integer sst) {
		this.sst = sst;
		return this;
	}

	/**
	 * Unsigned integer, within the range 0 to 255, representing the Slice/Service
	 * Type. It indicates the expected Network Slice behaviour in terms of features
	 * and services. Values 0 to 127 correspond to the standardized SST range.
	 * Values 128 to 255 correspond to the Operator-specific range. See clause
	 * 28.4.2 of 3GPP TS 23.003. Standardized values are defined in clause 5.15.2.2
	 * of 3GPP TS 23.501.
	 * minimum: 0
	 * maximum: 255
	 * 
	 * @return sst
	 **/
	@Schema(required = true, description = "Unsigned integer, within the range 0 to 255, representing the Slice/Service Type.  It indicates the expected Network Slice behaviour in terms of features and services. Values 0 to 127 correspond to the standardized SST range. Values 128 to 255 correspond  to the Operator-specific range. See clause 28.4.2 of 3GPP TS 23.003. Standardized values are defined in clause 5.15.2.2 of 3GPP TS 23.501.  ")
	@NotNull

	@Min(0)
	@Max(255)
	public Integer getSst() {
		return sst;
	}

	public void setSst(Integer sst) {
		this.sst = sst;
	}

	public Snssai sd(String sd) {
		this.sd = sd;
		return this;
	}

	/**
	 * 3-octet string, representing the Slice Differentiator, in hexadecimal
	 * representation. Each character in the string shall take a value of \"0\" to
	 * \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4 bits. The most
	 * significant character representing the 4 most significant bits of the SD
	 * shall appear first in the string, and the character representing the 4 least
	 * significant bit of the SD shall appear last in the string. This is an
	 * optional parameter that complements the Slice/Service type(s) to allow to
	 * differentiate amongst multiple Network Slices of the same Slice/Service type.
	 * This IE shall be absent if no SD value is associated with the SST.
	 * 
	 * @return sd
	 **/
	@Schema(description = "3-octet string, representing the Slice Differentiator, in hexadecimal representation. Each character in the string shall take a value of \"0\" to \"9\", \"a\" to \"f\" or \"A\" to \"F\" and shall represent 4 bits. The most significant character representing the 4 most significant bits of the SD shall appear first in the string, and the character representing the 4 least significant bit of the SD shall appear last in the string. This is an optional parameter that complements the Slice/Service type(s) to allow to  differentiate amongst multiple Network Slices of the same Slice/Service type. This IE shall be absent if no SD value is associated with the SST. ")

	@Pattern(regexp = "^[A-Fa-f0-9]{6}$")
	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Snssai snssai = (Snssai) o;
		return Objects.equals(this.sst, snssai.sst) &&
				Objects.equals(this.sd, snssai.sd);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sst, sd);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Snssai {\n");

		sb.append("    sst: ").append(toIndentedString(sst)).append("\n");
		sb.append("    sd: ").append(toIndentedString(sd)).append("\n");
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

	public String toKeyString() {
		StringBuilder sb = new StringBuilder();
		sb.append(sst.toString());
		if (sd != null && !sd.equals("")) {
			sb.append("-").append(sd);
		}
		return sb.toString();
	}

	public static Snssai fromKeyString(String key) {
		String[] elements = key.split("-");
		if(elements.length < 2) return null;
		return new Snssai()
				.sst(safeParseInteger(elements[0]))
				.sd(elements[1]);
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("sd", this.sd);
		map.put("sst", this.sst);
		return map;
	}

	public static Snssai fromMap(Map<String, Object> map) {
		if (map == null) {
			return null;
		}
		Snssai result = new Snssai();
		result.setSd((String) map.get("sd"));
		result.setSst((Integer) map.get("sst"));
		return result;
	}
}
