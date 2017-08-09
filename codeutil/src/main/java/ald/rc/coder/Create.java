package ald.rc.coder;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


import freemarker.template.Configuration;
import freemarker.template.Template;

public class Create {
	public static String priff = "arc";
	private static String author="shi";
	
	public static void main(String[] args) {
		Create ot=new Create();
		Table table= new Table();
		table.setTableComment("用户表");
		table.setTableName("arc_user");
		ot.generateMapperDo("risk",table);
	}
	
	public void generateMapperDo(String database,Table specTable){
		try {
			if(null ==specTable){
				List<Table> tables = DBUtil.getTableList(database);
				for (Table table : tables) {
					table.setDatabase(database);
					doGenerateMapperDo(table);
				}
			}else{
				specTable.setDatabase(database);
				doGenerateMapperDo(specTable);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void doGenerateMapperDo(Table table) throws Exception {
		if(null == table){
			return;
		}
		
		Map<String,Object> model = dataModel(table);
		
		Configuration cfg = new Configuration(Configuration.getVersion());
		cfg.setDirectoryForTemplateLoading(new File(MapperConfig.templatePath));
		
		if (null != MapperConfig.TEMPLATE_DO_FILE) {
			Template beanTemplate = cfg.getTemplate(MapperConfig.TEMPLATE_DO_FILE);
			String beanContent = FreeMarkers.renderTemplate(beanTemplate, model);
			String className=model.get("className") + ".java";
			String beanFile = MapperConfig.outputPath  + File.separator+"bo"+File.separator
					+className;
			DBUtil.writeFile(beanContent, beanFile);
		}
		
		if (null != MapperConfig.TEMPLATA_MAPPER_FILE) {
			Template daoTemplate = cfg.getTemplate(MapperConfig.TEMPLATA_MAPPER_FILE);
			String daoContent = FreeMarkers.renderTemplate(daoTemplate, model);
			String daoFile = MapperConfig.mapperoutputPath + File.separator +"mapper"+File.separator
					+ model.get("className") + "Mapper.java";
			DBUtil.writeFile(daoContent, daoFile);
		}
		
		if(null != MapperConfig.TEMPLATE_MAPPER_XML_FILE){
			Template ibatisTemplate = cfg.getTemplate(MapperConfig.TEMPLATE_MAPPER_XML_FILE);
			String ibatisContent = FreeMarkers.renderTemplate(ibatisTemplate, model);
			String batisSql = MapperConfig.xmlMapperOutPutPath + File.separator + model.get("className") + "Mapper.xml";
			DBUtil.writeFile(ibatisContent, batisSql);
		}

		


		
	}

	public static Map<String,Object> dataModel(Table table){
		String camelcaseTableName = DBUtil.underscore2Camelcase(table.getTableName(), priff);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("packageName",MapperConfig.baseMapperPackage);
		model.put("tableComment", table.getTableComment());
		model.put("className", StringUtils.capitalize(camelcaseTableName));
		model.put("classAuthor", author);
		model.put("classDate", LocalDate.now().toString());
		model.put("tableName", table.getTableName());
		List<Column> columns =DBUtil.getList(table.getDatabase(), table.getTableName());
		model.put("list", columns);
		model.put("listSize", columns.size());
		model.put("leftBraces", "{");
		model.put("rightBraces", "}");
		return model;
	}
}
