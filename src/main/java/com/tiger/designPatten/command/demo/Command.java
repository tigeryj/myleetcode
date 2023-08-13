package com.tiger.designPatten.command.demo;

/**
 * 命令抽象
 */
public interface Command {
    void execute();

    void undo();
}

