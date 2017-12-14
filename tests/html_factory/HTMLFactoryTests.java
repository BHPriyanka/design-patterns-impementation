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

public class HTMLFactoryTests {

	// test case to validate all the methods of standardHTMLNodeFactory
	@Test
	public void teststandaraHTMLFactory1() {
		StandardHTMLNodeFactory sFactory = new StandardHTMLNodeFactory();

		Map<String, String> divAtts = new HashMap<String, String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div3 = sFactory.makeDiv(divAtts, "b");

		Map<String, String> noAttributes = new HashMap<String, String>();
		B b2 = sFactory.makeB(noAttributes, div3);
		
		Title title = sFactory.makeTitle(noAttributes, "Example");
		
		Head head = sFactory.makeHead(noAttributes, title);

		Map<String, String> divAtts1 = new HashMap<String, String>();
		divAtts1.put("id", "first");
		divAtts1.put("class", "foo");
		Div div1 = new Div(divAtts1, "a");

		Map<String, String> divAtts2 = new HashMap<String, String>();
		divAtts2.put("id", "third");
		divAtts2.put("class", "foo");
		Div div2 = new Div(divAtts2, "c");

		List<Node> subtree1 = new ArrayList<Node>();
		subtree1.add(div1);
		subtree1.add(b2);
		subtree1.add(div2);

		Body body = sFactory.makeBody(noAttributes, subtree1);

		List<Node> subtree2 = new ArrayList<Node>();
		subtree2.add(head);
		subtree2.add(body);

		HTML html = sFactory.makeHTML(noAttributes, subtree2);
		assertEquals(html.textualRepresentation().equals("<html><head><title>Example</title></head><body><div id=first class=foo>a</div><b><div id=second class=bar>b</div></b><div id=third class=foo>c</div></body></html>"),true);
	}

}
