package html;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class HMTMLTests {

	// test case to test the Div tag textual representation
	@Test
	public void testDiv() {
		Map<String,String> divAtts = new TreeMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		assertEquals(div.textualRepresentation().equals("<div class=bar id=second>b</div>"), true);
	}

	// test case to test the B tag textual representation
	@Test
	public void testB(){
		Map<String,String> divAtts = new TreeMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new TreeMap<String,String>();
		B b = new B(noAttributes, div);
		assertEquals(b.textualRepresentation().equals("<b><div class=bar id=second>b</div></b>"), true);
	}
	
	// test case to test the title textual representation
	@Test
	public void testTitle(){
		Map<String,String> noAttributes = new TreeMap<String,String>();
		Title t = new Title(noAttributes, "Example");
		assertEquals(t.textualRepresentation().equals("<title>Example</title>"), true);
	}
	
	// test case to check the head textual representation
	@Test
	public void testHead(){
		Map<String,String> noAttributes = new TreeMap<String,String>();
		Title t = new Title(noAttributes, "Example");
		Head h = new Head(noAttributes, t);
		assertEquals(h.textualRepresentation().equals("<head><title>Example</title></head>"), true);
	}
	
	// test cas to check the body textual representation
	@Test
	public void testBody(){
		Map<String,String> divAtts = new TreeMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new TreeMap<String,String>();
		B b = new B(noAttributes, div);
		
		Map<String,String> divAtts1 = new TreeMap<String,String>();
		divAtts1.put("id", "first");
		divAtts1.put("class", "foo");
		Div div1 = new Div(divAtts1, "a");
		
		Map<String,String> divAtts2 = new TreeMap<String,String>();
		divAtts2.put("id", "third");
		divAtts2.put("class", "foo");
		Div div2 = new Div(divAtts2, "c");
		
		List<Node> subtree = new ArrayList<Node>();
		subtree.add(div1);
		subtree.add(b);
		subtree.add(div2);
		
		Body body  = new Body(noAttributes, subtree);
		assertEquals(body.textualRepresentation().equals("<body><div class=foo id=first>a</div><b><div class=bar id=second>b</div></b><div class=foo id=third>c</div></body>"), true);
		
	}
	
	//test case to check the entire html textual representation
	@Test
	public void testHtml(){
		Map<String,String> divAtts = new TreeMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new TreeMap<String,String>();
		B b = new B(noAttributes, div);
		
		Map<String,String> divAtts1 = new TreeMap<String,String>();
		divAtts1.put("id", "first");
		divAtts1.put("class", "foo");
		Div div1 = new Div(divAtts1, "a");
		
		Map<String,String> divAtts2 = new TreeMap<String,String>();
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
		assertEquals(html.textualRepresentation().equals("<html><head><title>Example</title></head><body><div class=foo id=first>a</div><b><div class=bar id=second>b</div></b><div class=foo id=third>c</div></body></html>"), true);
	}
	
	// test case given in assignment document
	 @Test   
	 public void test1(){    
		 Map<String,String> divAtts = new TreeMap<String,String>();    
		 divAtts.put("id", "second");    
		 divAtts.put("class", "bar"); 
	     Div div = new Div(divAtts, "b");   
	     Map<String,String> noAttributes = new TreeMap<String,String>();    
	     B b = new B(noAttributes, div);  
	     assertEquals(b.textualRepresentation(),
	    		 "<b><div class=bar id=second>b</div></b>");  
	 } 
	 
	}
