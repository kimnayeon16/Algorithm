fun main(){
    var s = readln()
    var array = Array<Int>(26) {-1}
    for((idx, element) in s.withIndex()){
        if(array[element.toInt() - 97] == -1){
            array[element.toInt() - 97] = idx
        }
    }

    array.forEach { print("$it ") }

}