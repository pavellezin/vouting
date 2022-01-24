package pro.paullezin.bootjava.vouting.util;

import pro.paullezin.bootjava.vouting.model.BaseEntity;

import java.util.Objects;

public class ValidationUtil {

    public static void checkNew(BaseEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalArgumentException(entity + " must be new");
        }
    }

    public static void assertConsistent(BaseEntity entity, Integer id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (!Objects.equals(entity.getId(), id)) {
            throw new IllegalArgumentException(entity + " must have id=" + id);
        }
    }
}
