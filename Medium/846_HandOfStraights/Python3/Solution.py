class Solution:
    def isNStraightHand(self, hand: list[int], groupSize: int) -> bool:
        if len(hand) % groupSize:
            return False
        
        hand.sort()
        
        while hand:
            num = hand[0]
            for i in range(groupSize):
                if num + i in hand:
                    hand.remove(num + i)
                else:
                    return False
        
        return True