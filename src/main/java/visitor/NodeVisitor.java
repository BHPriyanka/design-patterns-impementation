package main.java.visitor;

import html.B;
import html.Body;
import html.Div;
import html.HTML;
import html.Head;
import html.Title;

// NodeVisitor interface declaring all the visit methods of all node subclasses
public interface NodeVisitor {
	  void visitHTML(HTML h);  
	  void visitHead(Head h);  
	  void visitBody(Body b); 
	  void visitTitle(Title t);  
	  void visitDiv(Div d);  
	  void visitB(B b); 
}
