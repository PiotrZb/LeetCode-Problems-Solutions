#include <algorithm>
#include "TreeNode.h"

class Solution {
public:
    int maxDepth(TreeNode *root) {
        return root == nullptr ? 0 : 1 + std::max(maxDepth(root->left), maxDepth(root->right));
    }
};