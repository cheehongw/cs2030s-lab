class InvalidOperandException extends RuntimeException {
  public InvalidOperandException(char operator) {
    super("ERROR: Invalid operand for operator " + operator);
  }
}
