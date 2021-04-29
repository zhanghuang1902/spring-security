package com.security.tedu.entity;

public class Kvs<T> {

    private String key;
    private T value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Kvs(String key, T value) {
        this.key = key;
        this.value = value;
    }
}
