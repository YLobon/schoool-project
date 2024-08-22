package com.luna.school.config;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-07-01 1:57 p.m..
 */
public class Sms {
    private String to;
    private String message;

    public String getTo() {
      return to;
    }

    public void setTo(String to) {
      this.to = to;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }


    @Override
    public String toString() {
      return "SMS{" +
          "to='" + to + '\'' +
          ", message='" + message + '\'' +
          '}';
    }

}
