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

package com.fiorano.openesb.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.RandomAccessFile;
import java.io.StringReader;

/**
 * this class is used to create Document Object using SAX.
 * this class is used to overcome the performance issues of parsing
 * large XML files using DOM.
 *
 * @author     Santhosh Kumar T
 * @version    1.0
 * @date       March 2003
 */
public class DOMAdapter extends DefaultHandler
{
    //private static DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    //private static SAXParserFactory saxFactory = SAXParserFactory.newInstance();

    // Fix for bugID :: 9997 start
    //
    private static DocumentBuilderFactory domFactory = new org.apache.xerces.jaxp.DocumentBuilderFactoryImpl ();
    private static SAXParserFactory saxFactory = new org.apache.xerces.jaxp.SAXParserFactoryImpl ();
    //
    // Fix for bugID :: 9997 end

    private StringBuffer content = new StringBuffer();
    private Document doc = null;
    private Element elem = null;
    private boolean m_bIsTrimSpaces = true;

    public Document getDocument(String xml, boolean validate)
            throws Exception
    {
        return getDocument(xml, validate, false);
    }

    public Document getDocument(String xml, boolean validate, boolean trim)
            throws Exception
    {
        saxFactory.setValidating(validate);
        m_bIsTrimSpaces = trim;
        SAXParser parser = saxFactory.newSAXParser();
        parser.parse(new InputSource(new StringReader(xml)), this);
        return doc;
    }

    public void startDocument() throws SAXException
    {
        try
        {
            doc = domFactory.newDocumentBuilder().newDocument();
        }
        catch (ParserConfigurationException ex)
        {
            throw new SAXException(ex);
        }
    }

    public void startElement(String namespaceURI, String sName, String qName, Attributes attrs)
    {
        String text = content.toString();
        if(m_bIsTrimSpaces)
            text = text.trim();

        if(text.length()>0)
        {
            Text textNode = doc.createTextNode(text);
            elem.appendChild(textNode);
        }
        content.setLength(0);
        Element curElem = doc.createElement(qName);
        for(int i=0; i<attrs.getLength(); i++)
            curElem.setAttribute(attrs.getQName(i), attrs.getValue(i));
        if(elem==null)
            doc.appendChild(curElem);
        else
            elem.appendChild(curElem);
        elem = curElem;
    }

    public void characters(char buf[], int offset, int len) {
        content.append(buf, offset, len);
    }

    public void endElement(String namespaceURI, String sName, String qName)
    {
        String text = content.toString();
        if(m_bIsTrimSpaces)
            text = text.trim();

        if(text.length()>0){
            Text textNode = doc.createTextNode(text);
            elem.appendChild(textNode);
        }
        content.setLength(0);
        if(elem.getParentNode() instanceof Element)
            elem = (Element)elem.getParentNode();
        else
            elem = null;
    }

    public void error(SAXParseException sAXParseException) throws SAXException{
        throw sAXParseException;
    }

    public static void main(String[] args) throws Exception{
        DOMAdapter adapter = new DOMAdapter ();
        RandomAccessFile raf = new RandomAccessFile ("d:\\1.0.xml", "rw");
        long len = raf.length();
        byte[] buff = new byte [(int)len];
        raf.read (buff);
        adapter.getDocument(new String (buff), false);
    }
}