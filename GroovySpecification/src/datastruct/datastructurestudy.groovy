package datastruct
/**
 *  列表相关知识
 */

//def list = new ArrayList() //java的定义方式
def list = [1, 2, 3, 4, 5]
println list.class
println list.size()
// 数组定义
def array = [1, 2, 3, 4, 5] as int[]
int[] array2 = [1, 2, 3, 4, 5]

/**
 * list的添加元素
 */
list.add(6)
list.leftShift(7)
list << 8
def plusList = list + 9
println list.toListString()
/**
 * list的删除操作
 */
list.remove(7)
println list.toListString()
list.remove((Object) 7)
//list.removeAt(0)
println list.toListString()
list.removeElement(6)
list.removeAll { return it % 2 == 0 }
println list - [6, 7]
println list.toListString()
/**
 * 列表的排序
 */
def sortList = [6, -3, 9, 2, -7, 1, 5]
Comparator mc = { int a, int b ->
    a == b ? 0 :
            Math.abs(a) < Math.abs(b) ? -1 : 1
} as Comparator
Collections.sort(sortList, mc)
sortList.sort { a, b ->
    a == b ? 0 :
            Math.abs(a) < Math.abs(b) ? 1 : -1
}
println sortList
def sortStringList = ['abc', 'z', 'Hello', 'groovy', 'java']
sortStringList.sort { it -> return it.size() }
println sortStringList
/**
 * 列表的查找
 */
def findList = [-3, 9, 6, 2, -7, 1, 5]
// 返回第一个符合条件的
int result = findList.find { return it % 2 == 0 }
//def result = findList.findAll { return it % 2 != 0 }
//println result.toListString()
//def result = findList.any { return it % 2 != 0 }
//def result = findList.every { return it % 2 == 0 }
println result
println findList.min { return Math.abs(it) }
println findList.max { return Math.abs(it) }
def num = findList.count { return it % 2 != 0 }
println num

