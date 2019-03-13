package frc.robot.path;

public class Field {
    private static final double kVisionTargetLength = 18.5; // inches
    private static final double rampDx = 0.395; // the incline adds this much distance

    // the corner of the targets
    public static final Point kCargoLeftFront = in2m(new Point(219.13, 171.985));
    public static final Point kCargoRightFront = in2m(new Point(219.13, 150.235));
    public static final Point kCargoLeft1 = in2m(new Point(259.8, 183.86));
    public static final Point kCargoLeft2 = in2m(new Point(281.55, 183.86));
    public static final Point kCargoLeft3 = in2m(new Point(303.3, 183.86));
    public static final Point kCargoRight1 = in2m(new Point(259.8, 138.36));
    public static final Point kCargoRight2 = in2m(new Point(281.55, 138.36));
    public static final Point kCargoRight3 = in2m(new Point(303.3, 138.36));
    public static final Point kRocketLeftFront = in2m(new Point(207.57, 302.5));
    public static final Point kRocketLeftMiddle = in2m(new Point(228.28, 289.78));
    public static final Point kRocketLeftBack = in2m(new Point(248.99, 302.5));
    public static final Point kRocketRightFront = in2m(new Point(207.57, 19.72));
    public static final Point kRocketRightMiddle = in2m(new Point(228.28, 32.44));
    public static final Point kRocketRightBack = in2m(new Point(248.99, 19.72));
    public static final Point kHatchSupplyLeft = in2m(new Point(0, 296.5));
    public static final Point kHatchSupplyRight = in2m(new Point(0, 25.72));
    public static final Point kCargoSupplyLeft = in2m(new Point(48, 251.94));
    public static final Point kCargoSupplyRight = in2m(new Point(48, 70.28));
    // starting positions
    public static final Point kStartingLowLeft = in2m(new Point(48 - rampDx, 225.94));
    public static final Point kStartingLowMiddle = in2m(new Point(48 - rampDx, 161.11));
    public static final Point kStartingLowRight = in2m(new Point(48 - rampDx, 96.28));
    public static final Point kStartingHighLeft = in2m(new Point(0, 255.94));
    public static final Point kStartingHighMiddle = in2m(new Point(0, 161.11));
    public static final Point kStartingHighRight = in2m(new Point(0, 96.28));

    // ____________________________________________________
    //
    // vision target location: all 18.5 inches behind target

    public static final Point kvCargoLeftFront = in2m(new Point(201.13, 171.985));
    public static final Point kvCargoRightFront = in2m(new Point(201.13, 150.235));
    public static final Point kvCargoLeft1 = in2m(new Point(259.8, 207.24));
    public static final Point kvCargoLeft2 = in2m(new Point(281.55, 207.24));
    public static final Point kvCargoLeft3 = in2m(new Point(303.3, 207.24));
    public static final Point kvCargoRight1 = in2m(new Point(259.8, 114.98));
    public static final Point kvCargoRight2 = in2m(new Point(281.55, 114.98));
    public static final Point kvCargoRight3 = in2m(new Point(303.3, 114.98));
    public static final Point kvRocketLeftFront = in2m(new Point(199.13, 296.5));
    public static final Point kvRocketLeftMiddle = in2m(new Point(228.18, 276.78));
    public static final Point kvRocketLeftBack = in2m(new Point(258.83, 296.5));
    public static final Point kvRocketRightFront = in2m(new Point(199.13, 25.72));
    public static final Point kvRocketRightMiddle = in2m(new Point(228.28, 45.44));
    public static final Point kvRocketRightBack = in2m(new Point(258.83, 25.72));
    public static final Point kvHatchSupplyLeft = in2m(new Point(23.38, 296.5));
    public static final Point kvHatchSupplyRight = in2m(new Point(23.38, 25.72));
    public static final Point kvCargoSupplyLeft = in2m(
            new Point(48 + Math.cos(Math.toRadians(30)) * Field.kVisionTargetLength, //
                    251.94 + Math.sin(Math.toRadians(30)) * Field.kVisionTargetLength));
    public static final Point kvCargoSupplyRight = in2m(
            new Point(48 - Math.cos(Math.toRadians(30)) * Field.kVisionTargetLength, //
                    70.28 - Math.sin(Math.toRadians(30)) * Field.kVisionTargetLength));

    // starting positions
    public static final Point kvStartingLowLeft = in2m(new Point(48 - rampDx + Field.kVisionTargetLength, 225.94));
    public static final Point kvStartingLowMiddle = in2m(new Point(48 - rampDx + Field.kVisionTargetLength, 161.11));
    public static final Point kvStartingLowRight = in2m(new Point(48 - rampDx + Field.kVisionTargetLength, 96.28));
    public static final Point kvStartingHighLeft = in2m(new Point(0 + Field.kVisionTargetLength, 255.94));
    public static final Point kvStartingHighMiddle = in2m(new Point(0 + Field.kVisionTargetLength, 161.11));
    public static final Point kvStartingHighRight = in2m(new Point(0 + Field.kVisionTargetLength, 96.28));

    public static Point in2m(Point pt) {
        return new Point(pt).scale(0.0254);
    }

}