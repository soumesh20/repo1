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

package com.fiorano.openesb.application.schema;

import com.fiorano.openesb.application.CommonSchemas;


/**
 * This is a utility class which is helpful is resolving Default Schemas.
 *
 * @author Prasanna R
 * @created Oct 30 2006
 */
public final class SchemaUtil
{
    private SchemaUtil()
    {
        // Overriding the default public constructor. So that this copies of this utility class cannot be created.
    }
    public final static String DEF_ERROR_XSD_LBL = "DEF_ERROR_XSD";

    private static String m_defaultErrorPortXSD = CommonSchemas.ERROR_XSD;

    /**
     * Returns whether the passed XSD is the default Error Port XSD.
     * @param xsd
     * @return boolean whether the passed XSD is Default Error Port XSD.
     */
    public static boolean isDefaultErrorPortXSD(String xsd)
    {
        return SchemaChecker.checkSchemaForEquality(xsd, m_defaultErrorPortXSD);
    }

    /**
     * Returns the default error port XSDs.
     * @return String.
     */
    public static String getDefaultErrorPortXSD()
    {
        return m_defaultErrorPortXSD;
    }

   /**
     * Helper inner class to check the equality of the Schemas
     */
    static class SchemaChecker
    {
        /**
         * Static utility method for checking in the Equality of the schema.
         * Does a String.Equals Comparisions after removing all the spaces, tabs and the new line characters.
         * Note : It does a case in-sensitive comparision of the XSD Strings.
         *
         * @param xsd1
         * @param xsd2
         * @return whether the two XSDs are equal or not.
         */
        static boolean checkSchemaForEquality(String xsd1, String xsd2)
        {
            if(xsd1 == null || xsd2 == null)
                return false;
            
            StringBuffer xsd1Mut = new StringBuffer(xsd1);
            StringBuffer xsd2Mut = new StringBuffer(xsd2);

            // Remove the \n \t from the XSD's
            for(int index=0;index>=0;index=xsd1Mut.indexOf("\n"))
            {
                xsd1Mut.replace(index, index+1, "");
            }
            for(int index=0;index>=0;index=xsd1Mut.indexOf("\t"))
            {
                xsd1Mut.replace(index, index+1, "");
            }

            for(int index=0;index>=0;index=xsd2Mut.indexOf("\n"))
            {
                xsd2Mut.replace(index, index+1, "");
            }
            for(int index=0;index>=0;index=xsd2Mut.indexOf("\t"))
            {
                xsd2Mut.replace(index, index+1, "");
            }

            // Do a String.eqaulsIgnoreCase of the 2 strings.
            return xsd1Mut.toString().equalsIgnoreCase(xsd2Mut.toString());


        }
    }

}
