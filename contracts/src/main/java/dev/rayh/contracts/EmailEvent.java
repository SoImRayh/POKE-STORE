package dev.rayh.contracts;

public record EmailEvent(
        String ownerRef,
        String emailFrom,
        String emailTo,
        String subject,
        String text
) {
}
