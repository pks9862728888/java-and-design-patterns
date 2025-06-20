package src.main.java.bkp.designpattern.behavioral.chainofresponsibility.fix;

import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletRequest;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletResponse;

public class AuthenticationFilter extends AbstractFilter {

  @Override
  public void doFilter(HttpServletRequest request, HttpServletResponse response) {
    // Write business logic to authenticate user
    System.out.println("In authentication filter...");

    // If you want to filter request, directly return from here
//    if (true) {
//      request.setFiltered(true);
//      return;
//    }

    if (nextFilter != null) {
      nextFilter.doFilter(request, response);
    }
  }
}
