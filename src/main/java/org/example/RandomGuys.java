package org.example;

public class RandomGuys {
    @Person (name = "Cherry")
    public void annotatedMethod1() {
        System.out.println("Executing Person1.");
    }

    @Person (name = "Lily")
    public void annotatedMethod2() {
        System.out.println("Executing Person2.");
    }

    @Person
    private String annotatedField = "Josh";

}
