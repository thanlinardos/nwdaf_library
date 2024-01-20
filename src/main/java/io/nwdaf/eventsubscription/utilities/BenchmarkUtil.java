package io.nwdaf.eventsubscription.utilities;


import java.time.Duration;

public class BenchmarkUtil {
    private Duration startTime;
    private Duration endTime;
    private Duration accumulatedTime;

    public void start() {
        startTime = Duration.ofNanos(System.nanoTime());
    }

    public BenchmarkUtil end() {
        endTime = Duration.ofNanos(System.nanoTime());
        return this;
    }

    public Duration getDuration() {
        return endTime.minus(startTime);
    }

    public BenchmarkUtil accumulate() {
        if(accumulatedTime == null) {
            accumulatedTime = Duration.ZERO;
        }
        accumulatedTime = accumulatedTime.plus(end().getDuration());
        return this;
    }

    public String toMicrosStr() {
        return getDuration().toNanos() / 1000 + " µs";
    }

    public String toMillisStr() {
        return getDuration().toMillis() + " ms";
    }

    public String toNanosStr() {
        return getDuration().toNanos() + " ns";
    }

    public String toSecondsStr() {
        return getDuration().toSeconds() + " s";
    }

    public String toMinutesStr() {
        return getDuration().toMinutes() + " min";
    }

    public String toHoursStr() {
        return getDuration().toHours() + " h";
    }
}
