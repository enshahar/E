package example.edgeKotlin.ch2.variance3

class Container<out T>(val value: T) {
    //operator fun contains(value: T): Boolean = value == this.value
    //Type parameter T is declared as 'out' but occurs in 'in' position in type T
}

