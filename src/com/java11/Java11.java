package src.com.java11;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author bingshan
 * @date 2022/5/6 13:44
 */
public class Java11 {

    public static void main(String[] args) {

        /** 1、JShell */


        /** 2、Dynamic Class-File Constants 类文件新添的一种结构 */


        /** 3、增强局部变量类型推断var */
        Arrays.asList("Java", "Python", "Ruby")
                .forEach((var s) -> System.out.println("Hello, " + s));

        /** 4、新加一些使用的API
         *      1) 新的本机不可修改集合 APi
         *      2) Stream 加强
         *      3） 增加了一系列的字符串处理方法
         *      4） Optional 加强
         *      5） 改进的文件 API
         */
        //4.3 增加一系列的字符串处理方法
        //判断字符串是否为空白
        " ".isBlank();
        //去除首尾空白
        " JavaStack ".strip();
        " JavaStack ".stripTrailing();
        " JavaStack ".stripLeading();
        //复制字符串
        "Java".repeat(3);
        //行数统计
        "A\nB\nC".lines().count();

        //4.3 Optional加强
        Optional.of("javastack").orElseThrow();
        Optional.of("javastck").stream().count();
        Optional.ofNullable(null).or(() -> Optional.of("javastack")).get();



        /** 5、移除的一些其他内容 */

        /** 6、标准Java异步HTTP客户端 */

        /** 7、更简化的编译运行程序 */

        /** 8、Unicode 10 */

        /** 9、Remove the JavaEE and CORBA Modules */

        /** 10、JEP: 335: Deprecate the Nashorn JavaScript Engine */

        /** 11、JEP: 336: Deprecate the Pack200 Tools and Api */

        /** 12、 新的Epsilon垃圾收集器 */

        /** 13、ZGC, JDK11最瞩目的特性 */

        /** 14、完全支持Linux容器（包括Docker） */



    }

}
