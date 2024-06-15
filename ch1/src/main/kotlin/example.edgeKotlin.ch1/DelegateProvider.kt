package example.edgeKotlin.ch1.delegateProvider

import kotlin.reflect.KProperty

interface FieldProvider {
    val fields: MutableMap<String, Long>

    fun printFields() {
        println("Object: ${this}")
        if(fields.isEmpty())
            println("\tNo fields")
        else
            fields.forEach { (k, v) -> println("\t$k -> $v") }
    }
}

class LongDelegate private constructor(val provider: FieldProvider) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return provider.fields[property.name] ?: throw IllegalArgumentException("Unknown field")
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        provider.fields[property.name] =  value
    }
    companion object {
        operator fun provideDelegate(thisRef: FieldProvider, property: KProperty<*>): LongDelegate { // 1
            println("setting up delegate for ${property.name}")
            return LongDelegate(thisRef)
        }
    }
}

class X() : FieldProvider {
    override val fields: MutableMap<String, Long> = mutableMapOf()
    var first:Long by LongDelegate   // (1)
    var second:Long by LongDelegate.Companion
}

fun main() {
    val y = X()
    y.first = 10
    y.printFields()           // (5)
}