package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Util.LEDState;

public class LED extends Subsystem {

    private static LED instance;

    public static LED getInstance() {
        if (instance == null) {
            instance = new LED();
        }
        return instance;
    }

    private SpeedController led = new Spark(Const.kLEDPort);
    public LEDState state = LEDState.White;
    private double speed;

    private LED() {
    }

    public void setLEDRaw(double config) {
        speed = config;
    }

    public void set(LEDState state) {
        speed = Const.calcLEDSpd(state);
    }

    @Override
    public void periodic() {
        led.set(speed);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new HatchIntakeSet(HatchState.Grab));
    }
}
