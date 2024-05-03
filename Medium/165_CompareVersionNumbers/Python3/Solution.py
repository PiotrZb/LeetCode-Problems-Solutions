class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = version1.split('.')
        v2 = version2.split('.')
        l = max(len(v1), len(v2))
        v1.extend([0] * (l - len(v1)))
        v2.extend([0] * (l - len(v2)))

        for i in range(l):
            if int(v1[i]) < int(v2[i]):
                return -1
            if int(v1[i]) > int(v2[i]):
                return 1

        return 0