package example.edgeKotlin.ch2.inOutInDetail

class Container<in T, out R>(value1: T, value2: R, f1:(T)->R, f2:(R)->T) {  // (1)
    private fun foo(value1: T, value2: R, f1:(T)->R, f2:(R)->T):T = TODO()  // (2)

    private val p1: Container2<R,T> = TODO()                                // (3)
    //val p2: Container2<R,T> = TODO()                                      // (4)
    val p3: Container2<T,R> = TODO()                                        // (5)

    //fun bar(value1: T, value2: R, f1:(T)->R, f2:(R)->T):T = TODO()        // (6)
    //val x: Container2<Container2<T,R>,Container2<T,R>> = TODO()           //  (7)
}

class Container2<in In,out Out>
