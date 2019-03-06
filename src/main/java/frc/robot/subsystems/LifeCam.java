package frc.robot.subsystems;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifeCam extends Subsystem {

    private static LifeCam instance;

    public static LifeCam getInstance() {
        if (instance == null)
            instance = new LifeCam();
        return instance;
    }

    private UsbCamera camera;

    private LifeCam() {
        startCamera();
    }

    public void startCamera() {
        camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 15);
        MjpegServer cameraServer = new MjpegServer("Camera 0", 5810);
        cameraServer.setSource(camera);
    }

    private void startSimpleCamera() {
        CameraServer.getInstance().startAutomaticCapture();
    }

    @Override
    public void initDefaultCommand() {
    }
}
