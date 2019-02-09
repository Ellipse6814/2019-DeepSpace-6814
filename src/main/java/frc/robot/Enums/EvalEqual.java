package frc.robot.Enums;

public class EvalEqual implements Evaluate {
    private boolean bool;

    public EvalEqual() {
        this.bool = true;
    }

    public EvalEqual(boolean bool) {
        this.bool = bool;
    }

    @Override
    public boolean evaluate() {
        return bool;
    }
}