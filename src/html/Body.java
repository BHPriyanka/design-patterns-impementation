package html;

import java.util.List;
import java.util.Map;

import main.java.iterators.Iterator;
import main.java.visitor.NodeVisitor;

public class Body extends Node {

	// hashmap storing the attributes of body tag
	Map<String, String> BodyAttributes;
	
	// list of nodes present inside body tag
	List<Node> subTags;
	
	// start and end tags of Body
	String startTag = "<body";
	String endTag = "</body>";
	StringBuilder textRep = new StringBuilder();
	
	
	// Body contructor to  initialise the variables
	public Body(Map<String, String> BodyAttributes, List<Node> subTags) {
		super();
		this.BodyAttributes = BodyAttributes;
		this.subTags = subTags;
	}

	// overrides the method of Node class to prepare string for body element
	@Override
	public
	String textualRepresentation() {
		textRep.append(startTag);
		for(Map.Entry<String, String> entry : BodyAttributes.entrySet()) {
			textRep.append(" ");
			textRep.append(entry.getKey());
			textRep.append("=");
			textRep.append(entry.getValue());
		}
		textRep.append(">");
		for (Node obj : subTags) {
			textRep.append(obj.textualRepresentation());
		}
		textRep.append(endTag);
		return textRep.toString();
	}

	//accept visitor method
	public void accept(NodeVisitor v) {    
		  v.visitBody(this); 
	} 
	
	
	// private inner class defined for the iterator 
	// visible only to the methods inside the class
	private class BodyIterator implements Iterator<Node> {
		private List<Node> _tags;
		private int _tagCount;
		
		BodyIterator(Body body){
			_tags = body.subTags;
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
		 return new BodyIterator(this); 
	 }
	 
	 // search function
	 public String attributeSearch(String attrName, String value) {
			StringBuilder str = new StringBuilder();
			for (Map.Entry<String, String> entry : BodyAttributes.entrySet()) {
				if (entry.getKey().equals(attrName) && entry.getValue().equals(value)) {
					str.append(this.textualRepresentation());
				}
			}
			return str.toString();
	}
}
