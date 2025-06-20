package src.main.java.bkp.designpattern.behavioral.chainofresponsibility.fix;

import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletRequest;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletResponse;

public class WithChainOfResponsibilityPattern {

  public static void main(String[] args) {
    // Create filter chain
    AbstractFilter filterChain = new AuthenticationFilter();
    filterChain.setNext(new CorsFilter());
    // Prepare request and response object for demo (spring framework will create it automatically for us)
    HttpServletRequest request = new HttpServletRequest();
    HttpServletResponse response = new HttpServletResponse();
    // Send the request through filter chain, each filter either filters the req, or forwards to next
    filterChain.doFilter(request, response);
    // If request is not filtered, then process the request
    if (request.isFiltered()) {
      System.out.println("Request is filtered, so no work will be done...");
    } else {
      System.out.println("Request is not filtered, so do some work as per request....");
    }
  }
}
