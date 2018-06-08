package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import controller.Controller;
import model.Customer;

public class MainFrame extends JFrame {

	private TextPanel txtPanel;
	private ToolBar tlbar;
	private ToolBarListener tListener;
	private FormPanel fPanel;
	private MenuBar menuBar;
	private Controller cntrl;
	private TableFrame tableFrame;
	private MenuBarListener mListener;


	public MainFrame() {

		setLayout(new BorderLayout());

		createCompMainFrame();
		add(fPanel, BorderLayout.SOUTH);
		add(txtPanel, BorderLayout.CENTER);
		add(tlbar, BorderLayout.NORTH);
		tlbar.setToolBarListener(tListener);
		setJMenuBar(menuBar.getJMenuBar());
		menuBar.setMainFrame(MainFrame.this);
		menuBar.setMenuBarListener(mListener);
		setSize(750, 600);
		Dimension mins = new Dimension(700, 550);
		setMinimumSize(mins);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void createCompMainFrame() {

		txtPanel = new TextPanel();
		tlbar = new ToolBar();
		fPanel = new FormPanel();
		menuBar = new MenuBar();
		cntrl = new Controller();
		TableFrame tableFrame = new TableFrame();
		tListener = new ToolBarListener() {

			@Override
			public void setTextFromFile(String text) {

				txtPanel.writeText(text);

			}

			@Override
			public void clearAllText() {

				txtPanel.clearTextArea();

			}

			@Override
			public void listAllCustomers() {
				cntrl.listAllCustomers();

			}
		};
		
		mListener = new MenuBarListener() {

			@Override
			public List<Customer> getCustomersData() {
				
				return cntrl.getData();
			}

			@Override
			public void setTextFromFile(String text) {
				
				txtPanel.writeText(text);
			}

						
				
			
			
		};

		fPanel.setFormListener(new FormListener() {

			@Override
			public void leftPanelEventOccured(LeftFormEvent lfe) {

				String city = lfe.getCity();
				String mail = lfe.getMail();
				String name = lfe.getName();
				int counter = lfe.getNumClicked();

				txtPanel.writeText(name + " : " + city + " : " + mail);
				cntrl.addCustomerData(lfe);

				if (counter == 1) {
					
					tableFrame.setTableData(cntrl.getData());
					tableFrame.setVisible(true);
					tableFrame.refreshTable();

				} else {
					
					tableFrame.setTableData(cntrl.getData());
					tableFrame.refreshTable();

				}

			}

			@Override
			public void rightPanelEventOccured(RightFormEvent rfe) {

				int productCat = rfe.getProducrCat();
				boolean giftCard = rfe.isGiftCard();
				boolean decorativePack = rfe.isDecorativePack();
				boolean newLetter = rfe.isNewLetter();
				String paymentMet = rfe.getPaymentMet();
				String gcText = rfe.getGcText();
				String delivery = rfe.getDelivery();

				System.out.println("Kategorija proizvoda: " + productCat);
				System.out.println("Gift card: " + giftCard);
				System.out.println("Gift card short text: " + gcText);
				System.out.println("Decorative package: " + decorativePack);
				System.out.println("Send me newsletters: " + newLetter);
				System.out.println("Payment method: " + paymentMet + ", delivery: " + delivery);

			}
		});
		
		

	}


}
