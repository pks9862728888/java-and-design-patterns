package src.main.java.bkp.designpattern.behavioral.chainofresponsibility.problem.filters;

import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletRequest;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletResponse;

public class AuthenticationFilter implements IFilter {

  @Override
  public void doFilter(HttpServletRequest request, HttpServletResponse response) {
    // Write business logic to authenticate user
    System.out.println("In authentication filter...");
//    request.setFiltered(true);
  }
}
