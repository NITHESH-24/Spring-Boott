package com.example.springbootfirst.controllers;

import com.example.springbootfirst.controllers.Hello;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    @Test
    public void testHelloTest(){
        Hello hell = new Hello();
        String str = hell.helloTest();
        System.out.println(str);
        assertEquals("Hello Test",str);
    }
}
