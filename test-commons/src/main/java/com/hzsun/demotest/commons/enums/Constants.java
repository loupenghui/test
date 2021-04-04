package com.hzsun.demotest.commons.enums;

/**
 * @Description:
 * @Author: dingjl
 * @Date: 2018年4月17日
 **/
public class Constants {
    public enum ExceptionType {
        // 1.自定义异常2.程序异常3.致命错误4.处理超时 5 .第三方错误
        DEFINEDEXCEPTION(1), PROGRAMEXCEPTION(2), ERROR(3), TIMEOUT(4), THIRDEWARN(5);
        private int value;

        ExceptionType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum ExceptionSource {
        // 1.服务来源 2 接口来源
        SERVICE(1), INTERFACE(2);
        private int value;

        ExceptionSource(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum PayWayCode {
        // 1.支付宝 2 微信 3 预留 校园卡 4 银联 // 5 云马 一码通 6 建设银行 7 空着不用 8威富通 9农业银行 10:翼支付
        // 11 建行e码通
        ALIPAY("000001"), WECHAT("000002"), UNIONPAY("000004"), YUNMA("000005"), FJCCB("000006"), WEIFUTONG(
                "000008"), ABCBANK("000009"), YIZHIFU("000010"), CCBEMT("000011"),MESSAGEGATEWAY("999999");
        private String value;

        PayWayCode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum PayType {
        // 1.支付宝 2 校园卡 3微信支付 4 银联 5 云马 一码通 6 建设银行 8:威富通 9:农行 10:翼支付 11 建行e码通
        ALIPAY("1"), SchoolCard("2"), WECHAT("3"), UNIONPAY("4"), YUNMA("5"), FJCCB("6"), WEIFUTONG("8"), ABCBANK(
                "9"), YIZHIFU("10"), CCBEMT("11");
        private String value;

        PayType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum ClientFormat {
        JSON("json");
        private String value;

        ClientFormat(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum AliClientResponse {
        SUCCESS("10000");
        private String value;

        AliClientResponse(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum AppEncryptType {
        // 1.加密方式 2
        SHAWITHRSA256(1), SHA1(2), MD5(3);
        private int value;

        AppEncryptType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum EncryptType {
        // 1.加密方式 2
        RSA2(1), RSA(2), MD5(3);
        private int value;

        EncryptType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Flag {
        // 1.有效 2.无效
        VALID(1), INVALID(2);
        private int value;

        Flag(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum OperatorUsing {
        // 0:禁用 1:启用
        UNSING(0), USING(1);

        private int value;

        OperatorUsing(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum OrderStatus {
        // 1 待付款 2 支付成功 3 支付失败 4 退款中 5 退款成功
        UNPAID(1), PAID(2), PAYFAILED(3), UNREFUND(4), REFUND(5), CLOSE(6);
        private int value;

        OrderStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum OrderType {
        // 1充值类 2 消费类 3 缴费类 4 退款类 5 其他
        RECHARGE(1), CONSUME(2), PAYMENT(3), REFUND(4), OTHER(5);
        private int value;

        OrderType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum OrderTypeClass {
        // 1充值类 2 消费类 3 缴费类 4 退款类 5 其他
        RECHARGE("1"), CONSUME("2"), PAYMENT("3"), REFUND("4"), OTHER("5");
        private String value;

        OrderTypeClass(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum CheckStatus {
        // 1 未对账 2 对账成功 3通过补帐对账4 支付方式多扣 4 支付宝少扣
        UNCHECK(1), CHECK(2), SUPPLYCHECK(3), MOREPAY(4), LESSPAY(5);
        private int value;

        CheckStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum HandlerType {
        // 1 未处理 2 自动处理 3 手动处理 4 异常
        UNHANDLER(1), AUTOMATICHANDLER(2), HANDHANDLER(3), EXCEPTIONHANDLER(4);
        private int value;

        HandlerType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum SystemConfig {
        // 1.域名 2 cookie域名
        DOMAINNANE("000001"), COOKIEDOMAIN("000002"),
        // '微信开发平台账号component_appid');
        COMPONENT_APPID("000004"),
        // '微信开发平台秘钥component_appsecret');
        COMPONENT_APPSECRET("000005"),
        // '微信开发平台验证component_verify_ticket');
        COMPONENT_VERIFY_TICKET("000006"),
        // '微信开发平台TOKENcomponent_access_token');
        COMPONENT_ACCESS_TOKEN("000007"),
        // '微信开发平台AESKEY component_aeskey');
        COMPONENT_AESKEY("000008"),
        // '微信开发平台消息校验TOKEN component_TOKEN 
        COMPONENT_TOKEN("000009"),
        //极光推送push app_key
        JPUSH_APP_KEY("000010"),
        //极光推送push master_secret
        JPUSH_MASTER_SECRET("000011"),
        ;
        private String value;

        SystemConfig(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum RecFlag {// 禁用标记
        // 0-禁用，1-启用。
        FORBIDDEN(0), USING(1);

        private int value;

        RecFlag(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum IsDefaultPWD {// 默认密码
        // 0-非默认，1-默认。
        UNDEFAULT(0), DEFAULT(1);

        private int value;

        IsDefaultPWD(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum DefaultAPP {// 默认应用
        // 2-非默认，1-默认。
        UNDEFAULT(2), DEFAULT(1);

        private int value;

        DefaultAPP(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Finance {// 操作员类别
        // 0-非账务相关操作员，1-账务操作员。本数据无需前端维护，当操作员产生相关账务流水，如充值、取款、销卡取款、销户取款、收押金、收卡费、收存款管理费等等操作时后台自动更新成1
        NOTISFINANCE(0), ISFINANCE(1);

        private int value;

        Finance(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Charset {
        // 字符集
        UTF8("utf-8"), GBK("gbk");
        private String value;

        Charset(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Format {
        // 字符集
        JSON("json");
        private String value;

        Format(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum SignType {
        // 字符集
        RSA2("RSA2"), RSA("RSA");
        private String value;

        SignType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Version {
        // 字符集
        V1("1.0");
        private String value;

        Version(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Initialize {

        DEFAULTROLE(1), DEFAULTOPERATOR(100001), DEFAULPWD(888888);
        private int value;

        Initialize(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum AuthChannel {
        // 1 支付宝 2 微信 3 银联 4 校园卡
        ALIPAY(1), WECHAT(2), UNIONPAY(3), SCHOOLCARD(4);
        private int value;

        AuthChannel(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum AuthType {
        // 1 身份证认证 2 个人编号认证
        IDNO(1), PERSONCODE(2);
        private int value;

        AuthType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum WeiXinResponse {
        // 0:正常
        SUCCESS(0);
        private int value;

        WeiXinResponse(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum DefaulTreceive {// 默认二维码接收,在客户应用未开通微信支付宝,银行支持微信支付宝支付,则直接接收银行的二维码(大概就是这个意思)
        // 1 否 2 是
        UNDEFAULT(1), DEFAULT(2);
        private int value;

        DefaulTreceive(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum CCBQrCode {
        SCHOOLPAY("CCBIA"), // 校园付款码
        CANTEEN("CCB994"), // 食堂码,新的付款码
        UNIONPAY("6240"), UNIONPAY2("6230");
        private String code;

        private CCBQrCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public enum CCBEMTQrCode {
        YKT("YXY333"), // 一卡通二维码
        WALLET("CCB991");// 钱包二维码
        private String code;

        private CCBEMTQrCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
