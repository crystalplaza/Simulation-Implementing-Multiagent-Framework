/*
 * created by Xiaoli Tong on 4/12
 * revised by zihui Chen on 4/13
 * revised by Yunlin Xie on 4/14
 */

package pdt;

import simstation.*;

public class PDTournament extends Simulation{
	private static final long serialVersionUID = 1L;
	
	public static int eachAgentNum = 10;
	
	public PDTournament() {
		super();
	}
	
	public void populate() {
		for(int i =0; i< eachAgentNum; i++) {
			this.addAgent(new Prisoner(new AlwaysCheat()));
		}
		
		for(int i =0; i< eachAgentNum; i++) {
			this.addAgent(new Prisoner(new AlwaysCooperate()));
		}
		
		for(int i =0; i< eachAgentNum; i++) {
			this.addAgent(new Prisoner(new RandomCooperate()));
		}
		
		for(int i =0; i< eachAgentNum; i++) {
			this.addAgent(new Prisoner(new CooperateVSLastCooperate()));
		}		
	}
	
	
	@Override

	public synchronized String[] getStats() {
		double  cheatScore = 0.0;
		int cheatNum = 0;
		double cooperateScore = 0.0;
		int cooperateNum = 0;
		double  reciprocatorScore = 0.0;
		int reciprocatorNum = 0;
		double randomScore = 0.0;
		int randomNum = 0;
		
		double cheaterAvg =0.0;
		double cooperatorAvg =0;
		double reciprocatorAvg = 0.0;
		double randomAvg =0.0 ;
		
		for(Agent agent: agents) {
			Prisoner prisoner = (Prisoner) agent;
			
			if(prisoner.getStrategy() instanceof AlwaysCheat) {
				cheatScore += prisoner.getScore();
				cheatNum ++;
			}else if(prisoner.getStrategy() instanceof AlwaysCooperate) {
				cooperateScore += prisoner.getScore();
				cooperateNum ++;
			}else if(prisoner.getStrategy() instanceof CooperateVSLastCooperate) {
				reciprocatorScore += prisoner.getScore();
				reciprocatorNum ++;
			}else {
				randomScore += prisoner.getScore();
				randomNum ++;
			}
			
		}
		
		if(cheatNum >0) {
			cheaterAvg = cheatScore/(double)cheatNum;
		}
        
		if(cooperateNum >0) {
			cooperatorAvg = cooperateScore/(double)cooperateNum;
		}
		
		if(reciprocatorNum >0) {
			reciprocatorAvg = reciprocatorScore/(double)reciprocatorNum;
		}
		if(randomNum >0) {
			randomAvg = randomScore/(double)randomNum;
		}

		String[]  messages = new String[6];
		messages[0] ="#agent = " + Integer.toString(getAgentSize());
		messages[1] = "clock = " + Integer.toString(getClock());
		messages[2] = "cheater's average = " + Double.toString(cheaterAvg);
		messages[3] = "cooperator's average = " + Double.toString(cooperatorAvg);
		messages[4] = "reciprocator's average = " + Double.toString(reciprocatorAvg);
		messages[5] = "random's avg = " + Double.toString(randomAvg);
		return messages;
	}
	
	public static void main(String[] args) {
		SimulationPanel panel = new SimulationPanel(new pdtFactory());
		panel.display();
	}
}