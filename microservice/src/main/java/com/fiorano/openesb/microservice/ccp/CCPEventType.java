package com.fiorano.openesb.microservice.ccp;

import com.fiorano.openesb.microservice.ccp.event.EventFactory;

/**
 * Each event in CCP implementation is represented by a unique string known as Event Type for that particular event.
 * Event Type value can take one of the value specified in this enumeration. Passing an object of this class to
 * {@link EventFactory} returns a new event of that particular type.<br><br>
 *
 * Available event types are:<br>
 * <ul>{@link #DATA_REQUEST}</ul>
 * <ul>{@link #DATA}</ul>
 * <ul>{@link #HANDSHAKE_INITIATE}</ul>
 * <ul>{@link #HANDSHAKE_ACK}</ul>
 * <ul>{@link #COMMAND}</ul>
 * <ul>{@link #STATUS}</ul>
 * @author FSTPL
 * @version 10
 */
public enum CCPEventType {

    /**
     * This event type value represents a data request event sent by Peer Server to components.  e.g. request for
     * memory usage statistics, request for current log level set in the component etc.<br><br>
     *
     * See {@link com.fiorano.openesb.microservice.ccp.event.common.DataRequestEvent} and its sub-classes.
     */
    DATA_REQUEST,

    /**
     * This event type value represents a data event sent by components to Peer Server.
     * A data event is generally sent by component in response to {@link #DATA_REQUEST} event from Peer Server.<br><br>
     *
     * See {@link com.fiorano.openesb.microservice.ccp.event.common.DataEvent}, {@link com.fiorano.openesb.microservice.ccp.event.common.DataRequestEvent}.
     */
    DATA,

    /**
     * This event type value represents a hand-shake event sent by Peer Server to components. A hand-shake is done
     * to determine whether component supports CCP or not along with the version of CCP supported.<br><br>
     *
     * Note: This event type is not in use in current implementation. Currently, the decision whether component has
     * CCP enabled or not is done by reading ServiceDescriptor.xml file for the component. Presence of an element named
     * 'ccp' denotes that the component supports CCP.<br><br>
     * See {@link com.fiorano.openesb.microservice.ccp.event.peer.HandShakeEvent}
     */
    HANDSHAKE_INITIATE,

    /**
     * This event type value represents hand-shake acknowledgement event that is sent by components to Peer Server in response to
     * {@link #HANDSHAKE_INITIATE} event from Peer Server.<br><br>
     *
     * Note: This event type is not in use in current implementation. Currently, the decision whether component has
     * CCP enabled or not is done by reading ServiceDescriptor.xml file for the component. Presence of an element named
     * 'ccp' denotes that the component supports CCP.<br><br>
     * See {@link com.fiorano.openesb.microservice.ccp.event.component.HandShakeAckEvent}, {@link com.fiorano.openesb.microservice.ccp.event.peer.HandShakeEvent}
     */
    HANDSHAKE_ACK,

    /**
     * This event type value represents a command event sent by Peer Server to components.
     * e.g. {@link com.fiorano.openesb.microservice.ccp.event.peer.CommandEvent.Command#INITIATE_SHUTDOWN Shutdown} or
     * {@link com.fiorano.openesb.microservice.ccp.event.peer.CommandEvent.Command#SET_LOGLEVEL Set Log Level} command etc.
     * Component Process should acknowledge these commands by sending appropriate status event(s)
     * indicating the result of the operation performed for this command.<br><br>
     *
     * See {@link com.fiorano.openesb.microservice.ccp.event.peer.CommandEvent}
     */
    COMMAND,

    /**
     * This event type value represents a status event sent by components to Peer Server.
     * A status event is generally sent by component in response to {@link #COMMAND} event from Peer Server.<br><br>
     *
     * See {@link com.fiorano.openesb.microservice.ccp.event.component.StatusEvent}, {@link com.fiorano.openesb.microservice.ccp.event.peer.CommandEvent}.
     */
    STATUS,

    LOOKUP_CONFIG,

    CONFIG
}
