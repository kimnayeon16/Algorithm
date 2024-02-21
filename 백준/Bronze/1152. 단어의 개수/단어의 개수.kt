fun main(){
    var english = readln().split(" ").filter { it.isNotEmpty() }
    println(english.size)
}