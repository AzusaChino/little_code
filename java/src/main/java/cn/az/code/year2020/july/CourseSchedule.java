package cn.az.code.year2020.july;

import java.util.*;

/**
 * @author az
 * @since 2020-07-18 18:03
 */
public class CourseSchedule {

    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] G = new ArrayList[n];
        int[] degree = new int[n];
        List<Integer> bfs = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            G[i] = new ArrayList<Integer>();
        }
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 0) {
                bfs.add(i);
            }
        }
        for (int i = 0; i < bfs.size(); ++i) {
            for (int j : G[bfs.get(i)]) {
                if (--degree[j] == 0) {
                    bfs.add(j);
                }
            }
        }
        return bfs.size() == n;
    }

    public boolean _canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int ready = prerequisite[0];
            int pre = prerequisite[1];
            if (matrix[pre][ready] == 0) {
                //duplicate case
                inDegree[ready]++;
            }
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

    static class CourseSchedule2 {
        private int N = 0;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] result = new int[numCourses];
            Course[] courses = new Course[numCourses];
            for (int i = 0; i < numCourses; i++) {
                courses[i] = new Course(i);
            }
            for (int[] prerequisite : prerequisites) {
                courses[prerequisite[0]].add(courses[prerequisite[1]]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (isCyclic(courses[i], result)) {
                    return new int[0];
                }
            }
            return result;
        }

        private boolean isCyclic(Course cur, int[] result) {
            if (cur.tested) {
                return false;
            }
            if (cur.visited) {
                return true;
            }
            cur.visited = true;
            for (Course c : cur.pre) {
                if (isCyclic(c, result)) {
                    return true;
                }
            }
            cur.tested = true;
            result[N++] = cur.number;
            return false;
        }

        static class Course {
            boolean visited = false;
            boolean tested = false;
            int number;
            List<Course> pre = new ArrayList<Course>();

            public Course(int i) {
                number = i;
            }

            public void add(Course c) {
                pre.add(c);
            }
        }

        private int[] solveByDFS(List<List<Integer>> adjs) {
            BitSet hasCycle = new BitSet(1);
            BitSet visited = new BitSet(adjs.size());
            BitSet onStack = new BitSet(adjs.size());
            Deque<Integer> order = new ArrayDeque<>();
            for (int i = adjs.size() - 1; i >= 0; i--) {
                if (!visited.get(i) && hasOrder(i, adjs, visited, onStack, order)) {
                    return new int[0];
                }
            }
            int[] orderArray = new int[adjs.size()];
            for (int i = 0; !order.isEmpty(); i++) {
                orderArray[i] = order.pop();
            }
            return orderArray;
        }

        private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
            visited.set(from);
            onStack.set(from);
            for (int to : adjs.get(from)) {
                if (!visited.get(to)) {
                    if (hasOrder(to, adjs, visited, onStack, order)) {
                        return true;
                    }
                } else if (onStack.get(to)) {
                    return true;
                }
            }
            onStack.clear(from);
            order.push(from);
            return false;
        }
    }
}
