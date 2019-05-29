package com.jlj.pmd.azlist;



import com.jlj.pmd.selectcountry.Country;

import java.util.Comparator;

public class LettersComparator implements Comparator<AZItemEntity<Country>> {

	public int compare(AZItemEntity<Country> o1, AZItemEntity<Country> o2) {
		if (o1.getSortLetters().equals("@")
			|| o2.getSortLetters().equals("#")) {
			return 1;
		} else if (o1.getSortLetters().equals("#")
				   || o2.getSortLetters().equals("@")) {
			return -1;
		} else {
			return o1.getSortLetters().compareTo(o2.getSortLetters());
		}
	}

}
