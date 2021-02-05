package cn.az.code.year2021.feb;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author ycpang
 * @since 2021-02-05 17:03
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if ("..".equals(dir) && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.insert(0, dir).insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
