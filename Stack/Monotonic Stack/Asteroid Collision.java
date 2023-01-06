class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();

        int n = asteroids.length;

        for(int i=0;i<n;i++){

            boolean flag = true;
            
            while(!st.isEmpty() && asteroids[i]<0 && st.peek()>0){

                if(st.peek()==asteroids[i]*-1){
                    st.pop();
                    flag=false;
                    

                    // no need to be in while loop because both the astewroid are destroyed
                    break;
                }  

                else if(st.peek()>asteroids[i]*-1){
                    // non need to be in while loop because curr asteroid is too small to destroy others
                    flag=false;
                    break;
                }   

                else if(st.peek()<asteroids[i]*-1){
                    // it is big asteroid so keep destroying others untill bigger or equal asteroid is found
                    st.pop();
                }
            }

            if(flag)
                st.push(asteroids[i]);
                
        }

        int size = st.size();
        int ans[] = new int[size];

        for(int i=size-1;i>=0;i--){
            ans[i]=st.pop();
        }

        return ans;

    }
    
}
