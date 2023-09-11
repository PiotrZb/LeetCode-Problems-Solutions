class Solution:
    def compress(self, chars: List[str]) -> int:
        index = count = 0
        currentChar = chars[0]
        
        for char in chars:
            if (char == currentChar): count += 1
            else:
                index = self.print(currentChar, index, chars, count)
                currentChar = char
                count = 1
                
        index = self.print(currentChar, index, chars, count)
        
        return index

    def print(self, char, index, chars, l):
        chars[index] = char
        index += 1
        
        if l > 1:
            for c in str(l):
                chars[index] = c
                index += 1

        return index