/**
 * Copyright (c) 1999-2007, Fiorano Software Technologies Pvt. Ltd. and affiliates.
 * Copyright (c) 2008-2014, Fiorano Software Pte. Ltd. and affiliates.
 * <p>
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information
 * of Fiorano Software ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * enclosed with this product or entered into with Fiorano.
 * <p>
 * Created by chaitanya on 01-02-2016.
 */

/**
 * Created by chaitanya on 01-02-2016.
 */
package com.fiorano.openesb.microservice.launch.impl;

import com.fiorano.openesb.microservice.launch.LaunchConfiguration;
import com.fiorano.openesb.microservice.launch.Launcher;
import com.fiorano.openesb.microservice.launch.MicroserviceRuntimeHandle;

public class MicroserviceLauncher implements Launcher<MicroserviceRuntimeHandle>{
    public MicroserviceRuntimeHandle launch(LaunchConfiguration launchConfiguration) throws Exception {
        if(launchConfiguration.getLaunchMode() == LaunchConfiguration.LaunchMode.SEPARATE_PROCESS) {
            SeparateProcessLauncher separateProcessLauncher = new SeparateProcessLauncher();
            return separateProcessLauncher.launch(launchConfiguration);
        }
        return null;
    }
}
