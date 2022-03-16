fun main() {
    try {
        doSomethingWhichThrowsException(5)
        println("OK") // incorrect "OK" message is printed
    } catch (e: RuntimeException) {
        println("ERROR") // this message is not shown
    }
    try {
        doSomethingThatAlsoThrowsException(5)
        println("OK") // incorrect "OK" message is printed
    } catch (e: RuntimeException) {
        println("ERROR") // this message is not shown
    }
}

fun doSomethingWhichThrowsException(q: Int) {
    try {
        throw RuntimeException()
    } finally {
        //...
        if (someOtherCondition) {
            return  // Noncompliant - prevents the RuntimeException from being propagated
        }
        if (aLastConditionIsVerified) {
            throw IllegalStateException()  // Noncompliant - prevents the RuntimeException from being propagated
        }
    }
}

fun doSomethingThatAlsoThrowsException(q: Int) {
    while (someConditionIsVerified) {
        try {
            throw RuntimeException()
        } finally {
            //...
            if (someOtherCondition) {
                continue  // Noncompliant - prevents the RuntimeException from being propagated
            }
            break  // Noncompliant - prevents the RuntimeException from being propagated
        }
    }
}