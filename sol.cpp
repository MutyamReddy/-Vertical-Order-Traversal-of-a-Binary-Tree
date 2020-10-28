class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* A) {
      vector<vector<int>>ans;
        map<int,vector<int>>mp;
        queue<pair<TreeNode*,int>>q;
        if(A==NULL){
            return ans;
        }
        int n;
        q.push({A,0});
        TreeNode* temp;
        while(!q.empty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                temp=q.front().first;
                n=q.front().second;
                mp[n].push_back(temp->val);
                q.pop();
                if(temp->left!=NULL)
                    q.push({temp->left,n-1});
                if(temp->right!=NULL)
                    q.push({temp->right,n+1});
            }
        }
        for(auto it:mp){
            ans.push_back(it.second);
        }
        return ans;
    }
};
