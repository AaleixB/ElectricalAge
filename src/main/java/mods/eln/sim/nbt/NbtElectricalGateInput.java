package mods.eln.sim.nbt;

import mods.eln.Eln;
import mods.eln.misc.Utils;
import mods.eln.misc.VoltageTier;

public class NbtElectricalGateInput extends NbtElectricalLoad {

    public NbtElectricalGateInput(String name) {
        super(name);
        Eln.smallInsulationLowCurrentCopperCable.applyTo(this);
    }

    public String plot(String str) {
        return Utils.plotSignal(getU(), getI()); // str  + " "+ Utils.plotVolt("", getU()) + Utils.plotAmpere("", getCurrent());
    }

    public boolean stateHigh() {
        return getU() > VoltageTier.TTL.getVoltage() * 0.6;
    }

    public boolean stateLow() {
        return getU() < VoltageTier.TTL.getVoltage() * 0.2;
    }

    public double getNormalized() {
        double norm = getU() * (1.0 / VoltageTier.TTL.getVoltage());
        if (norm < 0.0) norm = 0.0;
        if (norm > 1.0) norm = 1.0;
        return norm;
    }

    public double getBornedU() {
        double U = this.getU();
        if (U < 0.0) U = 0.0;
        if (U > VoltageTier.TTL.getVoltage()) U = VoltageTier.TTL.getVoltage();
        return U;
    }
}
