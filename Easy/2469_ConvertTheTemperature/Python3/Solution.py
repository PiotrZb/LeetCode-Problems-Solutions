class Solution:
    def convertTemperature(self, celsius: float) -> List[float]:
        return [celsius + 273.15, 32.0 + 9.0 / 5.0 * celsius]