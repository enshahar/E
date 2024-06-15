package example.edgeKotlin.ch1.kProperty

import kotlin.reflect.*

// 최상위 프로퍼티
val topVal = "topVal"
val topVar = "topVar"

class Z {
}

// 일반적인 클래스 정의
class X {
    // 프로퍼티 선언
    val valProp = "valProp"
    var varProp = "varProp"

    // 확장 프로퍼티
    val Z.valExtProp: String
        get() = "X::Z.valExtProp"

    inner class Y {
        // 내부 클래스의 프로퍼티 선언
        val valProp = "valProp"
        var varProp = "varProp"
    }
}

inline fun <reified T> checkPropType(prop: KProperty<T>) {
    println("KProperty<${T::class.simpleName}>")
}
inline fun <reified T> checkPropType(prop: KMutableProperty<T>) {
    println("KMutableProperty<${T::class.simpleName}>")
}
inline fun <reified T> checkPropType(prop: KProperty0<T>) {
    println("KProperty0<${T::class.simpleName}>")
}
inline fun <reified T> checkPropType(prop: KMutableProperty0<T>) {
    println("KMutableProperty0<${T::class.simpleName}>")
}
inline fun <reified T, reified V> checkPropType(prop: KProperty1<V,T>) {
    println("KProperty1<${V::class.simpleName},${T::class.simpleName}>")
}
inline fun <reified T, reified V> checkPropType(prop: KMutableProperty1<V,T>) {
    println("KMutableProperty1<${V::class.simpleName},${T::class.simpleName}>")
}
inline fun <reified T, reified V, reified W> checkPropType(prop: KProperty2<V,W,T>) {
    println("KProperty1<${V::class.simpleName},${W::class.simpleName},${T::class.simpleName}>")
}
inline fun <reified T, reified V, reified W> checkPropType(prop: KMutableProperty2<V,W,T>) {
    println("KMutableProperty1<${V::class.simpleName},${W::class.simpleName},${T::class.simpleName}>")
}

fun main() {
    // 최상위 프로퍼티 참조
    checkPropType(::topVal)
    checkPropType(::topVar)

    // 프로퍼티 참조
    checkPropType(X::valProp)
    checkPropType(X::varProp)
    checkPropType(X.Y::valProp)
    checkPropType(X.Y::varProp)

    val x = X()

    checkPropType(x::valProp)
    checkPropType(x::varProp)

    // iterate over X's properties
    X::class.members.forEach { member ->
        when(member) {
            is KProperty2<*,*,*> -> {
                val m = member as KProperty2<*,*,*>
                println("${member.name} is a KProperty2. ${m.parameters.size} parameters ${m.typeParameters.size} type parameters ${m.returnType} return type")
            }
            is KProperty1<*,*> -> {
                println("${member.name} is a KProperty1")
            }
            is KProperty0<*> -> {
                println("${member.name} is a KProperty0")
            }
            is KProperty<*> -> {
                println("${member.name} is a KProperty")
            }
            else -> {
                println("${member.name} is not a KProperty")
            }
        }
    }
}