import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    
    val paper = Array(100) { BooleanArray(100) }
    val T = scanner.nextInt()
    
    for (i in 0 until T) {
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        
        for (j in x until x + 10) {
            for (k in y until y + 10) {
                paper[j][k] = true
            }
        }
    }
    
    var area = 0
    for (i in 0 until 100) {
        for (j in 0 until 100) {
            if (paper[i][j]) {
                area++
            }
        }
    }
    
    println(area)
}
