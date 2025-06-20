package src.main.java.bkp.designpattern.behavioral.chainofresponsibility.problem.filters;

import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletRequest;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletResponse;

public class CorsFilter implements IFilter {

  @Override
  public void doFilter(HttpServletRequest request, HttpServletResponse response) {
    // Write business logic to check if request is cross origin
    System.out.println("In CORS filter...");
  }
}
