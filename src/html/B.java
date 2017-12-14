package html;

import java.util.Map;

import main.java.visitor.NodeVisitor;

public class B extends Node {

	// hashmap of attrbutes for B tag
	Map<String, String> bAttributes;
	
	// Div element which is inside B tag
	Div div;
	
	// start and end tags of b
	String startTag = "<b";
	String endTag = "</b>";
	
	// a string builder to store the string
	StringBuilder textRep = new StringBuilder();
	
	// constructor for B 
	public B(Map<String, String> bAttributes, Div div) {
		super();
		this.bAttributes = bAttributes;
		this.div = div;
	}

	// overriding method of abstract Node class to return the valid string
	@Override
	public
	String textualRepresentation() {
		textRep.append(startTag);
		for(Map.Entry<String, String> entry : bAttributes.entrySet()) {
			textRep.append(" ");
			textRep.append(entry.getKey());
			textRep.append("=");
			textRep.append(entry.getValue());
		}
		textRep.append(">");
		textRep.append(div.textualRepresentation());
		textRep.append(endTag);
		return textRep.toString();
	}

	//accept visitor method
	public void accept(NodeVisitor v) {    
		  v.visitB(this); 
	} 
	
	// returns Div node to the Visitor class
	public Div getDiv(){
		return div;
	}
	
	public String attributeSearch(String attrName, String value) {
		StringBuilder str = new StringBuilder();
		for (Map.Entry<String, String> entry : bAttributes.entrySet()) {
			if (entry.getKey().equals(attrName) && entry.getValue().equals(value)) {
				str.append(this.textualRepresentation());
			}
		}
		return str.toString();
	}
}
