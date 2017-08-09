package ald.rc.coder;

import freemarker.template.utility.StringUtil;

public class UsedColumn extends Column {

	public String getAccessColumnName(){
		String accessName = StringUtil.capitalize(DBUtil.underscore2Camelcase(getColumnName(), Create.priff));
		return accessName;
	}
	public String getFieldName(){
		return super.getColumnName();
	}
	
	public String getJdbcType(){
		return DBUtil.sqlTypeToJdbcType(super.getDataType());
	}
	
	@Override
	public String getColumnName(){
		return DBUtil.underscore2Camelcase(super.getColumnName(), Create.priff);
	}
	
	@Override
	public String getDataType(){
		String javaDataType = DBUtil.sqlTypeToJavaType(super.getDataType());
		return javaDataType;
		
	}
}
