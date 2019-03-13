package frc.robot.path;

public class Field {

    // the corner of the targets
    public static final Point kCargoLeftFront = new Point(219.13, 171.985);
    public static final Point kCargoRightFront = new Point(219.13, 150.235);
    public static final Point kCargoLeft1 = new Point(259.8, 183.86);
    public static final Point kCargoLeft2 = new Point(281.55, 183.86);
    public static final Point kCargoLeft3 = new Point(303.3, 183.86);
    public static final Point kCargoRight1 = new Point(259.8, 138.36);
    public static final Point kCargoRight2 = new Point(281.55, 138.36);
    public static final Point kCargoRight3 = new Point(303.3, 138.36);
    public static final Point kRocketLeftFront = new Point(207.57, 302.5);
    public static final Point kRocketLeftMiddle = new Point(228.28, 289.78);
    public static final Point kRocketLeftBack = new Point(248.99, 302.5);
    public static final Point kRocketRightFront = new Point(207.57, 19.72);
    public static final Point kRocketRightMiddle = new Point(228.28, 32.44);
    public static final Point kRocketRightBack = new Point(248.99, 19.72);
    public static final Point kHatchSupplyLeft = new Point(0, 296.5);
    public static final Point kHatchSupplyRight = new Point(0, 25.72);
    public static final Point kCargoSupplyLeft = new Point();
    public static final Point kCargoSupplyRight = new Point();

    // vision target location
    public static final Point kvCargoLeftFront = new Point(201.13, 171.985);
    public static final Point kvCargoRightFront = new Point(201.13, 150.235);
    public static final Point kvCargoLeft1 = new Point(259.8, 207.24);
    public static final Point kvCargoLeft2 = new Point(281.55, 207.24);
    public static final Point kvCargoLeft3 = new Point(303.3, 207.24);
    public static final Point kvCargoRight1 = new Point(259.8, 114.98);
    public static final Point kvCargoRight2 = new Point(281.55, 114.98);
    public static final Point kvCargoRight3 = new Point(303.3, 114.98);
    public static final Point kvRocketLeftFront = new Point(199.13, 296.5);
    public static final Point kvRocketLeftMiddle = new Point(228.18, 276.78);
    public static final Point kvRocketLeftBack = new Point(258.83, 296.5);
    public static final Point kvRocketRightFront = new Point(199.13, 25.72);
    public static final Point kvRocketRightMiddle = new Point(228.28, 45.44);
    public static final Point kvRocketRightBack = new Point(258.83, 25.72);
    public static final Point kvHatchSupplyLeft = new Point(23.38, 296.5);
    public static final Point kvHatchSupplyRight = new Point(23.38, 25.72);
    public static final Point kvCargoSupplyLeft = new Point();
    public static final Point kvCargoSupplyRight = new Point();

    // starting positions
    public static final Point kStartingLowLeft = new Point(47, 225.94);
    public static final Point kStartingLowMiddle = new Point(47, 161.11);
    public static final Point kStartingLowRight = new Point(47, 96.28);
    public static final Point kStartingHighLeft = new Point(0, 255.94);
    public static final Point kStartingHighMiddle = new Point(0, 161.11);
    public static final Point kStartingHighRight = new Point(0, 96.28);

    public static Point in2m(Point pt) {
        return new Point(pt).scale(0.0254);
    }
}