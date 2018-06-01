package objectorention

ExpandoMetaClass.enableGlobally()
/**
 * 为类动态的添加一个属性
 */
Person.metaClass.sex = 'male'
def person = new Person(name: 'Qndroid', age: 26)
println person.sex
person.sex = 'female'
println "the new sex is:" + person.sex
/**
 * 为类动态的添加方法
 */
Person.metaClass.sexUpperCase = { -> sex.toUpperCase() }
def person2 = new Person(name: 'Qndroid', age: 26)
println person2.sexUpperCase()

/**
 * 为类动态的添加静态方法
 */
Person.metaClass.static.createPerson = {
    String name, int age -> new Person(name: name, age: age)
}
def person3 = Person.createPerson('renzhiqiang', 26)
println person3.name + " and " + person3.age