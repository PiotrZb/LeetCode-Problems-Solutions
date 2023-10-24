<?php
    include './TreeNode';

    class Solution {

        function largestValues($root) {
            $layersMaxVal = [];
            $this->search($root, 0, $layersMaxVal);
            return $layersMaxVal;
        }

        function search($root, $layerNumber, &$layersMaxVal) {
            if ($root == null) return;
            if (count($layersMaxVal) < $layerNumber + 1) $layersMaxVal[] = $root->val;
            else $layersMaxVal[$layerNumber] = max($layersMaxVal[$layerNumber], $root->val);
            $this->search($root->right, $layerNumber + 1, $layersMaxVal);
            $this->search($root->left, $layerNumber + 1, $layersMaxVal);
        }
    }
?>