package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles using Builder pattern with centralized validation.
 */
public class ProfileService {

    // returns a fully built immutable profile
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile createFullProfile(String id, String email, String phone,
            String displayName, String address,
            boolean marketingOptIn, String twitter, String github) {
        return new UserProfile.Builder(id, email)
                .phone(phone)
                .displayName(displayName)
                .address(address)
                .marketingOptIn(marketingOptIn)
                .twitter(twitter)
                .github(github)
                .build();
    }

    // Instead of mutating, create a new profile with updated display name
    public UserProfile updateDisplayName(UserProfile original, String displayName) {
        Objects.requireNonNull(original, "profile");

        // Truncate if too long (consistent policy)
        String finalDisplayName = displayName;
        if (displayName != null && displayName.length() > 100) {
            finalDisplayName = displayName.substring(0, 100);
        }

        return new UserProfile.Builder(original.getId(), original.getEmail())
                .phone(original.getPhone())
                .displayName(finalDisplayName)
                .address(original.getAddress())
                .marketingOptIn(original.isMarketingOptIn())
                .twitter(original.getTwitter())
                .github(original.getGithub())
                .build();
    }
}
