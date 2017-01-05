package T030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {

		System.out.println(findSubstring_worse("aaaaaaaa",new String[]{"aa","aa","aa"}));
		
	}
	
	//以下代码较为复杂，但效率很高
	public static List<Integer> findSubstring_best(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
        if(words == null || words.length == 0 || s.length() == 0) return res;
        int wordLen = words[0].length();
        int numWord = words.length;
        int windowLen = wordLen * numWord;
        int sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
        	//System.out.println(map.getOrDefault(word, 0));
        	map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i < wordLen; i++) {  // Run wordLen scans
            HashMap<String, Integer> curMap = new HashMap<>();
            for(int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {  // Move window in step of wordLen
                // count: number of exceeded occurences in current window
                // start: start index of current window of size windowLen
                if(start + windowLen > sLen) break;
                String word = s.substring(j, j + wordLen);
                if(!map.containsKey(word)) {
                    curMap.clear();
                    count = 0;
                    start = j + wordLen;
                }
                else {
                    if(j == start + windowLen) { // Remove previous word of current window
                        String preWord = s.substring(start, start + wordLen);
                        start += wordLen;
                        int val = curMap.get(preWord);
                        if(val == 1) curMap.remove(preWord);
                        else curMap.put(preWord, val - 1);
                        if(val - 1 >= map.get(preWord)) count--;  // Reduce count of exceeded word
                    }
                    // Add new word
                    curMap.put(word, curMap.getOrDefault(word, 0) + 1);
                    if(curMap.get(word) > map.get(word)) count++;  // More than expected, increase count
                    // Check if current window valid
                    if(count == 0 && start + windowLen == j + wordLen) {
                        res.add(start);
                    }
                }
            }
        }
        return res;
    }
	//以下代码较为简单，但效率较低
	public static List<Integer> findSubstring_worse(String s, String[] words) {
		int n = words.length, m = words[0].length();
    	List<Integer> res = new ArrayList();
        /*Store string array with hashtable.*/
        HashMap<String, Integer> map = new HashMap();
        for (String str : words) {
        	if (map.containsKey(str)) map.put(str, map.get(str)+1);
        	else map.put(str, 1);
        }
        //System.out.println(map);
        /*m is the length of each word in array words, each time get a substring of length m to check if it exits in words*/
        for (int i = 0; i <= s.length()-n*m; i++) {
            HashMap<String, Integer> copy = new HashMap(map);
        	/*if it exits, use another hashset to avoid duplicate and count the number to reach n, the number of words in array words*/
        	int k = n, j = i;
        	while (k > 0) {
        		String str = s.substring(j, j+m);
        		if (!copy.containsKey(str) || copy.get(str) < 1) break;
        		copy.put(str, copy.get(str)-1);
        		k--; j+=m;
        	}
        	if (k == 0) res.add(i);
        }
        return res;
	}
	
	
}
