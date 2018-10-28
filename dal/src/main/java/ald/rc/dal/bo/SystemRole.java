package ald.rc.dal.bo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体: 角色表
 * 
 * @author shi
 * @date 2018-10-28
 */
 
 public class SystemRole{
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 修改时间
     */
    private String gmtCreate;
    /**
     * 修改时间
     */
    private String gmtModified;
    /**
     * 名称
     */
    private String name;
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
    
    public String getGmtcreate(){
      return gmtCreate;
    }
    
    public void setGmtcreate(String gmtCreate){
      this.gmtCreate = gmtCreate;
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