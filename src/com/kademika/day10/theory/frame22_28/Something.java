package com.kademika.day10.theory.frame22_28;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Something {

    public static void printClassInfo(Class c) {
        System.out.println("Class name:");
        System.out.println(c.getSimpleName());
        System.out.println("Class name with packages:");
        System.out.println(c.getName());
        System.out.println("Superclass with packages:");
        System.out.println(c.getSuperclass());
    }

    public static void printClassMethods(Class c) {
        System.out.println("Constructors:");
        Constructor[] constructors = c.getConstructors();
        for(Constructor constr : constructors) {
            System.out.println(constr.toString());
        }
        System.out.println();

        System.out.println("Methods:");
        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods) {
            System.out.println(m.toString());
        }
    }

    public static void printClassFields(Class c) {
        System.out.println("Fields:");
        Field[] fields = c.getFields();
         for (Field f : fields) {
            System.out.print(f.getName().toString() + " ");
            System.out.println(f.getType().getName().toString());
        }
    }

    public static <T> T initClass(Class<T> c, Map<String, Object> map) throws Exception {
        T obj = c.newInstance();

        Method[] methods = c.getMethods();
        for (Method method : methods) {
            if (method.getName().substring(0, 3).equals("set")) {
                String name = Character.toLowerCase(method.getName().charAt(3)) + method.getName().substring(4);
                method.invoke(obj, map.get(name));
            }
        }

        return obj;
    }

    public static <T> T initClass(Class<T> c, List<Object> usingConstructor) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Object[] pars = usingConstructor.toArray();

        Class[] parTypes = new Class[usingConstructor.size()];
        for (int i = 0; i < usingConstructor.size(); i++) {
            parTypes[i] = pars[i].getClass();
        }

        Constructor theConstructor = null;
        for (Constructor constructor : c.getConstructors()) {
            if (compareArrayTypes((Class[]) constructor.getGenericParameterTypes(), parTypes)) {
                theConstructor = constructor;
                break;
            }
        }

        if (theConstructor == null) {
            return null;
        } else {
            T obj = (T) theConstructor.newInstance(pars);
            return obj;
        }
    }

    public static boolean compareArrayTypes(Class[] existingConstructor, Class[] inPutConstructor) {
        if (existingConstructor.length != inPutConstructor.length) {
            return false;
        }

        if (existingConstructor.length == 0) {
            return true;
        }


        for (int i = 0; i < existingConstructor.length; i++) {
            if (existingConstructor[i].getCanonicalName() == "byte") {
                existingConstructor[i] = java.lang.Byte.class;
            } else if (existingConstructor[i].getCanonicalName() == "short") {
                existingConstructor[i] = Short.class;
            } else if (existingConstructor[i].getCanonicalName() == "int") {
                existingConstructor[i] = java.lang.Integer.class;
            } else if (existingConstructor[i].getCanonicalName() == "long") {
                existingConstructor[i] = java.lang.Long.class;
            } else if (existingConstructor[i].getCanonicalName() == "float") {
                existingConstructor[i] = java.lang.Float.class;
            } else if (existingConstructor[i].getCanonicalName() == "double") {
                existingConstructor[i] = java.lang.Double.class;
            } else if (existingConstructor[i].getCanonicalName() == "boolean") {
                existingConstructor[i] = java.lang.Boolean.class;
            } else if (existingConstructor[i].getCanonicalName() == "char") {
                existingConstructor[i] = java.lang.Character.class;
            };
        }

        for (int i = 0; i < existingConstructor.length; i++) {
            if (existingConstructor[i] != inPutConstructor[i]) {
                return false;
            }
        }

        return true;
    }

    public static void setPrivates(Object obj, Map<String, Object> map) throws IllegalAccessException {
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        System.out.println(fields.length);

        for (Field field : fields) {
            if (map.containsKey(field.getName())) {
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
                field.setAccessible(false);
            }
        }

        while (c.getSuperclass() != null) {
            c = c.getSuperclass();
            fields = c.getDeclaredFields();

            for (Field field : fields) {
                if (map.containsKey(field.getName())) {
                    field.setAccessible(true);
                    field.set(obj, map.get(field.getName()));
                    field.setAccessible(false);
                }
            }
        }
    }
}
