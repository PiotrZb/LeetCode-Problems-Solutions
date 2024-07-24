#include "TreeNode.cpp"
#include <climits>
#include <queue>

class Solution {
public:
    int maxLevelSum(TreeNode* root) {
        int lvl = 1, currLvl = 1;
        std::queue<TreeNode*> queue;
        queue.push(root);

        for (int maxSum = INT_MIN; !queue.empty(); currLvl++) {
            int n = queue.size(), currSum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode* node = queue.front();
                currSum += node->val;
                if (node->left != nullptr) queue.push(node->left);
                if (node->right != nullptr) queue.push(node->right);
                queue.pop();
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                lvl = currLvl;
            }
        }

        return lvl;
    }
};