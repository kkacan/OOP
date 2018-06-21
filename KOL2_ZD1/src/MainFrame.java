import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;


public class MainFrame extends JFrame{
	
	private FormPanel fPanel;
	private DataPanel dPanel;
	private Database dbs = new Database();
	
	
	public MainFrame() {
		
		setLayout(new BorderLayout());
		setSize(550, 350);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createComp();
		activateApp();
	}
	
	private void createComp() {
		

		dPanel= new DataPanel();
		fPanel= new FormPanel();
		
		
		add(dPanel,BorderLayout.EAST);
		add(fPanel, BorderLayout.CENTER);
		
	}
	
	public void activateApp() {
		
		fPanel.setFormListener(new FormListener() {

			@Override
			public void calculateFormEventOccured(FormEvent cfe) {
				
				Calculation calc = new Calculation(cfe.getKreda(),cfe.getKamata(),cfe.getNacin(),cfe.getGodina());
				
				dbs.addCalc(calc);
				
				double rata= Calculation.calculate(cfe.getKreda(),cfe.getKamata(),cfe.getNacin(),cfe.getGodina());
				
				calc.setPay(rata);
				

				dPanel.setData(rata);
				
			}

			@Override
			public void listFormEventOccured(FormEvent lfe) {
				
				ArrayList<Calculation> calc= dbs.getCalc();
				
				dPanel.showCalculations(calc);
			}
			
		});
		
		
		
		
		
	}

}
