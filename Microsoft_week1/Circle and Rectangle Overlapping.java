class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX=Math.max(x1,Math.min(x2,xCenter));
        int nearestY=Math.max(y1,Math.min(y2,yCenter));
        int dis_x=nearestX-xCenter;
        int dis_y=nearestY-yCenter;
        return dis_x*dis_x+dis_y*dis_y<=radius*radius;
    }
}
// class Solution {
//     public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
//         int x3=x1, y3=y2, x4=x2, y4=y1;
//         int shortestDist=Integer.MAX_VALUE;
//         for(int i=x3;i<=x2;i++){
//             shortestDist=Math.min(shortestDist,distance(i,y2,xCenter,yCenter));
//         }
//         for(int j=y2;j<=y4;j++){
//             shortestDist=Math.min(shortestDist,distance(x2,j,xCenter,yCenter));
//         }
//         for(int i=x1;i<=x4;i++){
//             shortestDist=Math.min(shortestDist,distance(i,y1,xCenter,yCenter));
//         }
//         for(int j=y1;j<=y3;j++){
//             shortestDist=Math.min(shortestDist,distance(x1,j,xCenter,yCenter));
//         }
//         return shortestDist<=(radius*radius);
//     }
//     public int distance(int x1,int y1,int x2,int y2){
//         int x=Math.abs(x1-x2)*Math.abs(x1-x2);
//         int y=Math.abs(y1-y2)*Math.abs(y1-y2);
//         return x+y;
//     }
// }