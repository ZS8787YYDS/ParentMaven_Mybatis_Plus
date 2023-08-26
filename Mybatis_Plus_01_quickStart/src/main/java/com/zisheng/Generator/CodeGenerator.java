//package com.zisheng.Generator;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//
//public class CodeGenerator {
//    public static void main(String[] args)
//    {
//        // 创建代码生成器对象
//        AutoGenerator autoGenerator = new AutoGenerator();
//        /**
//         * 数据库相关配置
//         * */
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        // 数据库驱动类的全类名
//        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
//        // 数据库连接的url
//        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatis_plus");
//        // 数据库连接的用户名
//        dataSourceConfig.setUsername("root");
//        // 数据库连接的密码
//        dataSourceConfig.setPassword("8787521");
//        autoGenerator.setDataSource(dataSourceConfig);
//        /**
//         * 全局配置
//         */
//        GlobalConfig globalConfig = new GlobalConfig();
//        // 设置代码生成的位置
//        globalConfig.setOutputDir("D:\\javacode\\ParentMaven_Mybatis_Plus\\Mybatis_Plus_01_quickStart" +
//                "\\src\\main\\java");
//        // 设置生成代码后是否打开打开对应的目录
//        globalConfig.setOpen(false);
//        // 设置作者的名字，就是每个类上上方都会显示
//        globalConfig.setAuthor("zisheng8787");
//        // 设置是否覆盖之前生成的代码
//        globalConfig.setFileOverride(true);
//        // 设置主键生成策略
//        globalConfig.setIdType(IdType.ASSIGN_ID);
//        // 设置生成的Mappe接口的名称为数据库表名再加上Mapper
//        // 如果在策略配置中指定了表的前缀的话，那么Mapper接口的名称就是去掉前缀的表名加上Mapper
//        globalConfig.setMapperName("%sMapper");
//        autoGenerator.setGlobalConfig(globalConfig);
//        /**
//         * 包名相关配置
//         */
//        // 创建PackageConfig对象
//        PackageConfig packageConfig = new PackageConfig();
//        // 设置生成的所有代码所在的包名
//        packageConfig.setParent("com.YYDS");
//        // 设置实体类所在的包名
//        packageConfig.setEntity("Pojo");
//        // 设置Mapper接口所在的报名
//        packageConfig.setMapper("Mapper");
//        autoGenerator.setPackageInfo(packageConfig);
//        /**
//         * 策略配置
//         */
//        // 创建strategyConfig对象
//        StrategyConfig strategyConfig = new StrategyConfig();
//        // 指定为哪些表生成代码
//        strategyConfig.setInclude("tb_user","tb_da");
//        // 设置数据库表的前缀名，则生成的实体类名称就是：数据库表名 - 前缀名
//        strategyConfig.setTablePrefix("tb_");
//        // 设置设否启用RestController风格
//        strategyConfig.setRestControllerStyle(true);
//        // 设置是否采用Lombok模式
//        strategyConfig.setEntityLombokModel(true);
//        // 设置逻辑删除字段命名称
//        strategyConfig.setLogicDeleteFieldName("delete_state");
//        // 设置乐观锁字段名称
//        strategyConfig.setVersionFieldName("version");
//        autoGenerator.setStrategy(strategyConfig);
//        // 执行代码生成器
//        autoGenerator.execute();
//    }
//}
