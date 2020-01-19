// Copyright (c) 2011 Chan Wai Shing
//
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
package com.fjr.base.sintaxhighlighter.brush;

import java.util.ArrayList;
import java.util.List;


public class Brush {

  /**
   * Regular expression rules list. It will be executed in sequence.
   */
  protected List<RegExpRule> regExpRuleList;
  /**
   * The list of common file extension for this language. It is no use so far, 
   * just for reference.
   */
  protected List<String> commonFileExtensionList;


  /**
   * Constructor.
   */
  public Brush() {
    regExpRuleList = new ArrayList<RegExpRule>();
    commonFileExtensionList = new ArrayList<String>();
  }

  /**
   * Get the regular expression rule list.
   * @return a copy of the list
   */
  public List<RegExpRule> getRegExpRuleList() {
    return new ArrayList<RegExpRule>(regExpRuleList);
  }

	protected static String getKeywords(String str) {
		if (str == null) {
			throw new NullPointerException("argument 'str' cannot be null");
		}
		return "\\b(?:" + str.replaceAll("^\\s+|\\s+$", "").replaceAll("\\s+", "|") + ")\\b";
	}
  
  /**
   * Set the regular expression rule list.
   * @param regExpRuleList the list
   */
  public void setRegExpRuleList(List<RegExpRule> regExpRuleList) {
    if (regExpRuleList == null) {
      this.regExpRuleList = new ArrayList<RegExpRule>();
      return;
    }
    this.regExpRuleList = new ArrayList<RegExpRule>(regExpRuleList);
  }

}
