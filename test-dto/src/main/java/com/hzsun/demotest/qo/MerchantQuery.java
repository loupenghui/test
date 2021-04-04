package com.hzsun.demotest.qo;

import java.io.Serializable;
import java.util.Date;

public class MerchantQuery implements Serializable{
	private static final long serialVersionUID = -2279781482355968001L;

	private String merchantid;

    private String merchantname;

    private String merchantcode;

    private String merchantemail;

    private String merchanttel;

    private Integer merchanttype;

    private Integer province;

    private Integer city;

    private Integer area;

    private String address;

    private String artificialperson;

    private String artificialpersonid;

    private String contact;

    private String contacttel;

    private Date invaliddate;

    private byte[] businesslicence;

    private String invaliddateStr;
    
    private String imgpath;
    
    private String imgname;
    
    
    public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getInvaliddateStr() {
		return invaliddateStr;
	}

	public void setInvaliddateStr(String invaliddateStr) {
		this.invaliddateStr = invaliddateStr;
	}

	public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname == null ? null : merchantname.trim();
    }

    public String getMerchantcode() {
        return merchantcode;
    }

    public void setMerchantcode(String merchantcode) {
        this.merchantcode = merchantcode == null ? null : merchantcode.trim();
    }

    public String getMerchantemail() {
        return merchantemail;
    }

    public void setMerchantemail(String merchantemail) {
        this.merchantemail = merchantemail == null ? null : merchantemail.trim();
    }

    public String getMerchanttel() {
        return merchanttel;
    }

    public void setMerchanttel(String merchanttel) {
        this.merchanttel = merchanttel == null ? null : merchanttel.trim();
    }

    public Integer getMerchanttype() {
        return merchanttype;
    }

    public void setMerchanttype(Integer merchanttype) {
        this.merchanttype = merchanttype;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getArtificialperson() {
        return artificialperson;
    }

    public void setArtificialperson(String artificialperson) {
        this.artificialperson = artificialperson == null ? null : artificialperson.trim();
    }

    public String getArtificialpersonid() {
        return artificialpersonid;
    }

    public void setArtificialpersonid(String artificialpersonid) {
        this.artificialpersonid = artificialpersonid == null ? null : artificialpersonid.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContacttel() {
        return contacttel;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel == null ? null : contacttel.trim();
    }

    public Date getInvaliddate() {
        return invaliddate;
    }

    public void setInvaliddate(Date invaliddate) {
        this.invaliddate = invaliddate;
    }

    public byte[] getBusinesslicence() {
        return businesslicence;
    }

    public void setBusinesslicence(byte[] businesslicence) {
        this.businesslicence = businesslicence;
    }
}