package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.Util.LEDState;

public class LED {

    private static LED instance;

    public static LED getInstance() {
        if (instance == null) {
            instance = new LED();
        }
        return instance;
    }

    private SpeedController led = new Spark(Const.kLEDPort);
    public LEDState state;

    private LED() {
        set(LEDState.Disconnected);
    }

    @Deprecated
    public void set(LEDState state) {
        this.state = state;
    }

    public void update() {
        updateState();
        updateLEDs();
    }

    private void updateLEDs() {
        LEDColor wantedColor = LEDColor.Off;

        if (state == LEDState.Disconnected)
            wantedColor = (Timer.getFPGATimestamp() > 0.5) ? LEDColor.Off : LEDColor.Yellow;
        else if (state == LEDState.Normal)
            wantedColor = (Timer.getFPGATimestamp() > 0.5) ? LEDColor.Off : LEDColor.Green;
        else if (state == LEDState.PrepOut)
            wantedColor = LEDColor.Yellow;
        else if (state == LEDState.DoneOut)
            wantedColor = LEDColor.Aqua;
        else if (state == LEDState.Danger)
            wantedColor = LEDColor.Red;

        led.set(calcLEDSpd(wantedColor));
    }

    private void updateState() {
        if (Robot.arm.state == ArmState.Reset)
            state = LEDState.Danger;
        else if (Robot.jaw.state == JawState.Reset)
            state = LEDState.Danger;
        else if (Robot.arm.state == ArmState.Custom)
            state = LEDState.Danger;
        else if (Robot.jaw.state == JawState.Custom)
            state = LEDState.Danger;
        else if (Robot.ballIntake.state == BallState.In)
            state = LEDState.PrepOut;
        else if (Robot.ballIntake.state == BallState.Out)
            state = LEDState.DoneOut;
        else if (Robot.hatchIntake.state == HatchState.Release)
            state = LEDState.PrepOut;
        else
            state = LEDState.Normal;

    }

    private double calcLEDSpd(LEDColor state) {

        double spd;
        if (state == LEDColor.Green)
            spd = 0.75;
        else if (state == LEDColor.White)
            spd = 0.93;
        else if (state == LEDColor.Yellow)
            spd = 0.69;
        else if (state == LEDColor.Violet)
            spd = 0.91;
        else if (state == LEDColor.Off)
            spd = 0.99;
        else if (state == LEDColor.ColorGradient2)
            spd = 0.41;
        else if (state == LEDColor.ColorBlend1)
            spd = -0.03;
        else if (state == LEDColor.Aqua)
            spd = 0.81;
        else if (state == LEDColor.Red)
            spd = 0.61;
        else if (state == LEDColor.Pink)
            spd = 0.59;
        else {
            System.out.println("LED THIS IS NOT HOW TO USE CUSTOM SETPOINT, hopefully 0.93 did not break anything");
            spd = 0.93;
        }
        return spd;
    }
}

enum LEDColor {
    Green, Yellow, White, Violet, Off, ColorGradient2, ColorBlend1, Aqua, Red, Pink
}
