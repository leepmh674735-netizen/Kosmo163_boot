pakage ploymorphism;

import org.spingframework.context.support.AbstractApplicationContext;
import org.spingframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
      // 1.Spring IoC 컨테이너를 구동한다.
      AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
      new GenericXmlApplicationContext("applicationContext.xml");

      //2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
      TV tv1 = (TV)factory.getBean("tv");
      TV tv2 = (TV)factory.getBean("tv");
      TV t3 =(TV)factory.getBean("tv");

      // 3. Spring 컨테이너를 종료된다
      factory.close();
    }
}