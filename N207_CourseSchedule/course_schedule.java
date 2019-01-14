package N207_CourseSchedule;

import java.util.*;

/**
 * Created by srx on 2019/1/14.
 */
public class course_schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //BFS
        int indegree[] = new int[numCourses];
        ArrayList[] neighbours = new ArrayList[numCourses];
        Queue queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            neighbours[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            neighbours[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) { //courses who has no prerequisites
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            for (int j = 0; j < neighbours[course].size(); j++) {
                if (--indegree[(int) neighbours[course].get(j)] == 0)
                    queue.offer(neighbours[course].get(j));
            }
        }
        for (int i = 0; i < numCourses; i++) {
            //if some courses left having pres
            if (indegree[i] != 0)
                return false;
        }
        return true;
    }
    public boolean dfsMethod(int numCourses, int[][] prerequisites){
        ArrayList[] pres = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            pres[i] = new ArrayList();
        }
        for (int i = 0;i<prerequisites.length;i++){
            pres[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0;i<numCourses;i++){
            if (!no_cycle(pres,i,visited))
                return false;

        }
        return true;
    }

    private boolean no_cycle(ArrayList[] pres, int node, boolean[] visited) {
        if (visited[node])
            return false;
        visited[node] = true;
        for (int i = 0;i<pres[node].size();i++){
            int neigh = (Integer)pres[node].get(i);
            if (! no_cycle(pres,neigh,visited))
                return false;
        }
        visited[node] = false;
        return true;
    }

}
