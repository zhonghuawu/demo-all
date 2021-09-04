package com.huaa.demo.dlms;

import gurux.dlms.GXDLMSClient;
import gurux.dlms.enums.InterfaceType;

/**
 * Desc:
 *
 * @author wuzhonghua
 * @date 2021/7/4 23:24
 */
public class DlmsClient {

    private final GXDLMSClient client;

    {
        client = new GXDLMSClient();
        client.setInterfaceType(InterfaceType.HDLC);

        client.setClientAddress(16);
        client.setServerAddress(1);

    }

}
