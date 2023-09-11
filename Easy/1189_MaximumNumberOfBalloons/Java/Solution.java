class Solution {
    public int maxNumberOfBalloons(String text) {
        int numberOfBaloons = 0;
        while(true){
            for (char c : "balloon".toCharArray()){
                if (text.contains(String.valueOf(c))) text = text.replaceFirst(String.valueOf(c), "");
                else return numberOfBaloons;
            }
            numberOfBaloons++;
        }
    }
}