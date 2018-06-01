package variable

//def name = 'a single \'a\'string'
//println name.class

/**
 *  与kotlin语法相同
 *
 */
def thupleName = '''
line one
line two
line three
'''
//println thupleName

def doubleName = "this a common String"
//println doubleName.class

def name = "Qndroid"
def sayHello = "Hello: ${name}"
//println sayHello
// class org.codehaus.groovy.runtime.GStringImpl
// 这是个GString
println sayHello.class

def sum = "the sum of 2 and 3 equals ${2 + 3}" //可扩展做任意的表达式
//println sum
def result = echo(sum)
//println result.class

static String echo(String message) {
    return message
}
/* ==================字符串的方法=================== */
def str = "groovy Hello"
// 字符串的填充
println str.center(22,'s')
println str.padLeft(22, 'o')// 左边填充
def str2 = 'Hello'
println str > str2
println str[0]
println str[2..3]
println str - str2
println str.codePointAt(6)
println str.reverse() //反转
println str.capitalize() // 首字母大写
println str.isInteger()