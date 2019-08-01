/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2019. 4. 23
 */
package net.jjong.jsr305;


import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.ParametersAreNullableByDefault;

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
public class Jsr305 {

  /**
   * 파라미터에 null을 허용하지 않음.
   * @param name
   * @return
   */
  public static int getLength(@Nonnull String name) {
    return name.length();
  }

  /**
   * 파라미터에 Nullable일때 null체크가 필요하다.
   * @param name
   * @return
   */
  public static int getNameLength(@Nullable String name) {
    return name.length();
  }

  @ParametersAreNullableByDefault
  public static void parameterNullable(Map<String, String> map) {
    if(map != null) {
      map.get("test");
    }
    map.get("test"); // 경고 nullsafe 하지 않으므로
  }

  @ParametersAreNonnullByDefault
  public static void parameterNonnull(Map<String, String> map) {
    if(map != null) { //경고 굳이 null 체크 할 필요가 없다.
      map.get("test");
    }
    map.get("test"); // 경고 nullsafe 하지 않으므로
  }






  /**
   * 메서드에 Nonnull은 null을 리턴할 수 없다.
   * @return
   */
  @Nonnull
  public static String getLastName() {
    return null;
  }

  @Nullable
  public static Integer getNullableMethod(@Nullable String str) {
    return str.length(); // null 포인트 익셉션이 발생할 수 있음.
  }


  /**
   * 리턴할 값을 체크해야 됨.
   * @param name
   * @return
   */
  @CheckReturnValue
  public static Integer checkReturnValue(String name) {
    return name.length();
  }


  public static void main(String[] args) {
    getLength(null); // null 을 허용하지 않는 메서드 이므로 경고가 발생 함.

    Integer nullableMethod = getNullableMethod("");
    String s = nullableMethod.toString(); //null 포인트 exception 이 발생 할 수 있다.
    System.out.println(s);

    checkReturnValue("");


  }



}

class ParentClass {
  @OverridingMethodsMustInvokeSuper // 상속 받는 메소드에서 오버라이딩시 반드시 호출해야 한다.
  public String invokeMethod() {
    return "hello";
  }
}

class ChildClass extends ParentClass {

  @Override
  public String invokeMethod() {
    return "world!"; // parent 의 메서드를 호출하지 않으면 alert 뜸
  }
}
