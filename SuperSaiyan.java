package dragonball.model.attack;

import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.AlreadyTransformedException;
import dragonball.model.exceptions.NotEnoughKiException;

public class SuperSaiyan extends UltimateAttack {
	public SuperSaiyan() {
		super("Super Saiyan", 0);
	}

	@Override
	public int getAppliedDamage(BattleOpponent attacker) {
		return 0;
	}

	@Override
	public void onUse(BattleOpponent attacker, BattleOpponent defender, boolean defenderBlocking) throws NotEnoughKiException, AlreadyTransformedException {
		if (attacker instanceof Saiyan) {
			Saiyan attackerSaiyan = (Saiyan) attacker;
			if(attackerSaiyan.isTransformed() == true){
				throw new AlreadyTransformedException ("Fighter is arleady transformed" , attackerSaiyan) ;
			}
			
			else {

			// only requires 3 ki, without consuming them (override superclass behavior)
			if (attackerSaiyan.getKi() >= 3) {
				attackerSaiyan.setTransformed(true);
			}else{
				throw new NotEnoughKiException(3, attackerSaiyan.getKi());
			}
			}
		} 
	}
}

