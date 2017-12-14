package html;

import java.util.Map;

import main.java.visitor.NodeVisitor;

public class Title extends Node {

	Map<String, String> titleAttributes;
	String titleName;
	
	String startTag = "<title";
	String endTag = "</title>";
	StringBuilder textRep = new StringBuilder();
	
	public Title(Map<String, String> titleAttributes, String titleName) {
		super();
		this.titleAttributes = titleAttributes;
		this.titleName = titleName;
	}

	// method to generate textual representation
	@Override
	public
	String textualRepresentation() {
		textRep.append(startTag);
		for(Map.Entry<String, String> entry : titleAttributes.entrySet()) {
			textRep.append(" ");
			textRep.append(entry.getKey());
			textRep.append("=");
			textRep.append(entry.getValue());
		}
		textRep.append(">");
		textRep.append(titleName);
		textRep.append(endTag);
		return textRep.toString();
	}

	//accept visitor method
	public void accept(NodeVisitor v) {    
		  v.visitTitle(this); 
	} 
	
	public String attributeSearch(String attrName, String value) {
		StringBuilder str = new StringBuilder();
		for (Map.Entry<String, String> entry : titleAttributes.entrySet()) {
			if (entry.getKey().equals(attrName) && entry.getValue().equals(value)) {
					str.append(this.textualRepresentation());
			}
		}
		return str.toString();
	}
}
