package gfg;

import java.util.Arrays;
import java.util.Stack;

public class ReverseSentenceWords {
    public static void main(String[] args) {
        String s = "Hey.I.love.you.so";
        String rs = reverseWords(s);
        System.out.println(rs);
    }

    private static String reverseWords(String S) {
        Stack<String> wordStack = new Stack<>();
        Arrays.stream(S.split("\\.")).forEach(w -> wordStack.push(w));
        StringBuilder sb = new StringBuilder();
        while (wordStack.size() > 0) {
            String word = wordStack.pop();
            sb.append(word);
            if (wordStack.size() > 0) sb.append(".");
        }
        return sb.toString();
    }
}
