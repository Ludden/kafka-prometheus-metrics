package com.ldev.kafka.metrics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gauge implements Serializable, PrometheusFormat {
    private static final long serialVersionUID = -1L;
    private final String value;
    private MetricKey metricKey;

    public Gauge(MetricKey metricKey, String value) {
        this.metricKey = metricKey;
        this.value = value;
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
        res.add(head + separator + "Value" + s0 + name + s1 + scope + s2 + value);
        return res;
    }

}
