package codes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class SafCom {
    public static final int MAX = Integer.MAX_VALUE;
    public static final int MIN = 0;
    private static final Pattern NUMBER = Pattern.compile("\\d+");
    private static final Stack<Integer> stack = new Stack<>();
    private static final Map<String,Runnable> ACTION;
    static {
        ACTION = new HashMap<>();
        ACTION.put("POP", SafCom::pop);
        ACTION.put("DUP", SafCom::dup);
        ACTION.put("+", SafCom::add);
        ACTION.put("-", SafCom::sub);
    }

    public static void main(String[] args) {
        String s = "13 DUP 4 POP 5 DUP + DUP + -";
        String s2 = "5 6 + -";
        SafCom saf = new SafCom();
        System.out.println(saf.solution(s));
    }



    public int solution(String S) {
        try {
            Arrays.stream(S.split(" ")).forEach(this::executeCmd);
            return pop();
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    private void executeCmd(String s) {
        if (NUMBER.matcher(s).matches()) {
            push(Integer.parseInt(s));
        } else {
            ACTION.get(s).run();
        }
    }

    private static void push(int i) {
        inRange(i);
        stack.push(i);
    }

    private static int pop() {
        return stack.pop();
    }

    private static void dup() {
        hasElements(1);
        push(stack.peek());
    }

    private static void add() {
        hasElements(2);
        push(stack.pop() + stack.pop());
    }

    private static void sub() {
        hasElements(2);
        push(stack.pop() - stack.pop());
    }

    private static int hasElements(int cnt) {
        if(stack.size() < cnt){
            throw new IllegalArgumentException("Not enough elements available for processing");
        }
        return cnt;
    }

    private static int inRange(int val){
        if(val < MIN || val > MAX){
            throw new IllegalArgumentException("Input under/overflow");
        }
        return val;
    }
}
