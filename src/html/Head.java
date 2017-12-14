package html;

import java.util.List;
import java.util.Map;
import main.java.iterators.Iterator;
import main.java.visitor.NodeVisitor;

public class Head extends Node {

	// map to store the attributes of head tag
	Map<String, String> headAttributes;
	Title t;
	
	// start and end elements of the head tag
	String startTag = "<head";
	String endTag = "</head>";
	StringBuilder textRep = new StringBuilder();
	
	// constructor for head class
	public Head(Map<String, String> headAttributes, Title t) {
		super();
		this.headAttributes = headAttributes;
		this.t = t;
	}

	// method overiding its abstract declaration of Node class
	// and return  the textual representation 
	@Override
	public
	String textualRepresentation() {
		textRep.append(startTag);
		for(Map.Entry<String, String> entry : headAttributes.entrySet()) {
			textRep.append(" ");
			textRep.append(entry.getKey());
			textRep.append("=");
			textRep.append(entry.getValue());
		}
		textRep.append(">");
		textRep.append(t.textualRepresentation());
		textRep.append(endTag);
		return textRep.toString();
	}

	//accept visitor method
	public void accept(NodeVisitor v) {    
		  v.visitHead(this); 
	} 
	
	// getter for Title attribute of head tag
	public Title getTitle(){
		return t;
	}
	
	// private inner class for head iterator to iteratte over the list of elements passed as second attribute
	/*private class HeadIterator implements Iterator<Node> {
		private List<Node> _tags;
		private int _tagCount;
		
		HeadIterator(Head html){
			_tags = html.listOfNodes;
			_tagCount = 0;
		}
		
		public boolean hasAnotherElement(){
			if(_tagCount >= _tags.size()){
				return false;
			}
			return true;
		}
			
		public Node nextElement(){
			return _tags.get(_tagCount++);
		}
	}
	
	 // iterators over the array of elements
	 public Iterator<Node> iterator(){
		 return new HTMLIterator(this); 
	 }*/
	
	public String attributeSearch(String attrName, String value) {
		StringBuilder str = new StringBuilder();
		for (Map.Entry<String, String> entry : headAttributes.entrySet()) {
			if (entry.getKey().equals(attrName) && entry.getValue().equals(value)) {
					str.append(this.textualRepresentation());
			}
		}
		return str.toString();
	}
}
