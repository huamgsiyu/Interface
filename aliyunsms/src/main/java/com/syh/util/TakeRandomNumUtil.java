package com.syh.util;

import org.junit.Test;

/**
 * TakeRandomNumUtil
 *  only apply 1-9 digit verification code
 * @author HSY
 * @since 2020/05/11 13:15
 */
public class TakeRandomNumUtil {
    /**
     *  int maxvalue = 2147483647, so valid digits is 9
     */
    private final static int INT_DIGITS_LIMIT = 9;

    /**
     * 获取随机数
     * @param digits    指定获取几位随机数
     * @return  int
     */
    public static int getNum (int digits) {
        if (digits <= 0) {
            return 0;
        }
        if (digits > INT_DIGITS_LIMIT) {
            throw new NumberFormatException("out of int range");
        }
        int digit = 1;
        while (--digits > 0) {
            digit *= 10;
        }
        return (int)((Math.random() * 9 + 1) * digit);
    }
}
