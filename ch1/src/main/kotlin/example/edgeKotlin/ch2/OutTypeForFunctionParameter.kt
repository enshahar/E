package example.edgeKotlin.ch2.outTypeForFunctionParameter

class Container<out T>(val v:T) {
    fun check(block: (T)->Boolean): Boolean = block(v)
    fun <T> T.contains(): Boolean = check{this == v}
}

fun <T> Container<T>.contains(value: T) = value == v

sealed interface IntOrBool
@JvmInline value class I(val v: Int): IntOrBool
@JvmInline value class B(val v: Int): IntOrBool
