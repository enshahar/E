package example.edgeKotlin.ch1.tableExample

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


abstract class TABLE:ReadWriteProperty<TABLE,Any?> {
    override fun getValue(thisRef: TABLE, property: KProperty<*>): Any? {
        TODO("Not yet implemented")
    }

    override fun setValue(thisRef: TABLE, property: KProperty<*>, value: Any?) {
        TODO("Not yet implemented")
    }

    inline val string get() = this as ReadWriteProperty<TABLE,String>
    inline val long get() = this as ReadWriteProperty<TABLE,Long>
}

class TABLE1 : TABLE() {
    var rowid by long
    var name by string
}

fun main() {
    val x = TABLE1().also { table ->
        table.rowid = 1
    }

    println(x.rowid)
}