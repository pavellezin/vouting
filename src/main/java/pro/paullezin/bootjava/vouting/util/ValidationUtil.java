package pro.paullezin.bootjava.vouting.util;

import pro.paullezin.bootjava.vouting.error.IllegalRequestDataException;
import pro.paullezin.bootjava.vouting.model.BaseEntity;

import java.util.Objects;

public class ValidationUtil {

    public static void checkNew(BaseEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalRequestDataException(entity.getClass().getSimpleName() + "must be new");
        }
    }

    public static void assertConsistent(BaseEntity entity, Integer id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (!Objects.equals(entity.getId(), id)) {
            throw new IllegalRequestDataException(entity.getClass().getSimpleName() + " must have id=" + id);
        }
    }
}