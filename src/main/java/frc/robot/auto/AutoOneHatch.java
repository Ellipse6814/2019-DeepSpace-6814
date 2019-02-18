package frc.robot.auto;

import java.util.Arrays;
import java.util.List;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Util.ArmState;
import frc.robot.Util.BallState;
import frc.robot.Util.HatchState;
import frc.robot.Util.JawState;
import frc.robot.commands.FollowPath;
import frc.robot.commands.Run;
import frc.robot.commands.SetRobot;
import frc.robot.commands.SetStage;
import frc.robot.commands.WaitUntilPathProgress;
import frc.robot.commands.WaitUntilStage;
import frc.robot.path.RobotPathConfig;
import frc.robot.path.Units;
import frc.robot.path.Waypoint;

public class AutoOneHatch extends CommandGroup {

        private String stage = "not started";

        public AutoOneHatch() {

                // ============================ Pure Pursuit Config ==========================
                boolean reset, reverse;
                List<Waypoint> waypoints;
                RobotPathConfig config;

                reset = true;
                reverse = false;
                config = RobotPathConfig.getPracticeRobotConfig();

                waypoints = Arrays.asList(new Waypoint(Units.in2m(116.75), Units.in2m(66)),
                                new Waypoint(Units.in2m(116.75), Units.in2m(66) + 0.5),
                                new Waypoint(Units.in2m(150.12), Units.in2m(227.75) - 2),
                                new Waypoint(Units.in2m(150.12), Units.in2m(227.75)));

                Command path1 = new FollowPath(reverse, reset, config, waypoints);

                reset = false;
                reverse = true;
                config = RobotPathConfig.getPracticeRobotConfig();

                waypoints = Arrays.asList(new Waypoint(Units.in2m(150.12), Units.in2m(227.75)),
                                new Waypoint(Units.in2m(150.12), Units.in2m(200)));

                Command path2 = new FollowPath(reverse, reset, config, waypoints);

                // ============================ Auto Driving ==============================
                addParallel(new Run(Arrays.asList(new SetStage(stage, "diving first path"), path1,
                                new SetStage(stage, "arrived at first place"),
                                new WaitUntilStage(stage, "finished placing first piece"),
                                new SetStage(stage, "diving second path"), path2)));

                // ============================ Mechanisms ==============================
                addParallel(new Run(Arrays.asList(new WaitUntilPathProgress(path1, 0.25),
                                new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop, HatchState.Grab),
                                new WaitUntilStage(stage, "arrived at first place"),
                                new SetRobot(ArmState.FrontHatchInOut, JawState.Front, BallState.Stop,
                                                HatchState.Release),
                                new SetStage(stage, "finished placing first piece"),
                                new WaitUntilStage(stage, "diving second path"),
                                new SetRobot(ArmState.Middle, JawState.Front, BallState.Stop, HatchState.Release))));
        }
}
