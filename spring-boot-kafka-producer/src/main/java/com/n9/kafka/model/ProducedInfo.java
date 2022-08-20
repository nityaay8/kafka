package com.n9.kafka.model;

public class ProducedInfo {

    private String topicName;

    private Long offset;

    private Integer topicPartition;

    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Integer getTopicPartition() {
        return topicPartition;
    }

    public void setTopicPartition(Integer topicPartition) {
        this.topicPartition = topicPartition;
    }

    @Override
    public String toString() {
        return "ProducedInfo{" +
                "topicName='" + topicName + '\'' +
                ", offset=" + offset +
                ", topicPartition=" + topicPartition +
                ", value=" + value +
                '}';
    }
}
