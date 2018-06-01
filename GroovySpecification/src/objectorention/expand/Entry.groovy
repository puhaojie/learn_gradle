package objectorention.expand

/**
 *  使用ExpandoMetaClass.enableGlobally()来注入一个全局的方法
 *  为第三方类注入方法
 */
class Entry {

    static void main(def args) {
        println '应用程序正在启动...'
        //初始化
        ApplicationManager.init()
        println '应用程序初始化完成...'

        def person = PersonManager.createPerson('renzhiqiang', 26)
        println "the person name is ${person.name} " +
                "and the age is ${person.age}"
    }
}
