package io.nwdaf.eventsubscription.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents an offered scheduled communication time.
 */
@Schema(description = "Represents an offered scheduled communication time.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class ScheduledCommunicationTime {
	@JsonProperty("daysOfWeek")
	@Valid
	private List<Integer> daysOfWeek = new ArrayList<>();

	@JsonProperty("timeOfDayStart")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String timeOfDayStart = null;

	@JsonProperty("timeOfDayEnd")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String timeOfDayEnd = null;

	public ScheduledCommunicationTime daysOfWeek(List<Integer> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
		return this;
	}

	public ScheduledCommunicationTime addDaysOfWeekItem(Integer daysOfWeekItem) {
		if (this.daysOfWeek == null) {
			this.daysOfWeek = new ArrayList<Integer>();
		}
		this.daysOfWeek.add(daysOfWeekItem);
		return this;
	}

	/**
	 * Identifies the day(s) of the week. If absent, it indicates every day of the
	 * week.
	 * 
	 * @return daysOfWeek
	 **/
	@Schema(description = "Identifies the day(s) of the week. If absent, it indicates every day of the week.")

	@Size(min = 1, max = 6)
	public List<Integer> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(List<Integer> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public ScheduledCommunicationTime timeOfDayStart(String timeOfDayStart) {
		this.timeOfDayStart = timeOfDayStart;
		return this;
	}

	/**
	 * String with format partial-time or full-time as defined in clause 5.6 of IETF
	 * RFC 3339. Examples, 20:15:00, 20:15:00-08:00 (for 8 hours behind UTC).
	 * 
	 * @return timeOfDayStart
	 **/
	@Schema(description = "String with format partial-time or full-time as defined in clause 5.6 of IETF RFC 3339. Examples, 20:15:00, 20:15:00-08:00 (for 8 hours behind UTC).")

	public String getTimeOfDayStart() {
		return timeOfDayStart;
	}

	public void setTimeOfDayStart(String timeOfDayStart) {
		this.timeOfDayStart = timeOfDayStart;
	}

	public ScheduledCommunicationTime timeOfDayEnd(String timeOfDayEnd) {
		this.timeOfDayEnd = timeOfDayEnd;
		return this;
	}

	/**
	 * String with format partial-time or full-time as defined in clause 5.6 of IETF
	 * RFC 3339. Examples, 20:15:00, 20:15:00-08:00 (for 8 hours behind UTC).
	 * 
	 * @return timeOfDayEnd
	 **/
	@Schema(description = "String with format partial-time or full-time as defined in clause 5.6 of IETF RFC 3339. Examples, 20:15:00, 20:15:00-08:00 (for 8 hours behind UTC).")

	public String getTimeOfDayEnd() {
		return timeOfDayEnd;
	}

	public void setTimeOfDayEnd(String timeOfDayEnd) {
		this.timeOfDayEnd = timeOfDayEnd;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ScheduledCommunicationTime scheduledCommunicationTime = (ScheduledCommunicationTime) o;
		return Objects.equals(this.daysOfWeek, scheduledCommunicationTime.daysOfWeek) &&
				Objects.equals(this.timeOfDayStart, scheduledCommunicationTime.timeOfDayStart) &&
				Objects.equals(this.timeOfDayEnd, scheduledCommunicationTime.timeOfDayEnd);
	}

	@Override
	public int hashCode() {
		return Objects.hash(daysOfWeek, timeOfDayStart, timeOfDayEnd);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ScheduledCommunicationTime {\n");

		sb.append("    daysOfWeek: ").append(toIndentedString(daysOfWeek)).append("\n");
		sb.append("    timeOfDayStart: ").append(toIndentedString(timeOfDayStart)).append("\n");
		sb.append("    timeOfDayEnd: ").append(toIndentedString(timeOfDayEnd)).append("\n");
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
		map.put("daysOfWeek", this.getDaysOfWeek());
		map.put("timeOfDayStart", this.getTimeOfDayStart());
		map.put("timeOfDayEnd", this.getTimeOfDayEnd());
		return map;
	}

	public static ScheduledCommunicationTime fromMap(Map<String, Object> map) {
		if (map == null) {
			return null;
		}
		ScheduledCommunicationTime result = new ScheduledCommunicationTime();
		result.setDaysOfWeek((List<Integer>) map.get("daysOfWeek"));
		result.setTimeOfDayStart(ParserUtil.safeParseString(map.get("timeOfDayStart")));
		result.setTimeOfDayEnd(ParserUtil.safeParseString(map.get("timeOfDayEnd")));
		return result;
	}
}
