package frc.robot.auto;

import java.util.Arrays;
import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.Util.Trigger;
import frc.robot.commands.FollowPath;
import frc.robot.commands.Run;
import frc.robot.commands.SetRobot;
import frc.robot.commands.TriggerListener;
import frc.robot.commands.Wait;
import frc.robot.path.Field;
import frc.robot.path.Point;
import frc.robot.path.RobotPathConfig;
import frc.robot.path.Waypoint;

public class AutoRightCargoCargo extends CommandGroup { // todo

        public AutoRightCargoCargo() {

                // ============================ Pure Pursuit Config ==========================
                boolean reset;
                boolean reverse;
                double startingAngle = 180;
                List<Waypoint> waypoints;
                RobotPathConfig config;

                // ___________ Path 1____________

                reset = true;
                reverse = true;
                config = RobotPathConfig.getRobotConfig();

                waypoints = Arrays.asList( //
                                new Waypoint(Field.kStartingLowRight), //
                                new Waypoint(Field.kvStartingLowRight), //
                                new Waypoint(Field.kvCargoRightFront), //
                                new Waypoint(Field.kCargoRightFront) //
                );

                Command path1 = new FollowPath(reverse, reset, startingAngle - 90, config, waypoints);

                // ___________ Path 2____________

                reset = false;
                reverse = false;
                config = RobotPathConfig.getRobotConfig();
                // config.maxAngVel = 3;

                waypoints = Arrays.asList( //
                                new Waypoint(Field.kCargoRightFront), //
                                new Waypoint(Field.kvCargoRightFront), //
                                new Waypoint(Field.kvCargoSupplyRight), //
                                new Waypoint(Field.kCargoSupplyRight) //
                );

                Command path2 = new FollowPath(reverse, reset, startingAngle - 90, config, waypoints);

                // ___________ Path 3____________

                reset = false;
                reverse = true;
                config = RobotPathConfig.getRobotConfig();

                waypoints = Arrays.asList( //
                                new Waypoint(Field.kCargoSupplyRight), //
                                new Waypoint(Field.kvCargoSupplyRight), //
                                new Waypoint(Field.kvCargoRight1), //
                                new Waypoint(Field.kCargoRight1) //
                );

                Command path3 = new FollowPath(reverse, reset, startingAngle - 90, config, waypoints);

                ///

                Command frontGrab = new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop,
                                HatchState.Grab);
                Command backGrab = new SetRobot(ArmState.BackHatchInOut, JawState.Back, BallState.Stop,
                                HatchState.Grab);
                Command frontRelease = new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop,
                                HatchState.Release);
                Command backRelease = new SetRobot(ArmState.BackHatchInOut, JawState.Back, BallState.Stop,
                                HatchState.Release);
                Command frontIn = new SetRobot(ArmState.FrontBallFloorIn, JawState.Ball, BallState.In, HatchState.Grab);
                Command frontHold = new SetRobot(ArmState.FrontBallCargo, JawState.Ball, BallState.Hold,
                                HatchState.Grab);
                Command frontOut = new SetRobot(ArmState.FrontBallCargo, JawState.Ball, BallState.Out, HatchState.Grab);
                Command backOut = new SetRobot(ArmState.BackBallCargo, JawState.Ball, BallState.Out, HatchState.Grab);
                Command backHold = new SetRobot(ArmState.BackBallCargo, JawState.Ball, BallState.Hold, HatchState.Grab);
                Command inHold = new SetRobot(ArmState.FrontBallCargo, JawState.Ball, BallState.Hold, HatchState.Grab);

                /// =========================================================

                addParallel(new TriggerListener(Arrays.asList(//
                                new Trigger(path1, 16, backGrab), //
                                new Trigger(path1, 40, backRelease), //
                                new Trigger(path2, 20, frontIn), //
                                new Trigger(path3, 15, inHold), //
                                new Trigger(path3, 22, backHold), //
                                new Trigger(path3, 45, backOut) //
                )));

                addSequential(path1);
                addSequential(path2);
                addSequential(path3);

                // // Path 1
                // addParallel(new Run(new Wait(1), backGrab)); // parallel: don't wait for this
                // one to finish
                // addSequential(path1);
                // addParallel(backRelease);
                // addSequential(new Wait(0.3));
                // // Path 2
                // addParallel(new Run(new Wait(1), frontIn));
                // addSequential(path2);
                // addParallel(backGrab);
                // addSequential(new Wait(0.3));
                // addParallel(inHold);
                // // Path 3
                // addParallel(new Run(new Wait(1), backHold));
                // addSequential(path3);
                // addSequential(backOut);
        }

}
