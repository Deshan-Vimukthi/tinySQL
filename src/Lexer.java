import java.util.*;

public class Lexer {

    public enum TokenType {
        STRING,
        PUNCTUATION
    }

    public static class Token{
        private TokenType type;
        private String value;

        public Token(TokenType type, String value ) {
            this.type = type;
            this.value = value;
        }

        public TokenType getType() {
            return type;
        }

        public String getValue() {
            return value;
        }
    }

    public final static Set<String> KEYWORDS = Set.of(
            "CREATE","TABLE","ALTER","DROP","INSERT","UPDATE","DELETE","SELECT","FROM","WHERE","ORDER","BY","NULLABLE",
            "FK","AS","UNIQUE","PRIMARY","CURRENT_TIME","CURRENT_DATE","CURRENT_TIMESTAMP","DEFAULT","SEARCHABLE"
    );

    public static List<Token> parse(String line) {
        int index = 0;
        boolean isString = false;
        StringBuilder value = new StringBuilder();
        Stack<Character> parenthesis = new Stack<>();
        Stack<Character> quotationMark = new Stack<>();
        List<Token> tokens = new ArrayList<>();

        while(index < line.length()) {
            char c = line.charAt(index);
            if(isString) {
                if(c == quotationMark.peek()){
                    isString = false;
                    tokens.add(new Token(TokenType.STRING, value.toString()));
                    quotationMark.pop();
                    continue;
                } else if (c == '\\') {
                    index++;
                    c = line.charAt(index);
                    if(c == '\\'){
                        while (c != '\n' && c != '\r'){
                            index++;
                            c = line.charAt(index);
                        }
                    }
                    if(c=='*'){
                        boolean isComment = true;
                        while(isComment){
                            index++;
                            c = line.charAt(index);
                            if(c == '*'){
                                index++;
                                c = line.charAt(index);
                                if(c == '/'){
                                    isComment = false;
                                }
                            }
                        }
                    }
                    continue;
                }
                value.append(c);
                index++;
                continue;
            }else if(c == '\"' || c == '\'') {
                isString = true;
                quotationMark.push(c);
                continue;
            }


        }

        return tokens;
    }
}
