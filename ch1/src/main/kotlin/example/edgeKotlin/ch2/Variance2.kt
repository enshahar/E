package example.edgeKotlin.ch2.variance2

class Container<out T>(val value: T) {
    //val x: ContravariantContainer<T> = ContravariantContainer(value) // (1)
    //Type parameter T is declared as 'out' but occurs in 'in' position in type ContravariantContainer<T>
}
class ContravariantContainer<in T>(private var _value: T) {
    fun setValue(v: T) {
        _value = v
    }
}

