/**
 * Copyright Karos Health Incorporated 2018
 */
package org.dcm4che3.plugins.spi;

import org.dcm4che3.data.SpecificCharacterSet;
import org.dcm4che3.data.StringValueType;

/**
 * @author Mike McFarland
 * @since Aug 15, 2018
 */
public interface Dcm4che3StringCodec {

    String decode(SpecificCharacterSet scs, StringValueType svt, byte[] value);

    byte[] encode(SpecificCharacterSet scs, StringValueType svt, String value);
}
