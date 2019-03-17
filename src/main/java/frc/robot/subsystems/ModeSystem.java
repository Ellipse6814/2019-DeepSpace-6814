package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ModeSystem extends Subsystem {

    private static ModeSystem instance;

    public static ModeSystem getInstance() {
        if (instance == null)
            instance = new ModeSystem();
        return instance;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
