package html;

import java.util.Map;

import main.java.visitor.NodeVisitor;

public class Div extends Node {

	// hashmap to keep track of any additional parameters of Div tag 
	// like id, class
	Map<String, String> divAttributes;
	String divName;
	
	// start and end element tags
	String startTag = "<div";
	String endTag = "</div>";
	StringBuilder textRep = new StringBuilder();
	
	// Div constructor
	public Div(Map<String, String> divAttributes, String divName) {
		super();
		this.divAttributes = divAttributes;
		this.divName = divName;
	}

	// overrides the abstract Node class method textualRepresentation
	@Override
	public
	String textualRepresentation() {
		textRep.append(startTag);
		for(Map.Entry<String, String> entry : divAttributes.entrySet()) {
			textRep.append(" ");
			textRep.append(entry.getKey());
			textRep.append("=");
			textRep.append(entry.getValue());
		}
		textRep.append(">");
		textRep.append(divName);
		textRep.append(endTag);
		return textRep.toString();
	}

	//accept visitor method
	public void accept(NodeVisitor v) {    
		v.visitDiv(this); 
	} 
	
	public String attributeSearch(String attrName, String value) {
		StringBuilder str = new StringBuilder();
		for (Map.Entry<String, String> entry : divAttributes.entrySet()) {
			if (entry.getKey().equals(attrName) && entry.getValue().equals(value)) {
					str.append(this.textualRepresentation());
			}
		}
		return str.toString();
	}
}
