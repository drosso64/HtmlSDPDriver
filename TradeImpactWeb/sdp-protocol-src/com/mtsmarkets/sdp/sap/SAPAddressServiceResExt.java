package com.mtsmarkets.sdp.sap;


import java.io.Serializable;

import com.mtsmarkets.io.xdr.UInt;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPAddressServiceResExt extends SAPMessage {

    public static final int MSG_TYPE = 253;
    public static final int MAX_PLATFORMS = 20;
    public static final int MAX_SERVICES = 10;
        
    public enum Result {
        SAP_AddressServiceOK(0),
        SAP_AddressServiceBAD(1);

        Result(int value) {
        }
    }

    public class Service implements Serializable{

        private SAPServiceType service = SAPServiceType.TXN_INFO_PRIV;
        private String address;
        private ULong port = new ULong(0);

        public SAPServiceType getService() {
            return service;
        }

        public void setService(SAPServiceType service) {
            this.service = service;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getPort() {
            return (int) port.getValue();
        }

        public void setPort(ULong port) {
            this.port = port;
        }
    }

    public class Platform implements Serializable {

        private UInt platform = new UInt(0);
        private Service[] services = new Service[MAX_SERVICES];

        public UInt getPlatform() {
            return platform;
        }

        public void setPlatform(UInt platform) {
            this.platform = platform;
        }

        public Service[] getServices() {
            return services;
        }

        public void setServices(Service[] services) {
            this.services = services;
        }
    }

    //Body
    private ULong reqId = new ULong(0);
    private Result result = Result.SAP_AddressServiceOK;
    //private Service[] services = new Service[20];
    private Platform[] platforms = new Platform[MAX_PLATFORMS];

    public SAPAddressServiceResExt(SAPHeader sapHeader) {
        super(sapHeader);
        for (int platform = 0; platform < platforms.length; platform++) {
            platforms[platform] = new Platform();
            for (int service = 0; service < platforms[platform].getServices().length; service++) {
                platforms[platform].getServices()[service] = new Service();
            }
        }
    }

    @Override
    public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {
        reqId.setValue(byteBuff.readInt());
        result = Result.values()[byteBuff.readInt()];
        for (Platform platform : platforms) {
            platform.platform.setValue(byteBuff.readInt());
            for (Service service : platform.services) {
                service.service = SAPServiceType.values()[byteBuff.readInt()];
                service.address = byteBuff.readString();
                service.port.setValue(byteBuff.readInt());
            }
        }
    }

    @Override
    public int writeXDR(XDRByteBuffer byteBuff) throws Exception {
        int init = byteBuff.getByteBuff().position();
        // header pdu
        sapHeader.writeXDR(byteBuff);
        // body pdu
        byteBuff.writeInt((int) reqId.getValue());
        byteBuff.writeInt(result.ordinal());

        for (Platform platform : platforms) {
            byteBuff.writeInt((int) platform.platform.getValue());
            for (Service service : platform.services) {
                byteBuff.writeInt(service.service.ordinal());
                byteBuff.writeString(service.address);
                byteBuff.writeInt((int) service.port.getValue());
            }
        }
        return byteBuff.getByteBuff().position() - init;
    }

    public void setReqId(ULong reqId) {
        this.reqId = reqId;
    }

    public ULong getReqId() {
        return reqId;
    }

    public Platform[] getPlatforms() {
        return platforms;
    }

    @Override
    public String toString() {
        StringBuilder strBd = new StringBuilder().append("SAPAddressServiceResExt::")
                .append("ReqID(").append(reqId.getValue()).append(")")
                .append("Result(").append(result).append(")");

        for (Platform platform : platforms) {
            strBd.append("{Platform(").append(platform.platform.getValue()).append(")");
            for (Service service : platform.services) {
                strBd.append("[Service(").append(service.service).append(")")
                  .append("Address(").append(service.address).append(")")
                  .append("port(").append(service.port.value).append(")]");
            }
            strBd.append("} ");
        }
        return strBd.toString();
    }
}
