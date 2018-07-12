package com.ldev.kafka.metrics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Meter implements Serializable, PrometheusFormat {
    private static final long serialVersionUID = -1L;
    private MetricKey metricKey;
    private long count;
    private long deltaCount;
    private double oneMinuteRate;
    private double fiveMinuteRate;
    private double fifteenMinuteRate;
    private double meanRate;

    public Meter(MetricKey metricKey, long count, long deltaCount, double oneMinuteRate, double fiveMinuteRate, double fifteenMinuteRate, double meanRate) {
        this.metricKey = metricKey;
        this.count = count;
        this.deltaCount = deltaCount;
        this.oneMinuteRate = oneMinuteRate;
        this.fiveMinuteRate = fiveMinuteRate;
        this.fifteenMinuteRate = fifteenMinuteRate;
        this.meanRate = meanRate;
    }

    @Override
    public List<String> getPrometheusStrings(char separator) {
        List<String> res = new ArrayList<>();
        String head = metricKey.getGroup().replace('.', separator) + separator + metricKey.getType();
        String name = metricKey.getName();
        String scopeKey = metricKey.getScope();
        String scope = "";
        if (scopeKey != null) {
            scope = scopeKey.replaceAll("\\.", "=\"").concat("\",");
        }
        String s0 = "{name=\"";
        String s1 = "\",";
        String s2 = "} ";
        res.add(head + separator + "Count" + s0 + name + s1 + scope + s2 + count);
        res.add(head + separator + "DeltaCount" + s0 + name + s1 + scope + s2 + deltaCount);
        res.add(head + separator + "OneMinuteRate" + s0 + name + s1 + scope + s2 + oneMinuteRate);
        res.add(head + separator + "FiveMinuteRate" + s0 + name + s1 + scope + s2 + fiveMinuteRate);
        res.add(head + separator + "FifteenMinuteRate" + s0 + name + s1 + scope + s2 + fifteenMinuteRate);
        res.add(head + separator + "MeanRate" + s0 + name + s1 + scope + s2 + meanRate);
        return res;
    }
}
