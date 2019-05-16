 
# What is Kotlin


Kotlin语言是由JetBrains公司开发，也被赞誉为Android世界里的Swift。2019 io大会宣布，Android 开发将越来越向 Kotlin 倾斜，许多新增的 [Jetpack API]( https://developer.android.google.cn/jetpack/)和功能也将优先提供 Kotlin 版本
 

# 一.能给开发者带来什么？
-  更少的空指针异常
```
//Java
Room room = ...;
if(null != room && null != room.window) {
     room.window.open();
}
//Kotlin
val room: Room? = ...
room?.window?.open()
```
-  函数编程Function
```
//Java
public Sting sayHello(String name) {
   return "Hello, " + name;
}
//Kotlin
fun  sayHello(name: String?): String ="Hello, $name"

```
-  闭包Lambdas
```
//Java
interface Sum {
    int add(int x,int y);
}
Sum sum = (x,y) -> x + y

//Kotlin
val sum: (Int,Int) -> Int = { x,y -> x + y }

```
- 扩展
```
//给MutableList添加一个扩展方法
fun MutableList<Int>.swap(index1: Int, index2: Int) {
      val tmp = this[index1] // 'this' corresponds to the list
      this[index1] = this[index2]
      this[index2] = tmp
}
//调用
val list=mutableListOf<Int>(100,500,300)
list.swap(1,2)
    
```
-  更少的代码量（根据统计减少30%的代码编写） 
```
eg:
//数据类
data class Person(var name: String?,var age: Int?)

```

- 不再使用 findViewById 
```
静态布局引入（Static Layout Import）

直接使用控件 ID 对控件进行操作findCachedViewById
```


# 二、基础
## 1.基础类型及变量定义
```
/***
a.基础类型--numbers类型
    Type 	Bit width
    Double 	64
    Float 	32
    Long 	64
    Int 	32  var a: Int = 10
    Short 	16
    Byte 	8    var a: Byte = 127
    数字之间允许用下划线分割，更方便阅读

b.基础类型-Char类型:Kotlin中Char已经不再是数字类型
    //正确申明char变量的姿势：
    var char1: Char = 'a'
    //咋把Char转成Int呀？上面说咯，toInt即可
    var a: Int = 'a'.toInt()
    
c.基础类型-Boolean 类型    val b :Boolean =true

d.Array 数组
    //利用库函数申明一个函数
    var tempArray: Array<Int> = arrayOf(1, 2, 3)
    //申明100个元素的空数组
    var tempArray1: Array<Int?> =  arrayOfNulls<Int>(100)
    //声明Int类型的数组
    val x: IntArray = intArrayOf(1, 2, 3)
 
 e.var和val关键字
    var是一个可变变量，这是一个可以通过重新分配来更改为另一个值的变量。这种声明变量的方式和java中声明变量的方式一样。
    val是一个只读变量，这种声明变量的方式相当于java中的final变量。一个val创建的时候必须初始化，因为以后不能被改变。
 */
fun testVar() {
    //定义只读局部变量使用关键字 val 定义。只能为其赋值一次。
    val a: Int = 1  // 立即赋值
    val b = 2   // 自动推断出 `Int` 类型
    val c: Int  // 如果没有初始值类型不能省略
    c = 3       // 明确赋值
    println("a = $a, b = $b, c = $c")
    //    a=2;
    //可修改的变量 var
    var v = 5 // 自动推断出 `Int` 类型
    v += 1
    println("x = $v")

}
//全局变量
val PI = 3.14
var v = 0
```
## 2.串模版 ${}
```  
println("minus=${minus(85, 62)}") 
//eg 
tvVersion.text ="v${AppUtils.getVerName(MyApplication.context)}"

````

## 3.if
```
fun useIf() {
    // 传统用法
    val a = 10
    val b = 20
    var max = a
    if (a < b) max = b 

    // if是一个表达式，即它会返回一个值
    val max2 = if (a > b) a else b

    //if的分支可以是代码块，最后的表达式作为该块的值：
    val max3 = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
}
```
## 4.for
```
fun useFor() {
    val list = listOf("apple", "banana", "kiwifruit")
    for (s in list) {
        println(s)
    }
    //会自动排除掉null
    val listnotnull = listOfNotNull(null, null, "banana", "kiwifruit")
    println(listnotnull.size)//输出2
    for (s in listnotnull) {
        println(s)
    }
    
    //迭代 map，把 key 和 value
    for ((letter, binary) in binaryReps){ //赋值给变量
        println("$letter = $binary")
    }
}

```
## 5.区间
```
val x =5
val y = 9
if (x in 1..y) {
    println("in range")
}

for (i in 1..100) { }  // 闭区间：包含 100

for (i in 1 until 100) { } // 半开区间：不包含 100 

for (i in 1..10 step 2) {
    println(i)
}

for (i in 20 downTo 1 step 5) {
    println("downTo i=$i")
}
```
## 6. when ---类智能转换
```
fun useWhen(any: Any): String = when (any) {
    "fake" -> "yes"
    1 -> "1"
    is Long -> "is long"
    is String -> any
    !is String -> "not string"
    "fake" -> "yes"
    "2","3" -> "2 or 3"
    in 1..10 -> "in 1-10"
    is String ->  "length:${any.length}"
    else -> "not find"
}
```
## 7.null 空安全
```
//当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
fun parseString(str: String): String? { 
    if (str != null) {
        return str + "x"
    }
    return null
}
fun testNull() {
    var a = parseString("x")
    var b = parseString("y")
    println(a)
    println(b)

    //直接使用报错
    //---println(a.length)
    //// 在空检测后，a 与 b 会自动转换为非空值（non-nullable）
    if (a != null) {
        println(a.length)
    }
}

//If not null 缩写
val files = File("Test").listFiles()
println(files?.size)
//If not null and else 缩写
println(files?.size ?: "empty")


```
## 8.kotlin  返回和跳转
- return 默认从最直接包围它的函数或者匿名函数返回。
- break 终止最直接包围它的循环。
- continue 继续下一次最直接包围它的循环。

 比较特别的地方：标签
```
fun main(args: Array<String>) {
    //标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点。 continue 继续标签指定的循环的下一次迭代。
    tag@ for (i in 1..10) {
        for (j in 1..10) {
            if (j == 2) break@tag
            println("i=$i  j=$j")
        }
    }
    tag@ for (i in 1..10) {
        for (j in 1..10) {
            if (j == 2) continue@tag
            println("i=$i  j=$j")
        }
    }
    
    // 1   2
    fun foo0() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // 返回到foo0
            println(it)
        }
        println(" done with explicit label")
    }
    
    // 1  2  4  5
    fun foo1() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
            print(it)
        }
        println(" done with explicit label")
    } 
    foo0()
    foo1()
}
```
## 9 常见运算符
``` 
"?" 表示可以为空，加在变量名后，系统在任何情况不会报它的空指针异常。
"!!" 非空断言表示不为空才执行，加在变量名后，如果对象为null，那么系统一定会报异！KotlinNullPointerException
"?." 安全调用运算符  s?.length 就相当于 if(s!=null) s.length else null
"?:" Elvis运算符（null合并运算符） val t:String  =  s ?:  "" //如果?:左边的值不为空返回左边的值，如果为空返回""
"as?" 安全转换运算符  object as? Person ?: return false
"as" 不安全的转换运算符 val x: String = y as String  null是不能转换为String的，如果y为null,会抛异常
"is" 与 "!is" 操作符,判断类型，智能转换
if (obj is String) {
    print(obj.length)
}

