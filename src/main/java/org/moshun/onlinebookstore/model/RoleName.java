package org.moshun.onlinebookstore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoleName {
    USER("USER"),
    ADMIN("ADMIN");

    private final String stringValue;
}
