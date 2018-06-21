import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AppFrame extends JFrame{
	
	private JTextArea txtArea;
	private FormPanel fpanel;
	
	public AppFrame() {
		setLayout(new BorderLayout());
		setSize(650, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createComponents();

		activate_Frame();
	}
	
	public void createComponents() {
		txtArea = new JTextArea();
		fpanel = new FormPanel();
		
		Dimension dim = getPreferredSize();
        dim.height = 400;
        txtArea.setPreferredSize(dim);
		add(new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.NORTH);
		add(fpanel, BorderLayout.SOUTH);
		
		
		
	}
	
	public void activate_Frame() {
		
		fpanel.setFormListener(new FormListener() {

			@Override
			public void formEventOccured(FormEvent fe) {
				
				txtArea.append("///////////////VESSEL//////////////////"+"\n");
				txtArea.append("Name: "+fe.getVessName()+" --> Type: "+fe.getVessType()+" --> Age category: "+fe.getAgeCat()+"\n");
				
				
			}
			
		});
		
	}
	

}
