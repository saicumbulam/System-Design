package Threads;

public class SuperManProblem {
    private static SuperManProblem superman;

    private SuperManProblem() {

    }

    public static SuperManProblem getInstance() {

        // Check if object is uninitialized
        if (superman == null) {

            // Now synchronize on the class object, so that only
            // 1 thread gets a chance to initialize the superman
            // object. Note that multiple threads can actually find
            // the superman object to be null and fall into the
            // first if clause
            synchronized (SuperManProblem.class) {

                // Must check once more if the superman object is still
                // null. It is possible that another thread might have
                // initialized it already as multiple threads could have
                // made past the first if check.
                if (superman == null) {
                    superman = new SuperManProblem();
                }
            }

        }

        return superman;
    }
}
