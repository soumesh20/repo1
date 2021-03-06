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

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * This interface provides methods for adding/removing breakpoints on routes of an event process
 * @see BreakpointMetaData
 * @author FSTPL
 * @version 10
 *
 */
public interface IDebugger extends Remote {

    /**
     * This method adds the break point on the route and returns the metadata
     *
     * @param routeName route name
     * @param appGUID application GUID
     * @return meta data - contains connection parameters, connection factory name and the destination names
     * @throws java.rmi.RemoteException Remote Exception
     * @throws ServiceException Service Exception
     */
    public BreakpointMetaData addBreakpoint(String appGUID, float appVersion, String routeName) throws RemoteException, ServiceException;

    /**
     * This method returns the break point meta data of the debugger on the route.
     *
     * @param routeName route name
     * @param appGUID application GUID
     * @return meta data - contains connection parameters, connection factory name and the destination names. returns null if no breakpoint is set.
     * @throws java.rmi.RemoteException Remote Exception
     * @throws ServiceException Service Exception
     */
    public BreakpointMetaData getBreakpointMetaData(String appGUID, float appVersion, String routeName) throws RemoteException, ServiceException;

    /**
     * This method returns the routes on which the debugger is set.
     * @param appGUID application GUID
     * @return BreakPointMetaData - Object containing array of route names
     * @throws RemoteException Remote Exception
     * @throws ServiceException Service Exception
     */
    public String[] getRoutesWithDebugger(String appGUID, float appVersion) throws RemoteException, ServiceException;

    /**
     * This method removes the break point set on the route
     *
     * @param routeName route name
     * @param appGUID application GUID
     * @throws RemoteException Remote Exception
     * @throws ServiceException Service Exception
     */
    public void removeBreakpoint(String appGUID, float appVersion, String routeName) throws RemoteException, ServiceException;

    /**
     * This method removes all the break points in the application
     * @param appGUID application GUID
     * @throws RemoteException Remote Exception
     * @throws ServiceException Service Exception
     */
    public void removeAllBreakpoints(String appGUID, float appVersion) throws RemoteException, ServiceException;

    /**
     * This method informs server, if a message has been modified on Debugger
     * @param appGUID application GUID
     * @param version application Version
     * @param routeGUID route GUID
     * @param messageID Message ID
     * @throws RemoteException Remote Exception
     * @throws ServiceException Service Exception
     */
    public void messageModifiedonDebugger(String appGUID, float version, String routeGUID, String messageID) throws RemoteException, ServiceException;

    /**
     * This method informs server, if a message has been deleted from Debugger
     * @param appGUID application GUID
     * @param version application Version
     * @param routeGUID route GUID
     * @param messageID Message ID
     * @throws RemoteException Remote Exception
     * @throws ServiceException Service Exception
     */
    public void messageDeletedonDebugger(String appGUID, float version, String routeGUID, String messageID) throws RemoteException, ServiceException;

    /**
     * This method pauses message delivery on the route.
     *
     * @param routeGUID        Route GUID
     * @param appGUID          Application GUID
     * @param handleId         ConnectionHandle of the connection to Service Provider.
     * @param maintainSequence MaintainSequence
     * @param pauseTime        Time to Pause
     */
    public void pauseRoute(String appGUID, float version, String routeGUID, String handleId, boolean maintainSequence, long pauseTime) throws RemoteException, ServiceException;

}
