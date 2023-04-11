package util;

import util.annotation.Main;

import java.lang.reflect.Method;

/**
 * @author Lin
 * @date 2023/4/11
 */
public class TestUtil {


    public static void invoke(Object... args) {
        create().invoke(args);
    }

    public static Solution create() {
        return create(getClassForSolution());
    }

    public static Solution create(Class tClass) {
        Method[] methods = tClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Main.class)) {
                return new Solution(tClass, method);
            }
        }
        throw new RuntimeException("未找到执行方法");
    }

    private static Class<?> getClassForSolution() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String className = stackTrace[stackTrace.length - 1].getClassName();
            return Class.forName(className);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("未找到当前类");
        }
    }
}
