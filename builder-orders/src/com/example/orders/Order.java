package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines = Collections.unmodifiableList(new ArrayList<>(builder.lines));
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        return lines.stream()
                .mapToInt(l -> l.getQuantity() * l.getUnitPriceCents())
                .sum();
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    public static class Builder {
        private String id;
        private String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            lines.add(Objects.requireNonNull(line, "line"));
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            validateId();
            validateEmail();
            validateLines();
            validateDiscount();
            
            return new Order(this);
        }

        private void validateId() {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("id must not be blank");
            }
        }

        private void validateEmail() {
            if (customerEmail == null || customerEmail.trim().isEmpty()) {
                throw new IllegalArgumentException("customerEmail must not be blank");
            }
            if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", customerEmail)) {
                throw new IllegalArgumentException("invalid email format");
            }
        }

        private void validateLines() {
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("order must have at least one line");
            }
        }

        private void validateDiscount() {
            if (discountPercent != null && (discountPercent < 0 || discountPercent > 100)) {
                throw new IllegalArgumentException("discount must be between 0 and 100");
            }
        }
    }
}
