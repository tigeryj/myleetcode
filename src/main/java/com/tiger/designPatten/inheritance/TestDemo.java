package com.tiger.designPatten.inheritance;

import com.tiger.designPatten.inheritance.v1.CountingStackV1;
import org.junit.Test;

public class TestDemo {


    @Test
    public void test() {
        CountingStackV1<String> cs = new CountingStackV1();

        cs.push("tai");
        cs.push("yuejie");
        System.out.println(cs.getPushCount());
    }
}
