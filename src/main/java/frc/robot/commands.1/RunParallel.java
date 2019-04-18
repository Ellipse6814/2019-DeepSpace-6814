package frc.robot.commands;

import java.util.Arrays;
import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class RunParallel extends Command {

    List<Command> commands;
    int index = 0;

    public RunParallel(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    protected void execute() {
        while (index <= commands.size()) {
            if (index == 0 || commands.get(index).isCompleted()) {
                System.out.println("Starting command " + index);
                commands.get(index).start();
                index++;
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}