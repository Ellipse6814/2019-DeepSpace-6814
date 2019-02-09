package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Pneumatic extends Subsystem {

    private static Pneumatic instance;

    public static Pneumatic getInstance() {
        if (instance == null)
            instance = new Pneumatic();
        return instance;
    }

    private Compressor compressor;

    private Pneumatic() {
        compressor = new Compressor();
        startCompressor();
    }

    public void startCompressor() {
        System.out.println("Compressor Started.");
        compressor.start();
    }

    public void stopCompressor() {
        System.out.println("Compressor Stopped.");
        compressor.stop();
    }

    @Override
    public void initDefaultCommand() {
    }
}
