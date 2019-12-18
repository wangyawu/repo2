package com.qingcheng.consumer;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonResponse;
import com.qingcheng.util.SmsUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * @Author 86186
 * @Date 2019/10/21 15:56
 */
public class SmsMessageConsumer implements MessageListener {

    @Autowired
    private SmsUtil smsUtil;

    @Value("${smsCode}")
    private String smsCode;

    @Value("${param}")
    private String param;

    @Override
    public void onMessage(Message message) {
        String jsonString = new String(message.getBody());
        Map<String, String> map = JSON.parseObject(jsonString, Map.class);

        String phone = map.get("phone");
        String code = map.get("code");
        System.out.println("phone:" + phone + ",verification code:" + code);

        // 调用阿里云通信
        CommonResponse commonResponse = this.smsUtil.sendSms(phone, smsCode, param.replace("[value]", code));
    }
}
