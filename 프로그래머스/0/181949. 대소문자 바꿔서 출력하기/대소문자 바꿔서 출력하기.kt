fun main(args: Array<String>) {
    val s1 = readLine()!!
    val sb = StringBuilder()
    for(i in 0 until s1.length){
        if(s1[i].isUpperCase()){
            sb.append(s1[i].toLowerCase())
        }else{
            sb.append(s1[i].toUpperCase())
        }
    }
    println(sb.toString())
}