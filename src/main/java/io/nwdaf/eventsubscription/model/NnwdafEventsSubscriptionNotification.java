package io.nwdaf.eventsubscription.model;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents an Individual NWDAF Event Subscription Notification resource.
 */
@Schema(description = "Represents an Individual NWDAF Event Subscription Notification resource.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class NnwdafEventsSubscriptionNotification implements OneOfNnwdafEventsSubscriptionNotification {
	@JsonProperty("eventNotifications")
	@Valid
	private List<EventNotification> eventNotifications = null;

	@JsonProperty("subscriptionId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String subscriptionId = null;

	@JsonProperty("notifCorrId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String notifCorrId = null;

	@JsonProperty("oldSubscriptionId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String oldSubscriptionId = null;

	public NnwdafEventsSubscriptionNotification eventNotifications(List<EventNotification> eventNotifications) {
		this.eventNotifications = eventNotifications;
		return this;
	}

	public NnwdafEventsSubscriptionNotification addEventNotificationsItem(EventNotification eventNotificationsItem) {
		if (this.eventNotifications == null) {
			this.eventNotifications = new ArrayList<EventNotification>();
		}
		this.eventNotifications.add(eventNotificationsItem);
		return this;
	}

	/**
	 * Notifications about Individual Events
	 * 
	 * @return eventNotifications
	 **/
	@Schema(description = "Notifications about Individual Events")
	@Valid
	@Size(min = 1)
	public List<EventNotification> getEventNotifications() {
		return eventNotifications;
	}

	public void setEventNotifications(List<EventNotification> eventNotifications) {
		this.eventNotifications = eventNotifications;
	}

	public NnwdafEventsSubscriptionNotification subscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	/**
	 * String identifying a subscription to the Nnwdaf_EventsSubscription Service
	 * 
	 * @return subscriptionId
	 **/
	@Schema(required = true, description = "String identifying a subscription to the Nnwdaf_EventsSubscription Service")
	@NotNull

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public NnwdafEventsSubscriptionNotification notifCorrId(String notifCorrId) {
		this.notifCorrId = notifCorrId;
		return this;
	}

	/**
	 * Notification correlation identifier.
	 * 
	 * @return notifCorrId
	 **/
	@Schema(description = "Notification correlation identifier.")

	public String getNotifCorrId() {
		return notifCorrId;
	}

	public void setNotifCorrId(String notifCorrId) {
		this.notifCorrId = notifCorrId;
	}

	public NnwdafEventsSubscriptionNotification oldSubscriptionId(String oldSubscriptionId) {
		this.oldSubscriptionId = oldSubscriptionId;
		return this;
	}

	/**
	 * Subscription ID which was allocated by the source NWDAF. This parameter shall
	 * be present if the notification is for informing the assignment of a new
	 * Subscription Id by the target NWDAF.
	 * 
	 * @return oldSubscriptionId
	 **/
	@Schema(description = "Subscription ID which was allocated by the source NWDAF. This parameter shall be present if the notification is for informing the assignment of a new Subscription Id by the target NWDAF. ")

	public String getOldSubscriptionId() {
		return oldSubscriptionId;
	}

	public void setOldSubscriptionId(String oldSubscriptionId) {
		this.oldSubscriptionId = oldSubscriptionId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NnwdafEventsSubscriptionNotification nnwdafEventsSubscriptionNotification = (NnwdafEventsSubscriptionNotification) o;
		return Objects.equals(this.eventNotifications, nnwdafEventsSubscriptionNotification.eventNotifications) &&
				Objects.equals(this.subscriptionId, nnwdafEventsSubscriptionNotification.subscriptionId) &&
				Objects.equals(this.notifCorrId, nnwdafEventsSubscriptionNotification.notifCorrId) &&
				Objects.equals(this.oldSubscriptionId, nnwdafEventsSubscriptionNotification.oldSubscriptionId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventNotifications, subscriptionId, notifCorrId, oldSubscriptionId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NnwdafEventsSubscriptionNotification {\n");

		sb.append("    eventNotifications: ").append(toIndentedString(eventNotifications)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    notifCorrId: ").append(toIndentedString(notifCorrId)).append("\n");
		sb.append("    oldSubscriptionId: ").append(toIndentedString(oldSubscriptionId)).append("\n");
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
		map.put("eventNotifications", (Object) this.getEventNotifications());
		map.put("subscriptionId", (Object) this.getSubscriptionId());
		map.put("notifCorrId", (Object) this.getNotifCorrId());
		map.put("oldSubscriptionId", (Object) this.getOldSubscriptionId());
		return map;
	}

	public static NnwdafEventsSubscriptionNotification fromMap(Map<String, Object> map) {
        NnwdafEventsSubscriptionNotification result = new NnwdafEventsSubscriptionNotification();
        result.setEventNotifications((List<EventNotification>) map.get("eventNotifications"));
        result.setSubscriptionId((String) map.get("subscriptionId"));
        result.setNotifCorrId((String) map.get("notifCorrId"));
        result.setOldSubscriptionId((String) map.get("oldSubscriptionId"));
        return result;
    }
}