```
# 三 、函数
## 1.函数定义
```
定义格式为：可见性修饰符 fun 函数名(参数名 ：类型,...) : 返回值{}
//正常写法
fun sum(a: Int, b: Int): Int {
    return a + b
}
//单表达式函数
fun sum1(a: Int, b: Int) = a + b
override fun layoutId(): Int = R.layout.activity_splash

//Unit 就代表没有返回值
fun minus(a: Int, b: Int): Unit {
    println("${a - b}")
}
fun minus1(a: Int, b: Int) {
    println("${a - b}")
}
//函数的默认参数 foo()
fun foo(a: Int = 10, str: String = "default") {
    println("$a/" + str)
}
foo()//使用默认的参数

fun callFun(str : String, 
        isTrue : Boolean = false,
        numA : Int = 2,
        numB: Float = 2.0f,
        numC : Int = 2){}
callFun("str")
//当我们只需要部分参数时：
callFun("str",isTrue = true)

//可变数量参数
fun varargFun(numA: Int, vararg str : String){
    // ...
}
varargFun(1,"aaa","bbb","ccc","ddd","fff")
//伸展操作符( * )
val strArray = arrayOf("aaa","bbb","ccc","ddd","fff")
varargFun(1,*strArray)
```
## 2.高阶函数
```
fun test() {
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits .filter { it.startsWith("a") }
           .sortedBy { it }
           .map { it.toUpperCase() }
           .forEach { println(it) }
}


