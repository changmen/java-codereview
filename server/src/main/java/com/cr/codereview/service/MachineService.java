package com.cr.codereview.service;

import java.util.Optional;

public class MachineService {
    // relation: GroupEnv -> AppRunningEnv -> Machine -> MachineStatusEnum
    public String getMachineStatus(GroupEnv groupEnv) {
        return Optional.ofNullable(groupEnv)
                .map(GroupEnv::getAppRunningEnv)
                .map(AppRunningEnv::getMachine)
                .map(Machine::getStatus)
                .map(MachineStatusEnum::getStatus)
                .orElse(MachineStatusEnum.UNKNOWN.getStatus());
    }
}
