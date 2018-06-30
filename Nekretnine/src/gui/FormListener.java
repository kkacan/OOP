package gui;
import java.util.EventListener;

/**
 * Listener koji slu�a evente sa lijevog i desnog panela.
 * @author Kristijan Ka�an
 * @since lipanj, 2018.
 */

public interface FormListener extends EventListener {
	
	public void leftPanelEventOccured(LeftFormEvent lfe);
	public void rightPanelEventOccured(RightFormEvent rfe);
	

}
