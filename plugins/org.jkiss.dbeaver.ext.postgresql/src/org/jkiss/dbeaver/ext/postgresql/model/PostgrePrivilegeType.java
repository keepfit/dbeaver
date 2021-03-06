/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2017 Serge Rider (serge@jkiss.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ext.postgresql.model;

/**
 * PostgrePrivilegeType
 */
public enum PostgrePrivilegeType {
    // ALL privs
    ALL(Object.class, false),
    // TABLE privs
    SELECT(PostgreTableReal.class, true),
    INSERT(PostgreTableReal.class, true),
    UPDATE(PostgreTableReal.class,true),
    DELETE(PostgreTableReal.class,true),
    TRUNCATE(PostgreTableReal.class,true),
    REFERENCES(PostgreTableReal.class,true),
    TRIGGER(PostgreTableReal.class,true),
    // SEQUENCE privs
    USAGE(PostgreSequence.class, true),

    UNKNOWN(Object.class, false);

    private final Class<?> targetType;
    private final boolean valid;

    PostgrePrivilegeType(Class<?> targetType, boolean valid) {
        this.targetType = targetType;
        this.valid = valid;
    }

    public Class<?> getTargetType() {
        return targetType;
    }

    public boolean isValid() {
        return valid;
    }

    public static PostgrePrivilegeType fromString(String type) {
        try {
            return valueOf(type);
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}

