class Solution:
    def __init__(self):
        self.memo = {}
    
    def numMusicPlaylists(self, n: int, goal: int, k: int, uniqueSongs = 0) -> int:
        if goal == 0: return 1 if uniqueSongs == n else 0
        if (goal, uniqueSongs) not in self.memo: self.memo[(goal, uniqueSongs)] = (max(uniqueSongs - k, 0) * self.numMusicPlaylists(n, goal - 1, k, uniqueSongs) + (n - uniqueSongs) * self.numMusicPlaylists(n, goal - 1, k, uniqueSongs + 1)) % (10**9 + 7)
        return self.memo[(goal, uniqueSongs)]