class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, j = 0, result = 0;
		int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        Set<String> set = new HashSet<>();
        for(int[] ob : obstacles) set.add(ob[0] + "_" + ob[1]);
        for(int i=0; i<commands.length; i++) {
            if(commands[i]==-1) j = (j+1)%4;
            else if(commands[i]==-2) j = (j+3)%4;
            else {
                while(commands[i]-- >0 && !set.contains((x+dirs[j][0])+ "_" +(y+dirs[j][1]))) {
                    x += dirs[j][0];
                    y += dirs[j][1];
                }
            }
            result = Math.max(result, x*x + y*y);
        }
        return result;
    }
}