class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        /*
            Encoding steps
            1.) natural inclination will be to use a delimiter but the tricky part comes when we can be given
                strings that contain our delimiter, posing a problem during decoding.
            2.) Another natural inclination will be to preface the string with a number to dictate the number of characters
                present in the string ahead. Again this presents a problem if the string began with a number character
            3.) We will then combine both number and delimiter to tell us the number of characters forming the string AFTER
                the delimiter. The delimiter signals the start of the string.

                Approach is coined as chunk transfer.
            
            For simplistic purposes, we will be using # as our delimiter

        */
        std::string encoded = "";
        for (std::string s:strs){
            encoded += std::to_string(s.size()) + "#" + s;
        }
        return encoded;
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        /*
            Since it is guaranteed for any valid string that the first character is the string num followed by delimter,
            We can loop char by char and make sure to end each iteration at the string length of the next string.
        */
        std::vector<std::string>decoded;
        std::string length = "";
        std::string str = "";
        int i {0};
        while (i < s.size()) {
            while (s[i] != '#'){
                length += s[i];
                ++i;
            }
            ++i;
            for (int j=0; j<std::stoi(length); j++) {
                str += s[i];
                ++i;
            }
            decoded.push_back(str);
            str = "";
            length = "";
            
        }
        return decoded;
        
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));