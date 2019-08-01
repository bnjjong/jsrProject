package net.jjong.jsr305;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * create on 2019-07-31.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
class Jsr305Test {

  @Test
  void getLength() {
     assertEquals(Jsr305.getLength("test"), 4);
     assertThrows(NullPointerException.class, () -> {
       Jsr305.getLength(null);
    });

  }
}