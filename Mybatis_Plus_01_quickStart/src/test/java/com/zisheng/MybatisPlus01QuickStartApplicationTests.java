package com.zisheng;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.zisheng.Mapper.DemoMapper;
import com.zisheng.Mapper.TestMapper;
import com.zisheng.Pojo.User;
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
     * 查询所有信息功能测试代码
     */
    @Test
    public void testSelectList()
    {
        List<User> users = testMapper.selectList(null);
        log.info("查询的结果如下");
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
