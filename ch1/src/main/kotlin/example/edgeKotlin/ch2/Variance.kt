package example.edgeKotlin.ch2.variance

class Container<out T>(val value: T)
class InvariantContainer<T>(val value: T)

fun printAnyContainer(container: Container<Any>) = println(container.value)

fun printInvariantContainer(container: InvariantContainer<Any>) = println(container.value)

fun main() {
    val anyContainer = Container<Any>("string value")
    val intContainer = Container<Int>(1)

    printAnyContainer(anyContainer)
    printAnyContainer(intContainer)

    val anyContainer2 = InvariantContainer<Any>("string value")
    val intContainer2 = InvariantContainer<Int>(1)

    printInvariantContainer(anyContainer2)
    //printInvariantContainer(intContainer2)   // type mismatch
}

