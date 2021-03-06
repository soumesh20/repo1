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

package com.fiorano.openesb.application.configuration.data;

import com.fiorano.openesb.application.DmiObjectTypes;
import com.fiorano.openesb.utils.exception.FioranoException;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * This class provides information about data configuration of port
 *
 * @author FSTPL
 * @version 10
 */
public class PortConfigurationDataObject extends DataObject {
    private DestinationType destinationType;
    private PortType portType;

    public PortConfigurationDataObject() {}

    /**
     * Constructs Port configuration Data
     *
     * @param name  Config Name
     * @param label  Environment label eg. Develpoment/Production/Staging/Testing
     * @param objectCategory  ObjectCategory (In this case: Port)
     * @param dataType
     * @param data  bytes of data
     * @param destinationType  Destination type (Topic/Queue)
     * @param portType  Port Type(Input/Output)
     */
    public PortConfigurationDataObject(String name, Label label, ObjectCategory objectCategory, DataType dataType, byte[] data, DestinationType destinationType, PortType portType) {
        super(name, label, objectCategory, dataType, data);
        this.destinationType = destinationType;
        this.portType = portType;
    }

    /**
     * Gets destination type
     * @return Destination type
     */
    public DestinationType getDestinationType() {
        return destinationType;
    }

    /**
     * Gets Port Type
     * @return Port type(Input/Output)
     */
    public PortType getPortType() {
        return portType;
    }

    public ObjectCategory getObjectCategory() {
        return ObjectCategory.PORT_CONFIGURATION;
    }

    public void setObjectCategory(ObjectCategory objectCategory) throws UnsupportedOperationException {
        if(objectCategory == null || !objectCategory.equals(ObjectCategory.PORT_CONFIGURATION))
            throw new UnsupportedOperationException("OBJECT_CATEGORY_READ_ONLY");
    }

    /**
     * Sets Destination Type
     * @param destinationType  Destination Type (Topic/Queue)
     */
    public void setDestinationType(DestinationType destinationType) {
        this.destinationType = destinationType;
    }

    /**
     * Sets Port Type
     * @param portType Port type (Input/Output)
     */
    public void setPortType(PortType portType) {
        this.portType = portType;
    }

    /**
     * Returns ID of this object.
     *
     * @return the id of this object.
     * @since Tifosi2.0
     */
    public int getObjectID() {
        return DmiObjectTypes.PORT_CONFIGURATION_DATA_OBJECT;
    }

    /**
     * Resets the values of the data members of the object. This
     * may possibly be used to help the Dmifactory reuse Dmi objects.
     *
     * @since Tifosi2.0
     */
    public void reset() {
        super.reset();
        destinationType = null;
        portType = null;
    }

    /**
     * Tests whether this <code>DmiObject</code> object has the
     * required(mandatory) fields set. This method must be called before
     * inserting values in the database.
     *
     * @throws com.fiorano.openesb.utils.exception.FioranoException if the object is not valid
     * @since Tifosi2.0
     */
    public void validate() throws FioranoException {
        super.validate();
    }

    /**
     * Writes this object to specified output stream <code>out</code>
     *
     * @param out       output stream
     * @param versionNo version
     * @throws IOException If an error occurs while writing to stream
     */
    public void toStream(DataOutput out, int versionNo) throws IOException {
        super.toStream(out, versionNo);
        writeUTF(out, destinationType != null ? destinationType.toString() : null);
        writeUTF(out, portType != null ? portType.toString() : null);
    }

    /**
     * Reads this object from specified stream <code>is</code>
     *
     * @param is        input stream
     * @param versionNo version
     * @throws IOException If an error occurs while reading from stream
     */
    public void fromStream(DataInput is, int versionNo) throws IOException {
        super.fromStream(is, versionNo);
        destinationType = readDestinationType(readUTF(is));
        portType = readPortType(readUTF(is));
    }

    private PortType readPortType(String portType) {
        if(portType == null)
            return null;

        return PortType.getPortType(portType);
    }

    private DestinationType readDestinationType(String destinationType) {
        if(destinationType == null)
            return null;

        return DestinationType.valueOf(destinationType);
    }
}
