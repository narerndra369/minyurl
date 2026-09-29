CREATE TABLE IF NOT EXISTS url_mapping (
                                           short_code  VARCHAR(10)   NOT NULL,
    long_url    VARCHAR(768)  NOT NULL,  -- Reduced from 2048 to 768
    created_at  DATETIME      NOT NULL,
    expire_at   DATETIME,
    CONSTRAINT pk_url_mapping PRIMARY KEY (short_code)
    );

-- CREATE INDEX idx_long_url  ON url_mapping (long_url);
-- CREATE INDEX idx_expire_at ON url_mapping (expire_at);

CREATE TABLE IF NOT EXISTS url_sequence (
                                            id bigint not null,
                                            sequence bigint,
                                            primary key (id)
    );

INSERT IGNORE INTO url_sequence VALUES (1, 1000000000000);