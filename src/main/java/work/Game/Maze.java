package work.Game;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Maze {
    private int len = 11; //迷宫长度
    private int wid = 11; //迷宫宽度
    private char wall = '#'; //代表墙
    private char blank = '.'; //代表空地
    private char[][] maze; //迷宫
    private boolean[][] visit; //用来标记某一格是否被访问过
    private node start = new node(0, 0); //开始节点
    private node exit = new node(len - 1, wid - 1); //出口
    private node cur; //当前格
    private node next; //下一格
    private Stack<node> path = new Stack<node>(); //表示路径的栈
    private int[][] adj = {
            {0, 2}, {0, -2}, {2, 0}, {-2, 0}
    }; //用来计算邻接格
    private ArrayList<String> mazeScene = new ArrayList<>();
    private ArrayList<String> itemEnding = new ArrayList<>();

    public Maze() {
        this.len = 11;
        this.wid = 11;
        init();
    }

    public Maze(int len, int wid) {
        this.len = len;
        this.wid = wid;
        init();
        makemaze();
        //printmaze();
    }

    public ArrayList<String> getMazeScene() {
        return mazeScene;
    }

    /**
     * 初始化，初始化迷宫参数
     */
    void init() {
        itemEnding.add("一");
        itemEnding.add("键");
        itemEnding.add("三");
        itemEnding.add("连");
        maze = new char[len][wid];
        visit = new boolean[len][wid];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                maze[i][j] = wall;
                visit[i][j] = false;
            }
        }
        visit[start.x][start.y] = true;
        maze[start.x][start.y] = blank;
        cur = start; //将当前格标记为开始格
    }

    /**
     * 打印结果
     */
    void printmaze() {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                System.out.print(maze[i][j] + " ");
//  if(maze[i][j] == '○')
//  {
//   system.err.print(maze[i][j] + " ");
//  }
//  else
//  {
//   system.out.print(maze[i][j] + " ");
//  }
//  try {
//   thread.sleep(100);
//  } catch (interruptedexception e) {
//   e.printstacktrace();
//  }
            }
            System.out.println();
        }
        System.out.println("==========================================");
    }

    /**
     * 开始制作迷宫
     */
    void makemaze() {
        path.push(cur); //将当前格压入栈
        while (!path.empty()) {
            node[] adjs = notvisitedadj(cur);//寻找未被访问的邻接格
            if (adjs.length == 0) {
                cur = path.pop();//如果该格子没有可访问的邻接格，则跳回上一个格子
                continue;
            }
            next = adjs[new Random().nextInt(adjs.length)]; //随机选取一个邻接格
            int x = next.x;
            int y = next.y;
            //如果该节点被访问过，则回到上一步继续寻找
            if (visit[x][y]) {
                cur = path.pop();
            } else//否则将当前格压入栈，标记当前格为已访问，并且在迷宫地图上移除障碍物
            {
                path.push(next);
                visit[x][y] = true;
                maze[x][y] = blank;
                maze[(cur.x + x) / 2][(cur.y + y) / 2] = blank; //移除当前格与下一个之间的墙壁
                cur = next;//当前格等于下一格
            }
        }
        for (int i = 0; i < len; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < wid; j++) {
                if (i == 0 && j == 0) {
                    tmp.append("我");
                } else if (i == len - 1 && j == wid - 1) {
                    tmp.append(itemEnding.get(new Random().nextInt(4)));
                } else if (maze[i][j] == '#') {
                    tmp.append("墙");
                } else if (maze[i][j] == '.') {
                    tmp.append(" ");
                }
            }
            mazeScene.add(tmp.toString());
        }
    }

    /**
     * 判断节点是否都被访问
     *
     * @param ns
     * @return
     */
    boolean allvisited(node[] ns) {
        for (node n : ns) {
            if (!visit[n.x][n.y])
                return false;
        }
        return true;
    }

    /**
     * 寻找可访问的邻接格，这里可以优化，不用list
     *
     * @param node
     * @return
     */
    node[] notvisitedadj(node node) {
        List<node> list = new ArrayList<node>();
        for (int i = 0; i < adj.length; i++) {
            int x = node.x + adj[i][0];
            int y = node.y + adj[i][1];
            if (x >= 0 && x < len && y >= 0 && y < wid) {
                if (!visit[x][y])
                    list.add(new node(x, y));
            }
        }
        node[] a = new node[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    /**
     * 迷宫的格子类
     *
     * @author yan
     */
    class node {
        int x, y;

        public node() {
        }

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String tostring() {
            return "node [x=" + x + ", y=" + y + "]";
        }
    }

}
