package example.edgeKotlin.ch1.tableExample2

import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


abstract class TABLE:ReadWriteProperty<TABLE,Any?>, PropertyDelegateProvider<TABLE,ReadWriteProperty<TABLE,*>> {
    override fun getValue(thisRef: TABLE, property: KProperty<*>): Any? {
        TODO("Not yet implemented")
    }

    override fun setValue(thisRef: TABLE, property: KProperty<*>, value: Any?) {
        TODO("Not yet implemented")
    }

    override fun provideDelegate(thisRef: TABLE, property: KProperty<*>): ReadWriteProperty<TABLE,*> {
        println("provideDelegate: ${property.name} ${property.returnType}")
        return this
    }

    val string get() = this as PropertyDelegateProvider<TABLE,ReadWriteProperty<TABLE,String>>
    val long get() = this as PropertyDelegateProvider<TABLE,ReadWriteProperty<TABLE,Long>>
}

class TABLE1 : TABLE() {
    var rowid by long
    var name by string
}

fun main() {
    val x = TABLE1()
}