package com.tiger.designPatten.command.demo;

/**
 * Receiver角色
 */
public class Light {

    public void on() {
        System.out.println("灯打开");
    }

    public void off() {
        System.out.println("灯关闭");
    }
}
