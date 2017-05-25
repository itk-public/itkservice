package com.handchina.yunmart.artemis.exception;

import java.util.UUID;

/**
 * Created by markfredchen on 15/12/30.
 */
public class ObjectNotFoundException extends RuntimeException {
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ObjectNotFoundException(Class targetObject, Long targetObjectID) {
        super(targetObject.getSimpleName() + "[id=" + targetObjectID + "] not found");
        this.object = targetObjectID;
    }

    public ObjectNotFoundException(Class targetObject, UUID targetObjectOID) {
        super(targetObject.getSimpleName() + "[id=" + targetObjectOID + "] not found");
        this.object = targetObjectOID;
    }

    public ObjectNotFoundException(Class targetObject, String message) {
        super(targetObject.getSimpleName() + "[" + message + "] not found");
        this.object = message;
    }
}
