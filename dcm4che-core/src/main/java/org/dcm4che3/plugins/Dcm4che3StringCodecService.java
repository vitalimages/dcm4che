/**
 * Copyright Karos Health Incorporated 2018
 */
package org.dcm4che3.plugins;

import org.dcm4che3.data.SpecificCharacterSet;
import org.dcm4che3.data.StringValueType;
import org.dcm4che3.plugins.spi.Dcm4che3StringCodec;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Mike McFarland
 * @since Aug 15, 2018
 *
 */
public abstract class Dcm4che3StringCodecService {

    protected static final ServiceLoader<Dcm4che3StringCodec> loader = ServiceLoader.load(Dcm4che3StringCodec.class);

    public static byte[] encode(SpecificCharacterSet scs, StringValueType svt, String value) {

        Iterator<Dcm4che3StringCodec> codecs = loader.iterator();

        if (codecs.hasNext()) { // assume there's only one ...
            return codecs.next().encode(scs, svt, value);
        } else {
            return scs.encode(value, svt.getDelimiter());
        }
    }

    public static String decode(SpecificCharacterSet scs, StringValueType svt, byte[] value) {

        Iterator<Dcm4che3StringCodec> codecs = loader.iterator();

        if (codecs.hasNext()) { // assume there's only one ...
            return codecs.next().decode(scs, svt, value);
        } else {
            return scs.decode(value);
        }
    }
}
