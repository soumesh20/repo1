package com.fiorano.openesb.rmiconnector.impl;

import com.fiorano.openesb.applicationcontroller.ApplicationController;
import com.fiorano.openesb.rmiconnector.api.*;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Created by Janardhan on 1/22/2016.
 */
public class EventProcessManager extends AbstractRmiManager implements IEventProcessManager  {
    ApplicationController applicationController;

    private IEventProcessManager clientProxyInstance;

    void setClientProxyInstance(IEventProcessManager clientProxyInstance) {
        this.clientProxyInstance = clientProxyInstance;
    }

    IEventProcessManager getClientProxyInstance() {
        return clientProxyInstance;
    }

    EventProcessManager(RmiManager rmiManager){
        super(rmiManager);
        this.applicationController = rmiManager.getApplicationController();
    }

    @Override
    public String[] getEventProcessIds() throws RemoteException, ServiceException {
        return new String[0];
    }

    @Override
    public boolean exists(String id, float version) throws RemoteException, ServiceException {
        return false;
    }

    @Override
    public float[] getVersions(String id) throws RemoteException, ServiceException {
        return new float[0];
    }

    @Override
    public void deployEventProcess(byte[] zippedContents, boolean completed) throws RemoteException, ServiceException {

    }

    @Override
    public void changeRouteTransformation(String appGUID, float appVersion, String routeGUID, String transformerType, byte[] transformationProject, boolean completed, String scriptFile, String jmsScriptFile, String projectDir) throws RemoteException, ServiceException {

    }

    @Override
    public void changeRouteTransformationConfiguration(String appGUID, float appVersion, String routeGUID, String configurationName) throws RemoteException, ServiceException {

    }

    @Override
    public void clearRouteTransformation(String appGUID, float appVersion, String routeGUID) throws RemoteException, ServiceException {

    }

    @Override
    public void changePortAppContext(String appGUID, float appVersion, String serviceName, String portName, String transformerType, byte[] appContextBytes, boolean completed, String scriptFileName, String jmsScriptFileName, String projectDirName) throws RemoteException, ServiceException {

    }

    @Override
    public void changePortAppContextConfiguration(String appGUID, float appVersion, String serviceName, String portName, String configurationName) throws RemoteException, ServiceException {

    }

    @Override
    public void clearPortAppContext(String appGUID, float appVersion, String serviceName, String portName) throws RemoteException, ServiceException {

    }

    @Override
    public byte[] getEventProcess(String appGUID, float version, long index) throws RemoteException, ServiceException {
        return new byte[0];
    }

    @Override
    public void deleteEventProcess(String appGUID, float version, boolean deleteApplicationEvents, boolean deleteSBWEvents) throws RemoteException, ServiceException {

    }

    @Override
    public boolean dependenciesExists(ServiceReference[] serviceRefs, EventProcessReference[] eventProcessRefs) throws RemoteException, ServiceException {
        return false;
    }

    @Override
    public void startEventProcess(String appGUID, String version, boolean startServicesSeparately) throws RemoteException, ServiceException {
        applicationController.launchApplication(appGUID, version);
    }

    @Override
    public void restartEventProcess(String appGUID, float appVersion) throws RemoteException, ServiceException {

    }

    @Override
    public void stopEventProcess(String appGUID, float version) throws RemoteException, ServiceException {

    }

    @Override
    public Map<String, Boolean> getApplicationChainForShutdown(String appGUID, float version) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public Map<String, Boolean> getApplicationChainForLaunch(String appGUID, float appVersion) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public void startServiceInstance(String appGUID, float appVersion, String serviceInstanceName) throws RemoteException, ServiceException {

    }

    @Override
    public void stopServiceInstance(String appGUID, float appVersion, String serviceInstanceName) throws RemoteException, ServiceException {

    }

    @Override
    public void stopAllServiceInstances(String appGUID, float appVersion) throws RemoteException, ServiceException {

    }

    @Override
    public void deleteServiceInstance(String appGUID, float appVersion, String serviceInstanceName) throws RemoteException, ServiceException {

    }

    @Override
    public EventProcessReference[] getRunningEventProcesses() throws RemoteException, ServiceException {
        return new EventProcessReference[0];
    }

    @Override
    public List<RouteMetaData> getRoutesOfEventProcesses(String appGUID, float version) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public List<PortInstanceMetaData> getPortsForEventProcesses(String appGUID, float version) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public List<PortInstanceMetaData> getPortsForService(String appGUID, float version, String serviceInstName) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public List<ServiceInstanceMetaData> getServiceInstancesOfApp(String appGUID, float version) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public void addEventProcessListener(IEventProcessManagerListener listener, String appGUID, float appVersion) throws RemoteException, ServiceException {

    }

