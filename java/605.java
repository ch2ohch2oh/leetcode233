/**
 * id: 605 can place flowers
 * tags: greedy
 * date: 2021-04-26
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                boolean okLeft = (i == 0) || (flowerbed[i - 1] == 0);
                boolean okRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if(okLeft && okRight) {
                    count += 1;
                    flowerbed[i] = 1;
                    i++;
                }
            }
        }
        return count >= n;
    }
}