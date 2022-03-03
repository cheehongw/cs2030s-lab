class XorOperation extends Operation {
  public XorOperation(Expression x, Expression y) {
    super(x, y);
  }

  @Override
  public Object eval() {
    Object objX = this.getX().eval();
    Object objY = this.getY().eval();
    if (objX instanceof Boolean && objY instanceof Boolean) {
      boolean x = (Boolean) objX;
      boolean y = (Boolean) objY;
      return x ^ y;
    } else {
      throw new InvalidOperandException('^');
    }
  }
}
