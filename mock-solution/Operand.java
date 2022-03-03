class Operand extends Expression {
  private Object o;
  public Operand(Object o) {
    this.o = o;
  }

  public Object eval() {
    return this.o;
  }
}
