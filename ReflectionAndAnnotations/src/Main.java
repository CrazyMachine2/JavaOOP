import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

       Class reflectionClass = Reflection.class;
        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());

        Class[] interfaces = reflectionClass.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection ref = (Reflection) reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(ref);

        TreeSet<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();
        Field[] declaredFields = reflectionClass.getDeclaredFields();

        for (Method method : declaredMethods) {
            if(method.getName().startsWith("get")){
                if(method.getParameterCount() == 0){
                    getters.add(method);
                }
            }
        }

        for (Method method : declaredMethods) {
            if(method.getName().startsWith("set")){
                if(method.getParameterCount() == 1){
                    if(void.class.equals(method.getReturnType())){
                        setters.add(method);
                    }
                }
            }
        }

        getters.forEach(m -> System.out.println(String.format("%s will return %s",m.getName(),m.getReturnType().getSimpleName())));
        System.out.println();
        setters.forEach(m -> {
            Class<?>[] parameterTypes = m.getParameterTypes();
            System.out.println(String.format("%s and will set field of %s",m.getName(),parameterTypes[0].getSimpleName()));
        });

        System.out.println();

        Arrays.stream(declaredFields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(String.format("%s have to be private!",f.getName())));

        System.out.println();

        getters.stream().filter(m -> !Modifier.isPublic(m.getModifiers()))
                .forEach(m -> System.out.println(String.format("%s have to be public!",m.getName())));

        System.out.println();

        setters.stream().filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .forEach(m -> System.out.println(String.format("%s have to be private!",m.getName())));

    }
}
