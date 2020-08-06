package com.oklimenko.payment.exception;

/**
 * Top level parent exception class for all business related exceptions of service pay application.
 */
public class PaymentSystemServiceException extends RuntimeException {

  public PaymentSystemServiceException(String message) {
    super(message);
  }

  public PaymentSystemServiceException(String message, Throwable cause) {
    super(message, cause);
  }
}
