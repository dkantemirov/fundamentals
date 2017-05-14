package lang.java.core;

import java.util.LinkedList;
import java.util.List;

interface Identification {

}

class User implements Identification {
    private String name;

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class SuperUser extends User {
    SuperUser(String name) {
        super(name);
    }
}

/**
 * Generics allow any class to have a type tag just like an array does, but unlike arrays,
 * these type tags are not covariant.
 * <p>
 * There is a way to achieve polymorphism (that is, covariance and contravariance)
 * in this situation — by using bounded wildcards.
 * <p>
 * Concise Scala analog {@link fundamentals.scala.core.Variance}.
 */
public class Variance {

    static class Covariance {
        // Upper bounded wildcard
        public void show(List<? extends User> list) {
            for (User user : list) System.out.println(user.getName());
        }
    }

    static class Contravariance {
        // Lower bounded wildcard
        public void show(List<? super SuperUser> list) {
            for (Object user : list) System.out.println(user);
        }
    }

    static class Invariance {
        public void show(List<User> list) {
            for (User user : list) System.out.println(user.getName());
        }
    }

    public static void main(String[] args) {
        User u = new User("user");
        SuperUser su = new SuperUser("su");
        LinkedList<SuperUser> list = new LinkedList<SuperUser>();
        list.add(su);
        LinkedList<User> list1 = new LinkedList<User>();
        list1.add(u);

        // Covariance
        Covariance covariance = new Covariance();
        covariance.show(list);

        // Contravariance
        Contravariance contravariance = new Contravariance();
        contravariance.show(list1);

        // Invariance
        Invariance invariance = new Invariance();
        // invariance.show(list); Compile error!
    }

}
