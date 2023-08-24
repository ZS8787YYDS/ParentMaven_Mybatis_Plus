package com.zisheng;

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
    @Test
    public void testUpdateById_02()
    {
//        List<User> users = testMapper.selectList(null);
//        List<User> users = demoMapper.selectList(null);
//
//        users.forEach(System.out::println);
        User user = new User(1,"撒", (byte) 1, (short) 12);
        System.out.println(demoMapper.updateById(user));
    }
    @Test
    public void testSelectById() {
        User user = testMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void testSelectList()
    {
        List<User> users = testMapper.selectList(null);
        log.info("查询的结果如下");
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectCount()
    {
        Long count = testMapper.selectCount(null);
        log.info("表中的数据个数：{}",count);
    }
    @Test
    public void testSelect()
    {
    }
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
    @Test
    public void testDeleteById()
    {
        int n = testMapper.deleteById(7);
        log.info("n:[}",n);
    }
}
