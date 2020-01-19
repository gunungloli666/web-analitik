package com.fjr.base.sintaxhighlighter;


public class SyntaxDao {
	
	private static SyntaxDao syntaxDao; 
	public static SyntaxDao getInstance() {
		if(syntaxDao == null) {
			syntaxDao = new SyntaxDao();
		}
		return syntaxDao;
	}
	
	SyntaxHighlighter highlighter; 
	
	private SyntaxDao() {
		highlighter = new SyntaxHighlighter();
	}

	public String highlight(String input) {
		return highlighter.highlight(input);
	}
}
