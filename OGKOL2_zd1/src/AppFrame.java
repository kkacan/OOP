import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AppFrame extends JFrame {
	
	private JTextArea txtArea;
	private FormPanel fPanel;
	 //private TextPanel txtPanel;
	
	public AppFrame() {
		
		
		createComponents();
		setLayout(new BorderLayout());

		add(new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),	BorderLayout.CENTER);
		add(fPanel, BorderLayout.SOUTH);
		 
		activateFrame();
		
	}
	
	public void createComponents() {
		
		txtArea = new JTextArea();
		fPanel = new FormPanel();
		
		fPanel.setFormListener(new FormListener() {

			@Override
			public void formEventOccured(FormEvent evnt) {
				String name = evnt.getName();
                String type = evnt.getType();
                int ageCat = evnt.getAgeCat()+1;
 
                txtArea.append("//////////////////////////VESSEL//////////////////////////\n");
                txtArea.append("Name: " + name + "  --->  " + "Type: " + type + " ------> AgeCat: "+ ageCat + "\n");
				
			}
			
		});
		
	}
	public void activateFrame() {
		setSize(700,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	

}
