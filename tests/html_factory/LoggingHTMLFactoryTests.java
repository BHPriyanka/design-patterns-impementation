package html_factory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import html.B;
import html.Body;
import html.Div;
import html.HTML;
import html.Head;
import html.Node;
import html.Title;

public class LoggingHTMLFactoryTests {

	
	// test case to check the loggingfactory methods
	@Test
	public void testLoggingFactory() {
		LoggingHTMLFactory createLogFactory = new LoggingHTMLFactory();
		Map<String, String> divAtts = new HashMap<String, String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div3 = createLogFactory.makeDiv(divAtts, "b2");
		
		Map<String, String> noAttributes = new HashMap<String, String>();
		B b2 = createLogFactory.makeB(noAttributes, div3);
		
		Title title2 = createLogFactory.makeTitle(noAttributes, "Example2");
		Head head2 = createLogFactory.makeHead(noAttributes, title2);
		
		Map<String, String> divAtts1 = new HashMap<String, String>();
		divAtts1.put("id", "first");
		divAtts1.put("class", "foo");
		Div div1 = new Div(divAtts1, "a");

		Map<String, String> divAtts2 = new HashMap<String, String>();
		divAtts2.put("id", "third");
		divAtts2.put("class", "foo");
		Div div2 = new Div(divAtts2, "c");

		List<Node> subtree = new ArrayList<Node>();
		subtree.add(div1);
		subtree.add(div2);

		List<Node> subtree4 = new ArrayList<Node>();
		subtree4.add(div1);
		subtree4.add(b2);
		subtree4.add(div2);
		
		Body body2 = createLogFactory.makeBody(noAttributes, subtree4);
		List<Node> subtree3 = new ArrayList<Node>();
		subtree3.add(head2);
		subtree3.add(body2);
		HTML html2 = createLogFactory.makeHTML(noAttributes, subtree3);
		
		assertEquals(html2.textualRepresentation().equals("<html><head><title>Example2</title><title>Example2</title></head><head><title>Example2</title><title>Example2</title><title>Example2</title></head><body><div id=first class=foo>a</div><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><div id=third class=foo>c</div></body><body><div id=first class=foo>a</div><div id=first class=foo>a</div><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><div id=third class=foo>c</div><div id=third class=foo>c</div></body></html><html><head><title>Example2</title><title>Example2</title></head><head><title>Example2</title><title>Example2</title><title>Example2</title></head><head><title>Example2</title><title>Example2</title><title>Example2</title><title>Example2</title></head><body><div id=first class=foo>a</div><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><div id=third class=foo>c</div></body><body><div id=first class=foo>a</div><div id=first class=foo>a</div><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><div id=third class=foo>c</div><div id=third class=foo>c</div></body><body><div id=first class=foo>a</div><div id=first class=foo>a</div><div id=first class=foo>a</div><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><b><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div><div id=second class=bar>b2</div></b><div id=third class=foo>c</div><div id=third class=foo>c</div><div id=third class=foo>c</div></body></html>"),true);
	}

}
