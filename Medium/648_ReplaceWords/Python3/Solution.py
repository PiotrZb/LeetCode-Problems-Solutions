class Solution:
    def replaceWords(self, dictionary: list[str], sentence: str) -> str:
        words = sentence.split(" ")
        derivatives = set(dictionary)

        for i in range(len(words)):
            for j in range(len(words[i])):
                if words[i][0:j] in derivatives:
                    words[i] = words[i][0:j]
                    break
        
        return " ".join(words)

# import re

# class Solution:
#     def replaceWords(self, dictionary: list[str], sentence: str) -> str:
#         for derivative in dictionary:
#             sentence = re.sub(rf'\b{derivative}\w*', derivative, sentence)
#         return sentence

# class Solution:
#     def replaceWords(self, dictionary: list[str], sentence: str) -> str:
#         words = sentence.split(" ")

#         for i in range(len(words)):
#             for derivative in dictionary:
#                 if words[i].startswith(derivative):
#                     words[i] = derivative
        
#         return " ".join(words)