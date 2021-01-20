FROM mysql:8.0.22
ENV LANG=C.UTF-8
# RUN mkdir -p /tmp/init/
RUN mkdir -p /tmp/diplomska/

# COPY *_*sql /tmp/diplomska/
COPY 1_ddl.sql /docker-entrypoint-initdb.d
COPY 2_dml.sql /docker-entrypoint-initdb.d
# COPY 0_init.sql /tmp/diplomska
# COPY init-db.sh /docker-entrypoint-initdb.d/,


# HEALTHCHECK --interval=5s --timeout=3s \
#   CMD  exit 1
#   CMD  mysqladmin ping -h 127.0.0.1 -u $MYSQL_USER --password=$MYSQL_PASSWORD || exit 1

