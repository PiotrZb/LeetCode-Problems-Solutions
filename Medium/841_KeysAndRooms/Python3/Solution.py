class Solution:
    def canVisitAllRooms(self, rooms: list[list[int]]) -> bool:
        roomsToVisit, visitedRooms = [0], set()

        while roomsToVisit:
            room = roomsToVisit.pop()
            visitedRooms.add(room)
            
            for key in rooms[room]:
                if key not in visitedRooms:
                    roomsToVisit.append(key)
        
        return len(visitedRooms) == len(rooms)