package com.github.wxpay.sdk;

import java.io.InputStream;

/**
 * @Author 86186
 * @Date 2019/10/25 15:20
 */
public class Config extends WXPayConfig {
    // appid
    @Override
    public String getAppID() {
        return "wx8397f8696b538317";
    }

    // 商户号
    @Override
    public String getMchID() {
        return "1473426802";
    }

    @Override
    public String getKey() {
        return "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb";
    }

    // 证书
    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String s, long l, Exception e) {

            }

            @Override
            public DomainInfo getDomain(WXPayConfig wxPayConfig) {
                return new DomainInfo("api.mch.weixin.qq.com", true);
            }
        };
    }
}
