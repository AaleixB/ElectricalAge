package mods.eln.sim.mna.component;

import mods.eln.sim.mna.SubSystem;
import mods.eln.sim.mna.misc.ISystemProcessI;

public class Delay extends Bipole implements ISystemProcessI{

	
	public Delay set(double impedance){
		this.impedance = impedance;
		this.conductance = 1/impedance;
		return this;
	}
	
	double impedance,conductance;
	
	@Override
	public void addedTo(SubSystem s) {
		super.addedTo(s);
		s.addProcess(this);
	}
	
	@Override
	public void applyTo(SubSystem s) {
		s.addToA(aPin,aPin,conductance);
		s.addToA(bPin,bPin,conductance);
	}

	
	double oldIa,oldIb;
	@Override
	public void simProcessI(SubSystem s) {
		double aPinI = 2*s.getX(bPin)*conductance + oldIb;
		double bPinI = 2*s.getX(aPin)*conductance + oldIa;
		
		s.addToI(aPin,aPinI);
		s.addToI(bPin,bPinI);
		
		oldIa = -aPinI;
		oldIb = -bPinI;
	}
	
	

}