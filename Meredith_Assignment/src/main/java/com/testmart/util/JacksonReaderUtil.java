/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class JacksonReaderUtil {

    private static final Logger LOG = LogManager.getLogger();

    public static <T> T getObject(String jsonString, Class<T> clazz){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return (T) objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            LOG.error("An exception occurred while converting {} to class={}, exception={}",jsonString,clazz,e);
        }
        return null;
    }
}
