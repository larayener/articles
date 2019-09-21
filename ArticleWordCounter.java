import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArticleWordCounter {
	private ArrayList<item> counts = new ArrayList<item>();
	
	
	public int hasMatch(String word) {
		for (int i = 0; i < counts.size(); i++) {
			if (word.equals(counts.get(i).getWord())) {
				return i;
			}
		}
		return -1;
	}
	
	public void wordCount(String filename) {
		File m = new File(filename);
		try {
			Scanner s = new Scanner(m);
		while (s.hasNext()) {
				String f = s.next();
				f = trim(f);
			if (hasMatch(f) >= 0) {
				item i = counts.get(hasMatch(f));
				i.increment();
			}
			else {
				item i = new item(f);
				counts.add(i);
			}
			}
		System.out.println(counts);
		PrintWriter p = new PrintWriter("results.txt");
		for ( item i : counts ) {
			p.println(i.toString());
		}
		p.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Boyle bir dosyayi bulamadik");
		}
	}
	
	public static String trim(String word) {
		int start = 0;
		int end = word.length() - 1;
		while (!Character.isAlphabetic(word.charAt(start))) {
			if (start >= word.length() - 1) {
				break;
			}
			start++;
		}
		while (!Character.isAlphabetic(word.charAt(end))) {
			if (end == 0) {
				break;
			}
			end--;
		}
		if (start >= end) {
			return "";
		}
		return word.substring(start, end + 1);
	}
	
}
