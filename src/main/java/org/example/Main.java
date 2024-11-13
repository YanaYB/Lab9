package org.example;



public class Main {
    public static void main(String[] args) {
        RandomGuys testObject = new RandomGuys();

        System.out.println("Processing annotations...");
        ReflectionProcessor.processAnnotations(testObject);
    }
}
