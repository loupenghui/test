package com.hzsun.demotest.qo;
import java.io.Serializable;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年5月7日  
**/
public class UserinfoQuery  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String userid;

    private String username;

    private Short idtype;

    private String idno;

    private String contant;


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

 

}
    