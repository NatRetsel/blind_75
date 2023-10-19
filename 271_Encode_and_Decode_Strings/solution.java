public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String encode = "";
        int length;
        for (int i =0; i < strs.size(); i++) {
            length = strs.get(i).length();
            encode += Integer.toString(length) + "#" + strs.get(i);
        }
        return encode;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String length;
        String decode;
        int i = 0;
        List<String> result = new ArrayList<String>();
        while (i < s.length()){
            length = "";
            decode = "";
            while (s.charAt(i) != '#') {
                length += s.charAt(i);
                i++;
            }
            i++;
            
            for (int j=0; j < Integer.parseInt(length); j++) {
                decode += s.charAt(i);
                i++;
            }
            
            result.add(decode);
            
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
