package com.ldev.kafka.metrics;

import java.util.List;

public interface PrometheusFormat {
    List<String> getPrometheusStrings(char separator);

}

