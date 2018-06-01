package variable
/**
 * 闭包知识
 * 在一个函数内部的函数
 * 在本质上，闭包是将函数内部和函数外部连接起来的桥梁。
 */
// 一段简单的闭包，前部分为参数，后部分为方法体
// 闭包一定是有返回值的,最后一行为返回值，默认不写return
def clouser = { String name ->
    println("hello ${name}")
    "String"
}
clouser.call("world") // 调用
// clouser("world")  // 调用
/**
 * Integer 闭包
 */
int x = 10
// 10！ upto
def fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}
// downto
def fab2(int number) {
    int result = 1
    number.downto(1) { num -> result *= num }
    return result
}

def fab3(int number) {
    int result = 0
    number.times { num -> result += num }
    return result
}

//println fab3(10)

/**
 * 字符串结合闭包使用
 */
String str = 'the 2 and 3 is 5'
//each 遍历 (it是隐性参数)
//str.each {
//    String temp -> print temp.multiply(2)
//}

// 只找第一个成功的，闭包返回Boolean
str.find {
    String s -> s.isNumber()
}
// 返回所有的
def list = str.findAll {
    String s -> s.isNumber()
}
//print list

// 是否存在满足如下条件的
def result = str.any {
    String s -> s.isNumber()
}
//print result

//是否每一次都满足条件
result = str.every {
    String s -> s.isNumber()
}
//print result

result = str.collect {
    it.toUpperCase()
}
//for (String s in result){
//    print s
//}

/**
 *  闭包的三个重要变量：this，owner，delegate
 */
def scriptColuser = {
    println "this = " + this // 代表闭包定义处的类
    println "owner = " + owner // 代表闭包定义处的类或者对象
    println "delegate = " + delegate // 代表任意对象，默认为owner
}
//this = variable.clouserstudy@dbf57b3
//owner = variable.clouserstudy@dbf57b3
//delegate = variable.clouserstudy@dbf57b3
//scriptColuser.call()


class Person {
    def static classColuser = {
        println "this = " + this // 代表闭包定义处的类
        println "owner = " + owner // 代表闭包定义处的类或者对象
        println "delegate = " + delegate // 代表任意对象，默认为owner
    }

    def static say() {
        classColuser = {
            println "method this = " + this // 代表闭包定义处的类
            println "method owner = " + owner // 代表闭包定义处的类或者对象
            println "method delegate = " + delegate // 代表任意对象，默认为owner
        }

        classColuser.call()
    }
}

//Person.classColuser()
//Person.say()
Person p = new Person()
def nestColuser = {

    def innerColuser = {
        println "innerColuser this = " + this // 代表闭包定义处的类
        println "innerColuser owner = " + owner // 代表闭包定义处的类或者对象
        println "innerColuser delegate = " + delegate // 代表任意对象，默认为owner
    }
    innerColuser.delegate = p// 修改默认的delegate
    innerColuser.call()

}
//nestColuser()

/**
 *  闭包委托策略
 */
class Student {
    String name
    def pretty = { "my name is ${name}" }

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name
}


def stu = new Student(name: "phj")
def tea = new Teacher(name: "tea")
//println stu.toString()
stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST //修改委托策略
println stu.toString()