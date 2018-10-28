package ald.rc.dal.bo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体: 用户表
 * 
 * @author shi
 * @date 2018-10-28
 */
 
 public class SystemUser{
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 创建时间
     */
    private String gmtCrete;
    /**
     * 修改时间
     */
    private String gmtModified;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 禁用,1=是,0=否
     */
    private Integer disabled;
    /**
     * 备注
     */
    private String comment;
    
    public Long getId(){
      return id;
    }
    
    public void setId(Long id){
      this.id = id;
    }
    
    public String getGmtcrete(){
      return gmtCrete;
    }
    
    public void setGmtcrete(String gmtCrete){
      this.gmtCrete = gmtCrete;
    }
    
    public String getGmtmodified(){
      return gmtModified;
    }
    
    public void setGmtmodified(String gmtModified){
      this.gmtModified = gmtModified;
    }
    
    public String getName(){
      return name;
    }
    
    public void setName(String name){
      this.name = name;
    }
    
    public String getPassword(){
      return password;
    }
    
    public void setPassword(String password){
      this.password = password;
    }
    
    public String getSalt(){
      return salt;
    }
    
    public void setSalt(String salt){
      this.salt = salt;
    }
    
    public Integer getDisabled(){
      return disabled;
    }
    
    public void setDisabled(Integer disabled){
      this.disabled = disabled;
    }
    
    public String getComment(){
      return comment;
    }
    
    public void setComment(String comment){
      this.comment = comment;
    }
    
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}