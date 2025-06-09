CREATE TABLE IF NOT EXISTS undo_log
(
    id                BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    branch_id         BIGINT       NOT NULL,
    xid               VARCHAR(100) NOT NULL,
    context           VARCHAR(128) NOT NULL,
    rollback_info     BLOB         NOT NULL,
    log_status        INT          NOT NULL,
    log_created       TIMESTAMP    NOT NULL,
    log_modified      TIMESTAMP    NOT NULL,
    ext               VARCHAR(100) DEFAULT NULL,
    CONSTRAINT ux_undo_log UNIQUE (xid, branch_id)
    );