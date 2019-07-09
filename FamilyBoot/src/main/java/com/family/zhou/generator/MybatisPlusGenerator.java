package com.family.zhou.generator;


import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.Velocity;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * 周刘成   2019/7/8
 */
public class MybatisPlusGenerator {

    private static MybatisPlusGenerator single = null;

    private MybatisPlusGenerator() {
        super();
    }

    private static MybatisPlusGenerator getInstance() {
        if (single == null) {
            single = new MybatisPlusGenerator();
        }
        return single;
    }

    public String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请输入" + tip + ":");
        System.out.println(stringBuilder.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        return null;
    }

    public void autoGeneration() {
        AutoGenerator generator = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("周刘成");
        gc.setOpen(false);
        gc.setActiveRecord(false);
        gc.setFileOverride(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);
        //自定义文件命名，注意%s会自动填充实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");

        generator.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/family?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        generator.setDataSource(dataSourceConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setTablePrefix()
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(new String[]{"sys_config"});

        strategyConfig.setSuperServiceClass(null);
        strategyConfig.setSuperServiceImplClass(null);
        strategyConfig.setSuperMapperClass(null);
        generator.setStrategy(strategyConfig);
        //包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.family.zhou");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("pojo");
        pc.setXml("mapper");
        generator.setPackageInfo(pc);

        generator.execute();
    }

    public static void main(String[] args) {
        MybatisPlusGenerator generator = MybatisPlusGenerator.getInstance();
        generator.autoGeneration();
    }


}
