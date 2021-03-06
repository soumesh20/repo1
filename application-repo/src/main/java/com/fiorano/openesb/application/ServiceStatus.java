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

package com.fiorano.openesb.application;


import com.fiorano.openesb.utils.exception.FioranoException;

/**
 *  The object is used to set the status of a service.
 *
 * @author Manoj
 * @created January 5, 2003
 * @version 2.0
 */
public class ServiceStatus extends DmiObject
{
    private String  m_strServInstName;
    private String  m_strAppInstName;
    private String  m_strNodeName;
    private boolean m_isApplicationRunning;

    /**
     *  Returns the service instance name for which the service status is specified
     * by this object
     *
     * @return the name of the service instance
     */
    public String getServInstName()
    {
        return m_strServInstName;
    }

    /**
     * Returns the application instance name for which the service status is specified
     *
     * @return the name of the application
     */
    public String getAppInstName()
    {
        return m_strAppInstName;
    }

    /**
     * Returns the node name on which the service is running
     *
     * @return The name of the node
     */
    public String getNodeName()
    {
        return m_strNodeName;
    }

    /**
     *  Checks whether the application is running or not
     *
     * @return true if the application is running, false otherwise
     */
    public boolean getIsApplicationRunning()
    {
        //added for bug 4269 fix
        return m_isApplicationRunning;
    }

    /**
     *  Gets the objectID attribute of the AckPacket object
     *
     * @return The objectID value
     */
    public int getObjectID()
    {
        return DmiObjectTypes.SERVICE_STATUS;
    }


    /**
     *  Gets a unique name for this service status
     *
     * @return the name for this service status
     */
    public String getName()
    {
        return m_strAppInstName + " :: " + m_strServInstName;
    }

    //bug 4269 fix

    /**
     *  Sets the service instance name for which the service status is to be set
     *
     * @param servInstName the name of the service instance
     */
    public void setServInstName(String servInstName)
    {
        m_strServInstName = servInstName;
    }


    /**
     * Sets the application instance name for which the service status is to be set
     *
     * @param appInstName the name of the application
     */
    public void setAppInstName(String appInstName)
    {
        m_strAppInstName = appInstName;
    }


    /**
     * Sets the node name on which the service is running
     *
     * @param nodeName the name of the node
     */
    public void setNodeName(String nodeName)
    {
        m_strNodeName = nodeName;
    }

    /**
     *  Sets the boolean indicating whether the application is running or not
     *
     * @param applicationState boolean indicating whether the application is running or not
     */
    public void setIsApplicationRunning(boolean applicationState)
    {
        //added for bug 4269 fix
        m_isApplicationRunning = applicationState;
    }


    /**
     *  Validates the object for the correctness
     *
     * @exception FioranoException Exception if the object is not valid
     */
    public void validate()
        throws FioranoException
    {
    }

    /**
     *  Resets the values of the field to the default values
     */
    public void reset()
    {
    }


    /**
     *  Writes the value of this object to the output stream
     *
     * @param os The output stream on which the object is to be written
     * @param versionNo
     * @exception java.io.IOException Exception, if there is some error in writing the data on the stream
     */
    public void toStream(java.io.DataOutput os, int versionNo)
        throws java.io.IOException
    {
        super.toStream(os, versionNo);
        writeUTF(os, m_strServInstName);
        writeUTF(os, m_strAppInstName);
        writeUTF(os, m_strNodeName);
        os.writeBoolean(m_isApplicationRunning);
    }


    /**
     *  Reads the input stream and sets the values of the fields of the object
     *
     * @param is Input stream from which the data is to be read
     * @param versionNo
     * @exception java.io.IOException Exception if there us some problem in
     * reading the data from the stream.
     */
    public void fromStream(java.io.DataInput is, int versionNo)
        throws java.io.IOException
    {
        super.fromStream(is, versionNo);

        m_strServInstName = readUTF(is);
        m_strAppInstName = readUTF(is);
        m_strNodeName = readUTF(is);
        m_isApplicationRunning = is.readBoolean();
    }

}
