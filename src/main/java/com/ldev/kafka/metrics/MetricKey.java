package com.ldev.kafka.metrics;

import java.io.Serializable;

public class MetricKey implements Serializable, Comparable<MetricKey> {
    private static final long serialVersionUID = -1L;
    private final String group;
    private final String type;
    private final String name;
    private final String scope;
    private final String mBeanName;

    public MetricKey(String group, String type, String name, String scope, String mBeanName) {
        if (group != null && type != null) {
            if (name == null) {
                throw new IllegalArgumentException("Name needs to be specified");
            } else {
                this.group = group;
                this.type = type;
                this.name = name;
                this.scope = scope;
                this.mBeanName = mBeanName;
            }
        } else {
            throw new IllegalArgumentException("Both group and type need to be specified");
        }
    }

    public String getGroup() {
        return this.group;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getScope() {
        return this.scope;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            MetricKey that = (MetricKey) o;
            return this.mBeanName.equals(that.mBeanName);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.mBeanName.hashCode();
    }

    public String toString() {
        return this.mBeanName;
    }

    public int compareTo(MetricKey o) {
        return this.mBeanName.compareTo(o.mBeanName);
    }

}
