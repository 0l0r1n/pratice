/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
public class GroupAnagrams {
    
    public List<List<String>> group(String[] strs) {
      HashMap<String, List<String>> m = new HashMap<String, List<String>>();
      for (String s : strs) {
          char[] chars = s.toCharArray();
          Arrays.sort(chars);
          String sortedString = String.valueOf(chars);
          if (m.containsKey(sortedString)) m.get(sortedString).add(s);
          else { 
              m.put(sortedString, new ArrayList());
              m.get(sortedString).add(s);
          }
      }
      return new ArrayList(m.values());
    }
}