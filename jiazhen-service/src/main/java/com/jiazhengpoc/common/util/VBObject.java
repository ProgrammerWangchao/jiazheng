package com.jiazhengpoc.common.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * このクラスはVBObjectクラスです。
 * </pre>
 */
public class VBObject {

    /**
     * _Object
     *
     */
    private Object object;

    /**
     * VBObjectを処理する。
     *
     * @param obj obj
     */
    public VBObject(Object obj) {
        object = obj;
        if (obj instanceof VBObject) {
            object = ((VBObject) obj).getNative();
        }
    }

    /**
     * VBObject構造を処理する。
     *
     */
    public VBObject() {
    }

    /**
     * setValueを処理する。
     *
     * @param value value
     * @return
     */
    public void setValue(Object value) {
        object = value;
    }

    public Object getNative() {
        return object;
    }

    /**
     * setValueを処理する。
     *
     * @return result
     */
    public String stringValue() {
        String result = "";
        if (object != null) {
            result = String.valueOf(object);
        }
        return result;
    }

    /**
     * dateValueを処理する。
     *
     * @return result
     */
    public Date dateValue() {
        Date result = null;
        if (object != null) {
            if (object instanceof Date) {
                result = (Date) object;
            } else {
                result = DateUtil.stringToDate(object.toString());
            }
        }
        return result;
    }

    /**
     * bigDecimalValueを処理する。
     *
     * @return result
     */
    public BigDecimal bigDecimalValue() {
        return createBigDecimal();
    }

    /**
     * intValueを処理する。
     *
     * @return result
     */
    public int intValue() {
        int result = 0;
        BigDecimal decimal = createBigDecimal();
        if (decimal != null) {
            result = decimal.intValue();
        }
        return result;
    }

    /**
     *
     * <pre>
     * BigDecimalを転換する。
     * </pre>
     *
     * @return BigDecimal
     */
    private <T> BigDecimal createBigDecimal() {

        if (object == null) {
            return null;
        }

        if (object instanceof BigDecimal) {
            return (BigDecimal) object;
        } else if (object instanceof Integer) {
            return new BigDecimal(((Integer) object));
        } else if (object instanceof Long) {
            return new BigDecimal(((Long) object));
        } else if (object instanceof Double) {
            return new BigDecimal(((Double) object));
        } else if (object instanceof Float) {
            return new BigDecimal(((Float) object));
        } else {
            return new BigDecimal(object.toString().replace(",", ""));
        }
    }
}
