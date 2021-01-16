FROM mysql:8.0.22

# RUN mkdir -p /tmp/init/
RUN mkdir -p /tmp/diplomska/

# COPY *_*sql /tmp/diplomska/
COPY 1_ddl.sql /docker-entrypoint-initdb.d
COPY 2_dml.sql /docker-entrypoint-initdb.d
# COPY 0_init.sql /tmp/diplomska
# COPY init-db.sh /docker-entrypoint-initdb.d/

