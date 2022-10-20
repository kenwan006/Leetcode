public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append('/').append(s); // every section composed of 'lengthOfString' + '/' + this string
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int del = s.indexOf('/', start);
            int length = Integer.parseInt(s.substring(start, del)); // eg, "10/aaaaaaaaaa" start at index = 0 and '/' at 2, 10 is in between
            start = del + length + 1; //start index for next string
            decoded.add(s.substring(del + 1, start));
        }
        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

//Time: O(n); Space: O(1) for encode, O(n) for decode;