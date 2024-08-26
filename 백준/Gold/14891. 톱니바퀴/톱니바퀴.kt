var first: String = ""
var second: String = ""
var third: String = ""
var fourth: String = ""

fun main(){
    first = readln()
    second = readln()
    third = readln()
    fourth = readln()

    var K = readln().toInt()

    repeat(K){
        var (wheel, dir) = readln().split(" ").map{ it.toInt() }

        var left = '0'
        var right = '0'

        if(wheel == 1){
            left = first[2]
            changeWheel1(dir)

            if(left != second[6]){

                if(second[2] != third[6]){

                    if(third[2] != fourth[6]){
                        changeWheel4(dir*-1)
                    }
                    changeWheel3(dir)
                }
                changeWheel2(dir*-1)
            }


        }else if(wheel == 2){
            left = second[6]
            right =second[2]

            changeWheel2(dir)

            if(left != first[2]){
                changeWheel1(dir*-1)
            }

            if(right != third[6]){

                if(third[2] != fourth[6]){
                    changeWheel4(dir)
                }

                changeWheel3(dir*-1)
            }
        }else if(wheel == 3){
            left = third[6]
            right = third[2]

            changeWheel3(dir)

            if(right != fourth[6]){
                changeWheel4(dir*-1)
            }

            if(left != second[2]){

                if(second[6] != first[2]){
                    changeWheel1(dir)
                }
                changeWheel2(dir*-1)
            }

        }else{
            left = fourth[6]
            changeWheel4(dir)

            if(left != third[2]){

                if(third[6] != second[2]){

                    if(second[6] != first[2]){
                        changeWheel1(dir*-1)
                    }

                    changeWheel2(dir)
                }
                changeWheel3(dir*-1)
            }
        }


    }

    var result = 0
    if(first[0] == '1') result += 1
    if(second[0] == '1') result += 2
    if(third[0] == '1') result += 4
    if(fourth[0] == '1') result += 8

    println(result)
}

fun changeWheel1(dir: Int){
    if(dir == 1){
        first = first[7] + first.substring(0,7)
    }else{
        first = first.substring(1,8) + first[0]
    }
}

fun changeWheel2(dir: Int){
    if(dir == 1){
        second = second[7] + second.substring(0,7)
    }else{
        second = second.substring(1,8) + second[0]
    }
}

fun changeWheel3(dir: Int){
    if(dir == 1){
        third = third[7] + third.substring(0,7)
    }else{
        third = third.substring(1,8) + third[0]
    }
}

fun changeWheel4(dir: Int){
    if(dir == 1){
        fourth = fourth[7] + fourth.substring(0,7)
    }else{
        fourth = fourth.substring(1,8) + fourth[0]
    }
}