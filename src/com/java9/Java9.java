package com.java9;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author bingshan
 * @date 2022/5/6 13:44
 */
public class Java9 {

    public static void main(String[] args) {

        /**特性三 多版本兼容jar包 */
        // 很多项目的JDK使用的都是，JDK6或7，项目JDK不敢进行JDK升级主要是因为兼容的问题。
        //但是JDK9解决了此问题，不管项目使用的JDK6,7,8甚至5，他都可以兼容不出错。看到这一点相信很多开发者会露出一丝笑容。

        /**特性4: 接口Interface的升级 */
        //在 Java 8 中，一个接口中能定义如下几种变量/方法：
        //  常量
        //  抽象方法
        //  默认方法
        //  静态方法
        //在 Java 9 中，一个接口中能定义如下几种变量/方法：
        //  常量
        //  抽象方法
        //  默认方法
        //  静态方法
        //  私有方法
        //  私有静态方法

         /**特性5：JDK8 之前 String _ ="hello"; 这样的标识符可以用，JDK9就不能用了。

         /**特性六: String，StringBuffer，StringBuilder底层更换结构 */
        //JDK 8之前 String的底层结构类型都是 char[] ,但是JDK9 就替换成 byte[] 这样来讲，更节省了空间和提高了性能
        //之所以替换是因为 之前一直是最小单位是一个char，用到两个byte,但是JDK8是基于latin1的，而这个latin1编码可以用一个byte标识，
        //所以当你数据明明可以用到一个byte的时候，我们用到了一个最小单位chat两个byte，就多出了一个byte的空间。
        //所以JDK9在这一方面进行了更新，现在的JDK9 是基于ISO/latin1/Utf-16 ,latin1和ISO用一个byte标识,UTF-16用两个byte标识，
        //JDK9会自动识别用哪个编码，当数据用到1byte，就会使用iSO或者latin1 ，当空间数据满足2byte的时候，自动使用utf-16,节省了很多空间
        String aa = "aa";

         /** 特性七: 异常处理try升级 */

         /**特性八: 模块化 */
        //一个大型的项目：天猫，京东，唯品会等等，都会包含多个模块。
        //例如订单模块，前台模块，后台管理模块，广告位模块，会员模块.....，各个模块之间会相互调用，不过这种情况下会很少，
        //只针对特殊情况，如果一个项目有30个模块系统进行开发，但是只要某个单独模块运行时，都会带动所有的模块，这样对于jvm来说在内存和性能上会利用率很低，
        //所以，java9提供了这一个特性，某一个模块运行的时候，jvm只会启动和它有依赖的模块，并不会加载所有的模块到内存中，这样性能大大的提高了。写法上如下：

         /**特性九: 集合工厂方法 */
        //新方法创建集合  以下方法被添加到 List，Set 和 Map 接口以及它们的重载对象。
        //List 和 Set 接口, of(...) 方法重载了 0 ~ 10 个参数的不同方法 。
        //Map 接口, of(...) 方法重载了 0 ~ 10 个参数的不同方法 。
        //Map 接口如果超过 10 个参数, 可以使用 ofEntries(...) 方法。
        List.of("A", "b", "c");
        Set.of("A", "b", "c");
        Map.of("a", 1, "b", 2, "c", 3);
        Map.ofEntries(
                new AbstractMap.SimpleEntry<>("a", 1),
                new AbstractMap.SimpleEntry<>("b", 2),
                new AbstractMap.SimpleEntry<>("c", 3)
        );

        /**特性九: 改进的 Stream API */
        //添加了一些便利的方法，使流处理更容易，并使用收集器编写复杂的查询
        //Stream 新增了几个方法：dropWhile、takeWhile、ofNullable，为 iterate 方法新增了一个重载方法。

        /**特性十: 改进的 @Deprecated 注解 */
        //注解 @Deprecated 可以标记 Java API 状态，可以是以下几种：
        //
        //使用它存在风险，可能导致错误
        //可能在未来版本中不兼容
        //可能在未来版本中删除
        //一个更好和更高效的方案已经取代它。
        //Java 9 中注解增加了两个新元素：since 和 forRemoval。
        //
        //since: 元素指定已注解的API元素已被弃用的版本。
        //forRemoval: 元素表示注解的 API 元素在将来的版本中被删除，应该迁移 API。


        /**特性十一: 钻石操作符(Diamond Operator)  */
        // 在 java 9 中， 它可以与匿名的内部类一起使用，从而提高代码的可读性。

        /**特性十二: 改进的 Optional 类  */
        //Optional 类在 Java 8 中引入，Optional 类的引入很好的解决空指针异常。
        // 在 java 9 中, 添加了三个方法来改进它的功能：
        //stream()
        //ifPresentOrElse()
        //or()

        /** 特性十三 多分辨率图像 API */

        /** 特性十四  改进的 CompletableFuture API */
        //支持 delays 和 timeouts
        //提升了对子类化的支持
        //新的工厂方法



    }

    //java9及 每一个流打开的时候都要关闭,但是在try的括号中来进行关闭，
    //在java8的基础上进一步升级 直接在try括号中直接写入 变量就好，
    //如果有多个流，就用分号隔开//try(reader;writer){}
    @Test
    public void dasdemo03(){
        InputStreamReader reader =new InputStreamReader(System.in);
        try(reader){
            reader.read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
