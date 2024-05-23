public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoder = new StringBuilder();
        for (String s : strs) {
            encoder.append(s.length()).append('#').append(s);
        }
        return encoder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n) {
            //find the j - s[i..j) is the length of next string
            int j = i;
            while (j < n && s.charAt(j) != '#') j++;
            int len = Integer.parseInt(s.substring(i, j));
            i = j + 1;
            list.add(s.substring(i, i + len));
            i = i + len;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));