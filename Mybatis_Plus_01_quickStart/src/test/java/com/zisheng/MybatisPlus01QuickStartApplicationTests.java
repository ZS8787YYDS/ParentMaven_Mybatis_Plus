package com.zisheng;

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
    @Test
    public void test01() throws DocumentException {
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
    public void searchByIdTest()
    {
        User user = testMapper.searchById(1);
        log.info("查询到的结果为：{}",user);
    }

}
