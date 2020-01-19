package com.fjr.base.sintaxhighlighter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.Segment;

import com.fjr.base.sintaxhighlighter.brush.Brush;
import com.fjr.base.sintaxhighlighter.brush.RegExpRule;

public class Parser {
	public List<ParseResult> parse(Brush brush, String Content) {
		List<ParseResult > result = new ArrayList<>();
		List<RegExpRule> listRule = brush.getRegExpRuleList(); 
		for(RegExpRule rule : listRule) {
			parse(result, rule, Content.toCharArray(), 0, Content.length());
		}		
		return result;
	}
	
	public void parse(List<ParseResult> list, RegExpRule rule, char[] content, int offset, int length) {
		Pattern p  = rule.getPattern(); 
		Matcher matcher = p.matcher(new  Segment(content, offset, length)); 
		String keyWord  = (String) rule.getGroupOperations().get(0);
//		System.out.println(keyWord);
		while(matcher.find()) {
			int start = matcher.start(), end = matcher.end();
			check(list, start , end ); 
			ParseResult parsed = new ParseResult(); 
			parsed.setOffset(start); 
			parsed.setLength(end - start); 
			parsed.setType(keyWord);  
			
			if( !isContained(list, parsed)) {
				list.add(parsed); 
			}
		}
	}
	
	public boolean isContained(List<ParseResult> list ,  ParseResult p) {
		for( ParseResult p1 : list) {
			int _start = p1.getOffset(), _end = _start + p1.getLength();
			int start = p.getOffset(), end = start + p.getLength(); 
			if( start>= _start && end <=_end) {
				return true;
			}
		}
		return false;
	}
	
	public void check(List<ParseResult> result, int start, int end) {
		ListIterator<ParseResult> iterator = result.listIterator();

		while (iterator.hasNext()) {
			ParseResult parseResult = iterator.next(); 
			int _start = parseResult.getOffset(), _end = start + parseResult.getLength(); 
			if(_start >= end ||  _end <= start ) {
				continue; 
			}
			if(_start >= start && _end <= end) {
				iterator.remove(); 
			}else if(_end <= end) {
				ParseResult p1 = new ParseResult(); 
				p1.setOffset(_start); 
				p1.setLength(start - _start);
				p1.setType(parseResult.getType());
			}else if( _start >= start) {
				ParseResult p1 = new ParseResult(); 
				p1.setOffset(end); 
				p1.setLength(_end - end);
				p1.setType(parseResult.getType());
			}
		}
	}
	
}
