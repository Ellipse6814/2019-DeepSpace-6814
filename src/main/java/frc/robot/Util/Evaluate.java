package frc.robot.Util;

public interface Evaluate {
    /**
     * if the condition is met. FALSE if not met -> keep waiting; TRUE if condition
     * met -> finish command
     * 
     * * @return if the condition is met.
     */
    public boolean evaluate();
}