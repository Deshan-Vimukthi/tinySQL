import java.util.List;

public class Tester {
    public static void main(String[] args) {
        String builder = "CREATE TABLE IF NOT EXISTS (" +
                "`name` VARCHAR(255) NOT NULL, ";
        List<Lexer.Token> tokens = Lexer.parse(builder);
        System.out.println(tokens);
    }
}