//1.filter 函数用来过滤符合条件的函数，它是数组、集合、序列等数据结构的扩展函数。
//2.map 函数把一个值映射为另一个值

fun main(args: Array<String>) {
    val list:Array<Int> = arrayOf(1,2,3,4,5,6,7,8)
    val newList = list.map {
        it*5+10
    }
    val doubleList = list.map(Int::toDouble)
    newList.forEach(::println)
    doubleList.forEach(::println)
} 
//3.reduce函数 是将list中的元素 汇总 
fun main(args: Array<String>) {
    val list = arrayOf(
            1..10,
            20..30,
            50..100
    )
 
    val mergeList = list.flatMap { it }
    mergeList.forEach(::println)
    println("总和：${mergeList.reduce(Int::plus)}")
    println("总和：${mergeList.reduce { total, i -> total + i }}")
 
}
  
fun factorial(int: Int): Int {
    if (int == 0) return 1
    return (1..int).reduce { total, i -> total * i }
}
//4.flatMap 铺平
fun main(args: Array<String>) {
    val list = arrayOf(
            1..10,
            20..30,
            50..100
    )
    val mergeList = list.flatMap {
        it.map {
            "No.$it"
        }
    }
    mergeList.forEach(::println)
} 
``` 
## 3.inline内联函数（将内联函数的函数体复制到调用处实现内联。）
调用一个方法是一个压栈和出栈的过程，调用方法时将栈针压入方法栈，然后执行方法体，方法结束时将栈针出栈，这个压栈和出栈的过程会耗费资源，这个过程中传递形参也会耗费资源。

有些简单的方法会被频繁调用，什么叫简单的方法呢，举个例子：
```
fun <T> check(lock: Lock, body: () -> T): T {
        lock.lock()
        try {
            return body()
        } finally {
            lock.unlock()
        }
}
 check(l, {"我是lambda方法体"})//l是一个Lock对象
 //对于编译器来说，调用check方法就要将参数l和lambda表达式{"我是lambda方法体"}进行传递，还要将check方法进行压栈出栈处理，这个过程就会耗费资源。
 
 //如果我们把check方法删除，直接执行check方法的方法体：
        l.lock()
        try {
            return "我是lambda方法体"
        } finally {
            l.unlock()
        }
 //再函数前面加上inline就可以解决频繁压栈出栈的问题了，编译器会在编译的时候直接回将下面的代码优化成上述代码添加在指定位置
 inline fun <T> check(lock: Lock, body: () -> T): T {
        lock.lock()
        try {
            return body()
        } finally {
            lock.unlock()
        }
    } 
```
inline 关键字应该只用在需要内联特性的函数中，比如高阶函数作为参数和具体化的类型参数时。
## 4.常见的内联函数 [内联函数](https://blog.csdn.net/u013064109/article/details/78786646#1)
- let 函数
1. 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理。

2. 然后就是需要去明确一个变量所处特定的作用域范围内可以使用
```
 <!--private var mPhotoUrl: String? = null-->
 <!--fun uploadClicked() {-->
 <!--       //第一种写法,如果mPhotoUrl为空，会报空指针KotlinNullPointerException-->
 <!--       uploadPhoto(mPhotoUrl!!)-->
        
 <!--       //第二种写法 let   mPhotoUrl不为空了执行let{}-->
 <!--       mPhotoUrl?.let {-->
 <!--           uploadPhoto(it)-->
 <!--       }-->
 <!-- }-->
 <!-- fun uploadPhoto(mPhotoUrl: String){}-->
 
 object.let{
   it.todo()//在函数体内使用it替代object对象去访问其公有的属性和方法
   ...
}

