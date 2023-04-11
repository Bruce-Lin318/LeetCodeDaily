package util;

import java.lang.reflect.Method;

/**
 * @author Lin
 * @date 2023/4/11
 */
public class Solution<T> {
    private T core;
    private Method method;

    public Solution(Class<T> tClass, Method method) {
        this.method = method;
        try {
            // TODO: 2023/4/11 增加指定构造器的注解，先扫描有没有指定构造器，没有的话用空参
            this.core = tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void invoke(Object... args) {
        try {
            Object invoke = method.invoke(core, new Object[]{args});
            if (method.getReturnType().equals(Void.TYPE)) {
                return;
            }
            if (method.getReturnType().isArray()) {
                AlgorithmUtil.printArr((Object[])invoke);
            } else {
                System.out.println(invoke);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
