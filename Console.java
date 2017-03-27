package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.BattleView;
import dragonball.view.Header;

public class Console implements EventListener, GameListener,ActionListener {
 
private Header h ;
 private Game game ;
  private BattleView battleView;
  private Battle battle ;
   public Console () throws MissingFieldException, UnknownAttackTypeException {
	  h = new Header(this) ; 
	   game = new Game () ;
       battleView = new BattleView () ;
	   game.setListener(this);
   
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
   	JButton button = (JButton) e.getSource();
   	Header h2 = this.getH() ;
   	if (button.getActionCommand().equals("New Game") ) {
   	System.out.println(" X ");	
   	JPanel text = new JPanel () ;
   JTextField lastName = new JTextField ("Enter numbers here",10);
	lastName.setBounds(500, 500, 200, 50);
   	text.add(lastName) ;
	text.add(h2.getGameHeader()) ;
	h2.add(text) ;	
	h2.getPnlHeader().setVisible(false);
   		h2.getText().setVisible(true);
   		text.setVisible(true); 
   		this.setH(h2);
   	}
   		
   	
   }

@Override
public void onDragonCalled(Dragon dragon) {
	// TODO Auto-generated method stub
	
}

@Override
public void onCollectibleFound(Collectible collectible) {
	// TODO Auto-generated method stub
	
}

@Override
public void onBattleEvent(BattleEvent e) {
	// TODO Auto-generated method stub
	
}
public Header getH() {
	return h;
}

public Game getGame() {
	return game;
}
public void setH(Header h){
	this.h = h;
}


public void setGame(Game game) {
	this.game = game;
}

public static void main(String[] args) throws MissingFieldException, UnknownAttackTypeException {
	// initialize the supermarket GUI
new Console  ();}


public BattleView getBattleView() {
	return battleView;
}


public void setBattleView(BattleView battleView) {
	this.battleView = battleView;
}
 
}
