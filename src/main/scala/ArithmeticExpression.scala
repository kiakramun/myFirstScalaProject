enum ArithmeticExpression {
  case Num(value: Int) extends ArithmeticExpression
  case Minus(expression: ArithmeticExpression) extends ArithmeticExpression
  case Plus(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression
  case Mult(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression
  case Div(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression
  case Pow(base: ArithmeticExpression, exponent: ArithmeticExpression) extends ArithmeticExpression
}