from bisect import bisect_left

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if not intervals:
            return [newInterval]
        
        start, end = newInterval[0], newInterval[1]

        index1 = index2 = bisect_left([x[0] for x in intervals], start)
        if (index1 != 0 and self.checkIfOverlaps(intervals[index1 - 1], newInterval)) :
            index1 -= 1
            index2 -= 1

        for interval in intervals[index1:]:
            if self.checkIfOverlaps(interval, newInterval):
                start = min(interval[0], start)
                end = max(interval[1], end)
            else:
                break

            index2 += 1
        
        answer = intervals[:index1]
        answer.append([start, end])
        answer.extend(intervals[index2:])

        return answer
    
    def checkIfOverlaps(self, interval1: List[int], interval2: List[int]) -> bool:
        return (interval1[0] >= interval2[0] and interval1[0] <= interval2[1] or
                interval2[0] >= interval1[0] and interval2[0] <= interval1[1])
    

# Ugly solution, but actually with better performance o_O
# class Solution:
#     def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
#         if (len(intervals) == 0):
#             return [newInterval]

#         if (newInterval[1] < intervals[0][0]):
#             intervals.insert(0, newInterval)
#             return intervals

#         if (newInterval[0] > intervals[-1][1]):
#             intervals.append(newInterval)
#             return intervals

#         overlaping = []
#         first = last = -1
#         for index, interval in enumerate(intervals):
#             if (interval[0] > newInterval[1] and first == -1):
#                 first = index
#             if (self.checkIfOverlaps(interval, newInterval)):
#                 first = index
#                 overlaping.append(newInterval)
#                 while (self.checkIfOverlaps(intervals[index], newInterval)):
#                     last = index
#                     overlaping.append(intervals[index])
#                     index += 1
#                     if (index == len(intervals)): 
#                         break
#                 break

#         if (len(overlaping) == 0):
#             intervals.insert(first, newInterval)
#             return intervals

#         answer = intervals[:first]
#         answer.append(self.concatIntervals(overlaping))
#         answer.extend(intervals[last+1:])

#         return answer
    
#     def checkIfOverlaps(self, interval1: List[int], interval2: List[int]) -> bool:
#         return (interval1[0] >= interval2[0] and interval1[0] <= interval2[1] or
#                 interval2[0] >= interval1[0] and interval2[0] <= interval1[1])
    
#     def concatIntervals(self, intervals: List[List[int]]) -> List[int]:
#         starts = [x[0] for x in intervals]
#         ends = [x[1] for x in intervals]
#         return [min(starts), max(ends)]