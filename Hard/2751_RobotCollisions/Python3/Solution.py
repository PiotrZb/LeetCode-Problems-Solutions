class Solution(object):
    def survivedRobotsHealths(self, positions, healths, directions):
        """
        :type positions: List[int]
        :type healths: List[int]
        :type directions: str
        :rtype: List[int]
        """

        stack = []

        for pos, health, dir, i in sorted(zip(positions, healths, directions, range(len(positions)))):
            while stack and stack[-1][2] == 'R' and dir == 'L':
                pos2, health2, dir2, j = stack.pop()

                if health2 > health:
                    stack.append((pos2, health2 - 1, dir2, j))
                    health = 0
                    break
                elif health2 == health:
                    health = 0
                    break

                health -= 1
            
            if health > 0:
                stack.append((pos, health, dir, i))

        stack.sort(key=lambda robot: robot[3])
        
        return [robot[1] for robot in stack]
