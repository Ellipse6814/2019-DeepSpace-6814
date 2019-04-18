package frc.robot.Util;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.FollowPath;

public class Trigger {
    public FollowPath pathCommand;
    public Command triggerCommand;
    public double triggerPercent;
    public boolean fired = false;

    public Trigger(FollowPath pathCommand, Command triggerCommand, double triggerPercent) {
        this.pathCommand = pathCommand;
        this.triggerCommand = triggerCommand;
        this.triggerPercent = triggerPercent;
    }
}