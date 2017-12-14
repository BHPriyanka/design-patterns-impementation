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

public class LoggingHTMLFactory extends AbstractHTMLNodeFactory {

	//method to create a new instance of Div class and call its corresponsing textualRepresentation method
	@Override
	public Div makeDiv(Map<String,String> attributes, String str){
		Div div = new Div(attributes, str);
		System.out.println(div.textualRepresentation());
		return div;
	}

	//method to create a new instance of B class and call its corresponsing textualRepresentation method
	@Override
	public B makeB(Map<String,String> attributes, Div div){
		B b = new B(attributes, div);
		System.out.println(b.textualRepresentation());
		return b;
	}

	//method to create a new instance of Div class and body its corresponsing textualRepresentation method
	@Override
	public Body  makeBody(Map<String,String> attributes, List<Node> nodeList){
		Body body = new Body(attributes, nodeList);
		System.out.println(body.textualRepresentation());
		return body;
	}

	//method to create a new instance of title class and call its corresponsing textualRepresentation method
	@Override
	public Title makeTitle(Map<String,String> attributes, String str){
		Title title = new Title(attributes, str);
		System.out.println(title.textualRepresentation());
		return title;
	}

	//method to create a new instance of head class and call its corresponsing textualRepresentation method
	@Override
	public Head makeHead(Map<String,String> attributes, Title title){
		Head head = new Head(attributes, title);
		System.out.println(head.textualRepresentation());
		return head;
	}

	//method to create a new instance of html class and call its corresponsing textualRepresentation method
	@Override
	public HTML makeHTML(Map<String,String> attributes, List<Node> nodeList){
		HTML html = new HTML(attributes, nodeList);
		System.out.println(html.textualRepresentation());
		return html;
	}		
}