//另一种用途 判断object为null的操作
object?.let{//表示object不为null的条件下，才会去执行let函数体
   it.todo()
} 
```
- with 将某对象作为函数的参数，在函数块内可以通过 this 指代该对象

适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可
```
 with(object){
   //todo
 }
 //返回值为函数块的最后一行或指定return表达式。
 val result = with(user, {
        println("my name is $name, I am $age years old, my phone number is $phoneNum")
        1000
    })
'or'
//由于with函数最后一个参数是一个函数，可以把函数提到圆括号的外部
val result = with(user) {
        println("my name is $name, I am $age years old, my phone number is $phoneNum")
        1000
    }
    
```
- run 函数实际上可以说是let和with两个函数的结合体，run函数只接收一个lambda函数为参数，以闭包形式返回，返回值为最后一行的值或者指定的return的表达式。

适用于let,with函数任何场景。因为run函数是let,with两个函数结合体，准确来说它弥补了let函数在函数体内必须使用it参数替代对象，在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理 
```
object.run{
//todo
}   

item?.run{
      holder.tvNewsTitle.text = StringUtils.trimToEmpty(titleEn)
	   holder.tvNewsSummary.text = StringUtils.trimToEmpty(summary)
} 
```
- apply apply一般用于一个对象实例初始化的时候，需要对对象中的属性进行赋值。或者动态inflate出一个XML的View的时候需要给View绑定数据也会用到，这种情景非常常见
```
object.apply{
//todo
}

mSheetDialogView = View.inflate(activity, R.layout.biz_exam_plan_layout_sheet_inner, null).apply{
   course_comment_tv_label.paint.isFakeBoldText = true
   course_comment_tv_score.paint.isFakeBoldText = true
   course_comment_tv_cancel.paint.isFakeBoldText = true
   course_comment_tv_confirm.paint.isFakeBoldText = true
   course_comment_seek_bar.max = 10
   course_comment_seek_bar.progress = 0

}   
```
- also also函数的结构实际上和let很像唯一的区别就是返回值的不一样，let是以闭包的形式返回，返回函数体内最后一行的值，如果最后一行为空就返回一个Unit类型的默认值。而also函数返回的则是传入对象的本身
```
object.also{
//todo
}
//返回的是name.length
open val size: Int = 
        name.length.also { println("Initializing size in Base: $it") }
```
## 5.函数-闭包
- 普通函数（普通函数不携带状态，调用完毕后里面所有的内容就会被释放掉。）
```
fun test(){
    var a=3
    println(a);
}

fun main(args: Array<String>) {
    test()
}
```


- 闭包函数（让函数可以携带状态，函数里面声明函数，函数里面返回函数，就是闭包）
```
//返回值是一个函数()->Unit  其中 ()代表该函数没有参数，Unit代表该函数没有返回值
fun test():()->Unit{
    var a=3 //状态
    return  fun(){
        a++;
        println(a);
    }
}

fun main(args: Array<String>) {
    var t=test()
    t();
    t();
    t();
}
```
## 6.扩展
Kotlin的扩展函数可以让你作为一个类成员进行调用的函数，但是是定义在这个类的外部。
- 扩展函数
```
//定义一个String的扩展方法times,打印t次
    fun String.times(t:Int){
        for (i in 0 until t) {
            println(this)
        }
    }
```
- 扩展属性（扩展属性必须定义get和set方法）
```
    //给String中扩展一个Int类型的length1的属性
    var String.length1: Int
    get() = this.length
    set(value){
        //set方法并没有field可以用来存储value，
        //其实际作用是使用通过value来操作调用者，即this
        println(this.plus(value))
    }
    //调用： println("kotlin".length1)
    
    //eg：扩展ViewGroup属性获取子view 的集合
    val ViewGroup.children: List
    get() = (0..childCount -1).map { getChildAt(it) }
