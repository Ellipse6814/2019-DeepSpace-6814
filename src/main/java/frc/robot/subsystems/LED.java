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

    private LED() {
    }

    public void setLEDRaw(double config) {
        led.set(config);
    }

    public void setLED(LEDState state) {
        // TODO: replace the values here with the speed values, then call @{Link setLEDRaw()}
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new HatchIntakeSet(HatchState.Grab));
    }
}
