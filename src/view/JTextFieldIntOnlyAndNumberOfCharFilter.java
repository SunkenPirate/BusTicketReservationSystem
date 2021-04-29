package view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldIntOnlyAndNumberOfCharFilter extends PlainDocument{
    
    private static final long serialVersionUID = -8688648122864228483L;

    String numbers="1234567890-.";

    private int limit;

    public JTextFieldIntOnlyAndNumberOfCharFilter(int limit){
	this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException{

	if(str == null || !checkIfNumbersOnly(str)){
	    return;
	}else if((getLength() + str.length() <= limit)){
	    str = str.toUpperCase();
	    super.insertString(offset, str, set);
	}
    }
    
    private boolean checkIfNumbersOnly(String str){
	if(str == null){
	    return false;
	}else{
	    for(int i = 0; i < str.length(); i ++){
		if(!numbers.contains(str.substring(i, i+1))){
		    return false;
		}
			
	    }
	    return true;
	}
    }


}
