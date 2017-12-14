package main.java.visitor;

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

public class HTMLVisitorTests {

	// test case to test the NodeCountVisitor class, and NodeVisitor interface
	// and count the number of each kind of nodes
	@Test 
	public void testVisitor(){
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		B b = new B(noAttributes, div);
		
		Map<String,String> divAtts1 = new HashMap<String,String>();
		divAtts1.put("id", "first");
		divAtts1.put("class", "foo");
		Div div1 = new Div(divAtts1, "a");
		
		Map<String,String> divAtts2 = new HashMap<String,String>();
		divAtts2.put("id", "third");
		divAtts2.put("class", "foo");
		Div div2 = new Div(divAtts2, "c");
		
		List<Node> subtree = new ArrayList<Node>();
		subtree.add(div1);
		subtree.add(b);
		subtree.add(div2);
		
		Body body  = new Body(noAttributes, subtree);
				
		Title t = new Title(noAttributes, "Example");
		Head h = new Head(noAttributes, t);
		
		List<Node> subtree2 = new ArrayList<Node>();
		subtree2.add(h);
		subtree2.add(body);
		
		HTML html  = new HTML(noAttributes, subtree2);
		NodeCountVisitor cnt = new NodeCountVisitor();
		html.accept(cnt);
		System.out.println(cnt.getBCount());
		System.out.println(cnt.getBodyCount());
		System.out.println(cnt.getDivCount());
		System.out.println(cnt.getHeadCount());
		System.out.println(cnt.getTitleCount());
		assertEquals(cnt.getBCount(), 1);
		assertEquals(cnt.getBodyCount(), 1);
		assertEquals(cnt.getDivCount(), 3);
		assertEquals(cnt.getHeadCount(), 1);
		assertEquals(cnt.getHTMLCount(), 1);
		assertEquals(cnt.getTitleCount(), 1);
	}
	
	@Test
	public void test2(){
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		B b = new B(noAttributes, div);
		
		Map<String,String> divAtts1 = new HashMap<String,String>();
		divAtts1.put("id", "first");
		divAtts1.put("class", "foo");
		Div div1 = new Div(divAtts1, "a");
		
		Map<String,String> divAtts2 = new HashMap<String,String>();
		divAtts2.put("id", "third");
		divAtts2.put("class", "foo");
		Div div2 = new Div(divAtts2, "c");
		
		List<Node> subtree = new ArrayList<Node>();
		subtree.add(div1);
		subtree.add(b);
		subtree.add(div2);
		
		Body body  = new Body(noAttributes, subtree);
				
		Title t = new Title(noAttributes, "Example");
		Head h = new Head(noAttributes, t);
		
		List<Node> subtree2 = new ArrayList<Node>();
		subtree2.add(h);
		subtree2.add(body);
		
		HTML html  = new HTML(noAttributes, subtree2);
		AttributeSearchVisitor cnt = new AttributeSearchVisitor("foo", "class");
		html.accept(cnt);
		//System.out.println(x);
	}
}
