public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) { //use lengthOfString + "/" to delimit each string
            encoded.append(s.length()).append("/").append(s);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int del = s.indexOf('/', start);
            int len = Integer.parseInt(s.substring(start, del));
            start = del + len + 1; //next start
            String str = s.substring(del + 1, start);
            decoded.add(str);
           
        }
        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));