package src.main.java.bkp.designpattern.behavioral.chainofresponsibility.fix;

import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletRequest;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletResponse;

public class CorsFilter extends AbstractFilter {

  @Override
  public void doFilter(HttpServletRequest request, HttpServletResponse response) {
    // Write business logic to check if request is cross-origin
    System.out.println("In CORS filter...");

    if (nextFilter != null) {
      nextFilter.doFilter(request, response);
    }
  }
}
