package ald.rc.coder;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.utility.StringUtil;

/**
 * mybatis映射代码生成器
 * 
 * @author Administrator
 *
 */
public class MybatisGenerate {
	
	
	/**
	 * @Description: 生成代码方法
	 * 
	 * @param db
	 * @param url
	 * @param MysqlUser
	 * @param mysqlPassword
	 * @param database
	 * @param table
	 * @param packageName
	 * @param batisName
	 * @param moduleName
	 * @param classAuthor
	 * @param functionName
	 */
	public static void generateCode(String db, String url, String MysqlUser, String mysqlPassword, String database,
			String table,String commonName, String packageName, String batisName, String moduleName, String classAuthor,
			String functionName,String classNamePrefix) throws Exception {
		
		Boolean needsDomain = true; // 是否生成实体类
		Boolean needsDao = true; // 是否生成Dao
		Boolean needsService = true; // 是否生成Service和ServiceImpl
		Boolean needsAction = true; // 是否生成Action
		Boolean needsMapper = true; //是否生成Mapper配置文件
		String showTables = null;
		String getTable = null;
		String table_name = "";
		
		// 链接数据库操作
		switch (db) {
		case "mysql":
			showTables = "show tables";
			getTable = "Tables_in_" + database;
			break;
		case "oracle":
			showTables = "SELECT TABLE_NAME FROM USER_ALL_TABLES";
			getTable = "TABLE_NAME";
			break;
		default:
			System.err.println("---暂不支持该类型数据库----");
			break;
		}
			
			
			Connection connection = DBUtil.getConn();
			Statement stateMent_table = (Statement) connection.createStatement();
			// 查询该数据库所有的表名
			ResultSet tables = stateMent_table.executeQuery(showTables);
			while (tables.next()) {
				table_name = tables.getString(getTable);
				// 判断执行那个表的,生成代码操作
				if (table_name.indexOf(table) == -1) {
					continue;
				}
				String className = classNamePrefix;

				String separator = File.separator;

				// 获取工程路径
				File projectPath = new File("");
				while (!new File(projectPath.getPath() + separator + "src").exists()) {
					projectPath = projectPath.getParentFile();
				}

				// 模板文件路径
				String tplPath = "";
				if (db.equals("mysql")) {
					tplPath = StringUtil.replace(projectPath + "/generate/template/mysql", "/", separator);
				} else if (db.equals("oracle")) {
					tplPath = StringUtil.replace(projectPath + "/generate/template/oracle", "/", separator);
				}

				// Java文件路径,使用
				String javaPath = StringUtil.replace(projectPath + "/src/main/java/" + StringUtils.lowerCase(packageName), "/",separator);
				javaPath = StringUtil.replace(projectPath + "/src/main/java/" + StringUtils.lowerCase(packageName), ".",separator);

				// mybatis文件生成地址
				
				String batisPath = StringUtil
						.replace(projectPath + "/src/main/resources/" + batisName + "/" + moduleName, "/", separator);

				// 代码模板配置
				Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
				cfg.setDirectoryForTemplateLoading(new File(tplPath));

				// 定义模板变量
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("packageName", StringUtils.lowerCase(packageName));
				model.put("commonName",StringUtils.lowerCase(commonName));
				model.put("moduleName", StringUtils.lowerCase(moduleName));
				model.put("className", StringUtils.uncapitalize(className));
				model.put("ClassName", className);
				model.put("classAuthor", classAuthor);
				model.put("classDate", new Date());
				model.put("functionName", functionName);
				model.put("tableName", StringUtils.lowerCase(table_name));
				model.put("urlPrefix", model.get("moduleName") + " /" + model.get("className"));
				model.put("permissionPrefix", model.get("moduleName") + " :" + model.get("className"));
				model.put("list", DBUtil.getList(table_name, database));
				model.put("listSize", DBUtil.getList(table_name,  database).size());
				// mybatis {替代单词
				model.put("leftBraces", "{");
				// mybatis }替代单词
				model.put("rightBraces", "}");
				// mybatis $替代单词
				model.put("dollarSign", "$");
				
				
				/**
				 * 生成 ibatis文件
				 */
				if(needsMapper){
					Template ibatisTemplate = cfg.getTemplate("dbmapper.ftl");
					// 渲染生成模板
					String ibatisContent = FreeMarkers.renderTemplate(ibatisTemplate, model);
					// 生成的文件地址
					String batisSql = batisPath + separator + model.get("ClassName") + "Mapper.xml";
					// 将内容写入文件
					DBUtil.writeFile(ibatisContent, batisSql);
				}
				/**
				 * 生成实体类
				 */
				if (needsDomain) {
					// FreeMarkers模板地址
					Template beanTemplate = cfg.getTemplate("domain.ftl");
					// 渲染生成模板
					String beanContent = FreeMarkers.renderTemplate(beanTemplate, model);
					// 生成的文件地址
					String beanFile = javaPath + separator + model.get("moduleName") + separator + "domain" + separator
							+ model.get("ClassName") + ".java";
					// 将内容写入文件
					DBUtil.writeFile(beanContent, beanFile);
				}
				/**
				 * 生成 Dao
				 */
				if (needsDao) {
					// FreeMarkers模板地址
					Template daoTemplate = cfg.getTemplate("mapper.ftl");
					// 渲染生成模板
					String daoContent = FreeMarkers.renderTemplate(daoTemplate, model);
					// 生成的文件名称
					String daoFile = javaPath + separator + model.get("moduleName") + separator + "mapper" + separator
							+ model.get("ClassName") + "Mapper.java";
					// 将内容写入文件
					DBUtil.writeFile(daoContent, daoFile);
				}
				/**
				 * 生成 Service
				 */
				if (needsService) {
					// FreeMarkers模板地址
					Template serviceTemplate = cfg.getTemplate("service.ftl");
					// 渲染生成模板
					String serviceContent = FreeMarkers.renderTemplate(serviceTemplate, model);
					// 生成的文件名称
					String serviceFile = javaPath + separator + model.get("moduleName") + separator + "service"
							+ separator + model.get("ClassName") + "Service.java";
					// 将内容写入文件
					DBUtil.writeFile(serviceContent, serviceFile);

					/**
					 * 生成 ServiceImpl 代码
					 */
					// FreeMarkers模板地址
					Template serviceI_Template = cfg.getTemplate("serviceImpl.ftl");
					// 渲染生成模板
					String serviceI_Content = FreeMarkers.renderTemplate(serviceI_Template, model);
					// 生成的文件名称
					String serviceI_File = javaPath + separator + model.get("moduleName") + separator + "service"
							+ separator + "impl" + separator + model.get("ClassName") + "ServiceImpl.java";
					// 将内容写入文件
					DBUtil.writeFile(serviceI_Content, serviceI_File);
				}

				/**
				 * 生成 Action代码
				 */
				if (needsAction) {
					// FreeMarkers模板地址
					Template actionTemplate = cfg.getTemplate("controller.ftl");
					// 渲染生成模板
					String actionContent = FreeMarkers.renderTemplate(actionTemplate, model);
					// 生成的文件名称
					String actionFile = javaPath + separator + model.get("moduleName") + separator + "controller"
							+ separator + model.get("ClassName") + "Controller.java";
					// 将内容写入文件
					DBUtil.writeFile(actionContent, actionFile);
				}
				/**
				 * 提示信息
				 */
				System.out.println("代码生成成功");
			}
			tables.close();
			stateMent_table.close();
			connection.close();


	}
}
