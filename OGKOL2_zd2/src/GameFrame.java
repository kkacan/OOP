import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class GameFrame extends JFrame {
	
	private FormPanel form;
	private JTextArea textArea;
	Game game= new Game();
	
	public GameFrame() {
		
		super("Game app");
		setLayout(new BorderLayout());
		setSize(550, 350);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createComp();
		showDialog();
		
	}
	
	public void createComp() {
		
		form = new FormPanel();
		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(550,100));
		add(textArea,BorderLayout.NORTH);
		add(form, BorderLayout.CENTER);
		
		form.setFormListener(new FormListener() {

			@Override
			public void formEventOccured(FormEvent evnt) {
				String name = evnt.getName();
                String age = evnt.getAge();

                textArea.append("//////////////////////////New Player//////////////////////////"+"\n");
                textArea.append("Player: "+name+"\n");

			}

			@Override
			public void formPlayEventOccured(FormPlayEvent evnt) {
				
				String name = evnt.getName();
                String broj = evnt.getBroj();
                
                game.dodajPokusaj(Integer.parseInt(broj));
                
                if (Integer.parseInt(broj)==game.getRandomBroj()) {
                	
                	
                	textArea.append("//////////////////////////Player//////////////////////////"+"\n");
                    textArea.append("Player: "+name+"\n");
                    textArea.append(Arrays.toString(game.getPokusaji().toArray())+"\n");
                    textArea.append("Target: "+Integer.parseInt(broj)+"\n");
                    
                    showPlayDialog("Hit the shot! You won!");
                    
                	
                } else {
                	showPlayDialog("Miss the shot! - Try Again!");
                }
                
				
			}

			@Override
			public void formNewGameEventOccured(FormNewGameEvent evnt) {
				textArea.setText("");
				newGame();
				
			}
			
		});
	}
	
	private void showDialog() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "You are new Player", "Player info", dialogButton);
		
		if(dialogResult == 0) {
			
			newGame();
			
		} else {
			
			newGame();
			showPlayDialog("Random nuber [1,42] is generated!");
			
		} 
	}
	
	private void showPlayDialog(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Game info",  JOptionPane.DEFAULT_OPTION);
	}
	
	public void newGame() {

		game.setRandomBroj();
		game.obrisiPokusaje();
	}
	
	

}
