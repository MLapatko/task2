package dao;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by user on 20.04.2017.
 */
public abstract class ObjectPool<T> {
    private long expirationTime;

    private Hashtable<T, Long> locked, unlocked;

    ObjectPool() {
        expirationTime = 30000;
        locked = new Hashtable<T, Long>();
        unlocked = new Hashtable<T, Long>();
        System.out.println("new ObjectPool created");
    }

    protected abstract T create();

    public abstract boolean validate(T o);

    public abstract void expire(T o);

    public synchronized T checkOut() {
        long now = System.currentTimeMillis();
        T t;
        if (unlocked.size() > 0) {
            System.out.println("Found free object in Pool");
            Enumeration<T> e = unlocked.keys();
            while (e.hasMoreElements()) {
                t = e.nextElement();
                if ((now - unlocked.get(t)) > expirationTime) {
                    System.out.println("object has expired");
                    unlocked.remove(t);
                    expire(t);
                    t = null;
                } else {
                    if (validate(t)) {
                        System.out.println("object is valid");
                        unlocked.remove(t);
                        locked.put(t, now);
                        return (t);
                    } else {
                        System.out.println("object failed validation");
                        unlocked.remove(t);
                        expire(t);
                        t = null;
                    }
                }
            }
        }
        t = create();
        locked.put(t, now);
        return (t);
    }

    public synchronized void checkIn(T t) {
        locked.remove(t);
        unlocked.put(t, System.currentTimeMillis());
    }
}
