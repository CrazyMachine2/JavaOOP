package contracts;

import models.Hardware;

import java.util.Map;

public interface Command {
    void execute(Map<String, Hardware> hardwares);
}
