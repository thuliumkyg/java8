package com.java8.javassist;

import javassist.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 *
 * @author  bingshan
 * @date 2022/3/9 20:02
 */
public class GetStartedWithJavassist {
    private static final Logger LOG = LoggerFactory.getLogger(GetStartedWithJavassist.class);

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        /**
         * bytecode 读写
         */
        ClassPool pool = ClassPool.getDefault();
        //创建无成员方法   CtNewMethod附带的工厂方法创建，然后利用CtClass.addMethod()将其追加
        pool.makeClass("com.java8.javassist.clazz.Rectangle");

        pool.makeClass("com.java8.javassist.clazz.Point");
        CtClass point = pool.get("com.java8.javassist.clazz.Point");
        CtConstructor m = CtNewConstructor.make(
                                            "Point() {}", point);
        point.addConstructor(m);
        //直接加载CtClass
        Class pointClazz = point.toClass();
        LOG.info("Rectangle class: " + pointClazz );

        CtClass rectangle = pool.get("com.java8.javassist.clazz.Rectangle");
        rectangle.setSuperclass(point);
        //直接获取修改的字节码
        byte[] b = rectangle.toBytecode();
        LOG.info("Rectangle字节码: "+ b.toString());

        rectangle.writeFile("./src/main/java/");


    }

    GetStartedWithJavassist() {}


}
