package gui.inputs;

import config.Configurations;

public class DefaultUsernameInput extends Input {
	protected void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
		saveNameAndClose();
    }                                           

    protected void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	saveNameAndClose();
    } 
    
    private void saveNameAndClose(){
    	Configurations.setAttribute("Username", jTextField1.getText());
    	this.dispose();
    }
}
