class Solution:
    def candy(self, ratings: list[int]) -> int:
        l = len(ratings)
        candies = [1] * l

        for i in range(1, l):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        for i in range(l - 1, 0, -1):
            if ratings[i - 1] > ratings[i]:
                candies[i - 1] = max(candies[i - 1], candies[i] + 1)

        return sum(candies)