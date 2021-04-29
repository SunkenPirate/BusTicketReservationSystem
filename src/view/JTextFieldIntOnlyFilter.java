package view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldIntOnlyFilter extends PlainDocument{

    
    private static final long serialVersionUID = 3420094856973313941L;
    String numbers="1234567890-.";
    @Override
    public void insertString(int offs, String str, AttributeSet a)
	    throws BadLocationException {
	if(!checkIfNumbersOnly(str));
	else    super.insertString(offs, str, a);
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
