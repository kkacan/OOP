package gui;
import java.util.EventListener;

/**
 * Listener koji sluša evente sa lijevog i desnog panela.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */

public interface FormListener extends EventListener {
	
	public void leftPanelEventOccured(LeftFormEvent lfe);
	public void rightPanelEventOccured(RightFormEvent rfe);
	

}
