/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,Map<Integer,List<Integer>>> map=new TreeMap<>();
        solve(root,0,0,map);
        List<List<Integer>> list=new ArrayList<>();
        for(Integer col:map.keySet()){
            List<Integer> l=new ArrayList<>();
            for(Integer row:map.get(col).keySet()){
                Collections.sort(map.get(col).get(row));
                l.addAll(map.get(col).get(row));
            }
            list.add(l);
        }
        return list;
    }
    public TreeNode solve(TreeNode root,int col,int row, Map<Integer,
                          Map<Integer,List<Integer>>> map){
        if(root==null)  return null;
        map.putIfAbsent(col,new TreeMap<>());
        map.get(col).putIfAbsent(row,new ArrayList<>());
        map.get(col).get(row).add(root.val);
        solve(root.left,col-1,row+1,map);
        solve(root.right,col+1,row+1,map);
        
        return root;
    }
}