```
## 7.变长参数 vararg
变长参数类似数组，使用vararg关键字标识，同java相似，但又有区别，首先java中的变长参数只能声明在方法形参的末尾，但在kotlin中因为可以使用具名参数来调用方法，所以变长参数可以声明在形参的任意位置
```
fun main(args:Array<String>){
    printArray(3,"H","ello"," world",arg2 = "OK")
}
fun printArray(arg1:Int,vararg array:String,arg2:String){
    println("arg1=$arg1")
    array.forEach (::print)
    println("\narg2=$arg2")
}
```
另外在给变长参数传递实参时，我们也可以直接传递一个数组名，使用spread操作符
"*" 可以将此数组自动展开传入，如上面的代码在调用printArray方法时也可以这样写：
```
val s = arrayOf("H","ello"," world")
printArray(3,*s,arg2 = "OK")
```

# 四 、类和对象

## 1.构造函数
```
主构造函数
class Person { ... }
class Person (name: String) { ... }
class Person constructor(name: String) { ... }
class Person public @Inject constructor(name: String) { …… }
次构造函数，如果有主构造函数，次构造函数需要委托给主构造函数，通过this
constructor(name: String,age : Int) : this(name) {
      
}
```
## 2.构造函数执行顺序
```
class Person {
    /*构造1*/
    constructor() {
        println("constructor1")
    }
    /*属性*/
    private var gender: Boolean = true
    /*构造2*/
    constructor(name: String, age: Int) : this() {
        println("constructor2")
    }
    /*初始化代码块*/
    init {
        println("Person init 2,gender:${gender}")
    }
    /*初始化代码块*/
    init {
        println("Person init 1")
    }
} 
//调用Person()，执行结果
    Person init 2,gender:true
    Person init 1
    constructor1
//调用Person("xx",1)，执行结果
    Person init 2,gender:true
    Person init 1
    constructor1
    constructor2


//添加了伴生对象之后的执行顺序
class Person {

    /*构造1*/
    constructor() {
        println("constructor1")
    }

    /*属性*/
    private var gender: Boolean = true

    /*伴生对象*/
    companion object {
        val instance: Person by lazy {
            Person("yzq", 26)
        }

        /*伴生对象中的初始化代码*/
        init {
            println("companion init 1")
        }

        init {
            println("companion init 2")
        }
    }

    /*构造2*/
    constructor(name: String, age: Int) : this() {
        println("constructor2")
    }

    /*初始化代码块*/
    init {
        println("Person init 2,gender:${gender}")
    }

    /*初始化代码块*/
    init {
        println("Person init 1")
    }
} 
//调用Person("xx",1)，执行结果
    companion init 1
    companion init 2
    Person init 2,gender:true
    Person init 1
    constructor1
    constructor2
//调用Person.instance执行结果
    companion init 1
    companion init 2
    Person init 2,gender:true
    Person init 1
    constructor1
    constructor2
    

//继承下的执行顺序-->应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。
    open class Base(val name: String) {
        init { println("Initializing Base") }
        open val size: Int = 
            name.length.also { println("Initializing size in Base: $it") }
    }
    
    class Derived( name: String, val lastName: String) :Base(name.capitalize().also { println("Argument for Base: $it") }) {
        init { println("Initializing Derived") }
        override val size: Int =
            (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
    }
    //调用  Derived("kotlin","china")输出结果
    Argument for Base: Kotlin
    Initializing Base
    Initializing size in Base: 6
    Initializing Derived
    Initializing size in Derived: 11
    
```

## 3.继承

```
//Kotlin 中所有类都继承该 Any 类，它是所有类的超类
    class Example // 从 Any 隐式继承

//如果一个类要被继承，可以使用 open 关键字进行修饰。
//eg: 基类
    open class Person(var name : String, var age : Int){
    
    }
//子类有主构造函数-->基类必须在主构造函数中立即初始化。
    class Student(name : String, age : Int, var no : String, var score : Int) : Person(name, age) {
    
    }
//子类没有主构造函数-->必须在每一个二级构造函数中用 super 关键字初始化基类
    class Student:Person{
       /**次级构造函数**/
        constructor(name:String,age:Int,no:String,score:Int):super(name,age){
        }
    }

//方法重写，方法修饰为open才可以被重写
    open class Color {
        open fun name() {
            println("red")
        }
        fun type() {
            println("7 ColorS")
        }
    }
    class Blue: Color() {
        override fun name() {
            println("blue")
        }
    }
//属性重写,属性修饰为open才可以被重写
    open class MyParent {
        open val name: String = "parent"
    }
    
    class MyChild: MyParent() {
        override val name: String = "child";
    }

```
## 3.对象
a.对象表达式
```
textView.setOnClickListener(object : OnClickListener {
        override fun onClick(p0: View?) {
           
        }
})
//任何时候，如果我们只需要“一个对象而已”，那么我们可以简单地写：
fun foo() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
}

