package frc.robot.commands;

import java.util.Arrays;
import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Run extends CommandGroup {

    public Run(List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            addSequential(commands.get(i));
        }
    }

    public Run(Command command1) {
        this(Arrays.asList(command1));
    }

    public Run(Command command1, Command command2) {
        this(Arrays.asList(command1, command2));
    }

    public Run(Command command1, Command command2, Command command3) {
        this(Arrays.asList(command1, command2, command3));
    }

    public Run(Command command1, Command command2, Command comman3, Command command4) {
        this(Arrays.asList(command1, command2, comman3, command4));
    }

}