package _07__Hibernate._02__Hibernate_Core_Annotations.model;

import org.apache.log4j.*;
import jakarta.persistence.*;

public class AuditEntityListeners {

    private static Logger log = LogManager.getLogger(AuditEntityListeners.class);

    public AuditEntityListeners() {
        Layout layout = new PatternLayout("%n> [ %d ] -> [ %C.%M ] : %p - %m");
        Appender appender = new ConsoleAppender(layout);
        log.addAppender(appender);
    }

    @PrePersist
    public void prePersist(Employee employee) {
        if (employee.getId() != 0) {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : @PrePersist Phase");
        } else {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : NOT FOUND...");
        }
    }

    @PostPersist
    public void postPersist(Employee employee) {
        if (employee.getId() != 0) {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : @PostPersist Phase");
        } else {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : NOT FOUND...");
        }
    }

    @PreUpdate
    public void preUpdate(Employee employee) {
        if (employee.getId() != 0) {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : @PreUpdate Phase");
        } else {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : NOT FOUND...");
        }
    }

    @PostUpdate
    public void postUpdate(Employee employee) {
        if (employee.getId() != 0) {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : @PostUpdate Phase");
        } else {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : NOT FOUND...");
        }
    }

    @PreRemove
    public void preRemove(Employee employee) {
        if (employee.getId() != 0) {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : @PreRemove Phase");
        } else {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : NOT FOUND...");
        }
    }

    @PostRemove
    public void postRemove(Employee employee) {
        if (employee.getId() != 0) {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : @PostRemove Phase");
        } else {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : NOT FOUND...");
        }
    }

    @PostLoad
    public void postLoad(Employee employee) {
        if (employee.getId() != 0) {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : @PostLoad Phase");
        } else {
            log.info("> EMPLOYEE -> id=" + employee.getId() + " : NOT FOUND...");
        }
    }

}
