package frc.robot.commands;

import java.util.Arrays;
import java.util.List;

import frc.robot.Util.Trigger;
import frc.robot.log.CommandBase;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TriggerListener extends CommandBase {

    private List<Trigger> triggers;

    public TriggerListener(List<Trigger> triggers) {
        setLogSenderName("TriggerListener");
        this.triggers = triggers;
        log("Inited", "TriggerListener inited with " + triggers.size() + " triggers.");
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        for (Trigger trigger : triggers) {
            if (trigger.fired == false) {
                if (trigger.pathCommand.isCompleted()) {
                    trigger.triggerCommand.start();
                    trigger.fired = true;
                    System.out.println("TriggerListener fired a command because path was finished.");
                } else if (trigger.pathCommand.pathFollower.getProgress() >= trigger.triggerPercent) {
                    trigger.triggerCommand.start();
                    trigger.fired = true;
                    System.out.println("TriggerListener fired a command at percent: " + trigger.triggerPercent);
                }
            }
        }
    }

    @Override
    protected boolean isFinished() {
        for (Trigger trigger : triggers) {
            if (trigger.fired == false)
                return false;
        }
        return true;
    }

    @Override
    protected void end() {
        System.out.println("Last trigger fired, TriggerListener exiting...");
    }

    @Override
    protected void interrupted() {
        System.out.println("TriggerListener interrupted, this should not happen.");
    }
}