package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionProcessor {

    public static void processAnnotations(Object obj) {
        Class<?> clazz = obj.getClass();

        // Обработка аннотированных методов
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Person.class)) {
                Person annotation = method.getAnnotation(Person.class);
                System.out.println("Found annotated method: " + method.getName() + " with name: " + annotation.name());

                try {
                    method.setAccessible(true);  // На случай, если метод приватный
                    method.invoke(obj);          // Вызов метода
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        // Обработка аннотированных полей
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Person.class)) {
                field.setAccessible(true); // На случай, если поле приватное
                try {
                    System.out.println("Found annotated field: " + field.getName() + " with name: " + field.get(obj));
                    // Изменим значение поля
                    if (field.getType() == String.class) {
                        field.set(obj, "Modified name");
                        System.out.println("Modified field name: " + field.get(obj));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
