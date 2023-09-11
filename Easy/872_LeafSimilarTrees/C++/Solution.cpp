#include <algorithm>
#include <vector>
#include "TreeNode.h"

class Solution {
public:
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        std::vector<int> leafs1, leafs2;
        findLeafs(root1, &leafs1);
        findLeafs(root2, &leafs2);
        return leafs1.size() == leafs2.size() && std::equal(leafs1.begin(), leafs1.end(), leafs2.begin());
    }

public:
    void findLeafs(TreeNode* root, std::vector<int>* leafs) {
        if (root->left == nullptr && root->right == nullptr) {
            leafs->emplace_back(root->val);
            return;
        }
        if (root->left != nullptr) findLeafs(root->left, leafs);
        if (root->right != nullptr) findLeafs(root->right, leafs);
    }
};