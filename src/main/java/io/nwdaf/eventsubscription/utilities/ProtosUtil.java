package io.nwdaf.eventsubscription.utilities;

import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ProtosUtil {

    public static Timestamp getTimestampFromDate(OffsetDateTime date) {
        return Timestamp.newBuilder().setSeconds(date.toEpochSecond()).setNanos(date.getNano()).build();
    }

    public static OffsetDateTime getDateFromTimestamp(Timestamp timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
        return OffsetDateTime.ofInstant(instant, ZoneOffset.systemDefault());
    }
}
