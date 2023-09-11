#include "TreeNode.h"

class Solution {
public:
    int deepestLeavesSum(TreeNode *root) {
        int sum = 0, maxLvl  = 0;
        this->search(root, 0, sum, maxLvl);
        return sum;
    }

    static void search(TreeNode *root, int currentLvl, int& sum, int& maxLvl) {
        if (currentLvl == maxLvl) sum += root->val;
        if (currentLvl > maxLvl) {
            sum = root->val;
            maxLvl = currentLvl;
        }
        if (root->left != nullptr) search(root->left, currentLvl + 1, sum, maxLvl);
        if (root->right != nullptr) search(root->right, currentLvl + 1, sum, maxLvl);
    }
};