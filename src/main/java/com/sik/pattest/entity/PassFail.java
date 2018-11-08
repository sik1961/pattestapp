package com.sik.pattest.entity;

public enum PassFail {
    P("Pass"),
    F("Fail");

    private final String value;

    PassFail(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
