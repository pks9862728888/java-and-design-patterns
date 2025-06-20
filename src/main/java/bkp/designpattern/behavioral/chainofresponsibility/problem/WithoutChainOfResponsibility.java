package src.main.java.bkp.designpattern.behavioral.chainofresponsibility.problem;

import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletRequest;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletResponse;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.problem.filters.AuthenticationFilter;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.problem.filters.CorsFilter;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.problem.filters.IFilter;

import java.util.Arrays;
import java.util.List;

public class WithoutChainOfResponsibility {

  private static final List<IFilter> filterChain =
      Arrays.asList(new AuthenticationFilter(), new CorsFilter());

  public static void main(String[] args) {
    HttpServletRequest request = new HttpServletRequest();
    HttpServletResponse response = new HttpServletResponse();
    if (shouldFilter(request, response)) {
      System.out.println("Request is filtered, so no work will be done...");
    } else {
      System.out.println("Request is not filtered, so do some work as per request....");
    }
  }

  private static boolean shouldFilter(HttpServletRequest request, HttpServletResponse response) {
    // So here client is responsible for manually delegating request to next filter...
    for (IFilter filter : filterChain) {
      filter.doFilter(request, response);
      // isFiltered state is stored in request, and we have to check manually and pass to next filter
      if (request.isFiltered()) {
        break;
      }
    }
    return request.isFiltered();
  }
}
