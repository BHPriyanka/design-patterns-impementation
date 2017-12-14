package html_factory;

import java.util.List;
import java.util.Map;

import html.B;
import html.Body;
import html.Div;
import html.HTML;
import html.Head;
import html.Node;
import html.Title;

public class StandardHTMLNodeFactory extends AbstractHTMLNodeFactory {

	// method to create a new instance of Div class
	@Override
	public Div makeDiv(Map<String,String> attributes, String str){
		return new Div(attributes, str);
	}

	// method to create a new instance of B class
	@Override
	public B makeB(Map<String,String> attributes, Div div){
		B b = new B(attributes, div);
		return b;
	}

	//method to create a new instance of Body class
	@Override
	public Body  makeBody(Map<String,String> attributes, List<Node> nodeList){
		return new Body(attributes, nodeList);
	}

	//method to create a new instance of Title class
	@Override
	public Title makeTitle(Map<String,String> attributes, String str){
		return new Title(attributes, str);
	}

	//method to create a new instance of head class
	@Override
	public Head makeHead(Map<String,String> attributes, Title title){
		return new Head(attributes, title);
	}

	//method to create a new instance of html class
	@Override
	public HTML makeHTML(Map<String,String> attributes, List<Node> nodeList){
		HTML html = new HTML(attributes, nodeList);
		return html;
	}		
}
