package com.cr.codereview.service;

public class MachineService {
    // relation: GroupEnv -> AppRunningEnv -> Machine -> MachineStatusEnum
    public String getMachineStatus(GroupEnv groupEnv) {
        if (groupEnv != null
                && groupEnv.getAppRunningEnv() != null
                && groupEnv.getAppRunningEnv().getMachine() != null
                && groupEnv.getAppRunningEnv().getMachine().getStatus() != null) {

            return groupEnv.getAppRunningEnv().getMachine().getStatus().getStatus();
        }

        return MachineStatusEnum.UNKNOWN.getStatus();
    }
}
