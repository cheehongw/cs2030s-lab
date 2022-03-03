class TimesOperation extends Operation {
  public TimesOperation(Expression x, Expression y) {
    super(x, y);
  }

  @Override
  public Object eval() {
    Object objX = this.getX().eval();
    Object objY = this.getY().eval();
    if (objX instanceof Integer && objY instanceof Integer) {
      int x = (Integer) objX;
      int y = (Integer) objY;
      return x * y;
    } else {
      throw new InvalidOperandException('*');
    }
  }
}

