package frc.robot.commandGroups;

import java.util.Arrays;
import java.util.List;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.FollowPath;
import frc.robot.path.*;

public class LeftPath extends CommandGroup {

        public LeftPath() {
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

                addSequential(new FollowPath(reverse, reset, config, waypoints));

                reset = false;
                reverse = true;
                config = RobotPathConfig.getPracticeRobotConfig();
                // config.maxAngVel = 3;

                waypoints = Arrays.asList(new Waypoint(Units.in2m(150.12), Units.in2m(227.75)),
                                new Waypoint(Units.in2m(150.12), Units.in2m(227.75) - 2),
                                new Waypoint(Units.in2m(25.94), Units.in2m(0) + 2),
                                new Waypoint(Units.in2m(25.94), Units.in2m(0)));

                addSequential(new FollowPath(reverse, reset, config, waypoints));

                reset = false;
                reverse = false;
                config = RobotPathConfig.getPracticeRobotConfig();

                waypoints = Arrays.asList(new Waypoint(Units.in2m(25.94), Units.in2m(0)),
                                new Waypoint(Units.in2m(25.94), Units.in2m(0) + 1),
                                // new Waypoint(Units.in2m(74), Units.in2m(250)),
                                new Waypoint(Units.in2m(138) - 2, Units.in2m(260.75)),
                                new Waypoint(Units.in2m(138), Units.in2m(260.75)));

                addSequential(new FollowPath(reverse, reset, config, waypoints));

        }
}
