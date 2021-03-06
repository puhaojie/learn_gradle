/**
 *  groovy基础语法
 */
package variable

int x = 10

println x.class // 对象类型

double y = 3.14
//println y.class

/**
 *  弱类型定义方式
 *  没有基本类型，都是对象类型
 *  可以根据后面推测，def关键字。python和kotlin为var
 */
def x_1 = 11
//println x_1.class
def y_1 = 3.1415
//println y_1.class
def name = 'Qndroid'
//println name.class

/**
 *  强类型方式和弱类型方式建议
 *  别的类中也要用到，尽量使用强类型方式（）
 */
x_1 = 'Test'
//println x_1.class

//def map = new HashMap()
def color = [red: 'ff0000', green: '00ff00', blue: '0000ff']
color.yellow = 'ffff00' //添加
println color['red']
println color.green
println color.getClass()
println color.yellow
//注意key的取值,key做为变量时特殊处理
def pink = 'pink'
color.(pink) = 'ff00ff'
println color.toMapString()
def map = [a: 1, b: 2]
color.complex = map
println color.toMapString()
color.each { def entry ->
    println "the key is:${entry.key} the value is: ${entry.value}"

}
color.eachWithIndex { def key, def value, def index ->
    println "${index}:the key is ${key}, the value is ${value}"
}