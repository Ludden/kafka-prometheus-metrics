package com.ldev.kafka.metrics;

import java.io.Serializable;
import java.util.List;

public class MetricsResult implements Serializable {
    private static final long serialVersionUID = -1L;
    private final List<Gauge> gauges;
    private final List<Meter> meters;
    private final List<Histogram> histograms;
    private final List<Timer> timers;
    private int brokerId;
    private String clusterId;
    private long timestamp;

    public MetricsResult(List<Gauge> gauges, List<Meter> meters, List<Histogram> histograms, List<Timer> timers) {
        this.gauges = gauges;
        this.meters = meters;
        this.histograms = histograms;
        this.timers = timers;
    }

    public MetricsResult setBrokerId(int brokerId) {
        this.brokerId = brokerId;
        return this;
    }

    public MetricsResult setClusterId(String clusterId) {
        this.clusterId = clusterId;
        return this;
    }

    public MetricsResult setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public int getBrokerId() {
        return brokerId;
    }

    public String getClusterId() {
        return clusterId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getClusterBroker() {
        return clusterId + "-" + brokerId;
    }

    public List<Gauge> getGauges() {
        return gauges;
    }

    public List<Meter> getMeters() {
        return meters;
    }

    public List<Histogram> getHistograms() {
        return histograms;
    }

    public List<Timer> getTimers() {
        return timers;
    }
}
