package com.cr.codereview.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MachineService {

    private final static Map<Machine, String> groupEnvMap = new HashMap<>();

    // relation: GroupEnv -> AppRunningEnv -> Machine -> MachineStatusEnum
    public String getMachineStatus(GroupEnv groupEnv) {
        if (groupEnvMap.containsKey(groupEnv.getAppRunningEnvironment().getMachine())) {
            return groupEnvMap.get(groupEnv.getAppRunningEnvironment().getMachine());
        }
        return Optional.of(groupEnv)
                .map(GroupEnv::getAppRunningEnvironment)
                .map(AppRunningEnv::getMachine)
                .map(Machine::getStatus)
                .map(MachineStatusEnum::getStatus)
                .orElse(MachineStatusEnum.UNKNOWN.getStatus());
    }


}
