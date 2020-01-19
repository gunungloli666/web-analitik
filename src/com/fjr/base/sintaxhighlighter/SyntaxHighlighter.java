package com.fjr.base.sintaxhighlighter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.fjr.base.sintaxhighlighter.brush.Brush;
import com.fjr.base.sintaxhighlighter.brush.BrushJava;


public class SyntaxHighlighter {
	
	
	Parser parser ;
	Brush brush;
	public SyntaxHighlighter() {
		 parser = new Parser();
		 brush = new BrushJava(); 
	}
	
	
	public String highlight( String input) {
		StringBuilder builder = new StringBuilder(); 
		List<ParseResult> parsedList =  parser.parse(brush, input);
		Collections.sort(parsedList , new Comparator<ParseResult>() {
			@Override
			public int compare(ParseResult o1, ParseResult o2) {
				Integer a = o1.getOffset(); 
				Integer b = o2.getOffset(); 
				return a.compareTo(b);
			}
		});
		int index = 0; 
		for( ParseResult p : parsedList) {
			String tipe = p.getType(); 
			int offset = p.getOffset();
			int length = p.getLength(); 
			if(offset > index ) {
				builder.append(input.substring(index, offset).replace("<", "&lt;"));
//				builder.append(input.substring(index, offset).toString().replace("<", "&lt;"));
			}
			String  c = input.substring(offset  , offset + length).replace("<", "&lt;"); 
			if (tipe.equals("keyword")) {
				builder.append("<span style=\"color:#101094; font-weight:bold;\">").append(c).append("</span>");
			} else if (tipe.equals("string")) {
				builder.append("<span style=\"color:#7D2727;\">").append(c).append("</span>");
			}else if(tipe.equals("value")) {
				builder.append("<span style=\"color:#2B91AF;\">").
				append(c).append( "</span>") ;
			}else if(tipe.equals("comments")) {
				builder.append("<span style=\"color:#3f7f59;\">").
				append(c).append( "</span>") ;
			}
			else {
				builder.append(c);
			}
			index = offset + length;
		}
		if(input.length() > index) {
			builder.append(input.substring(index, input.length()).replace("<", "&lt;")); 
		}
		return builder.toString().replaceAll("\\t", "  "); 
	}
	
}
