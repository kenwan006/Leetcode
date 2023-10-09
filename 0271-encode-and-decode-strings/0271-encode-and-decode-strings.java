public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        //use word length + a divider '#' to seperate the words from each other
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n) {
            int j = i; //find the length of a string
            while (j < n && s.charAt(j) != '#') j++;
            int len = Integer.parseInt(s.substring(i, j));
            i = j + 1 + len; //next start
            res.add(s.substring(j + 1, i));
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));