package com.hzsun.demotest.commons.exceptions;
/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月12日  
**/
public enum ServiceErrorEnum {
    E_Object_IsNull("S10001","对象不能为空!"),
    E_RedisService_Error("S10002","Redis服务出错了!"),
    E_MapsetParse_Error("S10003","MapSet转换出错!"),
    E_MerchantService_IsNotFind("S10004","Appid没有找到对应的应用!"),
    E_OrderService_IsNotUnique("S10005","该应用号此订单号不是唯一值,请联系服务人员!"),
    E_OrderService_OrderNotFind("S10006","系统不存在该订单!"),
    E_OrderService_IsNotPerssion("S10007","该应用无此订单!"),
    E_OrderService_IsPaid("S10008","该订单已经处理完成不能重新修改订单状态!"),
    E_Service_Error("S10009","服务出错了请稍后再试!"),
    E_OrderService_Paid("S10010","该订单已经完成支付不能重复支付!"),
    E_OrderService_NotunPaidNotClose("S10011","非待转账订单不允许关闭!"),
    E_OrderService_FINISHISREFUND("S10012","只有支付完成的订单才能进行退款!"),
    E_OrderService_GeneratedRefund("S10013","该订单已经产生退款了!"),
    E_OrderService_RefundAmountDisaccord("S10014","2次发起退款金额不一致!"),
    E_OrderService_IsNotRefund("S10015","该订单不是退款订单!"),
    E_UserInfoService_IDNOError("S10016","同一个证件号出现多次注册!"),
    E_UserInfoService_MoreCard("S10017","同一个账户出现多次领卡!"),
    E_Sign_Error("S10018","签名出错了!"),
    E_Unknow_Role("S10019", "用户角色不存在!"),
    E_Exist_Optrator_Name("S10020", "用户名已经存在!"),
    E_Exist_role_Name("S10021", "角色名称不能重复!"),
    E_Initialization_Operator_Unchangeable("S10022", "初始化操作员不能修改"),
    E_Initialization_Operator_Delete("S10023", "初始化操作员不能删除!"),
    E_Initialization_Role_Unchangeable("S10024", "初始化角色不能修改!"),
    E_Initialization_Role_Delete("S10025", "初始化角色不能删除!"),
    E_Conflict_operator_Role("S10026", "还有操作员与该角色关联,请先删除操作员!"),
    E_Exist_App_Template("S10027", "该客户应用的该支付渠道的模板已存在, 无法创建!"),
    E_Exist_App_Name("S10028", "该应用名称已存在!"),
    E_App_Has_PayChannels("S10029", "请先删除应用的支付渠道参数!"),
    E_Exist_App_Payparam("S10030", "客户应用和配置参数关系已存在!"),
    E_Exist_Merchant_Name("S10031", "该客户名称已存在!"),
    E_Exist_Merchant_Code("S10032", "该客户号已存在!"),
    E_Operator_Delete_Self("S10033", "操作员不能删除自己!"),
    E_Exist_Operator_Name("S10034", "操作员名称已存在"),
    E_OrderService_CLOSEED("S10035","该订单已经关闭!"),
    E_Connection_HttpRequestException("S10036","http请求错误!"),
    E_OrderService_ISExist("S10037","该订单已经存在!"),
    E_UserInfoService_ISNotBind("S10038","用户未绑定!"),
    E_OrderService_ISNOTZERO("S10039","订单金额不能为0.00!"),
    E_OrderService_NotifyError("S10040","订单通知出错了啊!"),
    E_MerchantService_ApplicationInvalid("S10041","该应用已经禁用!"),
    E_OrderService_REFUNDAmountError("S10042","退款金额不能超过支付金额!"),
    E_MerchantService_ApplicationChannelInvalid("S10043","该支付渠道已经禁用!"),
    E_OrderService_ISCHECKED("S10044","该订单已经对账完成!"),
    E_System_AESError("S10045","AES加密出错!"),
    E_MerchantService_PayChannelNotFind("S10046","该应用未开启该渠道支付方式!"),
    E_OrderService_RechargeOrderNotFind("S10047","该应用充值订单没有生成请重新下单!"),
    E_EXIST_DEFAULT_PAYCHANNEL("S10048","该应用默认支付渠道已配置!"),
    E_UserInfoService_MoreWithholiding("S10049","同一个账户出现多次签约!"),
    E_MerchantService_ISHASDEFAULT("S10050","该客户已经存在默认应用!"),
    ; 
    
    private String errorCode;
    
    private String message;
    
    ServiceErrorEnum(String code,String message){
        this.errorCode=code;
        this.message=message;
    }

    public String getMessage(){
        return"[code="+errorCode+",message="+message+"]";
    }
    public String getErrorCode() {
    
        return errorCode;
    }
    
    public String getMsg(){
        return message;
    }
    
    
    
}
  
    