```
b.对象声明-单列
```
//Kotlin 中我们可以方便的通过对象声明来获得一个单例。用object 修饰的类为静态类，里面的方法和变量都为静态的
object PowerManager {
    fun getPower() {

    }
}
//使用： PowerManager.getPower()
```
c.对象声明-伴生对象

一个类最多只有一个伴生对象，类似于java 的static  ，类内部的对象声明，没有被inner 修饰的内部类都是静态的

```
class Test {
    companion object A（名字可以省略）{  
        //const val 可见性为public final static，可以直接访问。
        //val 可见性为private final static,会提供get方法
        const val name = "kotlin"
        var flag = false
        
        fun plus(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    }
    //调用
    fun main(args: Array<String>) {
        println(Test.plus(1, 2))  // 3
        println(Test.flag)  // false
    }
} 

```
## 4.属性声明   get set 使用
```
var <propertyName>[: <PropertyType>] [= <property_initializer>]
    [<getter>]
    [<setter>]
```
set和get可写也可不写, 不写的话会有默认的实现, 需要注意的是val修饰的变量是没有set方法的, 也不允许重写set方法
```
class Student {
    var name : String = "zhang"
        // 这里使用field(幕后字段)而不是使用name, 是因为如果使用name会造成递归调用从而造成内存溢出, 因为使用lastName也会涉及到调用set/get的问题
        get() = field.toUpperCase()
 
    var no : Int = 0
        get() = field
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }
 
    var classTeacher : String? = "孔子"
        set(value) = if (value == null) {
            field = "孔圣人"
        } else {
            field = value
        }
 
    var isKZ : Boolean = true
        get() {
            return this.classTeacher == "孔圣人"
        }
        
    // className属性的setter是私有的不能被赋值,  通过这种方式我们可以禁止某些属性被修改
    var className : String ? = "1班"
        private set
}
 
fun main(args: Array<String>) {
    var stu: Student = Student()
 
    stu.name = "wang"
    println("lastName:${stu.name}")
 
    stu.no = 9
    println("no:${stu.no}")
 
    stu.no = 20
    println("no:${stu.no}")
 
    stu.classTeacher = null
    println(stu.classTeacher)
    println(stu.isKZ)
 
    stu.className = "一年一班"
    println(stu.className)
}

以上的代码运行结果如下:
lastName:WANG
no:9
no:-1
孔圣人
true
一年一班


//get方法不能随便定义成private的,  需要和变量的可见范围是一样的, 如果变量是public的, 那么get是不能设置成private的例如
var className : String ? = "1班"
        private set
        private get//报错
```
## 5.接口
```
//Kotlin 的接口与 Java 8 (default)类似，既包含抽象方法的声明，也包含实现
interface MyInterface {
    // 抽象的
    val prop: Int 
    //提供访问器
    val propertyWithImplementation: String
        get() = "foo"
        
    fun bar()
    
