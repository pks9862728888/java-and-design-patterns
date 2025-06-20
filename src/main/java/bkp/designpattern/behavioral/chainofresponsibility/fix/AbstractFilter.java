package src.main.java.bkp.designpattern.behavioral.chainofresponsibility.fix;

import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletRequest;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletResponse;

public abstract class AbstractFilter {

  protected AbstractFilter nextFilter = null;

  public abstract void doFilter(HttpServletRequest request, HttpServletResponse response);

  public AbstractFilter setNext(AbstractFilter nextFilter) {
    this.nextFilter = nextFilter;
    return nextFilter;
  }
}
