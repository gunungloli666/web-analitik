package com.fjr.base.sintaxhighlighter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	class Match{
		private int offset; 
		private int length;
		public int getOffset() {
			return offset;
		}
		public void setOffset(int offset) {
			this.offset = offset;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
	}
	
	String input = "HashMap<Integer, String> map1 = new HashMap<>();";

	ArrayList<Match> listMatch = new ArrayList<>();
	public RegexTest() {
		Pattern p= Pattern.compile("\\<|\\>");
		Matcher m = p.matcher(input);
		System.out.println(input.length()); 
		while(m.find()) {
//			System.out.println(m.start()+"|" + m.end());
			int start = m.start(); 
			int length = m.end() - m.start(); 
			Match match = new Match(); 
			match.setLength(length);
			match.setOffset(start);
			
			listMatch.add(match); 
		}
		
		int index = 0; 
		StringBuilder builder = new StringBuilder(); 
		for(Match match: listMatch) {
			int start  = match.getOffset(); 
			int length = match.getLength(); 
			if(start > index) {
				builder.append(input.subSequence(index, start));
			}
			builder.append("%").append(input.subSequence(start, start+length)).append("%"); 
			index = start + length;
		}
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args) {
		
		new RegexTest();
	}

}
