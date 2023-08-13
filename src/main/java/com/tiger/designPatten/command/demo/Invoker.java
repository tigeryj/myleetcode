package com.tiger.designPatten.command.demo;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    List<Command> buttons = new ArrayList();

    private List<Command> history = new ArrayList<>();

    public void buttonOn(int buttonNo) {
        if (buttonNo >= buttons.size()) return;
        Command command = buttons.get(buttonNo);
        history.add(command);
        command.execute();
    }

    public void undo() {
        if (buttons.size() > 0) {
            Command lastCmd = buttons.remove(buttons.size() - 1);
            lastCmd.undo();
        }
    }

    public void addButton(int buttonNo, Command command) {
        buttons.add(buttonNo, command);
    }
}
