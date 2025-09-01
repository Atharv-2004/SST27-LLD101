import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Before: " + p.getEmail());

        try {
            System.out.println("Cannot modify email - UserProfile is immutable!");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Instead, create a new profile with updated email
        UserProfile updatedProfile = new UserProfile.Builder("u1", "new@example.com").build();
        System.out.println("After:  " + updatedProfile.getEmail());
        System.out.println("=> In the solution, this setter disappears and object becomes immutable.");

        try {
            new UserProfile.Builder("", "invalid-email").build();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }

        UserProfile fullProfile = svc.createFullProfile("u2", "user@example.com", "+1234567890",
                "John Doe", "123 Main St", true, "@johndoe", "johndoe");
        System.out.println("Full profile created: " + fullProfile.getDisplayName());
    }
}
