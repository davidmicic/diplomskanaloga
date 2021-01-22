FROM jboss/wildfly:19.0.0.Final

ENV DB_NAME diplomskanaloga
ENV DB_HOST mysql
ENV DB_PORT 3306
ENV DS_NAME MySqlDS
ENV JNDI_NAME java:/MySqlDS
ENV JBOSS_HOME /opt/jboss/wildfly

ADD ./jar/mysql-connector-java-8.0.20.jar /tmp/mysql-connector-java-8.0.20.jar
ADD ./conf/wildfly-static-config.cli /tmp/wildfly-static-config.cli
ADD ./fop  /opt/jboss/wildfly/fop

# Copy EAR file
COPY --chown=jboss:0 ./ear/*.ear ${JBOSS_HOME}/standalone/deployments/

#change ownership
USER root


RUN localedef -i sl_SI -f UTF-8 sl_SI.UTF-8
RUN echo "LANG=\"sl_SI.UTF-8\"" > /etc/locale.conf

RUN chown jboss:0 -R ${JBOSS_HOME}/standalone/configuration/ 

USER jboss

ENV LANG sl_SI.UTF-8
ENV LANGUAGE sl_SI.UTF-8
ENV LC_ALL sl_SI.UTF-8

# run config
RUN cp ${JBOSS_HOME}/standalone/configuration/standalone-full.xml ${JBOSS_HOME}/standalone/configuration/standalone.xml
RUN ${JBOSS_HOME}/bin/jboss-cli.sh --file=/tmp/wildfly-static-config.cli
RUN rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/

# add default admin user
RUN ${JBOSS_HOME}/bin/add-user.sh admin Admin  --silent

USER root
CMD [ "/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0" ]