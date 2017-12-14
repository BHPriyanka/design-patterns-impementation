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

// abstract class factory declaring all the methods
public abstract class AbstractHTMLNodeFactory {
	
	abstract Div makeDiv(Map<String,String> attattributesrMap, String str);
	abstract B makeB(Map<String,String> attributes, Div div);
	abstract Body makeBody(Map<String,String> attributes, List<Node> nodeList);
	abstract Title makeTitle(Map<String,String> attributes, String str);
	abstract Head makeHead(Map<String,String> attributes, Title title);
	abstract HTML makeHTML(Map<String,String> attributes, List<Node> nodeList);

}
