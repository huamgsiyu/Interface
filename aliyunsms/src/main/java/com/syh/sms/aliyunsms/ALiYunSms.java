package com.syh.sms.aliyunsms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class ALiYunSms {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI4FsCuaAsE5JkpALC6Hxc",
                "lAoBD3Ao9kKGDauzk0JZhdTGXivCdA");  //只有在创建accessKeyId时才能看到，如果忘记了只能重新创建
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "XXX");
        request.putQueryParameter("SignName", "XXX");
        request.putQueryParameter("TemplateCode", "XXX");

        request.putQueryParameter("TemplateParam", getMessage());
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    public static java.lang.String getMessage() {
        StringBuilder message = new StringBuilder("{\"name\":\"Tom\",\"code\":\"");
        message.append(getRandomNum());
        message.append("\"}");
        return message.toString();
    }
    public static int getRandomNum () {
        return (int)((Math.random() * 9 + 1) * 100000);
    }
}
