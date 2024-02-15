import org.scalatest.funsuite.AnyFunSuite

class TestArithmeticExpression extends AnyFunSuite {

  test("evaluate method should calculate the correct result") {
    val expr0 = ArithmeticExpression.Num(42)
    val expr1 = ArithmeticExpression.Minus(ArithmeticExpression.Num(42))
    val expr2 = ArithmeticExpression.Plus(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr3 = ArithmeticExpression.Mult(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr4 = ArithmeticExpression.Div(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr5 = ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr6 = ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(-1))

    assert(ArithmeticExpression.evaluate(expr0) == 42.0)
    assert(ArithmeticExpression.evaluate(expr1) == -42.0)
    assert(ArithmeticExpression.evaluate(expr2) == 6.0)
    assert(ArithmeticExpression.evaluate(expr3) == 8.0)
    assert(ArithmeticExpression.evaluate(expr4) == 0.5)
    assert(ArithmeticExpression.evaluate(expr5) == 16.0)
    assert(ArithmeticExpression.evaluate(expr6) == 0.5)
  }

  test("pretty method should format the expression in infix notation") {
    val expr0 = ArithmeticExpression.Num(42)
    val expr1 = ArithmeticExpression.Minus(ArithmeticExpression.Num(42))
    val expr2 = ArithmeticExpression.Plus(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr3 = ArithmeticExpression.Mult(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr4 = ArithmeticExpression.Div(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr5 = ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr6 = ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(-1))

    assert(ArithmeticExpression.pretty(expr0) == "42")
    assert(ArithmeticExpression.pretty(expr1) == "(-42)")
    assert(ArithmeticExpression.pretty(expr2) == "(2 + 4)")
    assert(ArithmeticExpression.pretty(expr3) == "(2 * 4)")
    assert(ArithmeticExpression.pretty(expr4) == "(2 / 4)")
    assert(ArithmeticExpression.pretty(expr5) == "2 ^ 4")
    assert(ArithmeticExpression.pretty(expr6) == "2 ^ -1")
  }

  test("new evaluate method should return the evaluations of each expression from the given list") {
    val expressions = List(
      ArithmeticExpression.Num(42),
      ArithmeticExpression.Minus(ArithmeticExpression.Num(42)),
      ArithmeticExpression.Plus(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4)),
      ArithmeticExpression.Mult(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4)),
      ArithmeticExpression.Div(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4)),
      ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4)),
      ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(-1)))

    val expectedEvaluations = List(42.0, -42.0, 6.0, 8.0, 0.5, 16.0, 0.5)

    assert(ArithmeticExpression.evaluate(expressions)equals(expectedEvaluations))
  }

  test("new showResults method should format the given expressions in infix notation") {
    val expressions = List(
      ArithmeticExpression.Num(42),
      ArithmeticExpression.Minus(ArithmeticExpression.Num(42)),
      ArithmeticExpression.Plus(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4)),
      ArithmeticExpression.Mult(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4)),
      ArithmeticExpression.Div(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4)),
      ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4)),
      ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(-1)))

    val expectedResult =
      "42 = 42.0\n"
        + "(-42) = -42.0\n"
        + "(2 + 4) = 6.0\n"
        + "(2 * 4) = 8.0\n"
        + "(2 / 4) = 0.5\n"
        + "2 ^ 4 = 16.0\n"
        + "2 ^ -1 = 0.5"
    assert(ArithmeticExpression.showResults(expressions) == expectedResult)
  }
}