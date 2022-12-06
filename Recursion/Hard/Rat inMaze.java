class Solution {
   public static ArrayList<String> findPath(int[][] m, int n) {
       ArrayList<String> paths=new ArrayList<String>();
       findPaths(m,0,0,paths,"");
       return paths;
   }
  static void findPaths(int[][] m,int i, int j, ArrayList<String> paths, String path)
   {
       if(i<0 || j<0 || i>m.length-1 || j>m.length-1 || m[i][j]==0 )
       {
           return;
       }
       if(i==m.length-1 && j==m.length-1)
       {
           paths.add(path);
           
       }
       m[i][j]=0;
       findPaths(m,i+1,j,paths,path+"D");
       findPaths(m,i,j+1,paths,path+"R");
       findPaths(m,i-1,j,paths,path+"U");
       findPaths(m,i,j-1,paths,path+"L");
       
       m[i][j]=1;
       
   }
}
   
