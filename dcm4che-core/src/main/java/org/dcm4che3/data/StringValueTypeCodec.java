/**
 * Copyright Karos Health Incorporated 2018
 */
package org.dcm4che3.data;

/**
 * @author Mike McFarland
 * @since Aug 15, 2018
 */
public interface StringValueTypeCodec {

    String decode(SpecificCharacterSet scs, StringValueType svt, byte[] value);

    byte[] encode(SpecificCharacterSet scs, StringValueType svt, String value);
}
