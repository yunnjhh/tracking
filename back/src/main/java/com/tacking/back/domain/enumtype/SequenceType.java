package com.tacking.back.domain.enumtype;

public enum SequenceType {

    CONTENTS("CONTENTS"),
    CATEGORY("CATEGORY");

    private final String type;

    SequenceType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
