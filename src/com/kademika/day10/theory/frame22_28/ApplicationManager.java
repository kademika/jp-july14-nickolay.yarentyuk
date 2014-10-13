package com.kademika.day10.theory.frame22_28;

import com.kademika.day10.theory.frame2.Device;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ApplicationManager<T> {

    private List <T> list = new ArrayList();

    public boolean addClass(Class c) {
        Annotation[] annotations = c.getAnnotations();
//        System.out.println(annotations.length);

        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == (Service.class)) {
                try {
                    T obj = (T) c.newInstance();
                    list.add(obj);
                    checkInitService(obj);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return true;
            }
        }

        return false;
    }

    public boolean addClass(Class c, List<Object> list) {
        Annotation[] annotations = c.getAnnotations();
//        System.out.println(annotations.length);

        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == (Service.class)) {
                try {
                    T obj = (T) c.newInstance();
                    list.add(obj);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                Object[] pars = list.toArray();

                Class[] parTypes = new Class[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    parTypes[i] = pars[i].getClass();
                }

                Constructor theConstructor = null;
                for (Constructor constructor : c.getConstructors()) {
                    if (Arrays.equals(constructor.getGenericParameterTypes(), parTypes)) {
                        theConstructor = constructor;
                        break;
                    }
                }

                return true;
            }
        }

        return false;
    }

    public boolean addClass(Class c, Map<String, Object> map) {
        Annotation[] annotations = c.getAnnotations();
//        System.out.println(annotations.length);

        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == (Service.class)) {
                try {
                    T obj = (T) c.newInstance();
                    list.add(obj);

                    Method[] methods = c.getMethods();
                    for (Method method : methods) {
                        if (method.getName().substring(0, 3).equals("set")) {
                            String name = Character.toLowerCase(method.getName().charAt(3)) + method.getName().substring(4);
                            method.invoke(obj, map.get(name));
                        }
                    }

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                return true;
            }
        }

        return false;
    }

    private void checkInitService(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(InitService.class)) {
//                    System.out.println(method.getName());
                    try {
                        method.setAccessible(true);
                        method.invoke(obj);
                        method.setAccessible(false);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    public T getSevice(Class c) throws  IllegalAccessException, InstantiationException, InvocationTargetException {
        T obj = (T) c.newInstance();
        return obj;
    }

    public T getSevice(Class c, List<Object> usingConstructor) throws IllegalAccessException, InstantiationException, InvocationTargetException {
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

    public static boolean compareArrayTypes(Class[] existingConstructor, Class[] usingConstructor) {
        if (existingConstructor.length != usingConstructor.length) {
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
            if (existingConstructor[i] != usingConstructor[i]) {
                return false;
            }
        }

        return true;
    }

    public static void copy(List<? extends Device> src, List<? super Device> dest) {
        for (Device device : src) {
            dest.add(device);
        }
    }

    public T get(int index) {
        return list.get(index);
    }

    public List<T> getAll() {
        return new ArrayList<>(list);
    }

    public void delete(T item) {
        list.remove(item);
    }

    public void printAll() {
        for (T obj : list) {
            System.out.println(obj.toString());
        }
    }
}
