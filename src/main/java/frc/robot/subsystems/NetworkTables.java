package frc.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Util.Listener;

public class NetworkTables extends Subsystem {

    private static NetworkTables instance;

    public static NetworkTables getInstance() {
        if (instance == null)
            instance = new NetworkTables();
        return instance;
    }

    NetworkTableInstance inst;

    // List<Listener> listeners = new ArrayList<Listener>();

    private NetworkTables() {
        inst = NetworkTableInstance.getDefault();

    }

    public void listen(String tab, String ent, Listener listener) {
        NetworkTable table = inst.getTable(tab);
        NetworkTableEntry entry= table.getEntry(ent);

        entry.addListener(event -> {
            listener.valueChanged(event.value);
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);
    }

    @Override
    public void initDefaultCommand() {

    }
}
