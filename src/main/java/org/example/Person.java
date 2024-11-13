package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})//указывает, что именно можно пометить этой аннотацией
@Retention(value= RetentionPolicy.RUNTIME)//указывает, где будет видна наша аннотация:во время исполнения программы
@interface Person {
    String name() default "No Name";
}
