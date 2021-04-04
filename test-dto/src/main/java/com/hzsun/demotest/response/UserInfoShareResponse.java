package com.hzsun.demotest.response;

import java.io.Serializable;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年5月7日  
**/
public class UserInfoShareResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;

    private String alipayUserId;

    private Integer idType;

    private String idNumber;

    private String username;

    private String avatar;

    private String nickName;
    
    private String country; 
    
    private String province;

    private String city;

    private String gender;

    private String userType;

    private Integer isCertified;

    private Integer isStudentCertified;
    
    private String  phone;

    private String email;

    private String paytype;// 支付方式, 这里云马一码通会主动返回调用一卡通支付

	private String extendsValue;//建行e码通存第三方平台组织机构代码

	public String getExtendsValue() {
		return extendsValue;
	}

	public void setExtendsValue(String extendsValue) {
		this.extendsValue = extendsValue;
	}

	public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getUserId() {
    
        return userId;
    }

    public void setUserId(String userId) {
    
        this.userId = userId;
    }

    public String getAlipayUserId() {
    
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
    
        this.alipayUserId = alipayUserId;
    }

    public Integer getIdType() {
    
        return idType;
    }

    public void setIdType(Integer idType) {
    
        this.idType = idType;
    }

    public String getIdNumber() {
    
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
    
        this.idNumber = idNumber;
    }

    public String getUsername() {
    
        return username;
    }

    public void setUsername(String username) {
    
        this.username = username;
    }

    public String getAvatar() {
    
        return avatar;
    }

    public void setAvatar(String avatar) {
    
        this.avatar = avatar;
    }

    public String getNickName() {
    
        return nickName;
    }

    public void setNickName(String nickName) {
    
        this.nickName = nickName;
    }

    public String getProvince() {
    
        return province;
    }

    public void setProvince(String province) {
    
        this.province = province;
    }

    public String getCity() {
    
        return city;
    }

    public void setCity(String city) {
    
        this.city = city;
    }

    public String getGender() {
    
        return gender;
    }

    public void setGender(String gender) {
    
        this.gender = gender;
    }

    public String getUserType() {
    
        return userType;
    }

    public void setUserType(String userType) {
    
        this.userType = userType;
    }

    public Integer getIsCertified() {
    
        return isCertified;
    }

    public void setIsCertified(Integer isCertified) {
    
        this.isCertified = isCertified;
    }

    public Integer getIsStudentCertified() {
    
        return isStudentCertified;
    }

    public void setIsStudentCertified(Integer isStudentCertified) {
    
        this.isStudentCertified = isStudentCertified;
    }

    public String getPhone() {
    
        return phone;
    }

    public void setPhone(String phone) {
    
        this.phone = phone;
    }

    public String getEmail() {
    
        return email;
    }

    public void setEmail(String email) {
    
        this.email = email;
    }

    public String getCountry() {
    
        return country;
    }

    public void setCountry(String country) {
    
        this.country = country;
    }
    
    
    
    
    
    

    
}
  
    