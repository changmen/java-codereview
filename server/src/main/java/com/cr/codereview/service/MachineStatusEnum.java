package com.cr.codereview.service;

public enum MachineStatusEnum {
    RUNNING("running"),
    STOP("stop"),
    UNKNOWN("unknown");

    private final String status;

    MachineStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