    @Override
    public void removeEventProcessListener(IEventProcessManagerListener listener, String appGUID, float appVersion) throws RemoteException, ServiceException {

    }

    @Override
    public void addRepositoryEventListener(IRepositoryEventListener listener) throws RemoteException, ServiceException {

    }

    @Override
    public void removeRepositoryEventListener() throws RemoteException, ServiceException {

    }

    @Override
    public boolean isRunning(String appGUID, float appVersion) throws RemoteException, ServiceException {
        return false;
    }

    @Override
    public void synchronizeEventProcess(String appGUID, float version) throws RemoteException, ServiceException {

    }

    @Override
    public void startAllServices(String appGUID, float version) throws RemoteException, ServiceException {

    }

    @Override
    public void checkResourcesAndConnectivity(String appGUID, float version) throws RemoteException, ServiceException {

    }

    @Override
    public String viewWSDL(String appGUID, float appVersion, String servInstName) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public String getComponentStats(String appGUID, float appVersion, String servInstName) throws ServiceException {
        return null;
    }

    @Override
    public void flushMessages(String appGUID, float appVersion, String servInstName) throws ServiceException {

    }

    @Override
    public String viewHttpContext(String appGUID, float appVersion, String servInstName) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public EventProcessStateData getApplicationStateDetails(String appGUID, float appVersion) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public EventProcessReference[] getAllEventProcesses() throws RemoteException, ServiceException {
        return new EventProcessReference[0];
    }

    @Override
    public EventProcessReference getEventProcess(String appGUID, float version) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public String getLastOutTrace(int numberOfLines, String serviceName, String appGUID, float appVersion) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public String getLastErrTrace(int numberOfLines, String serviceName, String appGUID, float appVersion) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public void clearServiceOutLogs(String serviceInst, String appGUID, float appVersion) throws RemoteException, ServiceException {

    }

    @Override
    public void clearServiceErrLogs(String serviceInst, String appGUID, float appVersion) throws RemoteException, ServiceException {

    }

    @Override
    public void clearApplicationLogs(String appGUID, float appVersion) throws RemoteException, ServiceException {

    }

    @Override
    public byte[] exportServiceLogs(String appGUID, float version, String serviceInst, long index) throws RemoteException, ServiceException {
        return new byte[0];
    }

    @Override
    public byte[] exportApplicationLogs(String appGUID, float version, long index) throws RemoteException, ServiceException {
        return new byte[0];
    }

    @Override
    public void setLogLevel(String appGUID, float appVersion, String serviceInstName, Hashtable modules) throws RemoteException, ServiceException {

    }

    @Override
    public void changeRouteSelector(String appGUID, float appVersion, String routeGUID, HashMap selectors) throws RemoteException, ServiceException {

    }

    @Override
    public void changeRouteSelectorConfiguration(String appGUID, float appVersion, String routeGUID, String configurationName) throws RemoteException, ServiceException {

    }

    @Override
    public void enableSBW(String servInstName, String appGUID, float appVersion, String portName, boolean isEndState, int trackingType) throws RemoteException, ServiceException {

    }

    @Override
    public void disableSBW(String servInstName, String appGUID, float appVersion, String portName) throws RemoteException, ServiceException {

    }

    @Override
    public void setTrackedDataType(String servInstName, String appGUID, float appVersion, String portName, int trackingType) throws RemoteException, ServiceException {

    }

    @Override
    public void changeSBWConfiguration(String servInstName, String appGUID, float appVersion, String portName, String configurationName) throws RemoteException, ServiceException {

    }

    @Override
    public String getWADLURL(String appGUID, float appVersion, String servInstName) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public Set<String> getReferringRunningApplications(String appGUID, float appVersion, String servInstName) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public List<String> getAllReferringApplications(String appGUID, float appVersion, String serviceInstName) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public boolean isApplicationReferred(String appGUID, float appVersion) throws RemoteException, ServiceException {
        return false;
    }

    @Override
    public HashMap getRunningCompUsingNamedConfigs(HashMap<Integer, HashMap<String, String>> configsToChange) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public String changeNamedConfigurations(HashMap<Integer, HashMap<String, String>> configsToChange) throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public String synchronizeAllRunningEP() throws RemoteException, ServiceException {
        return null;
    }

    @Override
    public boolean isFESLevelRouteDurable() {
        return false;
    }

    @Override
    public boolean isAppLevelRouteDurable(String appGUID, float appVersion) throws RemoteException, ServiceException {
        return false;
    }

    @Override
    public boolean isRouteDurable(String appGUID, float appVersion, String routeID) throws RemoteException, ServiceException {
        return false;
    }

    @Override
    public boolean isDeleteDestinationSetAtApp(String appGUID, float appVersion) throws RemoteException, ServiceException {
        return false;
    }
}
