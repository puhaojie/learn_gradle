package objectorention

/**
 *  与接口比较像，但可以实现默认的方法
 *  用的少
 */
trait DefualtAction {

    abstract void eat()

    void play() {
        println ' i can play.'
    }

}