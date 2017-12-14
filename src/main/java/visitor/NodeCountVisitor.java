package main.java.visitor;

import html.B;
import html.Body;
import html.Div;
import html.HTML;
import html.Head;
import html.Node;
import html.Title;
import main.java.iterators.Iterator;

// counts the number of times each type of node occurs in a document.
public class NodeCountVisitor implements NodeVisitor{

	// constructor initializing all the counts to 0
	public NodeCountVisitor(){
		_totalB = 0;
		_totalDiv = 0;
		_totalTitle = 0;
		_totalHTML = 0;
		_totalBody = 0;
		_totalHead = 0;
	}

	// visitHTML method to iteratively visit the html document using iterator
	@Override
	public void visitHTML(HTML html){
		_totalHTML++;

		Iterator<Node> it = html.iterator();  
		while(it.hasAnotherElement()){
			Node n = it.nextElement();
			if(n instanceof B){
				visitB((B) n);
			} else if(n instanceof Body){
				visitBody((Body) n);
			} else if(n instanceof Div){
				visitDiv((Div) n);
			} else if(n instanceof Head){
				visitHead((Head) n);
			} else if(n instanceof Title){
				visitTitle((Title) n);
			} 
		}
	}

	// visitHead method to iteratively visit the head tag using iterator
	@Override
	public void visitHead(Head h){
		_totalHead++;
		
	/*	Iterator<Node> it = h.iterator();  
		while(it.hasAnotherElement()){
			Node n = it.nextElement();
			if(n instanceof B){
				visitB((B) n);
			} else if(n instanceof Body){
				visitBody((Body) n);
			} else if(n instanceof Div){
				visitDiv((Div) n);
			} else if(n instanceof Head){
				visitHead((Head) n);
			} else if(n instanceof Title){
				visitTitle((Title) n);
			} 
		}*/
		
		if(h.getTitle() instanceof Title){
			visitTitle((Title) h.getTitle());
		}
	}

	// visitBody method to iteratively visit the body tag using iterator
	@Override
	public void visitBody(Body b){
		_totalBody++;
		
		Iterator<Node> it = b.iterator();  
		while(it.hasAnotherElement()){
			Node n = it.nextElement();
			if(n instanceof B){
				visitB((B) n);
			} else if(n instanceof Body){
				visitBody((Body) n);
			} else if(n instanceof Div){
				visitDiv((Div) n);
			} else if(n instanceof Head){
				visitHead((Head) n);
			} else if(n instanceof Title){
				visitTitle((Title) n);
			} 
		}
	}

	// visitTitle method to iteratively visit the body tag using iterator
	@Override
	public void visitTitle(Title t){
		_totalTitle++;
		
		/*Iterator<Node> it = t.iterator();  
		while(it.hasAnotherElement()){
			Node n = it.nextElement();
			if(n instanceof B){
				visitB((B) n);
			} else if(n instanceof Body){
				visitBody((Body) n);
			} else if(n instanceof Div){
				visitDiv((Div) n);
			} else if(n instanceof Head){
				visitHead((Head) n);
			} else if(n instanceof Title){
				visitTitle((Title) n);
			} 
		}*/
	}

	// visitDiv method to iteratively visit the div tag using iterator
	@Override
	public void visitDiv(Div d){
		_totalDiv++;
		
		/*Iterator<Node> it = d.iterator();  
		while(it.hasAnotherElement()){
			Node n = it.nextElement();
			if(n instanceof B){
				visitB((B) n);
			} else if(n instanceof Body){
				visitBody((Body) n);
			} else if(n instanceof Div){
				visitDiv((Div) n);
			} else if(n instanceof Head){
				visitHead((Head) n);
			} else if(n instanceof Title){
				visitTitle((Title) n);
			} 
		}*/
		
	}

	// visitDiv method to iteratively visit the b tag using iterator
	@Override
	public void visitB(B b){
		_totalB++;
		
		/*Iterator<Node> it = b.iterator();  
		while(it.hasAnotherElement()){
			Node n = it.nextElement();
			if(n instanceof B){
				visitB((B) n);
			} else if(n instanceof Body){
				visitBody((Body) n);
			} else if(n instanceof Div){
				visitDiv((Div) n);
			} else if(n instanceof Head){
				visitHead((Head) n);
			} else if(n instanceof Title){
				visitTitle((Title) n);
			} 
		}*/
		if(b.getDiv() instanceof Div){
			visitDiv((Div) b.getDiv());
		}
	}

	int _totalB;
	int _totalDiv;
	int _totalTitle;
	int _totalHTML;
	int _totalBody;
	int _totalHead;

	public int getBCount(){
		return _totalB;
	}
	
	public int getDivCount(){
		return _totalDiv;
	}
	
	public int getTitleCount(){
		return _totalTitle;
	}
	
	public int getHTMLCount(){
		return _totalHTML;
	}
	
	public int getBodyCount(){
		return _totalBody;
	}
	
	public int getHeadCount(){
		return _totalHead;
	}
}
