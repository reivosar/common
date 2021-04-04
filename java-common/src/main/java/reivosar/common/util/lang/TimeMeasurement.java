package reivosar.common.util.lang;

import org.apache.commons.lang3.time.StopWatch;

public class TimeMeasurement
{
    private final StopWatch stopWatch;

    public static TimeMeasurement ready() {
        return new TimeMeasurement();
    }

    private TimeMeasurement() {
        this.stopWatch = StopWatch.create();
    }

    public TimeMeasurement start() {
        this.stopWatch.start();
        return this;
    }

    public TimeMeasurement stop() {
        this.stopWatch.stop();
        return this;
    }

    public long startTime() {
        return this.stopWatch.getStartTime();
    }

    public long endTime() {
        return this.stopWatch.getNanoTime();
    }
}
