import java.util.*;
class Solution {
    private int[][] distMatrix;
    public int[] countSubgraphsForEachDiameter(int n, int[][] roads) {
        distMatrix=new int[n][n];
        List<Integer>[] graph=new List[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] road:roads){
            graph[road[0]-1].add(road[1]-1);
            graph[road[1]-1].add(road[0]-1);
        }
        for(int i=0;i<n;i++){
            calculateDistance(graph,i,-1,i,0);
        }
        int[] diameterFrequency=new int[n-1];
        for(int mask=1;mask<(1<<n);mask++){
            int maxDist=0;
            int singleEdgeCount=0;
            int includedCities=0;
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    includedCities++;
                    for(int j=i+1;j<n;j++){
                        if((mask&(1<<j))!=0){
                            maxDist=Math.max(maxDist,distMatrix[i][j]);
                            if(distMatrix[i][j]==1){
                                singleEdgeCount++;
                            }
                        }
                    }
                }
            }
            if(singleEdgeCount==includedCities-1&&maxDist>0){
                diameterFrequency[maxDist-1]++;
            }
        }
        return diameterFrequency;
    }
    private void calculateDistance(List<Integer>[] graph, int origin, int prevCity,int currentCity,int distance){
        if(prevCity==currentCity){
            return;
        }
        distMatrix[origin][currentCity]=distance;
        distMatrix[currentCity][origin]=distance;
        for(int neighbor:graph[currentCity]){
            if(neighbor!=prevCity){
                calculateDistance(graph,origin,currentCity,neighbor,distance+1);
            }
        }
    }
}