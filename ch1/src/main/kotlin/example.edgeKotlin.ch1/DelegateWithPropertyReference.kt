package example.edgeKotlin.ch1.delegateUsingPropertyReference

import kotlin.reflect.KProperty

interface FieldProvider {                 // (1)
    val fields: MutableMap<String, Long>

    fun printFields() {                  // (2)
        println("Object: ${this}")
        if(fields.isEmpty())
            println("\tNo fields")
        else
            fields.forEach { (k, v) -> println("\t$k -> $v") }
    }
}

class LongDelegate(val provider: FieldProvider, property: KProperty<*>) {  // (3)
    init {
        println("longDelegate init: ${property.name}")
    }
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return provider.fields[property.name] ?: throw IllegalArgumentException("Unknown field")
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        provider.fields[property.name] =  value
    }
}

class X() : FieldProvider {
    override val fields: MutableMap<String, Long> = mutableMapOf()
    var first:Long by LongDelegate(this, X::first)   // (4)
    var second:Long by LongDelegate(this, X::second)
}

fun main() {
    val y = X()
    y.first = 10
    y.printFields()           // (5)
}