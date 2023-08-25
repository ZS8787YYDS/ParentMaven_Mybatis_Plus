package com.zisheng;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.zisheng.Lambda.LambdaMethodQuote;
import com.zisheng.Mapper.DemoMapper;
import com.zisheng.Mapper.TestMapper;
import com.zisheng.Pojo.User;
import com.zisheng.QueryCondition.HandleNull;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlus01QuickStartApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(MybatisPlus01QuickStartApplicationTests.class);
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private DemoMapper demoMapper;

    /**
     * 解析XML文件测试代码
     * @throws DocumentException
     */
    @Test
    public void testParseXML() throws DocumentException {
        log.info("解析XML文件");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(this.getClass().getClassLoader().getResource("test.xml"));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for(Element element : elements)
        {
            String name = element.element("name").getText();
            String gender = element.elementText("gender");
            Integer age = Integer.parseInt(element.elementText("age"));
            System.out.println("name-->" + name);
            System.out.println("gender-->" + gender);
            System.out.println("age-->" + age);
        }
    }

    /**
     * 根据ID更新功能测试代码
     */
    @Test
    public void testUpdateById()
    {
//        List<User> users = testMapper.selectList(null);
//        List<User> users = demoMapper.selectList(null);
//
//        users.forEach(System.out::println);
        User user = new User(1,"撒", (byte) 1, (short) 12);
        System.out.println(demoMapper.updateById(user));
    }

    /**
     * 根据ID查询功能测试代码
     */
    @Test
    public void testSelectById() {
        User user = testMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 按条件查询所有信息功能测试代码,
     */
    @Test
    public void testSelectList()
    {
        /** 条件查询的第一种方式，这种方式设置查询条件的时候写的是字段的名称，很容易去写错，
         *  一般采用lambda表达式的形式设置查询条件
         */
        // 由于selectList方法的参数是Wrapper(抽象类)类型的对象，因此创建它的实现类对象
        // 同时指定泛型,泛型的类型就是实体类的类型
//        QueryWrapper<User>  wrapper = new QueryWrapper<>();
//        // 调用对象的方法设置查询条件,第一个参数是字段的名称，第二个参数是值
//        wrapper.lt("age",15);
//        List<User> users = testMapper.selectList(wrapper);
//        log.info("查询的结果如下");
//        users.forEach(System.out::println);
        /**
         * 条件查询的第二种方式：Lambda表达式的形式.这种方式必须指定泛型哈.
         * 采用lambda表达式进行书写可以避免写错表中字段的值
         */
//        QueryWrapper<User> qw = new QueryWrapper<>();
//        qw.lambda().lt(User::getAge,15);
//        List<User> users = testMapper.selectList(qw);
//        users.forEach(LambdaMethodQuote::getAge);
        /**
         * 条件查询的第三种方式
         * lambda表达式的方式,采用专用的LambdaQueryWrapper对象
         */
//        LambdaQueryWrapper<User> lwq = new LambdaQueryWrapper<>();
//        // 支持链式编程
//        // 设置查询条件为年龄大于20且小于23
////        lwq.lt(User::getAge,23).gt(User::getAge,20);
//        // 设置查询条件为年龄小于12或者大于20。or()方法表示或的关系，直接设置的话是且的关系
//        lwq.lt(User::getAge,12).or().gt(User::getAge,20);
//        List<User> users = testMapper.selectList(lwq);
//        users.forEach(System.out::println);
        /**
         * null值的判定
         */
        // 创建LambdaQueryWrapper类型的对象，同时指定泛型的类型为实体类的类型
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        // 创建一个对象，这个类继承实体类，同时新增了一个年龄属性，用于设置年龄的上限和下限
        HandleNull handleNull  = new HandleNull();
        handleNull.setAge((short) 10);
        handleNull.setAgeUp(null);
        // 以下方法就是当Condition条件不为空的时候，才会设置查询条件（为表中的某个字段设置条件，这个
        // 字段根据实体类的属性来定位，因为实体类上已经加上了tableName注解，与数据库中的表表是一 一对应的
        // ）
        // 调用gt方法，gt表示大于号
        lqw.gt(handleNull.getAge() != null, User::getAge,handleNull.getAge());
        // lt方法设置查询条件，表示小于号
        lqw.lt(handleNull.getAgeUp() != null,User::getAge,handleNull.getAgeUp());
        // 将LambdaQueryWrapper类型的对象传递给selectList方法，进行条件查询
        List<User> users = testMapper.selectList(lqw);
        users.forEach(System.out::println);

    }
    /**
     * 查询所有表中元素个数代码
     */
    @Test
    public void testSelectCount()
    {
        Long count = testMapper.selectCount(null);
        log.info("表中的数据个数：{}",count);
    }

    /**
     * 插入功能测试代码
     */
    @Test
    public void testInsert()
    {
//        int ans = testMapper.insert(new User(5, "张无忌", (byte) 2, (short) 22));
        User user = new User();
        user.setName("周芷若");
        user.setGender((byte) 2);
        user.setAge((short) 18);
        int ans = testMapper.insert(user);
        log.info("返回的结果为：{}",ans);
    }

    /**
     * 根据id删除功能测试代码
     */
    @Test
    public void testDeleteById()
    {
        int n = testMapper.deleteById(7);
        log.info("n:[}",n);
    }
    /**
     * 分页功能测试代码
     * 下面我将使用两种方式实现分页功能：Mybatis以及Mybatis_plus
     */
    @Test
    public void testPageByMP()
    {
//         创建image接口的实现类对象，设置分页参数，
        IPage page = new Page(1,3);
        /**
         * 调用BaseMapper接口的selectPage方法，执行分页查询操作
         *  注意：要声明MybatisPLusInterceptor拦截器的bean对象，并添加内置分页拦截器对象
         *  (可以定义一个配置类，在配置类中声明bean对象)，才能执行分页操作
         *  执行分页操作之后，会将结果封装到方法参数的IPage类型的对象当中
         * */
        testMapper.selectPage(page,null);
        long currentPage = page.getCurrent();
        log.info("当前{}页",currentPage);
        long size = page.getSize();
        log.info("每页显示的数据个数：{}",size);
        List results = page.getRecords();
        log.info("查询的信息如下：");
        log.info("-------------------------------------------------------");
        results.forEach(o -> log.info("" + o));
        log.info("-------------------------------------------------------");
        long totalPages = page.getPages();
        log.info("一共{}页",totalPages);
        Long total = page.getTotal();
        log.info("表中的数据个数为：{}",total);
    }
    @Test
    public void testPageByMybatis()
    {
        // 调用分页插件的startPage方法设置分页参数
        PageHelper.startPage(1,3);
        // 执行正常的查询操作，返回查询的结果
        List<User> users = testMapper.PageSelect();
        // 将List集合对象转换成Page类型的对象，然后就可以调用里面的方法去获取执行分页操作得到的数据了
        com.github.pagehelper.Page<User> page = (com.github.pagehelper.Page<User>)users;
        long currentPage = page.getStartRow();
        log.info("当前{}页",currentPage + 1);
        long size = page.getPageSize();
        log.info("每页显示的记录数目：{}",size);
        List<User> results = page.getResult();
        log.info("查询的数据信息如下：");
        log.info("---------------------------");
        users.forEach(o -> log.info("" + o));
        log.info("---------------------------");
        long pages = page.getPages();
        log.info("总页数：{}",pages);
        long total = page.getTotal();
        log.info("表中数据的总数为：{}",total);
    }
}
