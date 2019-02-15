package frc.robot.commands;

import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Run extends CommandGroup {

    public Run(List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            addSequential(commands.get(i));
        }
    }
}