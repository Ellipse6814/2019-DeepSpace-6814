package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.HatchState;
import frc.robot.commands.ClimbSet;
import frc.robot.commands.HatchIntakeSet;

public class Climb extends Subsystem {

    private static Climb instance;

    public static Climb getInstance() {
        if (instance == null) {
            instance = new Climb();
        }
        return instance;
    }

    private DoubleSolenoid frontSolenoid;
    private DoubleSolenoid backSolenoid;

    private Climb() {
        frontSolenoid = new DoubleSolenoid(Const.kClimbFrontSolenoidPort1, Const.kClimbFrontSolenoidPort2);
        backSolenoid = new DoubleSolenoid(Const.kClimbBackSolenoidPort1, Const.kClimbBackSolenoidPort2);

        setFront(false);
        setBack(false);
    }

    public void setFront(boolean down) {
        if (down)
            frontSolenoid.set(Const.kClimbFrontDownPos);
        else
            frontSolenoid.set(Const.kClimbFrontUpPos);
    }

    public void setBack(boolean down) {
        if (down)
            backSolenoid.set(Const.kClimbBackDownPos);
        else
            backSolenoid.set(Const.kClimbBackUpPos);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new ClimbSet(false, false));
    }
}
