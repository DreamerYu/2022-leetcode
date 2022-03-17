/**
 * @Author: Dreamer Yu
 * @Date: 1/17/22 10:12 PM
 */
public class lc457_unionfind {

    public boolean circularArrayLoop(int[] nums) {

        int[] n = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            n[i] = i;
        }

        for(int i = 0; i < nums.length; i++){

            int next = (i + nums[i]) % nums.length;
            if(next < 0) next = nums.length + next;
            if(next >= nums.length) next = next - nums.length;
            if(next == i) continue; //长度不为1
            if(find(n,i) == find(n,next)) return true;
            if(nums[i] * nums[next] > 0) union(n, i , next); //保证正负相同

        }
        return false;
    }

    public int find(int[] n, int x){
        if(n[x] == x) return x;
        else{
            n[x] = find(n, n[x]);
            return n[x];
        }
    }

    void union(int[] uf, int a, int b){
        int fa = find(uf, a);
        int fb = find(uf, b);
        if(fa != fb) uf[fa] = fb;
    }
}
