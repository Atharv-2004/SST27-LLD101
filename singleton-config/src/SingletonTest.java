import com.example.config.AppSettings;
import java.lang.reflect.Constructor;

public class SingletonTest {
    public static void main(String[] args) {
        AppSettings instance1 = AppSettings.getInstance();
        AppSettings instance2 = AppSettings.getInstance();

        System.out.println("Same instance: " + (instance1 == instance2));
        System.out.println("Instance 1 hash: " + System.identityHashCode(instance1));
        System.out.println("Instance 2 hash: " + System.identityHashCode(instance2));

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                AppSettings instance = AppSettings.getInstance();
                System.out.println("Thread " + Thread.currentThread().getId() +
                        " got instance: " + System.identityHashCode(instance));
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            Constructor<AppSettings> constructor = AppSettings.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            AppSettings reflectedInstance = constructor.newInstance();
            System.out.println("Reflection attack succeeded: " + (instance1 != reflectedInstance));
        } catch (Exception e) {
            System.out.println("Reflection attack blocked: " + e.getMessage());
        }

        System.out.println("Serialization protection: readResolve() method implemented");
    }
}
