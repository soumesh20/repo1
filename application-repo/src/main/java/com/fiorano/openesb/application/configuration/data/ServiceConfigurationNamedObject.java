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
 * This class is used to create the service named configuration instances
 * @author FSTPL
 * @version 10
 */
public class ServiceConfigurationNamedObject extends NamedObject {
    private ServiceConfigurationType configurationType;
    private String serviceGUID;
    private String serviceVersion;

    /**
     * Default constructor
     */
    public ServiceConfigurationNamedObject() {}

    /**
     * Constructor to initialize objects of this class
     * @param name Name
     * @param label Label
     * @param objectCategory Category
     * @param configurationType Type of the configuration
     * @param serviceGUID Service GUID
     * @param serviceVersion Service version
     */
    public ServiceConfigurationNamedObject(String name, Label label, ObjectCategory objectCategory, ServiceConfigurationType configurationType, String serviceGUID, String serviceVersion) {
        super(name, label, objectCategory);
        this.configurationType = configurationType;
        this.serviceGUID = serviceGUID;
        this.serviceVersion = serviceVersion;
    }

    /**
     * Returns the type of service configuration
     * @return ServiceConfigurationType - Type of the service configuration
     */
    public ServiceConfigurationType getConfigurationType() {
        return configurationType;
    }

    /**
     * Returns the GUID of the service
     * @return String - Service GUID
     */
    public String getServiceGUID() {
        return serviceGUID;
    }

    /**
     * Returns the service version
     * @return String - Version of the service
     */
    public String getServiceVersion() {
        return serviceVersion;
    }

    /**
     * Returns the object category of the configuration
     * @return ObjectCategory - Category of the configuration
     */
    public ObjectCategory getObjectCategory() {
        return ObjectCategory.SERVICE_CONFIGURATION;
    }

    /**
     * Sets the object category of the configuration
     * @param objectCategory Category of the configuration
     * @throws UnsupportedOperationException Exception thrown when an unsupported operation is called
     */
    public void setObjectCategory(ObjectCategory objectCategory) throws UnsupportedOperationException {
        if(objectCategory == null || !objectCategory.equals(ObjectCategory.SERVICE_CONFIGURATION))
            throw new UnsupportedOperationException("OBJECT_CATEGORY_READ_ONLY");
    }

    /**
     * Sets the type of the configuration
     * @param configurationType Type of the configuration
     */
    public void setConfigurationType(ServiceConfigurationType configurationType) {
        this.configurationType = configurationType;
    }

    /**
     * Sets the GUID for the service
     * @param serviceGUID GUID to be set
     */
    public void setServiceGUID(String serviceGUID) {
        this.serviceGUID = serviceGUID;
    }

    /**
     * Sets the version for the service
     * @param serviceVersion Version to be set
     */
    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    /**
     * Returns ID of this object.
     *
     * @return ID of this object.
     * @since Tifosi2.0
     */
    public int getObjectID() {
        return DmiObjectTypes.SERVICE_CONFIGURATION_NAMED_OBJECT;
    }

    /**
     * Resets the values of the data members of the object. This
     * may possibly be used to help the Dmifactory reuse Dmi objects.
     *
     * @since Tifosi2.0
     */
    public void reset() {
        super.reset();
        configurationType = null;
        serviceGUID = null;
        serviceVersion = null;
    }

    /**
     * Tests whether this <code>DmiObject</code> object has the
     * required(mandatory) fields set. This method must be called before
     * inserting values in the database.
     *
     * @throws com.fiorano.openesb.utils.exception.FioranoException If the object is not valid
     * @since Tifosi2.0
     */
    public void validate() throws FioranoException {
        super.validate();
    }

    /**
     * Writes this object to specified output stream <code>out</code>
     *
     * @param out       Output stream
     * @param versionNo Version
     * @throws IOException If an error occurs while writing to stream
     */
    public void toStream(DataOutput out, int versionNo) throws IOException {
        super.toStream(out, versionNo);
        writeUTF(out, configurationType != null ? configurationType.toString() : null);
        writeUTF(out, serviceGUID);
        writeUTF(out, serviceVersion);
    }

    /**
     * Reads this object from specified stream <code>is</code>
     *
     * @param is        Input stream
     * @param versionNo Version
     * @throws IOException If an error occurs while reading from stream
     */
    public void fromStream(DataInput is, int versionNo) throws IOException {
        super.fromStream(is, versionNo);
        configurationType = readConfigurationType(readUTF(is));
        serviceGUID = readUTF(is);
        serviceVersion = readUTF(is);
    }

    private ServiceConfigurationType readConfigurationType(String configurationType) {
        if(configurationType == null)
            return null;

        return ServiceConfigurationType.valueOf(configurationType);
    }
}
