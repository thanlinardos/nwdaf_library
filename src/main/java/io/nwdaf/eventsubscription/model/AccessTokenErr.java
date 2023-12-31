package io.nwdaf.eventsubscription.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Error returned in the access token response message
 */
@Schema(description = "Error returned in the access token response message")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class AccessTokenErr {
	/**
	 * Gets or Sets error
	 */
	public enum ErrorEnum {
		INVALID_REQUEST("invalid_request"),

		INVALID_CLIENT("invalid_client"),

		INVALID_GRANT("invalid_grant"),

		UNAUTHORIZED_CLIENT("unauthorized_client"),

		UNSUPPORTED_GRANT_TYPE("unsupported_grant_type"),

		INVALID_SCOPE("invalid_scope");

		private final String value;

		ErrorEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ErrorEnum fromValue(String text) {
			for (ErrorEnum b : ErrorEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("error")
	private ErrorEnum error = null;

	@JsonProperty("error_description")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorDescription = null;

	@JsonProperty("error_uri")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorUri = null;

	public AccessTokenErr error(ErrorEnum error) {
		this.error = error;
		return this;
	}

	/**
	 * Get error
	 * 
	 * @return error
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public ErrorEnum getError() {
		return error;
	}

	public void setError(ErrorEnum error) {
		this.error = error;
	}

	public AccessTokenErr errorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
		return this;
	}

	/**
	 * Get errorDescription
	 * 
	 * @return errorDescription
	 **/
	@Schema(description = "")

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public AccessTokenErr errorUri(String errorUri) {
		this.errorUri = errorUri;
		return this;
	}

	/**
	 * Get errorUri
	 * 
	 * @return errorUri
	 **/
	@Schema(description = "")

	public String getErrorUri() {
		return errorUri;
	}

	public void setErrorUri(String errorUri) {
		this.errorUri = errorUri;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AccessTokenErr accessTokenErr = (AccessTokenErr) o;
		return Objects.equals(this.error, accessTokenErr.error) &&
				Objects.equals(this.errorDescription, accessTokenErr.errorDescription) &&
				Objects.equals(this.errorUri, accessTokenErr.errorUri);
	}

	@Override
	public int hashCode() {
		return Objects.hash(error, errorDescription, errorUri);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AccessTokenErr {\n");

		sb.append("    error: ").append(toIndentedString(error)).append("\n");
		sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
		sb.append("    errorUri: ").append(toIndentedString(errorUri)).append("\n");
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
