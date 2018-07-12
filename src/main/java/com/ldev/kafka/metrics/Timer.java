package com.ldev.kafka.metrics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timer implements Serializable, PrometheusFormat {
    private static final long serialVersionUID = -1L;
    private MetricKey metricKey;
    private long count;
    private long deltaCount;
    private double max;
    private double min;
    private double stdDev;
    private double mean;
    private double sum;
    private double median;
    private double percentile75Th;
    private double percentile95Th;
    private double percentile98Th;
    private double percentile99Th;
    private double percentile999Th;
    private int size;
    private double oneMinuteRate;
    private double fiveMinuteRate;
    private double fifteenMinuteRate;
    private double meanRate;

    public Timer(MetricKey metricKey,
                 long count,
                 long deltaCount,
                 double max,
                 double min,
                 double mean,
                 double stdDev,
                 double sum,
                 double median,
                 double percentile75Th,
                 double percentile95Th,
                 double percentile98Th,
                 double percentile99Th,
                 double percentile999Th,
                 int size,
                 double oneMinuteRate,
                 double fiveMinuteRate,
                 double fifteenMinuteRate,
                 double meanRate) {
        this.metricKey = metricKey;
        this.count = count;
        this.deltaCount = deltaCount;
        this.max = max;
        this.min = min;
        this.mean = mean;
        this.stdDev = stdDev;
        this.sum = sum;
        this.median = median;
        this.percentile75Th = percentile75Th;
        this.percentile95Th = percentile95Th;
        this.percentile98Th = percentile98Th;
        this.percentile99Th = percentile99Th;
        this.percentile999Th = percentile999Th;
        this.size = size;
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
        res.add(head + separator + "Max" + s0 + name + s1 + scope + s2 + max);
        res.add(head + separator + "Min" + s0 + name + s1 + scope + s2 + min);
        res.add(head + separator + "StdDev" + s0 + name + s1 + scope + s2 + stdDev);
        res.add(head + separator + "Mean" + s0 + name + s1 + scope + s2 + mean);
        res.add(head + separator + "Sum" + s0 + name + s1 + scope + s2 + sum);
        res.add(head + separator + "Median" + s0 + name + s1 + scope + s2 + median);
        res.add(head + separator + "75thPercentile" + s0 + name + s1 + scope + s2 + percentile75Th);
        res.add(head + separator + "95thPercentile" + s0 + name + s1 + scope + s2 + percentile95Th);
        res.add(head + separator + "98thPercentile" + s0 + name + s1 + scope + s2 + percentile98Th);
        res.add(head + separator + "99thPercentile" + s0 + name + s1 + scope + s2 + percentile99Th);
        res.add(head + separator + "999thPercentile" + s0 + name + s1 + scope + s2 + percentile999Th);
        res.add(head + separator + "Size" + s0 + name + s1 + scope + s2 + size);
        res.add(head + separator + "OneMinuteRate" + s0 + name + s1 + scope + s2 + oneMinuteRate);
        res.add(head + separator + "FiveMinuteRate" + s0 + name + s1 + scope + s2 + fiveMinuteRate);
        res.add(head + separator + "FifteenMinuteRate" + s0 + name + s1 + scope + s2 + fifteenMinuteRate);
        res.add(head + separator + "MeanRate" + s0 + name + s1 + scope + s2 + meanRate);
        return res;
    }
}
