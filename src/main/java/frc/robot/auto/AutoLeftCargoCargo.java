package frc.robot.auto;

import java.util.Arrays;
import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.Evaluate;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.FollowPath;
import frc.robot.commands.Run;
import frc.robot.commands.SetRobot;
import frc.robot.commands.SetStage;
import frc.robot.commands.Wait;
import frc.robot.commands.WaitUntil;
import frc.robot.commands.WaitUntilPathProgress;
import frc.robot.commands.WaitUntilStage;
import frc.robot.path.RobotPathConfig;
import frc.robot.path.Units;
import frc.robot.path.Waypoint;

public class AutoLeftCargoCargo extends CommandGroup {

        private String stage = "not started";

        public AutoLeftCargoCargo() {

                // ============================ Pure Pursuit Config ==========================
                boolean reset, reverse;
                List<Waypoint> waypoints;
                RobotPathConfig config;

                // ___________ Path 1____________

                reset = true;
                reverse = false;
                config = RobotPathConfig.getRobotConfig();

                waypoints = Arrays.asList(new Waypoint(Units.in2m(116.75), Units.in2m(66)),
                                new Waypoint(Units.in2m(116.75), Units.in2m(66) + 0.5),
                                new Waypoint(Units.in2m(150.12), Units.in2m(227.75) - 2),
                                new Waypoint(Units.in2m(150.12), Units.in2m(227.75)));

                Command path1 = new FollowPath(reverse, reset, config, waypoints);

                // ___________ Path 2____________

                reset = false;
                reverse = true;
                config = RobotPathConfig.getRobotConfig();
                // config.maxAngVel = 3;

                waypoints = Arrays.asList(new Waypoint(Units.in2m(150.12), Units.in2m(227.75)),
                                new Waypoint(Units.in2m(150.12), Units.in2m(227.75) - 2),
                                new Waypoint(Units.in2m(25.94), Units.in2m(0) + 2),
                                new Waypoint(Units.in2m(25.94), Units.in2m(0)));

                Command path2 = new FollowPath(reverse, reset, config, waypoints);

                // ___________ Path 3____________

                reset = false;
                reverse = false;
                config = RobotPathConfig.getRobotConfig();

                waypoints = Arrays.asList(new Waypoint(Units.in2m(25.94), Units.in2m(0)),
                                new Waypoint(Units.in2m(25.94), Units.in2m(0) + 1),
                                // new Waypoint(Units.in2m(74), Units.in2m(250)),
                                new Waypoint(Units.in2m(138) - 2, Units.in2m(260.75)),
                                new Waypoint(Units.in2m(138), Units.in2m(260.75)));

                Command path3 = new FollowPath(reverse, reset, config, waypoints);

                ///

                Command frontGrab = new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop,
                                HatchState.Grab);
                Command backGrab = new SetRobot(ArmState.BackHatchInOut, JawState.Back, BallState.Stop,
                                HatchState.Grab);
                Command frontRelease = new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop,
                                HatchState.Release);
                Command backRelease = new SetRobot(ArmState.BackHatchInOut, JawState.Back, BallState.Stop,
                                HatchState.Release);
                /// =========================================================

                // Path 1
                addParallel(new Run(new Wait(1), frontGrab)); // parallel: don't wait for this one to finish
                addSequential(path1);
                addParallel(frontRelease);
                addSequential(new Wait(0.3));
                // Path 2
                addParallel(new Run(new Wait(1), backRelease));
                addSequential(path2);
                addParallel(backGrab);
                addSequential(new Wait(0.3));
                // Path 2
                addParallel(new Run(new Wait(1), frontGrab));
                addSequential(path3);
                addSequential(frontRelease);
        }

}
