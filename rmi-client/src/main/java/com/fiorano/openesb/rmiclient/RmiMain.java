package com.fiorano.openesb.rmiclient;

import com.fiorano.openesb.rmiconnector.api.IEventProcessManager;
import com.fiorano.openesb.rmiconnector.api.IRmiManager;
import com.fiorano.openesb.rmiconnector.api.ServiceException;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Janardhan on 1/25/2016.
 */
public class RmiMain {
    public static void main(String [] args){
        System.out.println("Starting the bundle- rmi client");
        RmiClient rmiClient = null;
        try {
            rmiClient = new RmiClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        IRmiManager rmiManager = rmiClient.getRmiManager();
        String handleid = null;
        try {
            handleid = rmiManager.login("", "");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        System.out.println(handleid);
        try {
            IEventProcessManager eventProcessManager = rmiManager.getEventProcessManager(handleid);
            eventProcessManager.startEventProcess("SIMPLECHAT", "1.0", false);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
