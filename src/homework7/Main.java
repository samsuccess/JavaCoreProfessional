package homework7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        Class c = MyClass.class;
        Object testObj = c.newInstance();
        Method[] methods = c.getDeclaredMethods();
        ArrayList<Method> arlist = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method o : c.getDeclaredMethods()) {
            if (o.isAnnotationPresent(Test.class)) {
                arlist.add(o);
            }
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = o;
                } else throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = o;
                } else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
            arlist.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                }
            });
            //или
        }
//        //for (int i = 1; i <= 4; i++) {
//            for (int j = 0; j < methods.length; j++) {
//                if (methods[j].getAnnotation(Test.class) != null) {
//                    if (methods[j].getAnnotation(Test.class).priority() == j) {
//                        al.add(methods[j]);
//                    }
//                }
//            //}
//        }


        if (beforeMethod != null) beforeMethod.invoke(testObj, null);
        for (Method o : arlist) o.invoke(testObj, null);
        if (afterMethod != null) afterMethod.invoke(testObj, null);
    }
}
