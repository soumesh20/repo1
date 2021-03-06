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

package com.fiorano.openesb.utils.crypto;

import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.security.KeyStore;

/**
 * Created by IntelliJ IDEA.
 * User: Lokesh
 * Date: 15 Jun, 2011
 * Time: 6:00:32 PM
 * To change this template use File | Settings | File Templates.
 */

public class KeystoreManager {

    /**
     * Writes the given key into a JCEKS keystore with default alias and storepass
     *
     * @param key  encryption key
     * @param file file to which keystore is written
     * @throws KeystoreException
     */
    public static void writeToKeystore(String key, File file) throws KeystoreException {
        writeToKeystore(key, file, CommonConstants.DEFAULT_ALIAS, CommonConstants.DEFAULT_STOREPASS.toCharArray());
    }

    /**
     * Writes the given key into a JCEKS keystore
     *
     * @param key       encryption key
     * @param file      file to which keystore is written
     * @param alias     alias for the encryption key
     * @param storePass masterPasswd for the keystore
     * @throws KeystoreException
     */
    public static void writeToKeystore(String key, File file, String alias, char[] storePass) throws KeystoreException {
        SecretKeySpec skeySpec = null;
        try {

            byte[] raw = key.getBytes(CommonConstants.UNICODE_FORMAT);
            skeySpec = new SecretKeySpec(raw, CommonConstants.AES_ENCRYPTION_SCHEME);

            // Get the KeyStore
            KeyStore ks = KeyStore.getInstance(CommonConstants.JCE_KEYSTORE);

            // Create the KeyStore
            ks.load((InputStream) null, storePass);

            // Put key into store
            ks.setKeyEntry(alias, skeySpec, storePass, null);

            // Write KeyStore to disk
            FileOutputStream out = new FileOutputStream(file);
            try {
                ks.store(out, storePass);
            } finally {
                out.close();
            }
        } catch (Exception e) {
            throw new KeystoreException(e);
        }
    }

    /**
     * Writes the given key into a JCEKS keystore and returns the keystore as a byte array with default alias and storepass
     *
     * @param key encryption key
     * @return The JCEKS keystore as a byte array
     * @throws KeystoreException
     */
    public static byte[] writeToKeystore(String key) throws KeystoreException {
        return writeToKeystore(key, CommonConstants.DEFAULT_ALIAS, CommonConstants.DEFAULT_STOREPASS.toCharArray());
    }

    /**
     * Writes the given key into a JCEKS keystore and returns the keystore as a byte array
     *
     * @param key       encryption key
     * @param alias     alias for the encryption key
     * @param storePass masterPasswd for the keystore
     * @return The JCEKS keystore as a byte array
     * @throws KeystoreException
     */
    public static byte[] writeToKeystore(String key, String alias, char[] storePass) throws KeystoreException {
        SecretKeySpec skeySpec = null;
        try {

            byte[] raw = key.getBytes(CommonConstants.UNICODE_FORMAT);
            skeySpec = new SecretKeySpec(raw, CommonConstants.AES_ENCRYPTION_SCHEME);

            // Get the KeyStore
            KeyStore ks = KeyStore.getInstance(CommonConstants.JCE_KEYSTORE);

            // Create the KeyStore
            ks.load((InputStream) null, storePass);

            // Put key into store
            ks.setKeyEntry(alias, skeySpec, storePass, null);

            // Write KeyStore to disk
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ks.store(baos, storePass);

            //closing BAOS has no effect

            return baos.toByteArray();

        } catch (Exception e) {
            throw new KeystoreException(e);
        }
    }

    /**
     * Returns the encryption key from the supplied JCEKS keystore and default alias and storepass
     *
     * @param file The keystore file from which encryption key is to be extracted
     * @return The encryption key
     * @throws KeystoreException
     */
    public static String getKeyFromKeystore(File file) throws KeystoreException {
        return getKeyFromKeystore(file, CommonConstants.DEFAULT_ALIAS, CommonConstants.DEFAULT_STOREPASS.toCharArray());
    }

    /**
     * Returns the encryption key from the supplied JCEKS keystore
     *
     * @param file      The keystore file from which encryption key is to be extracted
     * @param alias     alias for the encryption key
     * @param storePass masterPasswd for the keystore
     * @return The encryption key
     * @throws KeystoreException
     */
    public static String getKeyFromKeystore(File file, String alias, char[] storePass) throws KeystoreException {
        Key keyFromStore = null;
        byte[] raw = null;
        try {
            
            KeyStore keyStore = KeyStore.getInstance(CommonConstants.JCE_KEYSTORE);

            if (file.exists()) {   // don't buffer keystore; it's tiny anyway
                FileInputStream input = new FileInputStream(file);
                keyStore.load(input, storePass);
                input.close();
            }

            // Get key from KeyStore on disk
            keyFromStore = keyStore.getKey(alias, storePass);

            raw = keyFromStore.getEncoded();

        } catch (Exception e) {
            throw new KeystoreException(e);
        }

        return new String(raw);
    }

    /**
     * Returns the encryption key from the supplied JCEKS keystore byte stream with default alias and storepass
     *
     * @param keystoreStream The JCKES keystore byte stream
     * @return The encryption key
     * @throws KeystoreException
     */
    public static String getKeyFromKeystore(byte[] keystoreStream) throws KeystoreException {
        return getKeyFromKeystore(keystoreStream, CommonConstants.DEFAULT_ALIAS, CommonConstants.DEFAULT_STOREPASS.toCharArray());
    }

    /**
     * Returns the encryption key from the supplied JCEKS keystore byte stream
     *
     * @param keystoreStream The JCKES keystore byte stream
     * @param alias          alias for the encryption key
     * @param storePass      masterPasswd for the keystore
     * @return The encryption key
     * @throws KeystoreException
     */
    public static String getKeyFromKeystore(byte[] keystoreStream, String alias, char[] storePass) throws KeystoreException {
        Key keyFromStore = null;
        byte[] raw = null;
        try {
            
            KeyStore keyStore = KeyStore.getInstance(CommonConstants.JCE_KEYSTORE);
            ByteArrayInputStream bais = new ByteArrayInputStream(keystoreStream);
            keyStore.load(bais, storePass);

            // Get key from KeyStore on disk
            keyFromStore = keyStore.getKey(alias, storePass);

            raw = keyFromStore.getEncoded();

        } catch (Exception e) {
            throw new KeystoreException(e);
        }

        return new String(raw);
    }

    /**
     * wrapper exception class
     */
    public static class KeystoreException extends Exception {
        public KeystoreException(Throwable t) {
            super(t);
        }
    }
}
