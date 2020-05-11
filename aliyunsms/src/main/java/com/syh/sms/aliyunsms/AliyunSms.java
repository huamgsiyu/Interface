package com.syh.sms.aliyunsms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 阿里云短信服务——验证码demo
 */
public class AliyunSms {

    /**
     * 发送短信验证码
     * @param phoneNumbers      接收短信的手机号码
     * @param signName          短信签名名称
     * @param templateCode      短信模板ID
     * @param accessKeyId       阿里云AccessKey            LTAI4GDtjyYEm1FoXbmpgFaK
     * @param accessSecret      阿里云AccessKey Secret     2g5gEJ4hYS90Z2vzU36RREYBLJUz07
     * @param templateParam     短信模板变量对应的实际值，JSON格式
     * @return    CommonResponse
     */
    public static CommonResponse setSms(String phoneNumbers,
                                        String signName,
                                        String templateCode,
                                        String templateParam,
                                        String accessKeyId,
                                        String accessSecret) {
        return setSms("cn-hangzhou",
                phoneNumbers,
                signName,
                templateCode,
                templateParam,
                accessKeyId,
                accessSecret,
                "dysmsapi.aliyuncs.com",
                "2017-05-25",
                "SendSms");
    }

    /**
     * 发送短信验证码
     * @param regionId          地区Id
     * @param phoneNumbers      接收短信的手机号码
     * @param signName          短信签名名称
     * @param templateCode      短信模板ID
     * @param templateParam     短信模板变量对应的实际值，JSON格式
     * @param accessKeyId       阿里云AccessKey            LTAI4GDtjyYEm1FoXbmpgFaK
     * @param accessSecret      阿里云AccessKey Secret     2g5gEJ4hYS90Z2vzU36RREYBLJUz07
     * @param domain            域名
     * @param version           版本
     * @param action            执行动作
     * @return  CommonResponse
     */
    public static CommonResponse setSms(String regionId,
                                        String phoneNumbers,
                                        String signName,
                                        String templateCode,
                                        String templateParam,
                                        String accessKeyId,
                                        String accessSecret,
                                        String domain,
                                        String version,
                                        String action) {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion(version);
        request.setAction(action);
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumbers);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);

        request.putQueryParameter("TemplateParam", templateParam);
        try {
            return client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }
}
