package util;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
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
            throw new RuntimeException(e);
        }
    }

    public void invoke(Object... args) {
        try {
            Object res = doInvoke(args);
            parseResult(res, method.getReturnType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Object doInvoke(Object... args) throws InvocationTargetException, IllegalAccessException {
        if (method.getParameterCount() == 1 && method.getParameterTypes()[0].isArray() && !method.getParameterTypes()[0].getComponentType().isPrimitive()) {
            // 防止参数为数组时invoke将数组拆散拆散传入
            return method.invoke(core, new Object[]{args});
        }
        return method.invoke(core, args);
    }

    private Object[] convertToArray(Object o) {
        if (!o.getClass().isArray()) {
            throw new RuntimeException("传入对象不合法，为非数组");
        }
        int length = Array.getLength(o);
        Object[] objects = new Object[length];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = Array.get(o, i);
        }
        return objects;
    }

    private void parseResult(Object res, Class returnType) {
        if (Void.TYPE.equals(returnType)) {
            return;
        }
        if (returnType.isArray()) {
            AlgorithmUtil.printArr(convertToArray(res));
        } else {
            System.out.println(res);
        }
    }
}
