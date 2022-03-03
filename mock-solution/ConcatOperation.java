class ConcatOperation extends Operation {
  public ConcatOperation(Expression x, Expression y) {
    super(x, y);
  }

  @Override
  public Object eval() {
    Object objX = this.getX().eval();
    Object objY = this.getY().eval();
    if (objX instanceof String && objY instanceof String) {
      String x = (String) objX;
      String y = (String) objY;
      return x + y;
    } else {
      throw new InvalidOperandException('+');
    }
  }
}

