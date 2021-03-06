// FILE: 1.kt
// SKIP_INLINE_CHECK_IN: inlineFun$default
package test

open class A(val value: String)

class B(value: String): A(value)

@Suppress("NOT_YET_SUPPORTED_IN_INLINE")
inline fun <T : A> inlineFun(capturedParam: T, lambda: () -> T = { capturedParam }): T {
    return lambda()
}

// FILE: 2.kt

import test.*

fun box(): String {
    return inlineFun(B("O")).value + inlineFun(A("K")).value
}