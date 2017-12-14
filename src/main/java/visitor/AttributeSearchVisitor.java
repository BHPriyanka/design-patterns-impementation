package main.java.visitor;

import html.B;
import html.Body;
import html.Div;
import html.HTML;
import html.Head;
import html.Node;
import html.Title;
import main.java.adapter.StringSet;
import main.java.iterators.Iterator;

public class AttributeSearchVisitor implements NodeVisitor {

	private StringSet strSet = new StringSet();
	private String attrName;
	private String value;

	public AttributeSearchVisitor(String attrName, String value) {
		this.attrName = attrName;
		this.value = value;
	}

	@Override
	public void visitDiv(Div d) {
		String str = d.attributeSearch(attrName, value);
		System.out.println(str);
		strSet.add(str);
		// Iterator<Node> it = d.iterator();
		// while (it.hasAnotherElement()) {
		// Node n = it.nextElement();
		// if (n instanceof B) {
		// visitB((B) n);
		// } else if (n instanceof Body) {
		// visitBody((Body) n);
		// } else if (n instanceof Div) {
		// visitDiv((Div) n);
		// } else if (n instanceof Head) {
		// visitHead((Head) n);
		// } else if (n instanceof Title) {
		// visitTitle((Title) n);
		// } else {
		// System.out.println(n.getClass());
		// }
		// }
	}

	@Override
	public void visitB(B b) {
		String str = b.attributeSearch(attrName, value);
		System.out.println(str);
		strSet.add(str);
		if (b.getDiv() instanceof Div) {
			visitDiv((Div) b.getDiv());
		}
		// Iterator<Node> it = b.iterator();
		// while (it.hasAnotherElement()) {
		// Node n = it.nextElement();
		// if (n instanceof B) {
		// visitB((B) n);
		// } else if (n instanceof Body) {
		// visitBody((Body) n);
		// } else if (n instanceof Div) {
		// visitDiv((Div) n);
		// } else if (n instanceof Head) {
		// visitHead((Head) n);
		// } else if (n instanceof Title) {
		// visitTitle((Title) n);
		// } else {
		// System.out.println(n.getClass());
		// }
		// }
	}

	@Override
	public void visitBody(Body b) {
		String str = b.attributeSearch(attrName, value);
		System.out.println(str);
		strSet.add(str);
		Iterator<Node> it = b.iterator();
		while (it.hasAnotherElement()) {
			Node n = it.nextElement();
			if (n instanceof B) {
				visitB((B) n);
			} else if (n instanceof Body) {
				visitBody((Body) n);
			} else if (n instanceof Div) {
				visitDiv((Div) n);
			} else if (n instanceof Head) {
				visitHead((Head) n);
			} else if (n instanceof Title) {
				visitTitle((Title) n);
			}
		}
	}

	@Override
	public void visitTitle(Title t) {
		String str = t.attributeSearch(attrName, value);
		System.out.println(str);
		strSet.add(str);
		// Iterator<Node> it = t.iterator();
		// while (it.hasAnotherElement()) {
		// Node n = it.nextElement();
		// if (n instanceof B) {
		// visitB((B) n);
		// } else if (n instanceof Body) {
		// visitBody((Body) n);
		// } else if (n instanceof Div) {
		// visitDiv((Div) n);
		// } else if (n instanceof Head) {
		// visitHead((Head) n);
		// } else if (n instanceof Title) {
		// visitTitle((Title) n);
		// } else {
		// System.out.println(n.getClass());
		// }
		// }
	}

	@Override
	public void visitHead(Head h) {
		String str = h.attributeSearch(attrName, value);
		System.out.println(str);
		strSet.add(str);
		if (h.getTitle() instanceof Title) {
			visitTitle((Title) h.getTitle());
		}
		// Iterator<Node> it = h.iterator();
		// while (it.hasAnotherElement()) {
		// Node n = it.nextElement();
		// if (n instanceof B) {
		// visitB((B) n);
		// } else if (n instanceof Body) {
		// visitBody((Body) n);
		// } else if (n instanceof Div) {
		// visitDiv((Div) n);
		// } else if (n instanceof Head) {
		// visitHead((Head) n);
		// } else if (n instanceof Title) {
		// visitTitle((Title) n);
		// } else {
		// System.out.println(n.getClass());
		// }
		// }
	}

	@Override
	public void visitHTML(HTML h) {
		String str = h.attributeSearch(attrName, value);
		System.out.println(str);
		strSet.add(str);
		Iterator<Node> it = h.iterator();
		while (it.hasAnotherElement()) {
			Node n = it.nextElement();
			if (n instanceof B) {
				visitB((B) n);
			} else if (n instanceof Body) {
				visitBody((Body) n);
			} else if (n instanceof Div) {
				visitDiv((Div) n);
			} else if (n instanceof Head) {
				visitHead((Head) n);
			} else if (n instanceof Title) {
				visitTitle((Title) n);
			} else {
				System.out.println(n.getClass());
			}
		}
	}

	public void report() {
		System.out.println("strSet:   " + strSet.toString() + ".... " + strSet.size());
	}
}


