package core.commands;

import contracts.Command;

public abstract class CommandImpl implements Command {
    private String[] data;

    public CommandImpl(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return this.data;
    }
}
