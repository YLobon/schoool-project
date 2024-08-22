package com.luna.school.tools;

/**
 * <p> {@link  } .</p>
 *
 * @author BOUA YVES 2024-06-29 10:01 a.m..
 */
public class Pair<F,S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
      this.first = first;
      this.second = second;
    }

    public F getFirst() {
      return first;
    }

    public S getSecond() {
      return second;
    }

    @Override
    public String toString() {
      return "Pair{" + "first=" + first + ", second=" + second + '}';
    }

}
