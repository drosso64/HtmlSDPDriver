/*

 * To change this template, choose Tools | Templates

 * and open the template in the editor.

 */

package com.mtsmarkets.sdp.smp;



import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResult;
import com.mtsmarkets.sdp.common.SDPResultCode;






public class SMPException extends SDPException {





    public SMPException(SDPResultCode errorCode) {

        super(errorCode);        

    }



    public SMPException(SDPResultCode errorCode, Throwable cause) {

        super(errorCode, cause);        

    }



    public SMPException(SDPResultCode errorCode, String errorDetail) {

        super(errorCode, errorDetail);

    }



    public SMPException(SDPResultCode errorCode, String errorDetail, Throwable cause) {

        super(errorCode, errorDetail, cause);

    }



    public SMPException(SDPResult sdpResult) {

        super(sdpResult);

    }

    

}

