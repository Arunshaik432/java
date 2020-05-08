import java.util.*;


public class tree {

//    private static void BFS(int[][] g,int start,int n){
//        int[] visited =new int[n];
//        Queue<Integer> queue=new LinkedList<>();
//        System.out.print(start +" ");
//        visited[start]=1;
//        queue.add(1);
//        while(!queue.isEmpty()) {
//            int u=queue.poll();
//            for (int v = 1; v < n; v++) {
//                if(g[u][v]==1&&visited[v]==0){
//                    System.out.print(v+" ");
//                    queue.add(v);
//                    visited[v]=1;
//                }
//            }
//        }
//    }
//
//
//    private static void DFS(int[][] g,int start,int[] visited){
//        if(visited[start]==0){
//            System.out.print(start+" ");
//            visited[start]=1;
//            for(int v=1;v<visited.length;v++){
//                if(g[start][v]==1&&visited[v]==0)DFS(g,v,visited);
//            }
//        }
//    }

    private static int[] set={-1,-1,-1,-1,-1,-1,-1,-4};

    private static int[][] edges ={
            {1,1,2,2,3,4,4,5,5},
            {2,6,3,7,4,5,7,6,7},
            {25,5,12,10,8,16,14,20,18}
    };

    private static int[] include =new int[9];
    private static int[][] t =new int[2][7];
    private static void myunion(int u, int v){
        if(set[u]<set[v]){
            set[u]+=set[v];
            set[v]=u;
        }
        else{
            set[v]+=set[u];
            set[u]=v;
        }
    }

    private static int find(int u){
        int x=u,v=0;
        while (set[x]>0){
            x=set[x];
        }
        if(u!=x){
            v=set[u];
            set[u]=x;
            u=v;
        }
        return x;
    }

    private static void kruskals(){
        int i,j = 0,k = 0,u=0,v=0,min,n=7,e=9;
        i=0;
        while (i<n-1){
            min=Integer.MAX_VALUE;
            for(j=0;j<e;j++){
                if(include[j]==0&&edges[2][j]<min){
                    min=edges[2][j];
                    u=edges[0][j];
                    v=edges[1][j];
                    k=j;
                }
            }
            if(find(u)!=find(v)){
                t[0][i]=u;
                t[1][i]=v;
                myunion(find(u),find(v));
                i++;
            }
            include[k]=1;
        }
        for(i=0;i<n-1;i++){
            System.out.println(t[0][i]+" "+t[1][i]);

        }

    }


    public static void main(String[] args) {

        kruskals();
    }












    private static void Prims(int[][] g, int[] near, int[][] t) {
        int i,j,k = 0,min=Integer.MAX_VALUE,u = 0,v=0,n=4;
        for(i=1;i<=n;i++){
            for (j=1;j<n;j++){
                if(g[i][j]<min){
                    min=g[i][j];
                    u=i;v=j;
                }
            }
        }
        t[0][0]=u;
        t[1][0]=v;
        near[u]=near[v]=0;
        for(j=1;j<=n;j++){
            if(near[j]!=0){
                if(g[j][u]<g[j][v])near[j]=u;
                else near[j]=v;
            }
        }
        for(i=1;i<n;i++){
            min=Integer.MAX_VALUE;
            for(j=1;j<n;j++){
                if(near[j]!=0&&g[j][near[j]]<min){
                    min=g[j][near[j]];
                    k=j;
                }
            }
            t[0][i]=k;
            t[1][i]=near[k];
            near[k]=0;
            for(j=1;j<=n;j++){
                if(near[j]!=0&&g[j][k]<g[j][near[j]]){
                    near[j]=k;
                }
            }

        }

        for(i=1;i<n;i++){
            System.out.println(t[0][i]+" "+t[1][i]);
        }


    }


}