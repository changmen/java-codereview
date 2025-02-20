package com.cr.codereview.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MachineService {

    private final static Map<Machine, String> groupEnvMap = new HashMap<>();

    // relation: GroupEnv -> AppRunningEnv -> Machine -> MachineStatusEnum
    public String getMachineStatus(GroupEnv groupEnv) {
        if (groupEnvMap.containsKey(groupEnv.getAppRunningEnv().getMachine())) {
            return groupEnvMap.get(groupEnv.getAppRunningEnv().getMachine());
        }
        return Optional.ofNullable(groupEnv)
                .map(GroupEnv::getAppRunningEnv)
                .map(AppRunningEnv::getMachine)
                .map(Machine::getStatus)
                .map(MachineStatusEnum::getStatus)
                .orElse(MachineStatusEnum.UNKNOWN.getStatus());
    }


}
