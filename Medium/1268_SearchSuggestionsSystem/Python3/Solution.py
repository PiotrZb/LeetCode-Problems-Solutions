class Solution:
    def suggestedProducts(self, products: list[str], searchWord: str) -> list[list[str]]:
        d = {searchWord[:i]: [] for i in range(1, len(searchWord) + 1)}

        for product in sorted(products):
            for i in range(len(product)):
                prefix = product[:i + 1]
                if prefix in d and len(d[prefix]) < 3:
                    d[prefix].append(product)
        
        return [d[searchWord[:i + 1]] for i in range(len(searchWord))]
    
        # answer = [[] for _ in range(len(searchWord))]

        # for i in range(len(searchWord)):
        #     for product in sorted(products):
        #         if len(answer[i]) < 3 and product.startswith(searchWord[:i + 1]):
        #             answer[i].append(product)

        # return answer