create TABLE if not exists employee_data (
    ed_id bigint(20) NOT NULL AUTO_INCREMENT,
    ed_name VARCHAR(256),
    ed_email VARCHAR(256),
    ed_created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    ed_updated_at DATETIME DEFAULT NULL ON update CURRENT_TIMESTAMP,
    PRIMARY KEY (ed_id)
);