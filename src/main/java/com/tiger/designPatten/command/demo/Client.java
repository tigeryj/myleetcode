package com.tiger.designPatten.command.demo;

import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Light light = new Light();
        Command onCmd = new LightOnCommand(light);
        Command offCmd = new LightOffCommand(light);
        Invoker invoker = new Invoker();
        invoker.addButton(0, onCmd);
        invoker.addButton(1, offCmd);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (StringUtils.equalsIgnoreCase(input,"UNDO")) {
                invoker.undo();
            } else {
                invoker.buttonOn(Integer.parseInt(input));
            }
        }
    }
}
