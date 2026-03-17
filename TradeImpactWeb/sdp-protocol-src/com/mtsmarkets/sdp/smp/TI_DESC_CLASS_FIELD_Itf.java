/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mtsmarkets.sdp.smp;

import com.mtsmarkets.io.xdr.ULong;

public interface TI_DESC_CLASS_FIELD_Itf {

    public String getEntityName();
	public void setEntityName(String value);
	public ULong getEntityID();
	public void setEntityID(ULong value);
	public ULong getFieldIndx();
	public void setFieldIndx(ULong value);
	public String getFieldName();
	public void setFieldName(String value);
	public String getFieldType();
	public void setFieldType(String value);
	public short getDerived();
	public void setDerived(short value);
	public TI_DESC_FIELD_TYPE_Enum getPtype();
	public void setPtype(TI_DESC_FIELD_TYPE_Enum value);
	public ULong getOffset();
	public void setOffset(ULong value);
	public ULong getLen();
	public void setLen(ULong value);
	public ULong getNumElems();
	public void setNumElems(ULong value);

}
