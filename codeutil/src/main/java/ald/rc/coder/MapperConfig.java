package ald.rc.coder;

public class MapperConfig {
	public static String baseMapperPackage="ald.rc.dal";
	public static String doPackage="ald.rc.dal.bo";
	public static String daoPacakge="ald.rc.dal.dao";
	
	
	public static String resourcePath="src/main/resources/";
	public static String javaPath="src/main/java/";
	public static String packageNamePath="ald/rc/dal";
	public static String mapperPath="config/mapper/";
	public static String templatePath="D:/workspace/risk/codeutil/src/main/resources/template/mysql";
	public static String outprojectPath="D:/workspace/risk/dal/";
	public static String outputPath=outprojectPath+javaPath+packageNamePath;
	public static String mapperoutputPath=outprojectPath+javaPath+packageNamePath;
	public static String xmlMapperOutPutPath=outprojectPath+resourcePath+mapperPath;
	
	public static String TEMPLATA_MAPPER_FILE="mapper.ftl";
	public static String TEMPLATE_DO_FILE="domain.ftl";
	public static String TEMPLATE_MAPPER_XML_FILE="dbmapper.ftl";
}
