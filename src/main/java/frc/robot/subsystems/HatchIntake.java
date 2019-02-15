package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.HatchState;
import frc.robot.commands.HatchIntakeSet;

public class HatchIntake extends Subsystem {

    private static HatchIntake instance;

    public static HatchIntake getInstance() {
        if (instance == null) {
            instance = new HatchIntake();
        }
        return instance;
    }

    public HatchState state = HatchState.Open;
    private DoubleSolenoid doubleSolenoid;

    private HatchIntake() {
        doubleSolenoid = new DoubleSolenoid(Const.kIntakeSolenoidPort1, Const.kIntakeSolenoidPort2);
    }

    public void openHatchIntake() {
        doubleSolenoid.set(Const.kHatchIntakeOpenPos);
    }

    public void closeHatchIntake() {
        doubleSolenoid.set(Const.kHatchIntakeClosePos);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new HatchIntakeSet(HatchState.Open));
    }
}
