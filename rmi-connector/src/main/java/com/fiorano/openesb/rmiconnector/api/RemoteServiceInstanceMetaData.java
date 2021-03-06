/**
 * Copyright (c) 1999-2007, Fiorano Software Technologies Pvt. Ltd. and affiliates.
 * Copyright (c) 2008-2015, Fiorano Software Pte. Ltd. and affiliates.
 *
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Fiorano Software ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * enclosed with this product or entered into with Fiorano.
 */

package com.fiorano.openesb.rmiconnector.api;

/**
 * This class provides methods to manage information about remote service instances.
 * @author FSTPL
 * @version 10
 */
public class RemoteServiceInstanceMetaData extends ServiceInstanceMetaData {
    private static final long serialVersionUID = -4041858330173755942L;

    private String appGUID;
    private String remoteAppGUID;
    private String remoteInstanceName;

    /**
     *  This is a constructor to initialize values for objects of this class
     *  @param appGUID - Application GUID of the Event Process
     *  @param remoteAppGUID - Application GUID of the referred Event Process
     *  @param remoteInstanceName Name of the Service Instance in the remote application
     *  @param serviceInstanceName Name of the Service Instance
     *  @param serviceGUID GUID of the Service Instance
     *  @param version Version of the Service Instance
     *  @param shortDescription Short description about the Remote Service Instance
     *  @param longDescription Long description about the Remote Service Instance
     *  @param nodes Array of nodes configured for launching the Remote Service Instance
     *  @param launchType Launch type of the Remote Service Instance
     */
    public RemoteServiceInstanceMetaData(String appGUID, String remoteAppGUID, String remoteInstanceName, String serviceInstanceName, String serviceGUID, float version, String shortDescription, String longDescription, String[] nodes, int launchType) {
        super(serviceInstanceName, serviceGUID, version, shortDescription, longDescription, nodes, launchType);
        this.appGUID = appGUID;
        this.remoteAppGUID = remoteAppGUID;
        this.remoteInstanceName = remoteInstanceName;
    }

    /**
     *  This method returns the AppGUID of the referring Event Process
     *  @return String - AppGUID of the referring Event Process
     */
    public String getAppGUID() {
        return appGUID;
    }

    /**
     *  This method returns the AppGUID of the referred Event Process
     *  @return String - AppGUID of the referred Event Process
     */
    public String getRemoteAppGUID() {
        return remoteAppGUID;
    }

    /**
     *  This method returns the name of the Remote Service Instance
     *  @return String - Name of Remote Service Instance
     */
    public String getRemoteInstanceName() {
        return remoteInstanceName;
    }

    /**
     *  This method sets the AppGUID of the referring Event Process
     *  @param appGUID AppGUID of the referring Event Process
     */
    public void setAppGUID(String appGUID) {
        this.appGUID = appGUID;
    }

    /**
     *  This method sets the AppGUID of the referred Event Process
     *  @param remoteAppGUID AppGUID of the referred Event Process
     */
    public void setRemoteAppGUID(String remoteAppGUID) {
        this.remoteAppGUID = remoteAppGUID;
    }

    /**
     *  This method sets the Service Instance Name of the Remote Service
     *  @param remoteInstanceName Name of Remote Service Instance
     */
    public void setRemoteInstanceName(String remoteInstanceName) {
        this.remoteInstanceName = remoteInstanceName;
    }
}
