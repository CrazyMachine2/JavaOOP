package core.commands;

import contracts.Executable;
import contracts.Race;
import data.Database;

public abstract class CommandImpl implements Executable {
    private Database database;
    private String[] data;

    protected CommandImpl(Database database, String[] data) {
        this.database = database;
        this.data = data;
    }

    protected Database getDatabase() {
        return this.database;
    }

    protected String[] getData() {
        return this.data;
    }

}
