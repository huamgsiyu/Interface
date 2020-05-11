package com.syh.sms.aliyunsms;

import com.aliyuncs.CommonResponse;
import org.junit.Test;

/**
 * AliyunSmsTest
 *
 * @author HSY
 * @since 2020/05/11 12:53
 */

public class AliyunSmsTest {

    @Test
    public void setSmsTest () {
        CommonResponse commonResponse = AliyunSms.setSms("XXX",
                "XXX",
                "XXX",
                getMessage(),
                "XXX",
                "XXX");
        System.out.println("commonResponse = " + commonResponse.getData());
        /*
        收到短信结果如下：
            【业务监控系统】您的验证码323383，该验证码5分钟内有效，请勿泄漏于他人！
         */
    }
    private static java.lang.String getMessage() {
        return "{\"code\":\"" + getRandomNum() + "\"}";
    }

    private static int getRandomNum() {
        return (int)((Math.random() * 9 + 1) * 100000);
    }
}
