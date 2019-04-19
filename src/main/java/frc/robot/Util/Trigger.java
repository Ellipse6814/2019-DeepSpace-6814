package frc.robot.Util;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.FollowPath;

public class Trigger {
    public FollowPath pathCommand;
    public Command triggerCommand;
    public double triggerPercent;
    public boolean fired = false;

    public Trigger(Command pathCommand, double triggerPercent, Command triggerCommand) {
        this.pathCommand = (FollowPath) pathCommand;
        this.triggerCommand = triggerCommand;
        this.triggerPercent = triggerPercent;
    }

    public Trigger(Command pathCommand, int triggerPercent, Command triggerCommand) {
        this(pathCommand, triggerPercent + 0.0, triggerCommand);
    }
}