def foo(a: Int) {
  val i = 10;
  return a + i;       // Noncompliant
  bar;                // dead code
}
