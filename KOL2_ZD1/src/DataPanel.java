import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DataPanel extends JPanel{

	private JTextField payment;
	private JTextArea txtAr;
	
	public DataPanel() {
		createComp();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(250,350));
		add(new JScrollPane(txtAr, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS),
				BorderLayout.NORTH);
		
		add(payment, BorderLayout.SOUTH);
		
	}
	
	public void  createComp() {
		
		payment= new JTextField();
		txtAr= new JTextArea();

		txtAr.setPreferredSize(new Dimension(250,280));
		
		
	}
	
	public void setData(double rata) {
		
		payment.setText(Double.toString(rata));
		
	}
	public void showCalculations( ArrayList<Calculation> calc) {
		
		txtAr.setText("");
		
		for (int i=0; i<calc.size();i++) {
			txtAr.append("///////////////Calculation/////////////////"+"\n");
			txtAr.append("Visina kredita: "+calc.get(i).getKreda()+"\n");
			txtAr.append("Kamatna stopa: "+calc.get(i).getKamata()+"\n");
			txtAr.append("Godina otplate: "+calc.get(i).getGodina()+"\n");
			txtAr.append("Rata kredita: "+calc.get(i).getPay()+"\n");
		}
	}
}
