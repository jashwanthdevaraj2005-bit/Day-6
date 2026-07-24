class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj,HashSet<Integer> hs,int i){
        if(hs.contains(i))return ;
        hs.add(i);
        for(int node : adj.get(i)){
            dfs(adj,hs,node);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ls= new ArrayList<>();
        // Build a graph - directed
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : invocations){
            int a = edge[0];
            int b= edge[1];
            adj.get(a).add(b);
        }
        HashSet<Integer> hs = new HashSet<>();
        dfs(adj,hs,k);
        boolean remove=true;
        for(int []edges : invocations){
            if(!hs.contains(edges[0]) && hs.contains(edges[1])){
                remove=false;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(!hs.contains(i)||!remove){
                ls.add(i);
            }
        }
        return ls;        
    }
}