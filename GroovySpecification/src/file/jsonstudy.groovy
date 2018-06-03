package file

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectorention.Person

import java.lang.reflect.Type

/**
 *  Created by phj on 2018-06-03.
 *  groovy 对 json的操作
 */
def list = [new Person(name: 'phj', age: 23),
            new Person(name: 'tree', age: 24)]



/**
 *  转化成JSON字符串
 *  [{"age":23,"name":"phj"},{"age":24,"name":"tree"}]
 */
String json = JsonOutput.toJson(list)
//println JsonOutput.prettyPrint(json)// 格式输出打印

/**
 *  转化成对象
 */
def jsonSlurper = new JsonSlurper()
List<Person> result = (List<Person>)jsonSlurper.parseText(json)
result.forEach{
//    println it.age + " "+ it.name
}

// 使用Gson解析
Gson gson = new Gson()
Type type = new TypeToken<List<Person>>(){}.getType()
List<Person> gsonResult = gson.fromJson(json,type)
gsonResult.forEach{
//    println it.age + " "+ it.name
}

def reponse =
        getNetworkData(
                'http://yuexibo.top/yxbApp/course_detail.json')

println reponse.data.head.name

def getNetworkData(String url) {
    //发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text
    //将json转化为实体对象
    def jsonSluper = new JsonSlurper()
    return jsonSluper.parseText(response)
}
