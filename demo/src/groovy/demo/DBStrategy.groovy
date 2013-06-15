package demo

import org.hibernate.cfg.ImprovedNamingStrategy
import org.hibernate.util.StringHelper


class DBStrategy extends ImprovedNamingStrategy {

    String classToTableName(String className) {
        "tabla_" + StringHelper.unqualify(className)
    }

    String propertyToColumnName(String propertyName) {
        "col_" + StringHelper.unqualify(propertyName)
    }

}
