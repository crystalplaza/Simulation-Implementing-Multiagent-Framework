

package simstation;

import mvc.*;

public class SimulationFactory implements SimFactory {
	
	public Model makeModel() {return new Simulation();}
	
	public String[] getEditCommands() 
	{
		return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
	}
	
	public Command makeEditCommand(Model model, String type)
	{

		if(type == "Start") return new StartCommand(model);
		if(type == "Suspend")  return new SuspendCommand(model);
		if(type == "Resume") return new ResumeCommand(model);
		if(type == "Stop")  return new StopCommand(model);
		if(type=="Stats") return new StatsCommand(model);
		return null;
		
	}
	
	public String getTitle() {return "Simstation";}
	
	public String[] getHelp()
	{
		return new String[] {"click buttons to make changes"};
	}
	

	public String about()
	{
		return "Simstation version1.0. Copyright 2020.";
	}
	
	public View getView(Model model) {
		return new SimulationView(model);
		
	}
	
}

