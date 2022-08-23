import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 4/30/22 8:44 PM
 */
public class lc399_dfs_bfs_floyd {

    //哈希表给变量映射整数索引
    Map<String,Integer> map = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<double[]>[] graph = buildGraph(equations,values);
        int index = 0;
        //结果集
        double[] answer = new double[queries.size()];
        //遍历问题
        for(List<String> query : queries) {
            //如果问题中存在不存在的遍历
            if(!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))) {
                answer[index++] = -1;//返回-1
                continue;
            }
            //进行bfs搜索
            answer[index++] = bfs(graph,map.get(query.get(0)),map.get(query.get(1)),new HashSet<Integer>());
        }
        return answer;
    }
    double bfs(List<double[]>[] graph, int start, int end, HashSet<Integer> visited) {
        Queue<double[]> queue = new LinkedList<>();
        //将起始点存入队列中
        queue.offer(new double[]{(double) start,1});
        //标记起始点为已访问
        visited.add(start);
        while(!queue.isEmpty()) {
            double[] cur = queue.poll();
            int curNode = (int) cur[0];
            double curNum = cur[1];
            //如果遍历到终点
            if(curNode == end) {
                //返回结果
                return curNum;
            }
            //遍历邻接点
            for(double[] next : graph[curNode]) {
                int nextNode = (int) next[0];
                double nextNum = next[1] * curNum;
                //如果邻接点未被访问过
                if(!visited.contains(nextNode)) {
                    queue.offer(new double[]{(double) nextNode,nextNum});
                    visited.add(nextNode);
                }
            }
        }
        return -1;
    }
    //构建有向图的邻接表
    List<double[]>[] buildGraph(List<List<String>> equations, double[] values) {
        int index = 0;
        //遍历变量对数组
        for(List<String> pair : equations) {
            String a = pair.get(0);
            String b = pair.get(1);
            //为每一个变量映射整数索引
            if(!map.containsKey(a)) {
                map.put(a,index++);
            }
            if(!map.containsKey(b)) {
                map.put(b,index++);
            }
        }
        List<double[]>[] graph = new LinkedList[map.size()];
        for(int i : map.values()) {
            graph[i] = new LinkedList();
        }
        index = 0;
        //构建邻接表
        for(List<String> pair : equations) {
            int a = map.get(pair.get(0));
            int b = map.get(pair.get(1));
            double ans = values[index++];
            graph[a].add(new double[]{(double) b,ans});
            ans = 1 / ans;
            graph[b].add(new double[]{(double) a,ans});
        }
        return graph;
    }

}
