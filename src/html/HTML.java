package html;

import java.util.List;
import java.util.Map;

import main.java.iterators.Iterator;
import main.java.visitor.NodeVisitor;

public class HTML extends Node {

	// map to store the attributes of html tag
	Map<String, String> htmlAttributes;
	List<Node> listOfNodes;
	
	String startTag = "<html";  
	String endTag = "</html>";
	StringBuilder textRep = new StringBuilder();
	
	// constructor initializing the fields of html class
	public HTML(Map<String, String> htmlAttributes, List<Node> listOfNodes) {
		super();
		this.htmlAttributes = htmlAttributes;
		this.listOfNodes = listOfNodes;
	}

	// method overiding the textualRepresentation method of Node class
	@Override
	public
	String textualRepresentation() {
		textRep.append(startTag);
		for(Map.Entry<String, String> entry : htmlAttributes.entrySet()) {
			textRep.append(" ");
			textRep.append(entry.getKey());
			textRep.append("=");
			textRep.append(entry.getValue());
		}
		textRep.append(">");
		for (Node obj : listOfNodes) {
			textRep.append(obj.textualRepresentation());
		}
		
		textRep.append(endTag);
		return textRep.toString();
	}

	//accept visitor method
	public void accept(NodeVisitor v) {    
		 v.visitHTML(this); 
	}
	
	// private inner class for HTML iterator to iteratte over the list of elements passed as second attribute
	private class HTMLIterator implements Iterator<Node> {
		private List<Node> _tags;
		private int _tagCount;
		
		HTMLIterator(HTML html){
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
	 }
	 
		public String attributeSearch(String attrName, String value) {
			StringBuilder str = new StringBuilder();
			for (Map.Entry<String, String> entry : htmlAttributes.entrySet()) {
				if (entry.getKey().equals(attrName) && entry.getValue().equals(value)) {
						str.append(this.textualRepresentation());
				}
			}
			return str.toString();
		}
}
