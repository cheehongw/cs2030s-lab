abstract class Operation extends Expression {
  private Expression x;
  private Expression y;

  public Expression getX() {
    return this.x;
  }

  public Expression getY() {
    return this.y;
  }

  public Operation(Expression x, Expression y) {
    this.x = x;
    this.y = y;
  }

  public static Operation of(char c, Expression x, Expression y) {
    if (c == '*') {
      return new TimesOperation(x, y);
    } else if (c == '+') {
      return new ConcatOperation(x, y);
    } else if (c == '^') {
      return new XorOperation(x, y);
    }
    return null;
  }
}
