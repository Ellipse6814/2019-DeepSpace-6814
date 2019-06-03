package frc.robot.path;

public class Field {
        private static final double kVisionTargetLength = 18.5 + 10; // inches
        private static final double rampDx = 0.395; // the incline adds this much distance
        private static final double robotWidth = 32.5;// inches
        private static final double robotWidthRadius = robotWidth / 2;
        private static final double robotLength = 40.5;// inches
        private static final double robotLengthRadius = robotLength / 2;

        // the corner of the targets
        public static final Point kCargoLeftFront = in2m(new Point(219.13 - 30 + 10, 171.985 + 2)); // real field at 220
        public static final Point kCargoRightFront = in2m(new Point(219.13 - 30, 150.235));
        public static final Point kCargoLeft1 = in2m(new Point(259.8 - 11, 183.86 + 30)); // real field at 260
        public static final Point kCargoLeft2 = in2m(new Point(281.55, 183.86 + 30));
        public static final Point kCargoLeft3 = in2m(new Point(303.3, 183.86 + 30));
        public static final Point kCargoRight1 = in2m(new Point(259.8, 138.36 - 30));
        public static final Point kCargoRight2 = in2m(new Point(281.55, 138.36 - 30));
        public static final Point kCargoRight3 = in2m(new Point(303.3, 138.36 - 30));
        public static final Point kRocketLeftFront = in2m(new Point(207.57, 302.5));
        public static final Point kRocketLeftMiddle = in2m(new Point(228.28, 289.78));
        public static final Point kRocketLeftBack = in2m(new Point(248.99, 302.5));
        public static final Point kRocketRightFront = in2m(new Point(207.57, 19.72));
        public static final Point kRocketRightMiddle = in2m(new Point(228.28, 32.44));
        public static final Point kRocketRightBack = in2m(new Point(248.99, 19.72));
        public static final Point kHatchSupplyLeft = in2m(new Point(0, 296.5));
        public static final Point kHatchSupplyRight = in2m(new Point(0, 25.72));
        public static final Point kCargoSupplyLeft = in2m(new Point(48 - 8, 251.94 - 8));
        public static final Point kCargoSupplyRight = in2m(new Point(48, 70.28));
        // starting positions
        public static final Point kStartingLowLeft = in2m(
                        new Point(48 - rampDx + robotLengthRadius, 225.94 - robotWidthRadius));
        public static final Point kStartingLowMiddle = in2m(//
                        new Point(48 - rampDx + robotLengthRadius, 161.11));
        public static final Point kStartingLowRight = in2m(
                        new Point(48 - rampDx + robotLengthRadius, 96.28 + robotWidthRadius));
        public static final Point kStartingHighLeft = in2m(
                        new Point(0 - rampDx + robotLengthRadius, 255.94 - robotWidthRadius));
        public static final Point kStartingHighMiddle = in2m(//
                        new Point(0 - rampDx + robotLengthRadius, 161.11));
        public static final Point kStartingHighRight = in2m(
                        new Point(0 - rampDx + robotLengthRadius, 96.28 + robotWidthRadius));

        // ____________________________________________________
        //
        // vision target location: all 18.5 inches behind target

        public static final Point kvCargoLeftFront = in2m(new Point(201.13 - 10 - 30, 171.985 + 2));
        public static final Point kvCargoRightFront = in2m(new Point(201.13 - 10 - 30, 150.235));
        public static final Point kvCargoLeft1 = in2m(new Point(259.8 + 10, 207.24 + 20 + 30));
        public static final Point kvCargoLeft2 = in2m(new Point(281.55 + 10, 207.24 + 20 + 30));
        public static final Point kvCargoLeft3 = in2m(new Point(303.3 + 10, 207.24 + 20 + 30));
        public static final Point kvCargoRight1 = in2m(new Point(259.8 + 10, 114.98 - 20 - 30));
        public static final Point kvCargoRight2 = in2m(new Point(281.55 + 10, 114.98 - 20 - 30));
        public static final Point kvCargoRight3 = in2m(new Point(303.3 + 10, 114.98 - 20 - 30));
        public static final Point kvRocketLeftFront = in2m(new Point(199.13, 296.5));
        public static final Point kvRocketLeftMiddle = in2m(new Point(228.18, 276.78));
        public static final Point kvRocketLeftBack = in2m(new Point(258.83, 296.5));
        public static final Point kvRocketRightFront = in2m(new Point(199.13, 25.72));
        public static final Point kvRocketRightMiddle = in2m(new Point(228.28, 45.44));
        public static final Point kvRocketRightBack = in2m(new Point(258.83, 25.72));
        public static final Point kvHatchSupplyLeft = in2m(new Point(23.38, 296.5));
        public static final Point kvHatchSupplyRight = in2m(new Point(23.38, 25.72));
        public static final Point kvCargoSupplyLeft = in2m(
                        new Point(48 + Math.cos(Math.toRadians(30)) * kVisionTargetLength, //
                                        251.94 + Math.sin(Math.toRadians(30)) * kVisionTargetLength));
        public static final Point kvCargoSupplyRight = in2m(
                        new Point(48 + Math.cos(Math.toRadians(30)) * kVisionTargetLength, //
                                        70.28 - Math.sin(Math.toRadians(30)) * kVisionTargetLength));

        // starting positions
        public static final Point kvStartingLowLeft = in2m(
                        new Point(48 - rampDx + robotLengthRadius + kVisionTargetLength, 225.94 - robotWidthRadius));
        public static final Point kvStartingLowMiddle = in2m(//
                        new Point(48 - rampDx + robotLengthRadius + kVisionTargetLength, 161.11));
        public static final Point kvStartingLowRight = in2m(
                        new Point(48 - rampDx + robotLengthRadius + kVisionTargetLength, 96.28 + robotWidthRadius));
        public static final Point kvStartingHighLeft = in2m(
                        new Point(0 - rampDx + robotLengthRadius + kVisionTargetLength, 255.94 - robotWidthRadius));
        public static final Point kvStartingHighMiddle = in2m(//
                        new Point(0 - rampDx + robotLengthRadius + kVisionTargetLength, 161.11));
        public static final Point kvStartingHighRight = in2m(
                        new Point(0 - rampDx + robotLengthRadius + kVisionTargetLength, 96.28 + robotWidthRadius));

        public static Point in2m(Point pt) {
                return new Point(pt).scale(0.0254);
        }

        public static double in2m(double inches) {
                return inches * 0.0254;
        }

}