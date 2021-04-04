package com.hzsun.demotest.dto.userinfo;

import java.io.Serializable;
import java.util.Date;

public class UiWithholdbindDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String withholdid;

    private String userid;

    private String appid;

    private String paychannelid;

    private String paychanneluserid;

    private String signuserid;

    private String personcode;

    private String reqagreementno;

    private String agreementno;

    private Date signtime;

    private Date invalidtime;

    private String externalmsg;

    private Integer flag;
    
    //用来用户展示参数
    
//  cardState   String  卡状态 01有效 02无效
    private  String cardState;
//    balance String  卡余额
    private  String balance;
//    name    String  学生姓名
    private String name;
//    studentNo   String  学号
    private String studentNo;
    private String accnum;
    private String depname;

    public String getWithholdid() {
        return withholdid;
    }

    public void setWithholdid(String withholdid) {
        this.withholdid = withholdid == null ? null : withholdid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getPaychannelid() {
        return paychannelid;
    }

    public void setPaychannelid(String paychannelid) {
        this.paychannelid = paychannelid == null ? null : paychannelid.trim();
    }

    public String getPaychanneluserid() {
        return paychanneluserid;
    }

    public void setPaychanneluserid(String paychanneluserid) {
        this.paychanneluserid = paychanneluserid == null ? null : paychanneluserid.trim();
    }

    public String getSignuserid() {
        return signuserid;
    }

    public void setSignuserid(String signuserid) {
        this.signuserid = signuserid == null ? null : signuserid.trim();
    }

    public String getPersoncode() {
        return personcode;
    }

    public void setPersoncode(String personcode) {
        this.personcode = personcode == null ? null : personcode.trim();
    }

    public String getReqagreementno() {
        return reqagreementno;
    }

    public void setReqagreementno(String reqagreementno) {
        this.reqagreementno = reqagreementno == null ? null : reqagreementno.trim();
    }

    public String getAgreementno() {
        return agreementno;
    }

    public void setAgreementno(String agreementno) {
        this.agreementno = agreementno == null ? null : agreementno.trim();
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public Date getInvalidtime() {
        return invalidtime;
    }

    public void setInvalidtime(Date invalidtime) {
        this.invalidtime = invalidtime;
    }

    public String getExternalmsg() {
        return externalmsg;
    }

    public void setExternalmsg(String externalmsg) {
        this.externalmsg = externalmsg == null ? null : externalmsg.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getCardState() {
    
        return cardState;
    }

    public void setCardState(String cardState) {
    
        this.cardState = cardState;
    }

    public String getBalance() {
    
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getAccnum() {
        return accnum;
    }

    public void setAccnum(String accnum) {
        this.accnum = accnum;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }
    
    
}