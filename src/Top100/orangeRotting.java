package Top100;

import java.util.LinkedList;
import java.util.Queue;

public class orangeRotting {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (count > 0 && !queue.isEmpty()) {
            time++;
            int[] badOrange = queue.poll();
            int r = badOrange[0];
            int c = badOrange[1];
            if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                grid[r - 1][c] = 2;
                count--;
                queue.add(new int[]{r - 1, c});
            }
            if (r + 1 < row && grid[r + 1][c] == 1) {
                grid[r + 1][c] = 2;
                count--;
                queue.add(new int[]{r + 1, c});

            }
            if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                grid[r][c - 1] = 2;
                count--;
                queue.add(new int[]{r, c - 1});
            }
            if (c + 1 < col && grid[r][c + 1] == 1) {
                grid[r][c + 1] = 2;
                count--;
                queue.add(new int[]{r, c + 1});
            }

        }
        if (count > 0) {
            return -1;
        } else
            return time;
    }

    public static void main(String[] args) {

    }

}
