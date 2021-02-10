node 'puppetagent' {
  include role::webserver
  include java::install
  include tomcat
}

