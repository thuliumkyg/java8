package com.java8.javassist;

import javassist.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author  bingshan
 * @date 2022/3/13 15:57
 */
public class GSWJCustomization4 {

    private static final Logger LOG = LoggerFactory.getLogger(GSWJCustomization4.class);


    public static void main(String[] args) throws Throwable {
        ClassPool pool = ClassPool.getDefault();
        //创建无成员方法   CtNewMethod附带的工厂方法创建，然后利用CtClass.addMethod()将其追加
        //pool.makeClass("com.java8.javassist.clazz.Point");
        CtClass cc = pool.get("com.java8.javassist.clazz.Point");
        CtMethod m = cc.getDeclaredMethod("move");
        //目标方法的参数  $0, $1, $2, ..  $0等价于this关键字
        //insertBefore方法中的代码段是被大括号{}包围的，此方法只接受一个被大括号包围的代码段入参。
        m.insertBefore("{ System.out.println($1); System.out.println($2); }");
        cc.writeFile("./src/main/java/");
    }
}
