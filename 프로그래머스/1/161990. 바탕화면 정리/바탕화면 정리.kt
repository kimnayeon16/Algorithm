import kotlin.math.*

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var minX = wallpaper.size
        var minY = wallpaper[0].length
        var maxX = 0
        var maxY = 0

        for (i in wallpaper.indices) {
            for (j in wallpaper[i].indices) {
                if (wallpaper[i][j] == '#') {
                    minX = min(i, minX)
                    minY = min(j, minY)
                    maxX = max(i, maxX)
                    maxY = max(j, maxY)
                }
            }
        }
        return intArrayOf(minX, minY, maxX + 1, maxY + 1)
    }
}