    fun foo() {
        print(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29
    override fun bar() {
        // 方法体
    }
}
```

## 6.数据类
在Kotlin中一些只保存数据的类,称为数据类(data class),
为了确保自动生成的代码一致性和有意义,数据类(data class)必须满足以下要求:
    主构造函数至少有一个参数;
    主构造函数的所有参数需标记为val 或 var;
    数据类不能是抽象、开放、密封或者内部的; 

数据类(data class)的语法实例: 
    data class User(val name: String, val age: Int)
```
    编译器会为数据类(data class)自动生成以下函数:
        equals()/hashCode()
        toString() 默认输出"User(name=John, age=42)"
        componentN() 按声明顺序对应于所有属性
        copy()

    如果数据类需要无参构造函数,则所有属性必须有默认值:
    data class User(val name: String = "", val age: Int = 0) 
```
## 7.密封类
```
/**
 * 密封类
 * 1.密封类用sealed关键词表示
 * 2.密封类的子类只能定义在密封类的内部或同一个文件中，因为其构造方法为私有的
 * 3.密封类相比于普通的open类，可以不被此文件外被继承，有效保护代码
 * 4.与枚举的区别：密封类适用于子类可数的情况，枚举适用于实例可数的情况
 */
 sealed class SealedClass {
    class SonClass1 : SealedClass() {}
    class SonClass2 : SealedClass() {}
    class SonClass3 : SealedClass() {}
}
//你会发现when结构中少了else分支。对因为在密封类中已经列出了所有的密封类的所有子类，所以就不会有else的情况。这样之后，你每次增加一个子类，when结构就会检查到你增加了子类，就必须要给when结构添加一个分支，否则就会编译报错，这样就把潜在的问题消灭在了编译阶段。
fun check(sealedClass: SealedClass): String = when (sealedClass) {
    is SealedClass.SonClass1 -> "1"
    is SealedClass.SonClass2 -> "2"
    is SealedClass.SonClass3 -> "2"
} 
//Kotlin中的密封类的出现，在于它定义了一种受限的类继承结构，可以保证我们写出更安全的代码。
```

## 8.嵌套类与内部类
- 嵌套类
```
class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
        //内部不能访问bar
    }
}
val demo = Outer.Nested().foo() // == 2
```
- 内部类 inner 

类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：
```
class Outer {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}
val demo = Outer().Inner().foo() // == 1
```
- 匿名内部类 
```
//对象表达式创建的----配置log策略
Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
})
  //声明内部类
  private val logStrategy= object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
  }

```
## 9.泛型中的 in（逆变） 和 out（协变）
- in（逆变）

如果你的类是将泛型对象作为内部方法的参数，那么可以用in
```
interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V) 

}
//consume = input = in。
```
- out(协变)

如果你的类是将泛型对象作为内部方法的返回类型，那么可以用out
```
interface Production<out T> {
    fun produce(): T
}
//produce = output = out。
```

- Invariant(不变)

如果既将泛型作为函数参数，又将泛型作为函数的输出，那就既不用 in 或 out。
```
interface ProductionConsumer<T> {
    fun produce(): T
    fun consume(item: T)
}
```
总结：

父类泛型对象可以赋值给子类泛型对象，用 in

子类泛型对象可以赋值给父类泛型对象，用 out。



## 10.延迟初始化( by lazy, lateinit )
```
//在初始化的时候无法赋值，可以这么写
private lateinit var mAdapter: RecyclerAdapter<Transaction>
//或者
var mAdapter: RecyclerAdapter<Transaction> by Delegates.notNull()
 
override fun onCreate(savedInstanceState: Bundle?) {
   super.onCreate(savedInstanceState)
   mAdapter = RecyclerAdapter(R.layout.item_transaction)
}

//lateinit 和 lazy 是 Kotlin 中的两种不同的【延迟初始化】的实现
//1.lateinit 只用于变量 var，而 lazy 只用于常量 val
//2.lateinit不能用在可空的属性上和java的基本类型上

 private val mPresenter by lazy { HomePresenter() }
 'or'
 private val mUserMannager: UserMannager by lazy {
        UserMannager.getInstance()
    }
 
```


## 11、集合List、Set、Map
Kotlin 区分集合（lists、sets、maps 等）的可变与不可变视图,MutableList<T>/List<out T>
- List      listOf()、 mutableListOf()
```
  //可变
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    numbers.add(4)
    numbers.clear()
    //不可变--协变的
    val readOnlyView: List<Int> = numbers
    readOnlyView.add() // -> 不能编译 
    readOnlyView.clear() // -> 不能编译  
```
- Set 和list相似
```
val strings = hashSetOf("a", "b", "c", "c")
```
- Map
``` 
val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
println(readWriteMap["foo"])  // 输出“1”
```





# 五、协同程序--coroutines kotlin支持1.3
 implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1'


### 参考链接
[kotlin 学习地址-官方](https://www.kotlincn.net/docs/reference/)

[kotlin 学习地址](http://www.runoob.com/kotlin/kotlin-class-object.html)

[2019 Google Io 大会](https://www.infoq.cn/article/qt51vqATE7jf_bpw5ggJ)

by lhp













