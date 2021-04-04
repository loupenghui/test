package com.hzsun.demotest.dto.userinfo;
import java.io.Serializable;
import java.util.Date;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年5月7日  
**/
public class UserinfoDTO  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String userid;

    private String username;

    private Short idtype;

    private String idno;

    private String contant;

    private String email;

    private Short authchannel;

    private Short gender;

    private String country;

    private String province;

    private String city;

    private String avatar;

    private Date createtime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Short getIdtype() {
        return idtype;
    }

    public void setIdtype(Short idtype) {
        this.idtype = idtype;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant == null ? null : contant.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getAuthchannel() {
        return authchannel;
    }

    public void setAuthchannel(Short authchannel) {
        this.authchannel = authchannel;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
    