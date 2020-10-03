package mods.eln.signalinductor;

import mods.eln.node.six.SixNodeDescriptor;
import mods.eln.sim.ElectricalLoad;
import mods.eln.sim.mna.component.Inductor;
import mods.eln.sixnode.electricalcable.ElectricalCableDescriptor;
import mods.eln.sixnode.genericcable.GenericCableDescriptor;
import net.minecraft.item.Item;

public class SignalInductorDescriptor extends SixNodeDescriptor {

    GenericCableDescriptor cable;
    String descriptor;
    public double henri;

    public SignalInductorDescriptor(String name, double henri, GenericCableDescriptor cable) {
        super(name, SignalInductorElement.class, SignalInductorRender.class);
        this.henri = henri;
        this.cable = cable;
    }

    @Override
    public void setParent(Item item, int damage) {
        super.setParent(item, damage);
        //Data.addEnergy(newItemStack());
    }

    public void applyTo(ElectricalLoad load) {
        cable.applyTo(load);
    }

    public void applyTo(Inductor inductor) {
        inductor.setL(henri);
    }
}
