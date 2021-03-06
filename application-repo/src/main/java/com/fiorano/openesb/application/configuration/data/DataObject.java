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

import com.fiorano.openesb.application.DmiObject;
import com.fiorano.openesb.application.DmiObjectTypes;
import com.fiorano.openesb.utils.exception.FioranoException;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author FSTPL
 * @version 10
 * @since Jun 21, 2010 3:41:47 PM
 */
public class DataObject extends DmiObject {
    private String name;
    private Label label;
    private ObjectCategory objectCategory;
    private DataType dataType;
    private byte[] data;

    /**
     * Default Constructor
     */
    public DataObject() {}

    /**
     * Constructor that sets value of data members for the instance
     * @param name Object Name
     * @param label Object Label
     * @param objectCategory Object Category
     * @param dataType Object type
     * @param data Data
     */
    public DataObject(String name, Label label, ObjectCategory objectCategory, DataType dataType, byte[] data) {
        this.name = name;
        this.label = label;
        this.objectCategory = objectCategory;
        this.dataType = dataType;
        this.data = data;
    }

    /**
     * Gets Object name
     * @return Object name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Object Label
     * @return Object Label
     */
    public Label getLabel() {
        return label;
    }

    /**
     * Gets Object Category
     * @return Object Category
     */
    public ObjectCategory getObjectCategory() {
        return objectCategory;
    }

    /**
     * Sets Object Name
     * @param name Object Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets Object Label
     * @param label Object Label
     */
    public void setLabel(Label label) {
        this.label = label;
    }

    /**
     * Sets Object Category
     * @param objectCategory Object Category
     */
    public void setObjectCategory(ObjectCategory objectCategory) {
        this.objectCategory = objectCategory;
    }

    /**
     * Gets Data Type
     * @return Data Type
     */
    public DataType getDataType() {
        return dataType;
    }

    /**
     * Gets Data
     * @return byte[] Date
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets Data Type
     * @param dataType Data Type
     */
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    /**
     * Sets Data
     * @param data byte[] Data
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * Returns ID of this object.
     *
     * @return the id of this object.
     * @since Tifosi2.0
     */
    public int getObjectID() {
        return DmiObjectTypes.DATA_CONFIGURATION_OBJECT;
    }

    /**
     * Resets the values of the data members of the object. This
     * may possibly be used to help the Dmifactory reuse Dmi objects.
     *
     * @since Tifosi2.0
     */
    public void reset() {
        name = null;
        label = null;
        objectCategory = null;
        dataType = null;
        data = null;
    }

    /**
     * Tests whether this <code>DmiObject</code> object has the
     * required(mandatory) fields set. This method must be called before
     * inserting values in the database.
     *
     * @throws com.fiorano.openesb.utils.exception.FioranoException
     *          if the object is not valid
     * @since Tifosi2.0
     */
    public void validate() throws FioranoException {
        //Nothing to do
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
        writeUTF(out, name);
        writeUTF(out, label != null ? label.toString() : null);
        writeUTF(out, objectCategory != null ? objectCategory.toString() : null);
        writeUTF(out, dataType != null ? dataType.toString() : null);

        if(data != null){
            out.writeInt(data.length);
            out.write(data);
        }else
            out.writeInt(-1);
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
        name = readUTF(is);
        label = readLabel(readUTF(is));
        objectCategory = readObjectCategory(readUTF(is));
        dataType = readDataType(readUTF(is));

        int dataLength = is.readInt();
        data = new byte[dataLength];
        is.readFully(data);
    }

    private DataType readDataType(String dataType) {
        if(dataType == null)
            return null;

        return DataType.getDataType(dataType);
    }

    private ObjectCategory readObjectCategory(String category) {
        if(category == null)
            return null;

        return ObjectCategory.valueOf(category);
    }

    private Label readLabel(String label) {
        if(label == null)
            return null;

        return Label.valueOf(label.toUpperCase());
    }
}
