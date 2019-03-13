package frc.robot.path;

public class Field {

    // the corner of the targets
    private static final Point kCargoLeftFront = new Point(219.13, 171.985);
    private static final Point kCargoRightFront = new Point(219.13, 150.235);
    private static final Point kCargoLeft1 = new Point(259.8, 183.86);
    private static final Point kCargoLeft2 = new Point(281.55, 183.86);
    private static final Point kCargoLeft3 = new Point(303.3, 183.86);
    private static final Point kCargoRight1 = new Point(259.8, 138.36);
    private static final Point kCargoRight2 = new Point(281.55, 138.36);
    private static final Point kCargoRight3 = new Point(303.3, 138.36);
    private static final Point kRocketLeftFront = new Point(207.57, 302.5);
    private static final Point kRocketLeftMiddle = new Point(228.28, 289.78);
    private static final Point kRocketLeftBack = new Point(248.99, 302.5);
    private static final Point kRocketRightFront = new Point(207.57, 19.72);
    private static final Point kRocketRightMiddle = new Point(228.28, 32.44);
    private static final Point kRocketRightBack = new Point(248.99, 19.72);
    private static final Point kHatchSupplyLeft = new Point(0, 296.5);
    private static final Point kHatchSupplyRight = new Point(0, 25.72);
    private static final Point kCargoSupplyLeft = new Point();
    private static final Point kCargoSupplyRight = new Point();

    // vision target location: all 18 inches behind target
    private static final Point kvCargoLeftFront = new Point(201.13, 171.985);
    private static final Point kvCargoRightFront = new Point(201.13, 150.235);
    private static final Point kvCargoLeft1 = new Point(259.8, 207.24);
    private static final Point kvCargoLeft2 = new Point(281.55, 207.24);
    private static final Point kvCargoLeft3 = new Point(303.3, 207.24);
    private static final Point kvCargoRight1 = new Point(259.8, 114.98);
    private static final Point kvCargoRight2 = new Point(281.55, 114.98);
    private static final Point kvCargoRight3 = new Point(303.3, 114.98);
    private static final Point kvRocketLeftFront = new Point(199.13, 296.5);
    private static final Point kvRocketLeftMiddle = new Point(228.18, 276.78);
    private static final Point kvRocketLeftBack = new Point(258.83, 296.5);
    private static final Point kvRocketRightFront = new Point(199.13, 25.72);
    private static final Point kvRocketRightMiddle = new Point(228.28, 45.44);
    private static final Point kvRocketRightBack = new Point(258.83, 25.72);
    private static final Point kvHatchSupplyLeft = new Point(23.38, 296.5);
    private static final Point kvHatchSupplyRight = new Point(23.38, 25.72);
    private static final Point kvCargoSupplyLeft = new Point();
    private static final Point kvCargoSupplyRight = new Point();

    // starting positions
    private static final Point kStartingLowLeft = new Point(47, 225.94);
    private static final Point kStartingLowMiddle = new Point(47, 161.11);
    private static final Point kStartingLowRight = new Point(47, 96.28);
    private static final Point kStartingHighLeft = new Point(0, 255.94);
    private static final Point kStartingHighMiddle = new Point(0, 161.11);
    private static final Point kStartingHighRight = new Point(0, 96.28);

    public static Point in2m(Point pt) {
        return new Point(pt).scale(0.0254);
    }

    // the corner of the targets
    public static final Point CargoLeftFront = in2m(Field.kCargoLeftFront);
    public static final Point CargoRightFront = in2m(Field.kCargoRightFront);
    public static final Point CargoLeft1 = in2m(Field.kCargoLeft1);
    public static final Point CargoLeft2 = in2m(Field.kCargoLeft2);
    public static final Point CargoLeft3 = in2m(Field.kCargoLeft3);
    public static final Point CargoRight1 = in2m(Field.kCargoRight1);
    public static final Point CargoRight2 = in2m(Field.kCargoRight2);
    public static final Point CargoRight3 = in2m(Field.kCargoRight3);
    public static final Point RocketLeftFront = in2m(Field.kRocketLeftFront);
    public static final Point RocketLeftMiddle = in2m(Field.kRocketLeftMiddle);
    public static final Point RocketLeftBack = in2m(Field.kRocketLeftBack);
    public static final Point RocketRightFront = in2m(Field.kRocketRightFront);
    public static final Point RocketRightMiddle = in2m(Field.kRocketRightMiddle);
    public static final Point RocketRightBack = in2m(Field.kRocketRightBack);
    public static final Point HatchSupplyLeft = in2m(Field.kHatchSupplyLeft);
    public static final Point HatchSupplyRight = in2m(Field.kHatchSupplyRight);
    public static final Point CargoSupplyLeft = in2m(Field.kCargoSupplyLeft);
    public static final Point CargoSupplyRight = in2m(Field.kCargoSupplyRight);

    // vision target location: all 18 inches behind target
    public static final Point vCargoLeftFront = in2m(Field.kvCargoLeftFront);
    public static final Point vCargoRightFront = in2m(Field.kvCargoRightFront);
    public static final Point vCargoLeft1 = in2m(Field.kvCargoLeft1);
    public static final Point vCargoLeft2 = in2m(Field.kvCargoLeft2);
    public static final Point vCargoLeft3 = in2m(Field.kvCargoLeft3);
    public static final Point vCargoRight1 = in2m(Field.kvCargoRight1);
    public static final Point vCargoRight2 = in2m(Field.kvCargoRight2);
    public static final Point vCargoRight3 = in2m(Field.kvCargoRight3);
    public static final Point vRocketLeftFront = in2m(Field.kvRocketLeftFront);
    public static final Point vRocketLeftMiddle = in2m(Field.kvRocketLeftMiddle);
    public static final Point vRocketLeftBack = in2m(Field.kvRocketLeftBack);
    public static final Point vRocketRightFront = in2m(Field.kvRocketRightFront);
    public static final Point vRocketRightMiddle = in2m(Field.kvRocketRightMiddle);
    public static final Point vRocketRightBack = in2m(Field.kvRocketRightBack);
    public static final Point vHatchSupplyLeft = in2m(Field.kvHatchSupplyLeft);
    public static final Point vHatchSupplyRight = in2m(Field.kvHatchSupplyRight);
    public static final Point vCargoSupplyLeft = in2m(Field.kvCargoSupplyLeft);
    public static final Point vCargoSupplyRight = in2m(Field.kvCargoSupplyRight);

    // starting positions
    public static final Point StartingLowLeft = in2m(Field.kStartingLowLeft);
    public static final Point StartingLowMiddle = in2m(Field.kStartingLowMiddle);
    public static final Point StartingLowRight = in2m(Field.kStartingLowRight);
    public static final Point StartingHighLeft = in2m(Field.kStartingHighLeft);
    public static final Point StartingHighMiddle = in2m(Field.kStartingHighMiddle);
    public static final Point StartingHighRight = in2m(Field.kStartingHighRight);
}