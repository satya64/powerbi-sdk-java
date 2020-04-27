package io.github.satya64.powerbi.api.model;

public enum ConnectionType {
    CONNECT("connect"), IMPORT("import");

    private final String value;

    ConnectionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
